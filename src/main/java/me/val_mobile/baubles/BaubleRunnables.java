package me.val_mobile.baubles;

import de.tr7zw.nbtapi.NBTItem;
import me.val_mobile.rlcraft.RLCraft;
import me.val_mobile.utils.CustomConfig;
import me.val_mobile.utils.CustomItems;
import me.val_mobile.utils.PlayerRunnable;
import me.val_mobile.utils.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
/**
 * BaubleRunnables is a utility class containing methods that
 * execute various runnables and update static field values
 * to allow for correct functioning of baubles
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class BaubleRunnables {

    private final RLCraft plugin;
    
    public BaubleRunnables(RLCraft instance) {
        plugin = instance;
    }
    
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

    /**
     * Finds the number of rings of resistance in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrResValues(Player player) {
        String name = player.getName(); // get the player's name
        int prResAmount = 0; // create a variable to store the number of rings of resistance

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of resistance
                    if (nbti.getString("Bauble").equals("Potion Ring of Resistance")) {
                        // add however many potion rings to the total amount
                        prResAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRes(), name, prResAmount);
    }

    /**
     * Finds the number of rings of regeneration in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrRegenValues(Player player) {
        String name = player.getName(); // get the player's name
        int prRegenAmount = 0; // create a variable to store the number of rings of regeneration

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of regeneration
                    if (nbti.getString("Bauble").equals("Potion Ring of Regeneration")) {
                        // add however many potion rings to the total amount
                        prRegenAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegen(), name, prRegenAmount);
    }

    /**
     * Finds the number of rings of strength in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrStrengthValues(Player player) {
        String name = player.getName(); // get the player's name
        int prStrengthAmount = 0; // create a variable to store the number of rings of strength

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of strength
                    if (nbti.getString("Bauble").equals("Potion Ring of Strength")) {
                        // add however many potion rings to the total amount
                        prStrengthAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrength(), name, prStrengthAmount);
    }

    /**
     * Finds the number of rings of speed in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrSpeedValues(Player player) {
        String name = player.getName(); // get the player's name
        int prSpeedAmount = 0; // create a variable to store the number of rings of speed

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of speed
                    if (nbti.getString("Bauble").equals("Potion Ring of Speed")) {
                        // add however many potion rings to the total amount
                        prSpeedAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeed(), name, prSpeedAmount);
    }

    /**
     * Finds the number of rings of jump boost in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrJumpValues(Player player) {
        String name = player.getName(); // get the player's name
        int prJumpAmount = 0; // create a variable to store the number of rings of jump boost

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of jump boost
                    if (nbti.getString("Bauble").equals("Potion Ring of Jump Boost")) {
                        // add however many potion rings to the total amount
                        prJumpAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJump(), name, prJumpAmount);
    }

    /**
     * Finds the number of rings of haste in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updatePrHasteValues(Player player) {
        String name = player.getName(); // get the player's name
        int prHasteAmount = 0; // create a variable to store the number of rings of haste

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a ring of haste
                    if (nbti.getString("Bauble").equals("Potion Ring of Haste")) {
                        // add however many potion rings to the total amount
                        prHasteAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHaste(), name, prHasteAmount);
    }

    /**
     * Finds the number of dragon's eyes in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updateDragonsEyeValues(Player player) {
        String name = player.getName(); // get the player's name
        int dragonsEyeAmount = 0; // create a variable to store the number of dragon's eyes

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a dragon's eye
                    if (nbti.getString("Bauble").equals("Dragon's Eye")) {
                        // add however many dragon's eyes to the total amount
                        dragonsEyeAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEye(), name, dragonsEyeAmount);
    }

    /**
     * Finds the number of miner's rings in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updateMinersRingValues(Player player) {
        String name = player.getName(); // get the player's name
        int minersRingAmount = 0; // create a variable to store the number of miner's rings

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a miner's ring
                    if (nbti.getString("Bauble").equals("Miner's Ring")) {
                        // add however many miner's rings to the total amount
                        minersRingAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getMinersRing(), name, minersRingAmount);
    }

    /**
     * Finds the number of scarlite rings in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updateScarliteRingValues(Player player) {
        String name = player.getName(); // get the player's name
        int scarliteRingAmount = 0; // create a variable to store the number of scarlite rings

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a scarlite ring
                    if (nbti.getString("Bauble").equals("Scarlite Ring")) {
                        // add however many scarlite rings to the total amount
                        scarliteRingAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRing(), name, scarliteRingAmount);
    }

    /**
     * Finds the number of shields of honor in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updateShieldHonorValues(Player player) {
        String name = player.getName(); // get the player's name
        int shieldHonorAmount = 0; // create a variable to store the number of shields of honor

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // check if the item is a shield of honor
                    if (nbti.getString("Bauble").equals("Shield of Honor")) {
                        // add however many shields of honor to the total amount
                        shieldHonorAmount += amount;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonor(), name, shieldHonorAmount);
    }

    /**
     * Finds the number of potion effect baubles in a player's inventory
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void updateBaubleValues(Player player) {
        String name = player.getName(); // get the player's name

        // create variables to store the number of baubles
        int prResAmount = 0;
        int prRegenAmount = 0;
        int prStrengthAmount = 0;
        int prSpeedAmount = 0;
        int prJumpAmount = 0;
        int prHasteAmount = 0;
        int dragonsEyeAmount = 0;
        int scarliteRingAmount = 0;
        int minersRingAmount = 0;
        int shieldHonorAmount = 0;

        // for every item in a player's inventory
        for (ItemStack item : player.getInventory()) {
            // check if the item exists
            if (Utils.isItemReal(item)) {
                int amount = item.getAmount(); // get the amount of the item
                NBTItem nbti = new NBTItem(item); // get the nbt version of the item

                // check if item is a bauble
                if (nbti.hasKey("Bauble")) {
                    // increment values based on the type of bauble
                    switch (nbti.getString("Bauble")) {
                        case "Potion Ring of Resistance":
                            prResAmount += amount;
                            break;
                        case "Potion Ring of Regeneration":
                            prRegenAmount += amount;
                            break;
                        case "Potion Ring of Strength":
                            prStrengthAmount += amount;
                            break;
                        case "Potion Ring of Speed":
                            prSpeedAmount += amount;
                            break;
                        case "Potion Ring of Jump Boost":
                            prJumpAmount += amount;
                            break;
                        case "Dragon's Eye":
                            dragonsEyeAmount += amount;
                            break;
                        case "Scarlite Ring":
                            scarliteRingAmount += amount;
                            break;
                        case "Miner's Ring":
                            minersRingAmount += amount;
                            break;
                        case "Shield of Honor":
                            shieldHonorAmount += amount;
                            break;
                    }
                }
            }
        }
        // update hashmap values
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRes(), name, prResAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegen(), name, prRegenAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrength(), name, prStrengthAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeed(), name, prSpeedAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJump(), name, prJumpAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHaste(), name, prHasteAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEye(), name, dragonsEyeAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRing(), name, scarliteRingAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getMinersRing(), name, minersRingAmount);
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonor(), name, shieldHonorAmount);
    }

    /**
     * Resets bauble values of a player
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public static void resetBaubleMaps(Player player) {
        String name = player.getName(); // get the player's name

        // reset bauble values to 0
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRes(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrength(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegen(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHaste(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJump(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeed(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEye(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRing(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonor(), name, 0);
        Utils.setOrReplaceEntry(PlayerRunnable.getCrossNecklace(), name, false);

        // set the runnable values to false since there will be no active bauble runnables on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrResRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrengthRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegenRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHasteRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJumpRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeedRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEyeRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRingRunnables(), name, false);
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonorRunnables(), name, false);
    }

    /**
     * Activates a runnable that gives player the resistance effect if he/she
     * has rings of resistance and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrResRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingResistance.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingResistanceRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrResRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the regeneration effect if he/she
     * has rings of regeneration and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrRegenRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingRegeneration.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingRegenerationRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrRegenRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the strength effect if he/she
     * has rings of strength and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrStrengthRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingStrength.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingStrengthRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrStrengthRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the speed effect if he/she
     * has rings of speed and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrSpeedRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingSpeed.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingSpeedRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrSpeedRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the jump boost effect if he/she
     * has rings of jump boost and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrJumpRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingJumpBoost.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingJumpBoostRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrJumpRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the haste effect if he/she
     * has rings of haste and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startPrHasteRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("PotionRingHaste.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getPotionRingHasteRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getPrHasteRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the fire resistance and night vision effects if he/she
     * has dragon's eyes and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startDragonsEyeRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("DragonsEye.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getDragonsEyeRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getDragonsEyeRunnables(), name, true);
    }

    /**
     * Activates a runnable that heals the player every few seconds if he/she
     * has scarlite rings and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startScarliteRingRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("ScarliteRing.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getScarliteRingRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getScarliteRingRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the haste effect if he/she
     * has miner's rings and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startMinersRingRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("MinersRing.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getMinersRingRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getMinersRingRunnables(), name, true);
    }

    /**
     * Activates a runnable that gives player the resistance effect if he/she
     * has shields of honor and automatically cancels if he/she doesn't.
     * @param player The target player
     * @see Utils
     * @see PlayerRunnable
     */
    public void startShieldHonorRunnable(Player player) {
        String name = player.getName(); // get the player's name

        int tickSpeed = CustomConfig.getBaubleConfig().getInt("ShieldHonor.TickTime"); // get the tick speed

        // start the runnable
        BaubleRunnables.getShieldHonorRunnable(player).runTaskTimer(plugin, 0, tickSpeed);
        // set the runnable value to true since there is an active runnable on the player
        Utils.setOrReplaceEntry(PlayerRunnable.getShieldHonorRunnables(), name, true);
    }
}
