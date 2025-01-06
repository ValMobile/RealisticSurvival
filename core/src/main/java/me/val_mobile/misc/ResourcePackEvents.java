/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.misc;

import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcePackEvents implements Listener {

    private final RSVPlugin plugin;
    public ResourcePackEvents(RSVPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // if the plugin is run in version 1.21.3 or above
        if (Utils.getMinecraftVersion(false).compareTo("1.21.3") >= 0) {
            player.setResourcePack(plugin.getConfig().getString("ResourcePack.Url_1_21_3"));
        }
        // if the plugin is run in version 1.21.2 or below
        else {
            player.setResourcePack(plugin.getConfig().getString("ResourcePack.Url"));
        }
    }

}