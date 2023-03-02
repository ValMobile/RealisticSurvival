package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.TemperatureCalculateTask;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TemperatureNumericExpansion extends PlaceholderExpansion {

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvtemperaturenumeric";
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
                double temp = task.getTemp();

                return String.valueOf((int) Math.round(temp));
            }
        }
        return null;
    }
}
