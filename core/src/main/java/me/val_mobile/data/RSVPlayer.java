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

import me.val_mobile.baubles.BaubleModule;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.tan.TanModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class RSVPlayer {

    private UUID uuid;
    private final RealisticSurvivalPlugin plugin;
    private HashMap<String, RSVDataModule> dataModules = new HashMap<>();
    private static HashMap<UUID, RSVPlayer> players = new HashMap<>();

    public RSVPlayer(RealisticSurvivalPlugin plugin, Player player) {
        this.uuid = player.getUniqueId();
        this.plugin = plugin;
        Collection<RSVModule> modules = RSVModule.getModules().values();
        for (RSVModule module : modules) {
            if (module.isEnabled()) {
                dataModules.putIfAbsent(module.getName(), getDataModuleFromName(module.getName()));
            }
        }

        retrieveData();
        players.put(uuid, this);
    }

    public static HashMap<UUID, RSVPlayer> getPlayers() {
        return players;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public void setUUID(Player player) {
        this.uuid = player.getUniqueId();
    }

    public HashMap<String, RSVDataModule> getDataModules() {
        return dataModules;
    }

    public void retrieveData() {
        Collection<RSVDataModule> mod = dataModules.values();

        for (RSVDataModule module : mod) {
            module.retrieveData();
        }
    }

    public void saveData() {
        Collection<RSVDataModule> modules = dataModules.values();
        for (RSVDataModule module : modules) {
            module.saveData();
        }
    }

    public RSVDataModule getDataModuleFromName(String name) {

        RSVDataModule module = null;

        switch (name) {
            case BaubleModule.NAME -> module = new me.val_mobile.data.baubles.DataModule(getPlayer());
            case TanModule.NAME -> module = new DataModule(plugin, getPlayer());
        }
        return module;
    }
}
