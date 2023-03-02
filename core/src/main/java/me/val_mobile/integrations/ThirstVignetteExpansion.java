package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.ThirstCalculateTask;
import me.val_mobile.utils.CharacterValues;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThirstVignetteExpansion extends PlaceholderExpansion {

    private final CharacterValues charValues;

    public ThirstVignetteExpansion() {
        this.charValues = new CharacterValues();
    }

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvthirstvignette";
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
                int thirst = (int) Math.round(task.getThirstLvl());

                return String.valueOf(charValues.getThirstVignette(thirst));
            }
        }
        return null;
    }
}
