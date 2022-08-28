package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public abstract class InternalsProvider {

    public abstract void spawnEndermanAlly(Player owner, Location loc);

    public abstract Tag getTag(String name);

    public abstract PotionEffectType valueOfPotionEffectType(String potionEffectType);
}
