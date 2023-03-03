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
package me.val_mobile.data.baubles;

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.data.RSVDataModule;
import me.val_mobile.data.RSVModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

public class DataModule implements RSVDataModule {

    private final PlayerDataConfig config;
    private final BaubleInventory baubleBag;
    private final UUID id;

    public DataModule(Player player) {
        this.baubleBag = new BaubleInventory(player);
        this.config = ((BaubleModule) RSVModule.getModule(BaubleModule.NAME)).getPlayerDataConfig();
        this.id = player.getUniqueId();
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
        FileConfiguration config = this.config.getConfig();

        if (config.contains(id.toString())) {
            if (config.contains(id + ".Items")) {
                ItemStack[] items = loadItemStacks();

                if (items != null) {
                    Inventory inv = baubleBag.getInventory();

                    for (int i = 0; i < items.length; i++) {
                        inv.setItem(i, items[i]);
                    }
                }
            }
            else {
                config.createSection(id + ".Items");
                saveFile(config);
            }
        }
        else {
            String itemsPath = id + ".Items";

            config.createSection(id.toString());
            config.createSection(itemsPath);

            saveFile(config);
        }
    }

    @Override
    public void saveData() {
        FileConfiguration config = this.config.getConfig();

        config.set(id + ".Items", baubleBag.getInventory().getContents());

        saveFile(config);
    }

    public ItemStack[] loadItemStacks() {
        Object object = config.getConfig().get(id + ".Items");

        return object instanceof Collection ? ((Collection<ItemStack>) object).toArray(new ItemStack[baubleBag.getInventory().getSize()]) : null;
    }

    public void saveFile(FileConfiguration config) {
        try {
            config.save(this.config.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
