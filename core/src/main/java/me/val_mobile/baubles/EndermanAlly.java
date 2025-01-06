/*
    Copyright (C) 2025  Val_Mobile

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
package me.val_mobile.baubles;

import me.val_mobile.utils.RSVPet;
import me.val_mobile.utils.Utils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public interface EndermanAlly extends RSVPet {

    @Override
    default List<String> getRequiredModules() {
        return List.of(BaubleModule.NAME);
    }

    @Override
    default String getParentModule() {
        return BaubleModule.NAME;
    }

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", name(), PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvendermanallyowner", getOwner().getUniqueId().toString(), PersistentDataType.STRING);
    }

    @Override
    default String name() {
        return "enderman_ally";
    }

    @Override
    @Nonnull
    default Collection<ItemStack> getLoot(@Nullable ItemStack tool) {
        return getConfigurableLoot(tool);
    }
}
