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
package me.val_mobile.tan;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class DisplayTask extends BukkitRunnable {

    private final static HashMap<UUID, DisplayTask> tasks = new HashMap<>();
    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final RSVPlayer player;
    private final CharacterValues characterValues;
    private final boolean tempEnabled;
    private final boolean thirstEnabled;
    private final Collection<String> allowedWorlds;


    public DisplayTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.characterValues = new CharacterValues();
        this.tempEnabled = config.getBoolean("Temperature.Enabled");
        this.thirstEnabled = config.getBoolean("Thirst.Enabled");
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        DataModule module = ((DataModule) this.player.getDataModuleFromName(TanModule.NAME));
        GameMode mode = player.getGameMode(); // get the gamemode

        if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE || !player.isOnline() && allowedWorlds.contains(player.getWorld().toString())) {
            int temperature = (int) Math.round(module.getTemperature());
            int thirst = (int) Math.round(module.getThirst());
            boolean isUnderwater = player.getRemainingAir() < 300 ? true : false;

            String actionbarText;

            if (tempEnabled && thirstEnabled) {
                actionbarText = characterValues.getTemperatureThirstActionbar(temperature, thirst, isUnderwater);
            }
            else {
                // only temperature is enabled
                if (tempEnabled) {
                    actionbarText = characterValues.getTemperatureOnlyActionbar(temperature);
                }
                // only thirst is enabled
                else {
                    actionbarText = characterValues.getThirstOnlyActionbar(thirst, isUnderwater);
                }
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText));

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.*")) {
                if (temperature < 6 || temperature > 19 || thirst < 5) {
                    char titleText = ' ';

                    if (config.getBoolean("Temperature.Hypothermia.ScreenTinting.Enabled")) {
                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.coldvisual")) {
                            if (config.getBoolean("Temperature.Hypothermia.ScreenTinting.UseVanillaFreezeEffect")) {
                                Utils.setFreezingView(player, config.getInt("VisualTickSpeed") + 5);
                            }
                            else {
                                titleText += characterValues.getIceVignette(temperature);
                            }
                        }
                    }

                    if (config.getBoolean("Temperature.Hyperthermia.ScreenTinting.Enabled")) {
                        if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotvisual")) {
                            titleText += characterValues.getFireVignette(temperature);
                        }
                    }

                    if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hotvisual")) {
                        titleText += characterValues.getFireVignette(temperature);
                    }

                    if (!(Character.valueOf(titleText).equals(' '))) {
                        player.sendTitle(String.valueOf(titleText), "", 0, 70, 0);
                    }
                }
            }

        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            tasks.remove(player.getUniqueId());
            cancel();
        }
    }

    public void start() {
        int tickSpeed = config.getInt("VisualTickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static HashMap<UUID, DisplayTask> getTasks() {
        return tasks;
    }
}
