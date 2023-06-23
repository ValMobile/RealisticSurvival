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
import me.val_mobile.utils.RSVItem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

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
        ConfigurationSection section = config.getConfigurationSection(id + ".Items");
        Set<String> keys = section == null ? new HashSet<>() : section.getKeys(false);
        Inventory inv = baubleBag.getInventory();

        int dataVersion = Bukkit.getUnsafe().getDataVersion();

        for (String key : keys) {
            if (config.getInt(id + ".Items." + key + ".v") != dataVersion) {
                config.set(id + ".Items." + key + ".v", dataVersion);
            }

            int k = Integer.parseInt(key);

            ItemStack item = ItemStack.deserialize(config.getConfigurationSection(id + ".Items." + key).getValues(true));

            inv.setItem(k, item);
        }

        saveFile(config);

        baubleBag.fillDefaultItems();
    }

    @Override
    public void saveData() {
        FileConfiguration config = this.config.getConfig();

        Inventory inv = baubleBag.getInventory();

        BaubleSlot[] values = BaubleSlot.values();
        Pattern pattern = Pattern.compile("^(charm|body|ring|belt|amulet|head)_slot$");
        ItemStack item;
        for (BaubleSlot slot : values) {
            for (int i : slot.getValues()) {
                item = inv.getItem(i);
                if (RSVItem.isRSVItem(item) && !pattern.matcher(RSVItem.getNameFromItem(item)).find()) {
                    config.set(id + ".Items." + i, item.serialize());
                }
                else {
                    config.set(id + ".Items." + i, null);
                }
            }
        }

        saveFile(config);
    }

    public void saveFile(FileConfiguration config) {
        try {
            config.save(this.config.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
