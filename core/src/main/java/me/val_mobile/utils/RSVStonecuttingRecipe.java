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
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.StonecuttingRecipe;

public class RSVStonecuttingRecipe extends StonecuttingRecipe {

    public RSVStonecuttingRecipe(FileConfiguration config, String name, RealisticSurvivalPlugin plugin) {
        super(new NamespacedKey(plugin, name), RSVRecipe.getResult(config, name), RSVRecipe.getRecipeChoice(config.getString(name + ".Input")));
    }
}
