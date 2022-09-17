package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.potion.PotionEffectType;

public class v1_16_R1 extends InternalsProvider {

    @Override
    public void spawnEndermanAlly(Player owner, Location loc) {
        new EndermanAlly(owner, loc);
    }

    @Override
    public Tag getTag(String name) {
        return TagList.valueOf(name).getTag();
    }

    @Override
    public PotionEffectType valueOfPotionEffectType(String type) {
        return PotionEffectTypeList.valueOf(type).getType();
    }

    @Override
    public boolean isUndead(Entity entity) {
        switch (entity.getType()) {
            case ZOMBIE:
            case ZOMBIE_HORSE:
            case ZOMBIE_VILLAGER:
            case DROWNED:
            case HUSK:
            case PHANTOM:
            case SKELETON:
            case SKELETON_HORSE:
            case WITHER_SKELETON:
            case WITHER:
            case ZOGLIN:
            case ZOMBIFIED_PIGLIN:
            case STRAY: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override
    public boolean isNetheriteRecipe(SmithingInventory inv) {
        ItemStack base = inv.getItem(0);
        ItemStack result = inv.getItem(2);

        if (!(result == null || base == null)) {
            if (Utils.isNetherite(result.getType()) && Utils.isDiamond(base.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities.registerEntities();
    }
}
