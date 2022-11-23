package me.val_mobile.utils;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTeleportEvent;

import java.util.EnumSet;

public class FollowOwnerGoal_v1_16_R3 extends PathfinderGoal {
    private final RSVPet pet;
    private EntityLiving owner;
    private final IWorldReader world;
    private final double speedModifier;
    private final NavigationAbstract navigation;
    private int timeToRecalcPath;
    private final float stopDistance;
    private final float startDistance;
    private float oldWaterCost;
    private final boolean canFly;

    public FollowOwnerGoal_v1_16_R3(RSVPet pet, double d0, float f, float f1, boolean flag) {
        this.pet = pet;
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();
        this.world = mob.world;
        this.speedModifier = d0;
        this.navigation = mob.getNavigation();
        this.startDistance = f;
        this.stopDistance = f1;
        this.canFly = flag;
        this.a(EnumSet.of(Type.MOVE, Type.LOOK));
        if (!(mob.getNavigation() instanceof Navigation) && !(mob.getNavigation() instanceof NavigationFlying)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
        }
    }

    public boolean a() {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();
        EntityPlayer owner = ((CraftPlayer) pet.getOwner()).getHandle();
        if (owner == null) {
            return false;
        } else if (owner.isSpectator()) {
            return false;
        } else if (mob.h(owner) < (double) (startDistance * startDistance)) {
            return false;
        } else {
            this.owner = owner;
            return true;
        }
    }

    public boolean b() {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        return !navigation.m() && (mob.h(owner) > (double) (stopDistance * stopDistance));
    }

    public void c() {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        timeToRecalcPath = 0;
        oldWaterCost = mob.a(PathType.WATER);
        mob.a(PathType.WATER, 0.0F);
    }

    public void d() {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        owner = null;
        navigation.o();
        mob.a(PathType.WATER, oldWaterCost);
    }

    public void e() {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        mob.getControllerLook().a(owner, 10.0F, (float) mob.O());
        if (--timeToRecalcPath <= 0) {
            timeToRecalcPath = 10;
            if (!mob.isLeashed() && !mob.isPassenger()) {
                if (mob.h(owner) >= 144.0) {
                    teleportToOwner();
                } else {
                    navigation.a(owner, speedModifier);
                }
            }
        }

    }

    private void teleportToOwner() {
        BlockPosition blockposition = owner.getChunkCoordinates();

        for(int i = 0; i < 10; ++i) {
            int j = randomIntInclusive(-3, 3);
            int k = randomIntInclusive(-1, 1);
            int l = randomIntInclusive(-3, 3);
            boolean flag = maybeTeleportTo(blockposition.getX() + j, blockposition.getY() + k, blockposition.getZ() + l);
            if (flag) {
                return;
            }
        }

    }

    private boolean maybeTeleportTo(int i, int j, int k) {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        if (Math.abs((double)i - owner.locX()) < 2.0 && Math.abs((double)k - owner.locZ()) < 2.0) {
            return false;
        } else if (!canTeleportTo(new BlockPosition(i, j, k))) {
            return false;
        } else {
            CraftEntity entity = mob.getBukkitEntity();
            Location to = new Location(entity.getWorld(), (double)i + 0.5, j, (double)k + 0.5, mob.yaw, mob.pitch);
            EntityTeleportEvent event = new EntityTeleportEvent(entity, entity.getLocation(), to);
            mob.world.getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                return false;
            } else {
                to = event.getTo();
                mob.setPositionRotation(to.getX(), to.getY(), to.getZ(), to.getYaw(), to.getPitch());
                navigation.o();
                return true;
            }
        }
    }

    private boolean canTeleportTo(BlockPosition blockposition) {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        PathType pathtype = PathfinderNormal.a(world, blockposition.i());
        if (pathtype != PathType.WALKABLE) {
            return false;
        } else {
            IBlockData iblockdata = world.getType(blockposition.down());
            if (!canFly && iblockdata.getBlock() instanceof BlockLeaves) {
                return false;
            } else {
                BlockPosition blockposition1 = blockposition.b(mob.getChunkCoordinates());
                return world.getCubes(mob, mob.getBoundingBox().a(blockposition1));
            }
        }
    }

    private int randomIntInclusive(int i, int j) {
        EntityInsentient mob = (EntityInsentient) ((CraftEntity) pet.getEntity()).getHandle();

        return mob.getRandom().nextInt(j - i + 1) + i;
    }
}
