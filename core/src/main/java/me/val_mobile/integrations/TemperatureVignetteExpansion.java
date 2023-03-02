package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.TemperatureCalculateTask;
import me.val_mobile.utils.CharacterValues;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TemperatureVignetteExpansion extends PlaceholderExpansion {

    private final CharacterValues charValues;

    public TemperatureVignetteExpansion() {
        this.charValues = new CharacterValues();
    }

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvtemperaturevignette";
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
            if (TemperatureCalculateTask.hasTask(player.getUniqueId())) {
                TemperatureCalculateTask task = TemperatureCalculateTask.getTasks().get(player.getUniqueId());
                int temperature = (int) Math.round(task.getTemp());

                return String.valueOf(charValues.getTemperature(temperature));
            }
        }
        return null;
    }
}
