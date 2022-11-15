package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public class SirenUtils {

    private static final FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public static boolean isMob(Entity entity) {
        return Utils.hasNbtTag(entity, "rsvmob");
    }

    public static boolean isSiren(Entity entity) {
        if (isMob(entity)) {
            return getMob(entity).equals("siren");
        }
        return false;
    }

    public static String getMob(Entity entity) {
        return Utils.getNbtTag(entity, "rsvmob", PersistentDataType.STRING);
    }
}
