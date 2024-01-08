/*
    Copyright (C) 2024  Val_Mobile

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
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;

public class SeaSerpentUtils {

    private static final FileConfiguration CONFIG = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();

    public static void convertToSeaSerpent(ElderGuardian elderGuardian) {
        Utils.addNbtTag(elderGuardian, "rsvmob", "sea_serpent", PersistentDataType.STRING);
        Utils.addNbtTag(elderGuardian, "rsvseaserpentvariant", SeaSerpentVariant.getEnabledVariants().get(Utils.getRandomNum(0, SeaSerpentVariant.getEnabledVariants().size() - 1)).toString(), PersistentDataType.STRING);
    }

    public static Collection<ItemStack> generateLoot(ElderGuardian seaSerpent) {
        Collection<ItemStack> loot = new ArrayList<>();
        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + getVariant(seaSerpent).toString().toLowerCase());
        ItemStack item = seaSerpent.getKiller() == null ? null : seaSerpent.getKiller().getInventory().getItemInMainHand();
        Utils.getMobLoot(CONFIG.getConfigurationSection("SeaSerpent.LootTable.Scales"), scales, item, true);

        loot.add(scales);

        return loot;
    }

    public static boolean isSeaSerpent(Entity entity) {
        if (RSVMob.isMob(entity)) {
            return RSVMob.getMob(entity).equals("sea_serpent");
        }
        return false;
    }

    public static SeaSerpentVariant getVariant(ElderGuardian seaSerpent) {
        return SeaSerpentVariant.valueOf(Utils.getNbtTag(seaSerpent, "rsvseaserpentvariant", PersistentDataType.STRING).toUpperCase());
    }
}
