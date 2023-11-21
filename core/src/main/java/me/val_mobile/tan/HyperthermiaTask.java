/*
    Copyright (C) 2023  Val_Mobile

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

import me.val_mobile.data.RSVPlayer;
import me.val_mobile.integrations.CompatiblePlugin;
import me.val_mobile.integrations.RealisticSeasons;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.utils.RSVTask;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.*;

public class HyperthermiaTask extends BukkitRunnable implements RSVTask {

    private static final Map<UUID, HyperthermiaTask> tasks = new HashMap<>();
    private final TanModule module;
    private final FileConfiguration config;
    private final UUID id;
    private final RSVPlugin plugin;
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private final boolean damageEnabled;
    private final boolean damageImmunityEnabled;
    private final double damageCutoff;
    private final double damage;
    private final boolean potionEffectsEnabled;
    private final boolean potionImmunityEnabled;
    private final boolean igniteEnabled;
    private final int igniteTicks;
    private final boolean igniteImmunityEnabled;
    private final double minTemperature;
    private final RealisticSeasons rs;
    private final Collection<PotionEffect> potionEffects = new ArrayList<>();


    public HyperthermiaTask(TanModule module, RSVPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.module = module;
        this.config = module.getUserConfig().getConfig();
        this.player = player;
        this.id = player.getPlayer().getUniqueId();
        this.allowedWorlds = module.getAllowedWorlds();
        this.damageEnabled = config.getBoolean("Temperature.Hyperthermia.Damage.Enabled");
        this.damageImmunityEnabled = config.getBoolean("Temperature.Hyperthermia.Damage.FireResistanceImmunity");
        this.damage = config.getDouble("Temperature.Hyperthermia.Damage.Amount");
        this.damageCutoff = config.getDouble("Temperature.Hyperthermia.Damage.Cutoff");
        this.potionEffectsEnabled = config.getBoolean("Temperature.Hyperthermia.PotionEffects.Enabled");
        this.potionImmunityEnabled = config.getBoolean("Temperature.Hyperthermia.PotionEffects.FireResistanceImmunity");
        this.igniteEnabled = config.getBoolean("Temperature.Hyperthermia.Ignite.Enabled");
        this.igniteTicks = config.getInt("Temperature.Hyperthermia.Ignite.FireTicks");
        this.igniteImmunityEnabled = config.getBoolean("Temperature.Hyperthermia.Ignite.FireResistanceImmunity");
        this.minTemperature = config.getDouble("Temperature.Hyperthermia.Temperature");
        this.rs = (RealisticSeasons) CompatiblePlugin.getPlugin(RealisticSeasons.NAME);

        ConfigurationSection section = config.getConfigurationSection("Temperature.Hyperthermia.PotionEffects.Effects");
        Set<String> keys = section.getKeys(false);

        int dur;
        int amp;

        for (String key : keys) {
            dur = section.getInt(key + ".Duration");
            amp = section.getInt(key + ".Amplifier");
            potionEffects.add(new PotionEffect(PotionEffectType.getByName(key), dur, amp));
        }
        tasks.put(id, this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();

        if (conditionsMet(player)) {
            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hot.damage")) {
                if (damageEnabled && !rs.disableHyperthermiaDamage()) {
                    if (player.getHealth() >= damageCutoff) {
                        if (!(damageImmunityEnabled && player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))) {
                            if (player.getHealth() - damage <= 0) {
                                module.getHyperthermiaDeath().add(id);
                            }
                            player.damage(damage);
                        }
                    }
                }
            }

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hot.potioneffects")) {
                if (potionEffectsEnabled && !rs.disableHyperthermiaPotions()) {
                    if (!(potionImmunityEnabled && player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))) {
                        player.addPotionEffects(potionEffects);
                    }
                }
            }

            if (!player.hasPermission("realisticsurvival.toughasnails.resistance.hot.combustion")) {
                if (igniteEnabled && !rs.disableHyperthermiaIgnite()) {
                    if (player.getFireTicks() < igniteTicks) {
                        if (!(igniteImmunityEnabled && player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))) {
                            player.setFireTicks(igniteTicks);
                        }
                    }
                }
            }
        }
        else {
            stop();
        }
    }

    @Override
    public boolean conditionsMet(@Nullable Player player) {
        return globalConditionsMet(player) && !player.isDead() && allowedWorlds.contains(player.getWorld().getName()) && module.getTempManager().getTemperature(player) > minTemperature;
    }

    @Override
    public void start() {
        int tickPeriod = config.getInt("Temperature.Hyperthermia.TickPeriod"); // get the tick period
        this.runTaskTimer(plugin, 0L, tickPeriod);
    }

    @Override
    public void stop() {
        tasks.remove(id);
        cancel();
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }

    public static Map<UUID, HyperthermiaTask> getTasks() {
        return tasks;
    }
}
