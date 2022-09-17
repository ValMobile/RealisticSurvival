package me.val_mobile.utils;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import net.minecraft.server.v1_16_R1.EntityGuardian;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.persistence.PersistentDataType;

public class Siren extends EntityGuardian implements RSVMob {

    public Siren(Location loc) {
        super(EntityTypes.GUARDIAN, ((CraftWorld) loc.getWorld()).getHandle());
    }

    public Siren(EntityTypes<? extends EntityGuardian> entitytypes, World world) {
        super(entitytypes, world);
    }

    @Override
    public void addNbtData() {
        Utils util = RealisticSurvivalPlugin.getUtil();
        CraftEntity entity = this.getBukkitEntity();
        util.addNbtTag(entity, "rsvmob", "siren", PersistentDataType.STRING);
    }
}
