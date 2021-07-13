package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SeaSerpentGearRunnables {

    private final Utils util;
    private final SeaSerpentGearAbilities seaSerpentGearAbilities = new SeaSerpentGearAbilities();
    public SeaSerpentGearRunnables(RLCraft instance) {
        util = new Utils(instance);
    }

    public void checkTideGuardianArmor(Player player) {
        int pieces = 0;
        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (! (item == null || item.getType() == Material.AIR)) {
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Tide Guardian Armor")) {
                    pieces++;
                    break;
                }
            }
        }
        Utils.setOrReplaceEntry(PlayerRunnable.getTideArmor(), player.getName(), pieces);

    }

    public BukkitRunnable getTideGuardianArmorRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    util.resetArmorMaps(player);
                }
                if (PlayerRunnable.getTideArmor().get(player.getName()) != 0) {
                    seaSerpentGearAbilities.TideGuardianArmorAbility(player, PlayerRunnable.getTideArmor().get(player.getName()));
                }
            }
        };
    }
}
