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
package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class FreezeTask extends BukkitRunnable {

    private static final Map<UUID, FreezeTask> tasks = new HashMap<>();
    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private final Collection<FrozenBlock> blocks = new ArrayList<>();
    private final FileConfiguration config;
    private final boolean encaseIce;
    private final boolean playSound;
    private final PotionEffect slowness;
    private final Material frozenMaterial;
    private final String soundName;
    private final float volume;
    private final float pitch;
    private final int duration;
    private final boolean wasOriginallyFrozen;

    public FreezeTask(RealisticSurvivalPlugin plugin, int stage, Entity entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        this.encaseIce = config.getBoolean("Dragon.IceDragon.FreezeAbility.EncaseIce.Enabled");
        this.playSound = config.getBoolean("Dragon.IceDragon.FreezeAbility.Sound.Enabled");

        int amplifier = config.getInt("Dragon.IceDragon.FreezeAbility.Slowness.Amplifier.Stage" + stage);
        int duration = config.getInt("Dragon.IceDragon.FreezeAbility.Duration.Amplifier.Stage" + stage);
        this.slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        this.frozenMaterial = Material.valueOf(config.getString("Dragon.IceDragon.FreezeAbility.EncaseIce.Block"));
        this.volume = (float) config.getDouble("Dragon.IceDragon.FreezeAbility.Sound.Volume");
        this.pitch = (float) config.getDouble("Dragon.IceDragon.FreezeAbility.Sound.Pitch");
        this.soundName = config.getString("Dragon.IceDragon.FreezeAbility.Sound.Sound");
        this.duration = config.getInt("Dragon.IceDragon.FreezeAbility.FrozenDuration.Stage" + stage);
        this.wasOriginallyFrozen = entity instanceof LivingEntity living && !living.hasAI();
        tasks.put(entity.getUniqueId(), this);
    }

    public FreezeTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Entity entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.encaseIce = config.getBoolean("Items." + itemName + ".FreezeAbility.EncaseIce.Enabled");
        this.playSound = config.getBoolean("Items." + itemName + ".FreezeAbility.Sound.Enabled");
        int amplifier = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Amplifier");
        int duration = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Duration");
        this.slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        this.frozenMaterial = Material.valueOf(config.getString("Items." + itemName + ".FreezeAbility.EncaseIce.Block"));
        this.volume = (float) config.getDouble("Items." + itemName + ".FreezeAbility.Sound.Volume");
        this.pitch = (float) config.getDouble("Items." + itemName + ".FreezeAbility.Sound.Pitch");
        this.soundName = config.getString("Items." + itemName + ".FreezeAbility.Sound.Sound");
        this.duration = config.getInt("Items." + itemName + ".FreezeAbility.FrozenDuration");
        this.wasOriginallyFrozen = entity instanceof LivingEntity living && !living.hasAI();
        tasks.put(entity.getUniqueId(), this);
    }

    @Override
    public void run() {
        // add the slowness effect to the target entity
        if (entity instanceof LivingEntity living) {
            living.addPotionEffect(slowness);
            living.setAI(false);
        }
        // freeze the entity
        Utils.setZeroKb(entity);

        // encase the entity with ice
        Location loc = entity.getLocation().clone(); // get the location

        double height = entity.getHeight();

        if (encaseIce) {
            blocks.add(new FrozenBlock(loc, frozenMaterial));
            for (int i = 0; i < height - 1; i++) {
                blocks.add(new FrozenBlock(loc.add(0, 1, 0), frozenMaterial));
            }
        }

        if (playSound) {
            // play the ice break sound effect
            Utils.playSound(loc, soundName, volume, pitch);
        }

        // remove the ice block after some time
        if (encaseIce) {
            if (!UnfreezeTask.hasTask(entity.getUniqueId())) {
                new UnfreezeTask(plugin, entity, blocks, duration, wasOriginallyFrozen).start();
            }
        }

        tasks.remove(entity.getUniqueId());
    }

    public void start() {
        runTask(plugin);
    }

    public static Map<UUID, FreezeTask> getTasks() {
        return tasks;
    }

    public static boolean hasTask(UUID id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id) != null;
        }
        return false;
    }
}
