package me.val_mobile.minorities_smp_extras;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {

    public ItemStack resizeItem(ItemStack item, int amount) {

        item.setAmount(amount);

        return item;
    }

    public ItemStack addDragonSkullLore(ItemStack item, int stage, String dragon) {

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.translateAlternateColorCodes('&',""));
        lore.add(ChatColor.GRAY + "Stage " + stage);
        lore.add(ChatColor.GRAY + dragon + " Dragon");

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack resetDurability(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        ((Damageable)meta).setDamage(0);

        item.setItemMeta(meta);

        return item;
    }

    public Location modifyLocationX(Location loc, double x) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);

        return newLoc;
    }

    public Location modifyLocationY(Location loc, double y) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getY() + y);

        return newLoc;
    }

    public Location modifyLocationZ(Location loc, double z) {

        Location newLoc = loc.clone();
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public Location modifyLocation(Location loc, double x, double y, double z) {

        Location newLoc = loc.clone();
        newLoc.setX(newLoc.getX() + x);
        newLoc.setY(newLoc.getY() + y);
        newLoc.setZ(newLoc.getZ() + z);

        return newLoc;
    }

    public double getDiamondHelmetArmor() {

        return 3.0;
    }

    public double getDiamondHelmetToughness() {

        return 2.0;
    }

    public double getDiamondChestplateArmor() {

        return 8.0;
    }

    public double getDiamondChestplateToughness() {

        return 2.0;
    }

    public double getDiamondLeggingsArmor() {

        return 6.0;
    }

    public double getDiamondLeggingsToughness() {

        return 2.0;
    }

    public double getDiamondBootsArmor() {

        return 3.0;
    }

    public double getDiamondBootsToughness() {

        return 2.0;
    }
}
