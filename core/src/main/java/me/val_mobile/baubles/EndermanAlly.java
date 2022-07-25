package me.val_mobile.baubles;

import me.val_mobile.utils.PathfinderGoalPet;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class EndermanAlly extends EntityEnderman {

    public EndermanAlly(Location loc)
    {
        super(EntityTypes.ENDERMAN, ((CraftWorld)loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.setInvulnerable(true);
    }

    @Override
    protected void initPathfinder()
    {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));

        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1.0, 25));
    }

    public void setOwner(Player player)
    {
        this.setGoalTarget(((CraftPlayer)player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, false);
    }

    public void setItem(EnumItemSlot slot, org.bukkit.inventory.ItemStack item)
    {
        this.setSlot(slot,  CraftItemStack.asNMSCopy(item));
    }

    public void setName(String name)
    {
        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&', name)));
        this.setCustomNameVisible(true);
    }
}
