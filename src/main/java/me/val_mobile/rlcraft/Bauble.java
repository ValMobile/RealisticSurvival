package me.val_mobile.rlcraft;

import com.google.common.collect.Multimap;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Bauble extends ItemStack {

    private final static String KEY = "Bauble";

    public Bauble(Material mat, String displayName, List<String> lore, int modelData, String name) {
        super(mat);
        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        meta.setCustomModelData(modelData);
        this.setItemMeta(meta);
        NBTItem temp = new NBTItem(this);
        temp.setString(KEY, name);
    }

    public Bauble(Material mat, String displayName, List<String> lore, int modelData, String name, Map<Enchantment, Integer> ench, Multimap<Attribute, AttributeModifier> atr) {
        super(mat);
        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        meta.setCustomModelData(modelData);
        for (Map.Entry<Attribute, Collection<AttributeModifier>> entry : atr.asMap().entrySet()) {
            meta.addAttributeModifier(entry.getKey(), (AttributeModifier) entry.getValue());
        }
        for (Map.Entry<Enchantment, Integer> entry : ench.entrySet()) {
            meta.addEnchant(entry.getKey(), entry.getValue(), true);
        }
        this.setItemMeta(meta);
        NBTItem temp = new NBTItem(this);
        temp.setString(KEY, name);
    }

}
