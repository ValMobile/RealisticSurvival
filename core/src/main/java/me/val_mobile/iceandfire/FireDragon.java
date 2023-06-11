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
        double stageMultiplier = CONFIG.getDouble("Dragon.FireDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(CONFIG.getDouble("Dragon.FireDragon.MeleeAttack.BaseDamage") * stageMultiplier, getEntity());
    }

    @Override
    default void performSpecialAbility(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragon.FireDragon.InfernoAbility.StageMultiplier.Stage" + getStage());
        if (!BurnTask.hasTask(entity.getUniqueId())) {
            new BurnTask(RealisticSurvivalPlugin.getPlugin(), entity, (int) (CONFIG.getInt("Dragon.FireDragon.InfernoAbility.FireTicks") * stageMultiplier), CONFIG.getInt("Dragon.FireDragon.InfernoAbility.TickPeriod")).start();
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
