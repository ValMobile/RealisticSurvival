package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.potion.PotionEffectType;

public abstract class InternalsProvider {

    public abstract void spawnEndermanAlly(Player owner, Location loc);

    public abstract Tag getTag(String name);

    public abstract PotionEffectType valueOfPotionEffectType(String potionEffectType);

    public abstract boolean isUndead(Entity entity);

    public abstract boolean isNetheriteRecipe(SmithingInventory inv);

    public abstract void registerEntities();

    public abstract void setFreezingView(Player player);
}
