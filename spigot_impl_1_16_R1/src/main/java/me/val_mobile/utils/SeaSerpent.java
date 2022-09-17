package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.EntityGuardianElder;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.persistence.PersistentDataType;

public class SeaSerpent extends EntityGuardianElder implements RSVMob {

    public SeaSerpent(Location loc) {
        super(EntityTypes.ELDER_GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
    }

    public SeaSerpent(EntityTypes<? extends EntityGuardianElder> entitytypes, World world) {
        super(entitytypes, world);
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", "sea_serpent", PersistentDataType.STRING);
    }
}
