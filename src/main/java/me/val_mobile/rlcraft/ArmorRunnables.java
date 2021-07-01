package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ArmorRunnables {

    private final RLCraft plugin;
    private final BaseRunnables baseRunnables;
    private final ArmorAbilities armorAbilities;

    public ArmorRunnables(RLCraft instance) {
        plugin = instance;
        armorAbilities = new ArmorAbilities(instance);
        baseRunnables = new BaseRunnables(instance);
    }

    public void checkTideGuardianArmor(Player player) {
        boolean hasTideGuardianArmor = false;
        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (! (item == null || item.getType() == Material.AIR)) {
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Tide Guardian Armor")) {
                    hasTideGuardianArmor = true;
                    break;
                }
            }
        }
        if (plugin.tideArmor.containsKey(player.getUniqueId())) {
            plugin.tideArmor.replace(player.getUniqueId(), plugin.tideArmor.get(player.getUniqueId()), hasTideGuardianArmor);
        }
        else {
            plugin.tideArmor.put(player.getUniqueId(), hasTideGuardianArmor);
        }

    }

    public BukkitRunnable getTideGuardianArmorRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.tideArmor.get(player.getUniqueId())) {
                    armorAbilities.TideGuardianArmorAbility(player);
                }
            }
        };
    }
}
