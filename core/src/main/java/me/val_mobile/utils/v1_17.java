package me.val_mobile.utils;

import org.bukkit.Material;
import org.bukkit.Tag;

import java.util.*;

public class v1_17 {
    public static Collection<Material> getPickaxeMaterials() {
        //org.bukkit.Tag
        Tag<Material> [] tags = new Tag[]{
                Tag.STONE_BRICKS, Tag.STONE_PRESSURE_PLATES,
                Utils.getTag("BASE_STONE_NETHER"), Utils.getTag("BASE_STONE_OVERWORLD"),
                Utils.getTag("REDSTONE_ORES"), Utils.getTag("COAL_ORES"), Utils.getTag("COPPER_ORES"),
                Utils.getTag("DIAMOND_ORES"), Utils.getTag("EMERALD_ORES"), Tag.GOLD_ORES,
                Utils.getTag("IRON_ORES"), Utils.getTag("LAPIS_ORES")
        };

        Set<Material> list = new HashSet<>();

        for(Tag<Material> tag : tags) {
            for(Material mat : Material.values()) {
                if(tag.isTagged(mat)) {
                    list.add(mat);
                }
            }
        }

        for(Material mat : Material.values()) {
            if(mat.name().toLowerCase(Locale.ROOT).contains("cobbled")) {
                list.add(mat);
            } else if(mat.name().toLowerCase(Locale.ROOT).contains("copper")) {
                list.add(mat);
            }
        }

        list.addAll(Arrays.asList(
                Material.valueOf("RAW_IRON_BLOCK"),
                Material.valueOf("RAW_COPPER_BLOCK"),
                Material.valueOf("RAW_GOLD_BLOCK")));
        return list;


    }
}
