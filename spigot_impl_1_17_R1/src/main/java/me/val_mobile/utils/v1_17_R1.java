package me.val_mobile.utils;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.potion.PotionEffectType;

public class v1_17_R1 extends InternalsProvider {



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

    @Override
    public boolean isUndead(Entity entity) {
        if (entity instanceof LivingEntity) {
            if (((LivingEntity) entity).getCategory() == EntityCategory.UNDEAD) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isNetheriteRecipe(SmithingInventory inv) {
        Recipe recipe = inv.getRecipe();

        if (recipe instanceof SmithingRecipe) {
            NamespacedKey key = ((SmithingRecipe) recipe).getKey();

            if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                switch (key.getKey()) {
                    case "netherite_axe_smithing":
                    case "netherite_pickaxe_smithing":
                    case "netherite_shovel_smithing":
                    case "netherite_sword_smithing":
                    case "netherite_hoe_smithing":
                    case "netherite_helmet_smithing":
                    case "netherite_chestplate_smithing":
                    case "netherite_leggings_smithing":
                    case "netherite_boots_smithing": {
                        inv.setResult(null);
                    }
                    default: {
                        break;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void registerEntities() {
        CustomEntities.registerEntities();
    }
}
