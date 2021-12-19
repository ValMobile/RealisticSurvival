package me.val_mobile.tan;

import me.val_mobile.rlcraft.RLCraftPlugin;
import me.val_mobile.utils.EnchantmentWrapper;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TanEnchants {

    public HashSet<Enchantment> enchants = new HashSet<>();

    public static final Enchantment WARMING = new EnchantmentWrapper("warming", "Warming", 1);
    public static final Enchantment COOLING = new EnchantmentWrapper("cooling", "Cooling", 1);
    public static final Enchantment OZZY_LINER = new EnchantmentWrapper("ozzy_liner", "Ozzy Liner", 1);

    private final RLCraftPlugin plugin;

    public TanEnchants(RLCraftPlugin instance) {
        plugin = instance;
    }

    public void register(Enchantment ench) {
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(ench);

        if (!registered) {
            registerEnchantment(ench);
        }
    }

    public void registerEnchantment(Enchantment ench) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(ench);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if (registered) {
            String raw = plugin.getConfig().getString("RegisteredEnchant");

            raw = raw.replaceAll("%enchant%", ench.getKey().getKey());
            plugin.getLogger().info(ChatColor.translateAlternateColorCodes('&', raw));
        }
    }

    public void populateEnchants() {
        enchants.add(WARMING);
        enchants.add(COOLING);
        enchants.add(OZZY_LINER);
    }

    public HashSet<Enchantment> getEnchants() {
        return enchants;
    }
}
