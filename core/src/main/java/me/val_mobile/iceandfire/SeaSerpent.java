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
package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;

public interface SeaSerpent extends RSVMob {

    FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    @Override
    default void addNbtData() {
        Utils.addNbtTag(getEntity(), "rsvmob", "sea_serpent", PersistentDataType.STRING);
        Utils.addNbtTag(getEntity(), "rsvseaserpentvariant", getVariant().toString(), PersistentDataType.STRING);
    }

    SeaSerpentVariant getVariant();

    default void generateLoot(Collection<ItemStack> loot) {
        loot.clear();
        int scaleAmount = Utils.getRandomNum(CONFIG.getInt("SeaSerpents.Drops.Scales.Min"), CONFIG.getInt("SeaSerpents.Drop.Scales.Max"));

        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + getVariant().toString().toLowerCase());
        scales.setAmount(scaleAmount);

        loot.add(scales);
    }
}
