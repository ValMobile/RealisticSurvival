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
package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.DragonVariant;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.BurnTask;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

import static me.val_mobile.iceandfire.DragonBreed.FIRE;

public class FireDragon_v1_16_R1 extends Dragon_v1_16_R1 {

    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public FireDragon_v1_16_R1(Location loc, RealisticSurvivalPlugin plugin) {
        super(loc, FIRE);

        this.plugin = plugin;
    }

    public FireDragon_v1_16_R1(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        super(loc, FIRE, stage);

        this.plugin = plugin;
    }

    public FireDragon_v1_16_R1(Location loc, DragonVariant variant, RealisticSurvivalPlugin plugin) {
        super(loc, FIRE, variant);

        this.plugin = plugin;
    }

    public FireDragon_v1_16_R1(Location loc, DragonVariant variant, int stage, RealisticSurvivalPlugin plugin) {
        super(loc, FIRE, variant, stage);

        this.plugin = plugin;
    }

    public FireDragon_v1_16_R1(EntityTypes entityTypes, World world) {
        super(null, FIRE, null);
        this.plugin = null;
    }

    @Override
    public void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = config.getDouble("Dragons.FireDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(config.getDouble("Dragons.FireDragon.MeleeAttack.BaseDamage") * stageMultiplier, this.getBukkitEntity());
    }

    @Override
    public void performSpecialAbility(LivingEntity entity) {
        double stageMultiplier = config.getDouble("Dragons.FireDragon.InfernoAbility.StageMultiplier.Stage" + getStage());
        if (!BurnTask.hasTask(entity.getUniqueId())) {
            new BurnTask(plugin, entity, (int) (config.getInt("Dragons.FireDragon.InfernoAbility.FireTicks") * stageMultiplier), config.getInt("Dragons.FireDragon.InfernoAbility.TickSpeed")).start();
        }
    }

    @Override
    public void triggerBreathAttack(Location target) {
        new FireBreath_v1_16_R1(this, target, plugin).start();
    }

    @Override
    public void triggerExplosionAttack(Location target) {
        new FireExplosionAttack_v1_16_R1(this, target, plugin);
    }
}