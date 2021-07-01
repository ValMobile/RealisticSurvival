package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;

public class BaseRunnables {

    private final RLCraft plugin;

    public BaseRunnables(RLCraft instance) {
        plugin = instance;;
    }

    public void resetBaubleMaps(Player player) {
        if (plugin.prRes.containsKey(player.getUniqueId())) {
            plugin.prRes.replace(player.getUniqueId(), plugin.prRes.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prRes.put(player.getUniqueId(), 0);
        }

        if (plugin.prRegen.containsKey(player.getUniqueId())) {
            plugin.prRegen.replace(player.getUniqueId(), plugin.prRegen.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prRegen.put(player.getUniqueId(), 0);
        }

        if (plugin.prStrength.containsKey(player.getUniqueId())) {
            plugin.prStrength.replace(player.getUniqueId(), plugin.prStrength.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prStrength.put(player.getUniqueId(), 0);
        }

        if (plugin.prSpeed.containsKey(player.getUniqueId())) {
            plugin.prSpeed.replace(player.getUniqueId(), plugin.prSpeed.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prSpeed.put(player.getUniqueId(), 0);
        }

        if (plugin.prJump.containsKey(player.getUniqueId())) {
            plugin.prJump.replace(player.getUniqueId(), plugin.prJump.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prJump.put(player.getUniqueId(), 0);
        }

        if (plugin.prHaste.containsKey(player.getUniqueId())) {
            plugin.prHaste.replace(player.getUniqueId(), plugin.prHaste.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prHaste.put(player.getUniqueId(), 0);
        }

        if (plugin.dragonsEye.containsKey(player.getUniqueId())) {
            plugin.dragonsEye.replace(player.getUniqueId(), plugin.dragonsEye.get(player.getUniqueId()), false);
        }
        else {
            plugin.dragonsEye.put(player.getUniqueId(), false);
        }

        if (plugin.scarliteRing.containsKey(player.getUniqueId())) {
            plugin.scarliteRing.replace(player.getUniqueId(), plugin.scarliteRing.get(player.getUniqueId()), false);
        }
        else {
            plugin.scarliteRing.put(player.getUniqueId(), false);
        }

    }
}
