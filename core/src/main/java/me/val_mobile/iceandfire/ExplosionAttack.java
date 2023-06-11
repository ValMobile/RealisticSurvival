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

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;

public abstract class ExplosionAttack extends GenericBreath {

    private final ExplosiveBreathBlock block;

    public ExplosionAttack(EnderDragon dragon, Location target, RealisticSurvivalPlugin plugin) {
        super(dragon, target, plugin, BreathType.EXPLOSION);

        String capitalizeBreed = StringUtils.capitalize(DragonUtils.getBreed(dragon).toString().toLowerCase());

        this.block = new ExplosiveBreathBlock(loc, Material.valueOf(config.getString("Dragon." + capitalizeBreed + "Dragon.ExplosionAttack.FallingBlock")));
    }

    public ExplosionAttack(Dragon dragon, Location target, RealisticSurvivalPlugin plugin) {
        super(dragon, target, plugin, BreathType.EXPLOSION);

        String capitalizeBreed = StringUtils.capitalize(dragon.getBreed().toString().toLowerCase());

        this.block = new ExplosiveBreathBlock(loc, Material.valueOf(config.getString("Dragon." + capitalizeBreed + "Dragon.ExplosionAttack.FallingBlock")));
    }

    @Override
    public void performSpecialCollisionLogic() {
        this.block.remove();
    }

    @Override
    public void performSpecialRunnableLogic() {
        this.block.teleport(loc);
    }
}
