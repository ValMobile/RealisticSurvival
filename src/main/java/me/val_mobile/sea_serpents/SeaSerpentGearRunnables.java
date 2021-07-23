package me.val_mobile.sea_serpents;

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SeaSerpentGearRunnables {

    public static void updateTideGuardianArmor(Player player) {
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

    public static BukkitRunnable getTideGuardianArmorRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (PlayerRunnable.getTideArmor().get(player.getName()) != 0) {
                    SeaSerpentGearAbilities.TideGuardianArmorAbility(player, PlayerRunnable.getTideArmor().get(player.getName()));
                }
            }
        };
    }
}
