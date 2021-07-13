package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class PlayerRunnable extends BukkitRunnable {

    private static final String prResName = "Potion Ring of Resistance";
    private static final String prRegenName = "Potion Ring of Regeneration";
    private static final String prStrengthName = "Potion Ring of Strength";
    private static final String prJumpName = "Potion Ring of Jump Boost";
    private static final String prHasteName = "Potion Ring of Haste";
    private static final String prSpeedName = "Potion Ring of Speed";
    private static final String tideArmorName = "Tide Guardian Armor";
    private static final String dragonsEyeName = "Dragon's Eye";
    private static final String minersRingName = "Miner's Ring";
    private static final String scarliteRingName = "Scarlite Ring";
    private static final String shieldHonorName = "Shield of Honor";

    private static HashMap<String, Boolean> prResRunnables = new HashMap<>();
    private static HashMap<String, Boolean> prRegenRunnables = new HashMap<>();
    private static HashMap<String, Boolean> prStrengthRunnables = new HashMap<>();
    private static HashMap<String, Boolean> prSpeedRunnables = new HashMap<>();
    private static HashMap<String, Boolean> prJumpRunnables = new HashMap<>();
    private static HashMap<String, Boolean> prHasteRunnables = new HashMap<>();
    private static HashMap<String, Boolean> tideArmorRunnables = new HashMap<>();
    private static HashMap<String, Boolean> dragonsEyeRunnables = new HashMap<>();
    private static HashMap<String, Boolean> minersRingRunnables = new HashMap<>();
    private static HashMap<String, Boolean> scarliteRingRunnables = new HashMap<>();
    private static HashMap<String, Boolean> shieldHonorRunnables = new HashMap<>();

    // Hashmaps for saving player and potion effect bauble amounts
    private static HashMap<String, Integer> prRes = new HashMap<>();
    private static HashMap<String, Integer> prRegen = new HashMap<>();
    private static HashMap<String, Integer> prStrength = new HashMap<>();
    private static HashMap<String, Integer> prSpeed = new HashMap<>();
    private static HashMap<String, Integer> prJump = new HashMap<>();
    private static HashMap<String, Integer> prHaste = new HashMap<>();
    private static HashMap<String, Integer> tideArmor = new HashMap<>();

    private static HashMap<String, Integer> dragonsEye = new HashMap<>();
    private static HashMap<String, Integer> scarliteRing = new HashMap<>();
    private static HashMap<String, Integer> minersRing = new HashMap<>();
    private static HashMap<String, Integer> shieldHonor = new HashMap<>();

    private static HashMap<String, Boolean> crossNecklace = new HashMap<>();

    private final Player player;
    private final String type;

    public PlayerRunnable(Player player, String type) {
        this.player = player;
        this.type = type;
    }

    @Override
    public synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        String name = player.getName();
        switch (type) {
            case prResName:
                Utils.setOrReplaceEntry(prResRunnables, name, true);
            case prRegenName:
                Utils.setOrReplaceEntry(prRegenRunnables, name, true);
            case prStrengthName:
                Utils.setOrReplaceEntry(prStrengthRunnables, name, true);
            case prSpeedName:
                Utils.setOrReplaceEntry(prSpeedRunnables, name, true);
            case prJumpName:
                Utils.setOrReplaceEntry(prJumpRunnables, name, true);
            case prHasteName:
                Utils.setOrReplaceEntry(prHasteRunnables, name, true);
            case tideArmorName:
                Utils.setOrReplaceEntry(tideArmorRunnables, name, true);
            case dragonsEyeName:
                Utils.setOrReplaceEntry(dragonsEyeRunnables, name, true);
            case scarliteRingName:
                Utils.setOrReplaceEntry(scarliteRingRunnables, name, true);
            case minersRingName:
                Utils.setOrReplaceEntry(minersRingRunnables, name, true);
            case shieldHonorName:
                Utils.setOrReplaceEntry(shieldHonorRunnables, name, true);
        }
        return super.runTaskTimer(plugin, delay, period);
    }

    @Override
    public synchronized BukkitTask runTaskLater(Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException {
        return super.runTaskLater(plugin, delay);
    }

    @Override
    public void run() {

    }

    public static HashMap<String, Integer> getPrRes() {
        return prRes;
    }

    public static HashMap<String, Integer> getPrRegen() {
        return prRegen;
    }

    public static HashMap<String, Integer> getPrStrength() {
        return prStrength;
    }

    public static HashMap<String, Integer> getPrJump() {
        return prJump;
    }

    public static HashMap<String, Integer> getPrSpeed() {
        return prSpeed;
    }

    public static HashMap<String, Integer> getPrHaste() {
        return prHaste;
    }

    public static HashMap<String, Integer> getDragonsEye() {
        return dragonsEye;
    }

    public static HashMap<String, Integer> getTideArmor() {
        return tideArmor;
    }

    public static HashMap<String, Integer> getScarliteRing() {
        return scarliteRing;
    }

    public static HashMap<String, Integer> getMinersRing() {
        return minersRing;
    }

    public static HashMap<String, Boolean> getCrossNecklace() {
        return crossNecklace;
    }

    public static HashMap<String, Integer> getShieldHonor() {
        return shieldHonor;
    }

    public static HashMap<String, Boolean> getPrResRunnables() {
        return prResRunnables;
    }

    public static HashMap<String, Boolean> getPrRegenRunnables() {
        return prRegenRunnables;
    }

    public static HashMap<String, Boolean> getPrStrengthRunnables() {
        return prStrengthRunnables;
    }

    public static HashMap<String, Boolean> getPrJumpRunnables() {
        return prJumpRunnables;
    }

    public static HashMap<String, Boolean> getPrSpeedRunnables() {
        return prSpeedRunnables;
    }

    public static HashMap<String, Boolean> getPrHasteRunnables() {
        return prHasteRunnables;
    }

    public static HashMap<String, Boolean> getDragonsEyeRunnables() {
        return dragonsEyeRunnables;
    }

    public static HashMap<String, Boolean> getTideArmorRunnables() {
        return tideArmorRunnables;
    }

    public static HashMap<String, Boolean> getScarliteRingRunnables() {
        return scarliteRingRunnables;
    }

    public static HashMap<String, Boolean> getMinersRingRunnables() {
        return minersRingRunnables;
    }

    public static HashMap<String, Boolean> getCrossNecklaceRunnables() {
        return getCrossNecklaceRunnables();
    }

    public static HashMap<String, Boolean> getShieldHonorRunnables() {
        return shieldHonorRunnables;
    }
}
