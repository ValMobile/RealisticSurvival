package me.val_mobile.integrations;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.val_mobile.tan.ThirstCalculateTask;
import me.val_mobile.utils.CharacterValues;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThirstBarExpansion extends PlaceholderExpansion {

    private final CharacterValues charValues;

    public ThirstBarExpansion() {
        this.charValues = new CharacterValues();
    }

    @Override
    public @Nonnull String getIdentifier() {
        return "rsvthirstbar";
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
                boolean isUnderwater = player.getRemainingAir() < 300 || player.getEyeLocation().getBlock().getType() == Material.WATER;

                return charValues.getThirstOnlyActionbar(thirst, isUnderwater, task.isParasitesActive());
            }
        }
        return null;
    }
}
