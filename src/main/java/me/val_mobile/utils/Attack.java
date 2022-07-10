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
package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Method;
import java.util.logging.Level;

public class Attack {
    private static RealisticSurvivalPlugin plugin;

    private static final String VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    private static Class<?> craftPlayerClass;

    private static Class<?> craftEntityClass;

    private static Class<?> entityClass;

    private static Method playerHandle;

    private static Method entityHandle;

    public static void load(RealisticSurvivalPlugin plugin) throws Exception {
        Attack.plugin = plugin;
        craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + VERSION + ".entity.CraftPlayer");
        craftEntityClass = Class.forName("org.bukkit.craftbukkit." + VERSION + ".entity.CraftEntity");
        try {
            entityClass = Class.forName("net.minecraft.world.entity.Entity");
        } catch (ClassNotFoundException e) {
            entityClass = Class.forName("net.minecraft.server." + VERSION + ".Entity");
        }
        playerHandle = craftPlayerClass.getDeclaredMethod("getHandle", new Class[0]);
        entityHandle = craftEntityClass.getDeclaredMethod("getHandle", new Class[0]);
    }

    public static void attack(Player player, Entity entity) {
        try {
            Object nmsPlayer = playerHandle.invoke(craftPlayerClass.cast(player), new Object[0]);
            Object nmsEntity = entityHandle.invoke(craftEntityClass.cast(entity), new Object[0]);
            Method attack = nmsPlayer.getClass().getDeclaredMethod("attack", new Class[] { entityClass });
            attack.invoke(nmsPlayer, new Object[] { nmsEntity });
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Failed to load Reach!");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }
}
