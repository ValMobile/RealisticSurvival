/*
    Copyright (C) 2023  Val_Mobile

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
package me.val_mobile.ntp;

import me.val_mobile.data.ModuleItems;
import me.val_mobile.data.ModuleRecipes;
import me.val_mobile.data.RSVModule;
import me.val_mobile.data.notreepunching.ItemConfig;
import me.val_mobile.data.notreepunching.RecipesConfig;
import me.val_mobile.data.notreepunching.UserConfig;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Map;

public class NtpModule extends RSVModule {

    private final RealisticSurvivalPlugin plugin;

    private NtpEvents events;

    public static final String NAME = "NoTreePunching";

    public NtpModule(RealisticSurvivalPlugin plugin) {
        super(NAME, plugin, Map.of(), Map.of());
        this.plugin = plugin;
    }

    @Override
    public void initialize() {
        setUserConfig(new UserConfig(plugin));
        setItemConfig(new ItemConfig(plugin));
        setRecipeConfig(new RecipesConfig(plugin));
        setModuleItems(new ModuleItems(this));
        setModuleRecipes(new ModuleRecipes(this, plugin));

        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Initialize.Enabled")) {
            String message = Utils.translateMsg(config.getString("Initialize.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }

        events = new NtpEvents(this, plugin);

        getModuleItems().initialize();
        getModuleRecipes().initialize();
        events.initialize();

        if (config.getBoolean("Lumberjack.RemovePlankRecipes")) {
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "acacia_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "birch_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "crimson_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "dark_oak_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "jungle_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "mangrove_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "oak_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "spruce_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "warped_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "cherry_planks"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "bamboo_planks"));
        }

        if (config.getBoolean("Lumberjack.RemoveStickRecipes")) {
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "stick"));
        }

        if (config.getBoolean("FireStarter.RemoveVanillaCampfireRecipes")) {
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "campfire"));
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "soul_campfire"));
        }

        if (config.getBoolean("Pottery.RemoveFlowerPotRecipe")) {
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "flower_pot"));
        }

        if (config.getBoolean("Pottery.RemoveBrickSmeltingRecipe")) {
            Bukkit.removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "brick"));
        }
    }

    @Override
    public void shutdown() {
        FileConfiguration config = getUserConfig().getConfig();
        if (config.getBoolean("Shutdown.Enabled")) {
            String message = Utils.translateMsg(config.getString("Shutdown.Message"), null, Map.of("NAME", NAME));

            plugin.getLogger().info(message);
        }
    }

    public NtpEvents getEvents() {
        return events;
    }
}
