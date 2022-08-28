package me.val_mobile.utils;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public abstract class RSVMob {

    private final Entity entity;
    private final String name;
    private final RSVModule module;

    private static HashMap<String, RSVMob> mobs = new HashMap<>();

    public RSVMob(RSVModule module, String name, Entity entity) {
        this.name = name;
        this.module = module;
        this.entity = entity;
        RealisticSurvivalPlugin.getUtil().addNbtTag(entity, "rsvmodule", module.getName(), PersistentDataType.STRING);
        RealisticSurvivalPlugin.getUtil().addNbtTag(entity, "rsvmob", name, PersistentDataType.STRING);
    }

    public String getName() {
        return name;
    }

    public RSVModule getModule() {
        return module;
    }

    public Entity getEntity() {
        return entity;
    }

    public void spawn(Location loc) {
    }

    public static HashMap<String, RSVMob> getMobs() {
        return mobs;
    }

    public static RSVMob getMob(String name) {
        return mobs.get(name);
    }
}
