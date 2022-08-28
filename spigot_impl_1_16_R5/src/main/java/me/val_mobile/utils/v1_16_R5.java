package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class v1_16_R5 extends InternalsProvider {


    @Override
    public void spawnEndermanAlly(Player owner, Location loc) {

    }

    @Override
    public Tag getTag(String name) {
        return TagList.valueOf(name).getTag();
    }

    @Override
    public PotionEffectType valueOfPotionEffectType(String type) {
        return PotionEffectTypeList.valueOf(type).getType();
    }
}
