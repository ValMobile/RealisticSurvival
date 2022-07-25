package me.val_mobile.spartanweaponry;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.FrozenBlock;
import me.val_mobile.spartanandfire.UnfreezeTask;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;

public class KbTask extends BukkitRunnable {

    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private final double multiplier;

    public KbTask(RealisticSurvivalPlugin plugin, Entity entity, double multiplier) {
        this.entity = entity;
        this.plugin = plugin;
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        entity.setVelocity(entity.getVelocity().multiply(multiplier));
    }

    public void start() {
        runTaskLater(plugin, 1);
    }
}
