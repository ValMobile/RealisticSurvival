package me.val_mobile.rlcraft;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
/**
 * BaubleRunnables is a utility class containing methods that
 * execute various runnables to allow for correct functioning of baubles
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleRunnables {

    /**
     * Effects the player with resistance if they have rings of resistance and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingResistanceRunnable(Player player) {
        String name = CustomItems.getPotionRingResistance().getItemMeta().getDisplayName(); // get the name of the
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrRes().get(player.getName()) > 0) {
                    BaubleAbilities.RingResistanceAbility(player, PlayerRunnable.getPrRes().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrResRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getPotionRingRegenerationRunnable(Player player) {
        String name = CustomItems.getPotionRingRegeneration().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrRegen().get(player.getName()) > 0) {
                    BaubleAbilities.RingRegenerationAbility(player, PlayerRunnable.getPrRegen().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrRegenRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getPotionRingStrengthRunnable(Player player) {
        String name = CustomItems.getPotionRingStrength().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrStrength().get(player.getName()) > 0) {
                    BaubleAbilities.RingStrengthAbility(player, PlayerRunnable.getPrStrength().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrStrengthRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getPotionRingSpeedRunnable(Player player) {
        String name = CustomItems.getPotionRingSpeed().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrSpeed().get(player.getName()) > 0) {
                    BaubleAbilities.RingSpeedAbility(player, PlayerRunnable.getPrSpeed().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrSpeedRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getPotionRingJumpBoostRunnable(Player player) {
        String name = CustomItems.getPotionRingJumpBoost().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrJump().get(player.getName()) > 0) {
                    BaubleAbilities.RingJumpBoostAbility(player, PlayerRunnable.getPrJump().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrJumpRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getPotionRingHasteRunnable(Player player) {
        String name = CustomItems.getPotionRingHaste().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getPrHaste().get(player.getName()) > 0) {
                    BaubleAbilities.RingHasteAbility(player, PlayerRunnable.getPrHaste().get(player.getName()));
                }
                else {
                    Utils.setOrReplaceEntry(getPrHasteRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getDragonsEyeRunnable(Player player) {
        String name = CustomItems.getDragonsEye().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getDragonsEye().get(player.getName()) > 0) {
                    BaubleAbilities.DragonsEyeAbility(player);
                }
                else {
                    Utils.setOrReplaceEntry(getDragonsEyeRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getScarliteRingRunnable(Player player) {
        String name = CustomItems.getScarliteRing().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getScarliteRing().get(player.getName()) > 0) {
                    BaubleAbilities.ScarliteRingAbility(player);
                }
                else {
                    Utils.setOrReplaceEntry(getScarliteRingRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getMinersRingRunnable(Player player) {
        String name = CustomItems.getMinersRing().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getMinersRing().get(player.getName()) > 0) {
                    BaubleAbilities.MinersRingAbility(player);
                }
                else {
                    Utils.setOrReplaceEntry(getMinersRingRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable getShieldHonorRunnable(Player player) {
        String name = CustomItems.getShieldHonor().getItemMeta().getDisplayName();
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                if (PlayerRunnable.getShieldHonor().get(player.getName()) > 0) {
                    BaubleAbilities.ShieldHonorAbility(player);
                }
                else {
                    Utils.setOrReplaceEntry(getShieldHonorRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    public static BukkitRunnable freezeEntity(Entity entity) {
        return new BukkitRunnable() {
            public void run() {
                entity.setVelocity(new Vector());
            }
        };
    }

    public static BukkitRunnable removeInvFrames(Player player) {
        return new BukkitRunnable() {
            public void run() {
                Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), false);
            }
        };
    }

}
