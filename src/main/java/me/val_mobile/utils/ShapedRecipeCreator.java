package me.val_mobile.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.List;

public class ShapedRecipeCreator extends ShapedRecipe {

    public ShapedRecipeCreator(NamespacedKey key, ItemStack item, FileConfiguration config, int index) {
        super(key, item);

        String resultPath = index + ".Result.Item";
        String amountPath = index + ".Result.Amount";

        String ingredientsPath = index + "Ingredients";

        String result = config.getString(resultPath);
        int amount = config.getInt(amountPath);

        ItemStack resultingItem;
        if (Item.getItemMap().containsKey(result)) {
            resultingItem = Item.getItem(Item.getItemMap().get(result));
        }
        else {
            resultingItem = new ItemStack(Material.valueOf(result));
        }

        List<String> ingredients = config.getStringList(ingredientsPath);

        ItemStack[][] array = new ItemStack[3][3];

        for (int i = 0; i < ingredients.size(); i++) {
            String raw = ingredients.get(i);
            ItemStack[] items = Utils.getItemsFromString(raw);

            for (int j = 0; j < items.length; j++) {
                if (!(items[j] == null || items[j].getType().equals(Material.AIR))) {
                    array[i][j] = items[j];
                }
            }
        }


    }

}
