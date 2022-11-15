package me.val_mobile.baubles;

import me.val_mobile.utils.RSVPet;
import me.val_mobile.utils.Utils;
import org.bukkit.persistence.PersistentDataType;

public interface EndermanAlly extends RSVPet {

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", "enderman_ally", PersistentDataType.STRING);
    }
}
