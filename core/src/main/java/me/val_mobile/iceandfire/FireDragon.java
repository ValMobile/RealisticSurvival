package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

public interface FireDragon extends Dragon {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    @Override
    default void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragons.FireDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(CONFIG.getDouble("Dragons.FireDragon.MeleeAttack.BaseDamage") * stageMultiplier, getEntity());
    }

    @Override
    default void performSpecialAbility(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragons.FireDragon.InfernoAbility.StageMultiplier.Stage" + getStage());
        if (!BurnTask.hasTask(entity.getUniqueId())) {
            new BurnTask(RealisticSurvivalPlugin.getPlugin(), entity, (int) (CONFIG.getInt("Dragons.FireDragon.InfernoAbility.FireTicks") * stageMultiplier), CONFIG.getInt("Dragons.FireDragon.InfernoAbility.TickPeriod")).start();
        }
    }

    @Override
    default void triggerBreathAttack(Location target) {
        new FireBreath(this, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    @Override
    default void triggerExplosionAttack(Location target) {
        new FireExplosionAttack(this, target, RealisticSurvivalPlugin.getPlugin());
    }
}
