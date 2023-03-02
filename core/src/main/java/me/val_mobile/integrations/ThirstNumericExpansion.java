package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.ThirstCalculateTask;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThirstNumericExpansion extends PlaceholderExpansion {

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvthirstnumeric";
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
            if (ThirstCalculateTask.hasTask(player.getUniqueId())) {
                ThirstCalculateTask task = ThirstCalculateTask.getTasks().get(player.getUniqueId());
                double thirst = task.getThirstLvl();

                return String.valueOf((int) Math.round(thirst));
            }
        }
        return null;
    }
}
