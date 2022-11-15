package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

public interface LightningDragon extends Dragon {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    default void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragons.LightningDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(CONFIG.getDouble("Dragons.LightningDragon.MeleeAttack.BaseDamage") * stageMultiplier, getEntity());
    }

    default void performSpecialAbility(LivingEntity entity) {
        Location loc = entity.getLocation();
        if (CONFIG.getBoolean("Dragons.LightningDragon.ElectrocuteAbility.SummonCosmeticLightning")) {
            loc.getWorld().strikeLightningEffect(loc);
        }
        else {
            loc.getWorld().strikeLightning(loc);
        }
        if (!ElectrocuteTask.hasTask(entity.getUniqueId())) {
            new ElectrocuteTask(RealisticSurvivalPlugin.getPlugin(), getStage(), entity).start();
        }
    }

    default void triggerBreathAttack(Location target) {
        new LightningBreath(this, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    default void triggerExplosionAttack(Location target) {
        new LightningExplosionAttack(this, target, RealisticSurvivalPlugin.getPlugin()).start();
    }
}
