package me.val_mobile.iceandfire;

import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public interface Siren extends RSVMob {

    @Override
    default List<String> getRequiredModules() {
        return List.of(IceFireModule.NAME);
    }

    @Override
    default String getParentModule() {
        return IceFireModule.NAME;
    }

    @Override
    default String name() {
        return "siren";
    }

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", name(), PersistentDataType.STRING);
    }

    @Override
    @Nonnull
    default Collection<ItemStack> getLoot(@Nullable ItemStack tool) {
        return getConfigurableLoot(tool);
    }
}
