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
package me.val_mobile.data;

import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemManager {

    private final FileConfiguration itemConfig;
    private final FileConfiguration userConfig;
    private final Map<String, RSVItem> items = new HashMap<>();
    private final RSVModule module;

    public ItemManager(RSVModule module) {
        this.itemConfig = module.getItemConfig().getConfig();
        this.userConfig = module.getUserConfig().getConfig();
        this.module = module;
        initialize();
    }

    public ItemManager(FileConfiguration itemConfig) {
        this.itemConfig = itemConfig;
        this.userConfig = null;
        this.module = null;
        initialize();
    }

    public void initialize() {
        Set<String> keys = itemConfig.getKeys(false);
        keys.remove("ConfigId");

        for (String key : keys) {
            if (userConfig == null) {
                RSVItem item = new RSVItem(itemConfig, key);
                items.putIfAbsent(key, item);
            }
            else {
                if (userConfig.getBoolean("Items." + key + ".Enabled.EnableAllVersions")) {
                    RSVItem item = new RSVItem(module, key);
                    items.putIfAbsent(key, item);
                }
                else {
                    if (userConfig.contains("Items." + key + ".Enabled.Versions." + Utils.getMinecraftVersion(true))) {
                        if (userConfig.getBoolean("Items." + key + ".Enabled.Versions." + Utils.getMinecraftVersion(true))) {
                            RSVItem item = new RSVItem(module, key);
                            items.putIfAbsent(key, item);
                        }
                    }
                    else {
                        RSVItem item = new RSVItem(module, key);
                        items.putIfAbsent(key, item);
                    }
                }
            }
        }
    }

    public RSVModule getModule() {
        return module;
    }

    public Map<String, RSVItem> getItems() {
        return items;
    }

    public RSVItem getItem(String name) {
        return items.get(name);
    }
}
