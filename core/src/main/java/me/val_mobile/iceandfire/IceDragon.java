package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.FreezeTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

public interface IceDragon extends Dragon {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    default void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragons.IceDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(CONFIG.getDouble("Dragons.IceDragon.MeleeAttack.BaseDamage") * stageMultiplier, getEntity());
    }

    default void performSpecialAbility(LivingEntity entity) {
        if (!FreezeTask.hasTask(entity.getUniqueId())) {
            new FreezeTask(RealisticSurvivalPlugin.getPlugin(), getStage(), entity).start();
        }
    }

    default void triggerBreathAttack(Location target) {
        new IceBreath(this, target, RealisticSurvivalPlugin.getPlugin()).start();
    }

    default void triggerExplosionAttack(Location target) {
        new IceExplosionAttack(this, target, RealisticSurvivalPlugin.getPlugin()).start();
    }
}
