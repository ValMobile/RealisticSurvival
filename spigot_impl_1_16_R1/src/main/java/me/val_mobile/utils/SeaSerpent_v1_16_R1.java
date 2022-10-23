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
import me.val_mobile.iceandfire.SeaSerpentVariant;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.*;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;

public class SeaSerpent_v1_16_R1 extends EntityGuardianElder implements RSVMob {

    private final RealisticSurvivalPlugin plugin;
    private final RSVModule module;
    private SeaSerpentVariant variant;
    private final Collection<ItemStack> loot = new ArrayList<>();

    public SeaSerpent_v1_16_R1(Location loc, RealisticSurvivalPlugin plugin) {
        super(EntityTypes.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());

        this.plugin = plugin;

        SeaSerpentVariant[] allVariants = SeaSerpentVariant.values();

        do {
            variant = allVariants[Utils.getRandomNum(0, allVariants.length)];
        } while(!variant.isEnabled());

        this.module = RSVModule.getModule(IceFireModule.NAME);

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);

        FileConfiguration config = module.getUserConfig().getConfig();

        int scaleAmount = Utils.getRandomNum(config.getInt("SeaSerpents.Drops.Scales.Min"), config.getInt("SeaSerpents.Drop.Scales.Max"));

        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + variant.toString().toLowerCase());
        scales.setAmount(scaleAmount);

        loot.add(scales);
    }

    public SeaSerpent_v1_16_R1(Location loc, SeaSerpentVariant variant, RealisticSurvivalPlugin plugin) {
        super(EntityTypes.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());

        this.plugin = plugin;

        this.variant = variant.isEnabled() ? variant : null;
        this.module = RSVModule.getModule(IceFireModule.NAME);

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);

        FileConfiguration config = module.getUserConfig().getConfig();

        int scaleAmount = Utils.getRandomNum(config.getInt("SeaSerpents.Drops.Scales.Min"), config.getInt("SeaSerpents.Drop.Scales.Max"));

        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + variant.toString().toLowerCase());
        scales.setAmount(scaleAmount);

        loot.add(scales);
    }

    public SeaSerpent_v1_16_R1(EntityTypes<? extends EntityGuardianElder> entitytypes, World world) {
        super(entitytypes, world);

        this.plugin = null;

        SeaSerpentVariant[] allVariants = SeaSerpentVariant.values();

        do {
            variant = allVariants[Utils.getRandomNum(0, allVariants.length)];
        } while(!variant.isEnabled());

        this.module = RSVModule.getModule(IceFireModule.NAME);

        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',"Realistic Survival " + StringUtils.capitalize(variant.toString().toLowerCase()) + " Sea Serpent")));
        this.setCustomNameVisible(false);

        FileConfiguration config = module.getUserConfig().getConfig();

        int scaleAmount = Utils.getRandomNum(config.getInt("SeaSerpents.Drops.Scales.Min"), config.getInt("SeaSerpents.Drop.Scales.Max"));

        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + variant.toString().toLowerCase());
        scales.setAmount(scaleAmount);

        loot.add(scales);
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", "sea_serpent", PersistentDataType.STRING);
    }

    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);

        Location loc = this.getBukkitEntity().getLocation();
        org.bukkit.World world = loc.getWorld();

        for (ItemStack item : loot) {
            world.dropItemNaturally(loc, item);
        }
    }

    @Override
    protected void initPathfinder()
    {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));

        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(1, new PathfinderGoalPet_v1_16_R1(this, 1.0, 25));
    }
}
