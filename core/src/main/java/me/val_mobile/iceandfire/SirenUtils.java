package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.RSVMob;
import me.val_mobile.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Guardian;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

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

    public static Collection<ItemStack> generateLoot(Guardian siren) {
        Set<String> keys = CONFIG.getConfigurationSection("Siren.LootTable").getKeys(false);
        Collection<ItemStack> items = new ArrayList<>();
        ItemStack tool = siren.getKiller() == null ? null : siren.getKiller().getInventory().getItemInMainHand();

        for (String key : keys) {
            items.add(Utils.getMobLoot(CONFIG.getConfigurationSection("Siren.LootTable." + key), RSVItem.getItem(key), tool, true));
        }
        return items;
    }
}
