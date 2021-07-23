package me.val_mobile.baubles;

import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
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
     * Effects a player with resistance if he/she has a ring of resistance and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with resistance if he/she has a ring of resistance
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingResistanceRunnable(Player player) {
        String name = CustomItems.getPotionRingResistance().getItemMeta().getDisplayName(); // get the name of the ring of res
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of res in his/her inventory
                if (PlayerRunnable.getPrRes().get(player.getName()) > 0) {
                    // effect the player with resistance
                    BaubleAbilities.RingResistanceAbility(player, PlayerRunnable.getPrRes().get(player.getName()));
                }
                // if the player doesn't have rings of res in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrResRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with regeneration if he/she has a ring of regeneration and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with regeneration if he/she has a ring of regeneration
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingRegenerationRunnable(Player player) {
        String name = CustomItems.getPotionRingRegeneration().getItemMeta().getDisplayName(); // get the name of the ring of regen
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of regen in his/her inventory
                if (PlayerRunnable.getPrRegen().get(player.getName()) > 0) {
                    // effect the player with regeneration
                    BaubleAbilities.RingRegenerationAbility(player, PlayerRunnable.getPrRegen().get(player.getName()));
                }
                // if the player doesn't have rings of regen in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrRegenRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with strength if he/she has a ring of strength and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with strength if he/she has a ring of strength
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingStrengthRunnable(Player player) {
        String name = CustomItems.getPotionRingStrength().getItemMeta().getDisplayName(); // get the name of the ring of strength
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of strength in his/her inventory
                if (PlayerRunnable.getPrStrength().get(player.getName()) > 0) {
                    // effect the player with strength
                    BaubleAbilities.RingStrengthAbility(player, PlayerRunnable.getPrStrength().get(player.getName()));
                }
                // if the player doesn't have rings of strength in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrStrengthRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with speed if he/she has a ring of speed and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with speed if he/she has a ring of speed
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingSpeedRunnable(Player player) {
        String name = CustomItems.getPotionRingSpeed().getItemMeta().getDisplayName(); // get the name of the ring of speed
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of speed in his/her inventory
                if (PlayerRunnable.getPrSpeed().get(player.getName()) > 0) {
                    // effect the player with speed
                    BaubleAbilities.RingSpeedAbility(player, PlayerRunnable.getPrSpeed().get(player.getName()));
                }
                // if the player doesn't have rings of speed in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrSpeedRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with jump boost if he/she has a ring of jump boost and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with jump boost if he/she has a ring of jump boost
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingJumpBoostRunnable(Player player) {
        String name = CustomItems.getPotionRingJumpBoost().getItemMeta().getDisplayName(); // get the name of the ring of jump boost
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of jump boost in his/her inventory
                if (PlayerRunnable.getPrJump().get(player.getName()) > 0) {
                    // effect the player with jump boost
                    BaubleAbilities.RingJumpBoostAbility(player, PlayerRunnable.getPrJump().get(player.getName()));
                }
                // if the player doesn't have rings of jump boost in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrJumpRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with haste if he/she has a ring of haste and
     * automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with haste if he/she has a ring of haste
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getPotionRingHasteRunnable(Player player) {
        String name = CustomItems.getPotionRingHaste().getItemMeta().getDisplayName(); // get the name of the ring of haste
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has rings of haste in his/her inventory
                if (PlayerRunnable.getPrHaste().get(player.getName()) > 0) {
                    // effect the player with haste
                    BaubleAbilities.RingHasteAbility(player, PlayerRunnable.getPrHaste().get(player.getName()));
                }
                // if the player doesn't have rings of haste in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getPrHasteRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with fire resistance and night vision if he/she has a dragon's eye
     * and automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with fire resistance and night vision if he/she has a dragon's eye
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getDragonsEyeRunnable(Player player) {
        String name = CustomItems.getDragonsEye().getItemMeta().getDisplayName(); // get the name of the dragon's eye
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has dragon's eyes in his/her inventory
                if (PlayerRunnable.getDragonsEye().get(player.getName()) > 0) {
                    // effect the player with fire resistance and night vision
                    BaubleAbilities.DragonsEyeAbility(player);
                }
                // if the player doesn't have dragon's eyes in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getDragonsEyeRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Heals a player if he/she has a scarlite ring
     * and automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable healing the player if he/she has a scarlite ring
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getScarliteRingRunnable(Player player) {
        String name = CustomItems.getScarliteRing().getItemMeta().getDisplayName(); // get the name of the scarlite ring
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has scarlite rings in his/her inventory
                if (PlayerRunnable.getScarliteRing().get(player.getName()) > 0) {
                    // give the player health
                    BaubleAbilities.ScarliteRingAbility(player);
                }
                // if the player doesn't have scarlite rings in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getScarliteRingRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with haste if he/she has a miner's ring
     * and automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with haste if he/she has a miner's ring
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getMinersRingRunnable(Player player) {
        String name = CustomItems.getMinersRing().getItemMeta().getDisplayName(); // get the name of the miner's ring
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has miner's rings in his/her inventory
                if (PlayerRunnable.getMinersRing().get(player.getName()) > 0) {
                    // effect the player with haste
                    BaubleAbilities.MinersRingAbility(player);
                }
                // if the player doesn't have miner's rings in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getMinersRingRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Effects a player with resistance if he/she has a shield of honor
     * and automatically cancels if the player doesn't have any
     * @param player The target player
     * @return A runnable effecting the player with resistance if he/she has a shield of honor
     * @see BaubleAbilities
     * @see Utils
     */
    public static BukkitRunnable getShieldHonorRunnable(Player player) {
        String name = CustomItems.getShieldHonor().getItemMeta().getDisplayName(); // get the name of the shield of honor
        // remove any color codes to get the basic string name
        Utils.removeColorCodes(name);
        return new PlayerRunnable(player, name) {
            @Override
            public void run() {
                // if the player has shields of honor in his/her inventory
                if (PlayerRunnable.getShieldHonor().get(player.getName()) > 0) {
                    BaubleAbilities.ShieldHonorAbility(player);
                }
                // if the player doesn't have shields of honor in his/her inventory
                else {
                    // update static hashmap values and cancel the runnable
                    Utils.setOrReplaceEntry(getShieldHonorRunnables(), player.getName(), false);
                    cancel();
                }
            }
        };
    }

    /**
     * Removes knockback from an entity by setting its velocity to zero
     * @param entity The target entity who will receive no knockback
     * @return A runnable removing the knockback from an entity
     */
    public static BukkitRunnable freezeEntity(Entity entity) {
        return new BukkitRunnable() {
            public void run() {
                // set the velocity to zero to mimic anti-kb
                entity.setVelocity(new Vector());
            }
        };
    }

    /**
     * Removes invincibility frames resulting from the cross necklace
     * @param player The target player whose i-frames will be removed
     * @return A runnable removing the player's i-frames
     * @see Utils
     */
    public static BukkitRunnable removeInvFrames(Player player) {
        return new BukkitRunnable() {
            public void run() {
                // remove the i-frames by setting the static hashmap value to false
                Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), player.getName(), false);
            }
        };
    }

}
