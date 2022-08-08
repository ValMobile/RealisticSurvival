package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public abstract class InternalsProvider {

    public abstract void spawnEndermanAlly(Location loc);

    public abstract void spawnEntity(Object entity);

    public abstract Object getWorld(World world);

    public abstract HashMap<String, Tag> getTags();

    public abstract PotionEffectType valueOfPotionEffectType(String potionEffectType);
}
