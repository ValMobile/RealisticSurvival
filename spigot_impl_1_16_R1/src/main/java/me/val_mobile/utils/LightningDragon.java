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
import me.val_mobile.iceandfire.DragonBreed;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.spartanandfire.ElectrocuteTask;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

import static me.val_mobile.iceandfire.DragonBreed.ICE;
import static me.val_mobile.iceandfire.DragonBreed.LIGHTNING;

public class LightningDragon extends Dragon {

    private final RealisticSurvivalPlugin plugin;
    private final FileConfiguration config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public LightningDragon(Location loc, RealisticSurvivalPlugin plugin) {
        super(loc, LIGHTNING, plugin);
        this.plugin = plugin;
    }

    public LightningDragon(Location loc, int stage, RealisticSurvivalPlugin plugin) {
        super(loc, LIGHTNING, stage, plugin);
        this.plugin = plugin;
    }

    public LightningDragon(Location loc, DragonBreed.Variant variant, RealisticSurvivalPlugin plugin) {
        super(loc, LIGHTNING, variant, plugin);

        this.plugin = plugin;
    }

    public LightningDragon(Location loc, DragonBreed.Variant variant, int stage, RealisticSurvivalPlugin plugin) {
        super(loc, LIGHTNING, variant, stage, plugin);

        this.plugin = plugin;
    }

    public LightningDragon(EntityTypes entityTypes, World world) {
        super(null, ICE, null);
        this.plugin = null;
    }

    @Override
    public void performMeleeAttack(LivingEntity entity) {
        double stageMultiplier = config.getDouble("Dragons.LightningDragon.MeleeAttack.StageMultiplier.Stage" + getStage());
        entity.damage(config.getDouble("Dragons.LightningDragon.MeleeAttack.BaseDamage") * stageMultiplier, this.getBukkitEntity());
    }

    @Override
    public void performSpecialAbility(LivingEntity entity) {
        Location loc = entity.getLocation();
        if (config.getBoolean("Dragons.LightningDragon.ElectrocuteAbility.SummonCosmeticLightning")) {
            loc.getWorld().strikeLightningEffect(loc);
        }
        else {
            loc.getWorld().strikeLightning(loc);
        }
        new ElectrocuteTask(plugin, getStage(), entity).start();
    }

    @Override
    public void triggerBreathAttack(Location target) {
        new LightningBreath(this, target, plugin).start();
    }

    @Override
    public void triggerExplosionAttack(Location target) {
        new LightningExplosionAttack(this, target, plugin).start();
    }
}