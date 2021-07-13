package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcePackEvents implements Listener {

    private final RLCraft plugin;
    public ResourcePackEvents(RLCraft instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (plugin.getConfig().getBoolean("ResourcePack.Enabled")) {
            player.setResourcePack(plugin.getConfig().getString("ResourcePack.URL"));
        }

    }

}
