package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.TemperatureCalculateTask;
import me.val_mobile.tan.ThirstCalculateTask;
import me.val_mobile.utils.CharacterValues;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public class TemperatureThirstBarExpansion extends PlaceholderExpansion {

    private final CharacterValues charValues;

    public TemperatureThirstBarExpansion() {
        this.charValues = new CharacterValues();
    }

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvtemperaturethirstbar";
    }

    @Override
    public @Nonnull String getAuthor() {
        return "Val_Mobile";
    }

    @Override
    public @Nonnull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @Nonnull String params) {
        if (player != null) {
            UUID id = player.getUniqueId();
            if (TemperatureCalculateTask.hasTask(id) && ThirstCalculateTask.hasTask(id)) {
                TemperatureCalculateTask tempTask = TemperatureCalculateTask.getTasks().get(id);
                ThirstCalculateTask thirstTask = ThirstCalculateTask.getTasks().get(id);

                int temp = (int) Math.round(tempTask.getTemp());
                int thirst = (int) Math.round(thirstTask.getThirstLvl());
                boolean isUnderwater = player.getRemainingAir() < 300 || player.getEyeLocation().getBlock().getType() == Material.WATER;

                return charValues.getTemperatureThirstActionbar(temp, thirst, isUnderwater, thirstTask.isParasitesActive());
            }
        }
        return null;
    }
}
