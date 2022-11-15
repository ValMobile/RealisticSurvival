package me.val_mobile.iceandfire;

import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.persistence.PersistentDataType;

public interface Siren extends RSVMob {

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", "siren", PersistentDataType.STRING);
    }
}
