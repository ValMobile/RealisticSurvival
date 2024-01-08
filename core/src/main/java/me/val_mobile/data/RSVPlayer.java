/*
    Copyright (C) 2024  Val_Mobile

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
import me.val_mobile.tan.TanModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RSVPlayer {

    private final UUID uuid;
    private final DataModule tanDataModule;
    private final me.val_mobile.data.baubles.DataModule baubleDataModule;
    private static final Map<UUID, RSVPlayer> players = new HashMap<>();

    public RSVPlayer(Player player) {
        this.uuid = player.getUniqueId();
        baubleDataModule = RSVModule.getModule(BaubleModule.NAME).isGloballyEnabled() ? new me.val_mobile.data.baubles.DataModule(player) : null;

        tanDataModule = RSVModule.getModule(TanModule.NAME).isGloballyEnabled() ? new DataModule(player) : null;

        players.put(uuid, this);
    }

    @Nonnull
    public static Map<UUID, RSVPlayer> getPlayers() {
        return players;
    }

    @Nullable
    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public void retrieveData() {
        if (tanDataModule != null) {
            tanDataModule.retrieveData();
        }
        if (baubleDataModule != null) {
            baubleDataModule.retrieveData();
        }
    }

    public void saveData() {
        if (tanDataModule != null) {
            tanDataModule.saveData();
        }
        if (baubleDataModule != null) {
            baubleDataModule.saveData();
        }
    }

    @Nullable
    public DataModule getTanDataModule() {
        return tanDataModule;
    }

    @Nullable
    public me.val_mobile.data.baubles.DataModule getBaubleDataModule() {
        return baubleDataModule;
    }

    public static boolean isValidPlayer(@Nullable Player player) {
        if (player == null) {
            return false;
        }

        if (players.containsKey(player.getUniqueId())) {
            return players.get(player.getUniqueId()) != null;
        }
        return false;
    }

    public static boolean isValidPlayer(@Nullable UUID id) {
        if (id == null) {
            return false;
        }

        if (players.containsKey(id)) {
            return players.get(id) != null;
        }
        return false;
    }
}
