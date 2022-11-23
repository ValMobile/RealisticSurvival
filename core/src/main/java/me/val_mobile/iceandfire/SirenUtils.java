package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public class SirenUtils {

    private static final FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public static void convertToSiren(ElderGuardian elderGuardian) {
        Utils.addNbtTag(elderGuardian, "rsvmob", "siren", PersistentDataType.STRING);
    }

    public static boolean isSiren(Entity entity) {
        if (RSVMob.isMob(entity)) {
            return RSVMob.getMob(entity).equals("siren");
        }
        return false;
    }
}
