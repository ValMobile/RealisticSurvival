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
package me.val_mobile.iceandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SeaSerpentGearRunnables {

    private final RealisticSurvivalPlugin plugin;
    private final Utils util;
    public SeaSerpentGearRunnables(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
        util = new Utils(plugin);
    }

    public void updateTideGuardianArmor(Player player) {
        int pieces = 0;
        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (! (item == null || item.getType() == Material.AIR)) {
                if (util.hasNbtTag(item,"tide_guardian_armor")) {
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
                if (PlayerRunnable.getTideArmor().get(player.getName()) != 0) {
                    SeaSerpentGearAbilities.TideGuardianArmorAbility(player, PlayerRunnable.getTideArmor().get(player.getName()));
                }
            }
        };
    }

    public void startTideGuardianRunnable(Player player) {
        String name = player.getName();

        int tickSpeed = RSVFiles.getIfUserConfig().getInt("Abilities.TideGuardian.TickTime");
        getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        Utils.setOrReplaceEntry(PlayerRunnable.getTideArmorRunnables(), name, true);
    }

    public void resetArmorMaps(Player player) {
        Utils.setOrReplaceEntry(PlayerRunnable.getTideArmor(), player.getName(), 0);
    }
}