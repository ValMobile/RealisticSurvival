/*
    Copyright (C) 2022  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.tan;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
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

    private final RealisticSurvivalPlugin plugin;

    public TanEnchants(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
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
