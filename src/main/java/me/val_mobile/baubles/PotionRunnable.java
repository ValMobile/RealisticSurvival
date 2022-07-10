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

import me.val_mobile.data.RSVFiles;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.baubles.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class PotionRunnable extends BukkitRunnable {

    private static HashMap<UUID, Collection<PotionBauble>> baubles = new HashMap<>();

    private final DataModule dataModule;
    private final RSVPlayer rsvPlayer;
    private final RealisticSurvivalPlugin plugin;
    private final PotionBauble potionBauble;

    public PotionRunnable(PotionBauble potionBauble, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.plugin = plugin;
        this.potionBauble = potionBauble;
        this.dataModule = (DataModule) rsvPlayer.getDataModuleFromName("Baubles");
        UUID id = rsvPlayer.getPlayer().getUniqueId();
        Collection<PotionBauble> potBaubles;
        if (baubles.containsKey(id)) {
            potBaubles = baubles.get(id);
        }
        else {
            potBaubles = new ArrayList<>();
        }
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
        int tickSpeed = RSVFiles.getBaubleUserConfig().getInt(potionBauble.getName() + ".TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    private int getAmount() {
        int amount = 0;
        switch (potionBauble) {
            case POTION_RING_RESISTANCE:
                amount = dataModule.getPotionResRings();
                break;
            case POTION_RING_STRENGTH:
                amount = dataModule.getPotionStrRings();
                break;
            case POTION_RING_REGENERATION:
                amount = dataModule.getPotionRegenRings();
                break;
            case POTION_RING_SPEED:
                amount = dataModule.getPotionSpeedRings();
                break;
            case POTION_RING_HASTE:
                amount = dataModule.getPotionHasteRings();
                break;
            case POTION_RING_JUMP_BOOST:
                amount = dataModule.getPotionJumpRings();
                break;
            case DRAGONS_EYE:
                amount = dataModule.getDragonsEye();
                break;
            case SHIELD_HONOR:
                amount = dataModule.getShieldHonor();
                break;
            case MINERS_RING:
                amount = dataModule.getMinersRing();
                break;
            case PHANTOM_PRISM:
                amount = dataModule.getPhantomPrism();
                break;
        }
        return amount;
    }

    public void ability(int amount) {
        Player player = rsvPlayer.getPlayer();
        Collection<RSVPotionEffect> effects = potionBauble.getEffects();
        for (RSVPotionEffect effect : effects) {
            int baseAmp = effect.getAmplifier();
            int inc = effect.getIncrement();
            int amp = baseAmp + (amount - 1) * inc;

            player.addPotionEffect(new PotionEffect(effect.getType(), effect.getDuration(), amp));
        }
    }

    public PotionBauble getPotionBauble() {
        return potionBauble;
    }

    public static HashMap<UUID, Collection<PotionBauble>> getBaubleMap() {
        return baubles;
    }
}
