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

import java.util.*;

public class PotionBaubleTask extends BukkitRunnable {

    private static final HashMap<UUID, Collection<PotionBaubleTask>> tasks = new HashMap<>();
    private final DataModule dataModule;
    private final RSVPlayer rsvPlayer;
    private final UUID id;
    private final Collection<String> allowedWorlds;
    private final RealisticSurvivalPlugin plugin;
    private final PotionBauble potionBauble;

    public PotionBaubleTask(PotionBauble potionBauble, RSVPlayer rsvPlayer, RealisticSurvivalPlugin plugin) {
        this.rsvPlayer = rsvPlayer;
        this.id = rsvPlayer.getPlayer().getUniqueId();
        this.allowedWorlds = RSVModule.getModule(BaubleModule.NAME).getAllowedWorlds();
        this.plugin = plugin;
        this.potionBauble = potionBauble;
        this.dataModule = rsvPlayer.getBaubleDataModule();
        HashMap<UUID, Collection> baubles = TickableBaubleManager.getBaubles();

        Collection<PotionBauble> potBaubles = (baubles.containsKey(id)) ? baubles.get(id) : new ArrayList<>();

        potBaubles.add(potionBauble);
        baubles.put(id, potBaubles);
        if (tasks.containsKey(id)) {
            Collection<PotionBaubleTask> colTasks = new ArrayList<>(tasks.get(id));
            colTasks.add(this);
            tasks.replace(id, colTasks);
        }
        else {
            tasks.put(id, List.of(this));
        }
    }

    @Override
    public void run() {
        Player player = rsvPlayer.getPlayer();

        if (player == null) {
            tasks.remove(id);
            cancel();
        }
        else {
            if (!player.isDead() && player.isOnline() && allowedWorlds.contains(player.getWorld().getName())) {
                // if the player has rings of res in his/her inventory
                int amount = getAmount();

                if (amount > 0) {
                    // effect the player with resistance
                    ability(amount);
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    if (tasks.get(id).size() < 2) {
                        tasks.remove(id);
                    }
                    else {
                        Collection<PotionBaubleTask> colTasks = tasks.get(id);
                        colTasks.remove(this);
                        tasks.put(id, colTasks);
                    }
                    cancel();
                }
            }
            else {
                tasks.remove(id);
                cancel();
            }
        }
    }

    public void start() {
        FileConfiguration config = RSVModule.getModule(BaubleModule.NAME).getUserConfig().getConfig();

        int tickSpeed = config.getInt("Items." + potionBauble.getName() + ".TickTime"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
    }

    private int getAmount() {
        return dataModule.getBaubleAmount(potionBauble.getName());
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

    public static boolean hasTask(UUID id, String name) {
        if (tasks.containsKey(id)) {
            Collection<PotionBaubleTask> colTasks = tasks.get(id);

            if (colTasks != null) {
                for (PotionBaubleTask t : colTasks) {
                    if (t.getPotionBauble().getName().equals(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public UUID getId() {
        return id;
    }

    public HashMap<UUID, Collection<PotionBaubleTask>> getTasks() {
        return tasks;
    }
}
