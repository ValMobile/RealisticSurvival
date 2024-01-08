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
package me.val_mobile.baubles;

import me.val_mobile.data.baubles.GUI;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class WormholeInventory extends GUI {

    private final NavigableMap<UUID, Integer> players = new TreeMap<>();
    private final Collection<Integer> notAllowed = List.of(17, 18, 26, 27, 35, 36);
    private final FileConfiguration config;
    private int nextSlot = 10;

    public WormholeInventory(RSVPlugin plugin, BaubleModule module) {
        super(null, 54, "Wormhole Inventory");
        this.config = module.getUserConfig().getConfig();
        Inventory inv = getInventory();

        ItemStack guiGlass = RSVItem.getItem("gui_glass");

        int size = inv.getSize();

        for (int i = 0; i < size; i++) {
            if (!Utils.isItemReal(inv.getItem(i))) {
                inv.setItem(i, guiGlass);
            }
        }
    }

    public void addPlayer(Player player) {
        UUID id = player.getUniqueId();
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = skull.getItemMeta();
        if (player.isOnline()) {
            ((SkullMeta) meta).setOwningPlayer(Bukkit.getPlayer(id));
        }
        else {
            ((SkullMeta) meta).setOwningPlayer(Bukkit.getOfflinePlayer(id));
        }

        meta.setDisplayName(Utils.translateMsg(config.getString("WormholeInventory.SkullName"), player, Map.of("PLAYER_NAME", player.getDisplayName())));

        skull.setItemMeta(meta);
        if (!players.containsKey(id)) {
            if (nextSlot > 9 && nextSlot < 44) {
                if (notAllowed.contains(nextSlot)) {
                    while (notAllowed.contains(nextSlot)) {
                        nextSlot++;
                    }
                    players.put(id, nextSlot);
                    getInventory().setItem(nextSlot, skull);
                }
                else {
                    players.put(id, nextSlot);
                    getInventory().setItem(nextSlot, skull);
                    nextSlot++;
                }
            }
        }
    }

    public boolean containsPlayer(Player player) {
        if (players.containsKey(player.getUniqueId())) {
            return players.get(player.getUniqueId()) != null;
        }
        return false;
    }

    public void removePlayer(Player player) {
        if (containsPlayer(player)) {
            UUID id = player.getUniqueId();
            int slot = players.get(id);
            // slot = 11,
            if (players.lastKey().equals(id)) {
                players.remove(id);
                getInventory().setItem(slot, RSVItem.getItem("gui_glass"));
                nextSlot--;
            }
            else {
                // swap items
                Map.Entry<UUID, Integer> lastEntry = players.lastEntry();
                UUID lastId = lastEntry.getKey();
                int lastSlot = lastEntry.getValue();

                players.put(lastId, slot);
                getInventory().setItem(slot, getInventory().getItem(lastSlot));
                getInventory().setItem(lastSlot, RSVItem.getItem("gui_glass"));
                players.remove(id);
                nextSlot = lastSlot;
            }
        }
    }
}
