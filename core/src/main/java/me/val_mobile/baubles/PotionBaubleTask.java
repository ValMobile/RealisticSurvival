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
package me.val_mobile.baubles;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class PotionBaubleTask extends BukkitRunnable {

    private final DataModule dataModule;
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final PotionBauble potionBauble;

    public PotionBaubleTask(PotionBauble potionBauble, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
        this.potionBauble = potionBauble;
        this.dataModule = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");
        UUID id = rsvPlayer.getPlayer().getUniqueId();
        HashMap<UUID, Collection> baubles = TickableBaubleManager.getBaubles();

        Collection<PotionBauble> potBaubles = (baubles.containsKey(id)) ? baubles.get(id) : new ArrayList<>();

        potBaubles.add(potionBauble);
        baubles.put(id, potBaubles);
    }

    @Override
    public void run() {
        // if the player has rings of res in his/her inventory
        int amount = getAmount();

        if (amount > 0) {
            // effect the player with resistance
            ability(amount);
        }
        // if the player doesn't have rings of res in his/her inventory
        else {
            // update static hashmap values and cancel the runnable
            cancel();
        }
    }

    public void startRunnable() {
        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();

        int tickSpeed = config.getInt("Items." + potionBauble.getName() + ".TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    private int getAmount() {
        TickableBaubleManager manager = TickableBaubleManager.valueOf(potionBauble.getName().toUpperCase());

        return dataModule.getBaubleAmount(manager.getName());
    }

    public void ability(int amount) {
        Player player = rsvPlayer.getPlayer();
        Collection<PotionBaubleEffect> effects = potionBauble.getEffects();
        for (PotionBaubleEffect effect : effects) {
            int baseAmp = effect.getAmplifier();
            int inc = effect.getIncrement();
            int amp = baseAmp + (amount - 1) * inc;

            player.addPotionEffect(new PotionEffect(effect.getType(), effect.getDuration(), amp));
        }
    }

    public PotionBauble getPotionBauble() {
        return potionBauble;
    }
}
