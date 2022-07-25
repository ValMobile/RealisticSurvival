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
package me.val_mobile.data.baubles;

import me.val_mobile.data.RSVDataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.UUID;

public class DataModule implements RSVDataModule {

    private UUID uuid;
    private BaubleInventory baubleBag;
    private final RealisticSurvivalPlugin plugin;
    private final Utils util;


    public DataModule(RealisticSurvivalPlugin plugin, Player player) {
        this.plugin = plugin;
        this.util = new Utils(plugin);
        this.uuid = player.getUniqueId();
        baubleBag = new BaubleInventory(player, plugin);
        retrieveData();
    }

    public BaubleInventory getBaubleBag() {
        return baubleBag;
    }

    public boolean hasBauble(String name) {
        return baubleBag.hasBauble(name);
    }

    public int getBaubleAmount(String name) {
        return baubleBag.getBaubleAmount(name);
    }

    @Override
    public void retrieveData() {

    }

    @Override
    public void updateData() {
    }

    @Override
    public void saveData() {

    }
}
