/*
    Copyright (C) 2024  Val_Mobile

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
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

public interface LightningDragon extends Dragon {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    default void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = CONFIG.getDouble("Dragon.LightningDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(CONFIG.getDouble("Dragon.LightningDragon.MeleeAttack.BaseDamage") * stageMultiplier, getEntity());
    }

    default void performSpecialAbility(LivingEntity entity) {
        Location loc = entity.getLocation();
        if (CONFIG.getBoolean("Dragon.LightningDragon.ElectrocuteAbility.SummonCosmeticLightning")) {
            loc.getWorld().strikeLightningEffect(loc);
        }
        else {
            loc.getWorld().strikeLightning(loc);
        }
        if (!ElectrocuteTask.hasTask(entity.getUniqueId())) {
            new ElectrocuteTask(RSVPlugin.getPlugin(), getStage(), entity).start();
        }
    }

    default void triggerBreathAttack(Location target) {
        new LightningBreath(this, target, RSVPlugin.getPlugin()).start();
    }

    default void triggerExplosionAttack(Location target) {
        new LightningExplosionAttack(this, target, RSVPlugin.getPlugin()).start();
    }
}
