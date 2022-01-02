/*
    Copyright (C) 2021  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.dragons;

import me.val_mobile.enums.Dragon.Variant;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftCreature;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

public abstract class Dragon extends EntityEnderDragon {

    private final RealisticSurvivalPlugin plugin;
    private me.val_mobile.enums.Dragon.Breed breed;
    private int stage;
    private int age;
    private me.val_mobile.enums.Dragon.Gender gender;
    private Variant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();
    private final UUID uuid;

    public Dragon(EntityTypes<? extends EntityEnderDragon> entitytypes, Location loc, me.val_mobile.enums.Dragon.Breed breed, RealisticSurvivalPlugin instance) {
        super(entitytypes, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        plugin = instance;
        uuid = getUniqueID();

        Random r = new Random();

        this.breed = breed;
        stage = (int) Math.round(r.nextDouble() * 4) + 1;
        age = this.stage * 100 + (int) Math.round(r.nextDouble() * 99);

        if ((int) Math.round(r.nextDouble()) == 1)
            gender = me.val_mobile.enums.Dragon.Gender.MALE;
        else
            gender = me.val_mobile.enums.Dragon.Gender.FEMALE;

        switch (breed) {
            case FIRE: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0: {
                        variant = Variant.RED;
                        this.setCustomName(IChatBaseComponent.a("Red"));
                        break;
                    }
                    case 1: {
                        variant = Variant.BRONZE;
                        this.setCustomName(IChatBaseComponent.a("Bronze"));
                        break;
                    }
                    case 2: {
                        variant = Variant.EMERALD;
                        this.setCustomName(IChatBaseComponent.a("Emerald"));
                        break;
                    }
                    default: {
                        variant = Variant.GRAY;
                        this.setCustomName(IChatBaseComponent.a("Gray"));
                        break;
                    }
                }
                break;
            }
            case ICE: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0: {
                        variant = Variant.BLUE;
                        this.setCustomName(IChatBaseComponent.a("Blue"));
                        break;
                    }
                    case 1: {
                        variant = Variant.SAPPHIRE;
                        this.setCustomName(IChatBaseComponent.a("Sapphire"));
                        break;
                    }
                    case 2: {
                        variant = Variant.WHITE;
                        this.setCustomName(IChatBaseComponent.a("White"));
                        break;
                    }
                    default: {
                        variant = Variant.SILVER;
                        this.setCustomName(IChatBaseComponent.a("Silver"));
                        break;
                    }
                }
                break;
            }
            default: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0: {
                        variant = Variant.AMETHYST;
                        this.setCustomName(IChatBaseComponent.a("Amethyst"));
                        break;
                    }
                    case 1: {
                        variant = Variant.ELECTRIC_BLUE;
                        this.setCustomName(IChatBaseComponent.a("Electric Blue"));
                        break;
                    }
                    case 2: {
                        variant = Variant.COPPER;
                        this.setCustomName(IChatBaseComponent.a("Copper"));
                        break;
                    }
                    default: {
                        variant = Variant.BLACK;
                        this.setCustomName(IChatBaseComponent.a("Black"));
                        break;
                    }
                }
                break;
            }
        }
    }

    public Dragon(EntityTypes<? extends EntityEnderDragon> entitytypes, Location loc, me.val_mobile.enums.Dragon.Breed breed, int stage,  RealisticSurvivalPlugin instance) {
        super(entitytypes, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        plugin = instance;
        uuid = getUniqueID();

        Random r = new Random();

        this.breed = breed;
        this.stage = stage;
        age = this.stage * 100 + (int) Math.round(r.nextDouble() * 99);

        if ((int) Math.round(r.nextDouble()) == 1)
            gender = me.val_mobile.enums.Dragon.Gender.MALE;
        else
            gender = me.val_mobile.enums.Dragon.Gender.FEMALE;

        switch (breed) {
            case FIRE: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0:
                        variant = Variant.RED;
                        this.setCustomName(IChatBaseComponent.a("Red"));
                    case 1:
                        variant = Variant.BRONZE;
                        this.setCustomName(IChatBaseComponent.a("Bronze"));
                    case 2:
                        variant = Variant.EMERALD;
                        this.setCustomName(IChatBaseComponent.a("Emerald"));
                    default:
                        variant = Variant.GRAY;
                        this.setCustomName(IChatBaseComponent.a("Gray"));
                }
            }
            case ICE: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0:
                        variant = Variant.BLUE;
                        this.setCustomName(IChatBaseComponent.a("Blue"));
                    case 1:
                        variant = Variant.SAPPHIRE;
                        this.setCustomName(IChatBaseComponent.a("Sapphire"));
                    case 2:
                        variant = Variant.WHITE;
                        this.setCustomName(IChatBaseComponent.a("White"));
                    default:
                        variant = Variant.SILVER;
                        this.setCustomName(IChatBaseComponent.a("Silver"));
                }
            }
            default: {
                switch ((int) Math.round(r.nextDouble() * 3)) {
                    case 0:
                        variant = Variant.AMETHYST;
                        this.setCustomName(IChatBaseComponent.a("Amethyst"));
                    case 1:
                        variant = Variant.ELECTRIC_BLUE;
                        this.setCustomName(IChatBaseComponent.a("Electric Blue"));
                    case 2:
                        variant = Variant.COPPER;
                        this.setCustomName(IChatBaseComponent.a("Copper"));
                    default:
                        variant = Variant.BLACK;
                        this.setCustomName(IChatBaseComponent.a("Black"));
                }
            }
        }
    }

    public void spawn() {
        org.bukkit.World world = this.getWorld().getWorld();
        ((CraftWorld)world).getHandle().addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);

//        Entity armorStand = world.spawnEntity(this.getBukkitEntity().getLocation(), EntityType.ARMOR_STAND);
//        armorStand.setInvulnerable(true);
//        armorStand.setGravity(false);
//        armorStand.setSilent(true);
//        armorStand.setPersistent(true);
//        this.setGoalTarget(((CraftArmorStand) armorStand).getHandle());

        new BukkitRunnable() {
            final FireDragon dragon = (FireDragon) ((CraftEnderDragon) Bukkit.getEntity(getUuid())).getHandle();

            @Override
            public void run() {
                dragon.triggerBreathAttack();
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void walkToPosition(Location loc, float speed) {
        ((CraftCreature) this.getBukkitEntity())
                .getHandle()
                .getNavigation()
                .a(loc.getX(), loc.getY(), loc.getZ(), speed);
    }

    public void ability(LivingEntity entity) {}

    public void triggerBreathAttack() {}

    public void triggerExplosionAttack() {}

    public void generateLoot() {}

    public me.val_mobile.enums.Dragon.Breed getBreed() {
        return breed;
    }

    public Variant getVariant() {
        return variant;
    }

    public int getStage() {
        return stage;
    }

    public int getAge() {
        return age;
    }

    public void getGender(me.val_mobile.enums.Dragon.Gender gender) {
        this.gender = gender;
    }

    public Collection<ItemStack> getLoot() {
        return loot;
    }

    public void setBreed(me.val_mobile.enums.Dragon.Breed breed) {
        this.breed = breed;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
}