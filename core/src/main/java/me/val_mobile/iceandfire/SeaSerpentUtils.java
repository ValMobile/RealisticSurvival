package me.val_mobile.iceandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.utils.RSVItem;
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

    public static Collection<ItemStack> generateLoot(ElderGuardian seaSerpent) {
        Collection<ItemStack> loot = new ArrayList<>();

        int scaleAmount = Utils.getRandomNum(CONFIG.getInt("SeaSerpents.Drops.Scales.Min"), CONFIG.getInt("SeaSerpents.Drop.Scales.Max"));

        ItemStack scales = RSVItem.getItem("sea_serpent_scale_" + getVariant(seaSerpent).toString().toLowerCase());
        scales.setAmount(scaleAmount);

        loot.add(scales);

        return loot;
    }

    public static boolean isMob(Entity entity) {
        return Utils.hasNbtTag(entity, "rsvmob");
    }

    public static boolean isSeaSerpent(Entity entity) {
        if (isMob(entity)) {
            return getMob(entity).equals("sea_serpent");
        }
        return false;
    }

    public static String getMob(Entity entity) {
        return Utils.getNbtTag(entity, "rsvmob", PersistentDataType.STRING);
    }

    public static SeaSerpentVariant getVariant(ElderGuardian seaSerpent) {
        return SeaSerpentVariant.valueOf(Utils.getNbtTag(seaSerpent, "rsvseaserpentvariant", PersistentDataType.STRING));
    }
}
