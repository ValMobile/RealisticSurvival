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
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.DamageSource;
import net.minecraft.server.v1_16_R1.EntityGuardian;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;

public class Siren_v1_16_R1 extends EntityGuardian implements RSVMob {

    private final RealisticSurvivalPlugin plugin;
    private final RSVModule module;
    private final FileConfiguration config;
    private final Collection<ItemStack> loot = new ArrayList<>();

    public Siren_v1_16_R1(Location loc, RealisticSurvivalPlugin plugin) {
        super(EntityTypes.GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());

        this.plugin = plugin;
        this.module = RSVModule.getModule(IceFireModule.NAME);

        this.config = module.getUserConfig().getConfig();
    }

    public Siren_v1_16_R1(EntityTypes<? extends EntityGuardian> entitytypes, World world) {
        super(entitytypes, world);
        this.plugin = null;
        this.module = RSVModule.getModule(IceFireModule.NAME);

        this.config = module.getUserConfig().getConfig();
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", "siren", PersistentDataType.STRING);
    }

    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);

        Location loc = this.getBukkitEntity().getLocation();

        ItemStack item = null;
        Entity e = damageSource.getEntity().getBukkitEntity();

        if (e != null) {
            if (e instanceof LivingEntity) {
                item = ((LivingEntity) e).getEquipment().getItemInMainHand();
            }
        }

        Utils.harvestLooting(config.getConfigurationSection("Sirens.Drops.ShinyScales"), RSVItem.getItem("shiny_scale"), item, loc);
    }
}
