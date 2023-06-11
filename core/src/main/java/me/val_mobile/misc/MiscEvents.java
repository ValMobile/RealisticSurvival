/*
    Copyright (C) 2023  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.misc;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.PlayerJumpEvent;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import me.val_mobile.utils.recipe.RSVAnvilRecipe;
import me.val_mobile.utils.recipe.RSVBrewingRecipe;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.Set;

public class MiscEvents implements Listener {

    private final RealisticSurvivalPlugin plugin;

    public MiscEvents(RealisticSurvivalPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!RSVPlayer.isValidPlayer(player)) {
            RSVPlayer rsvplayer = new RSVPlayer(player);
            rsvplayer.retrieveData();
        }

        Collection<RSVModule> rsvModules = RSVModule.getModules().values();

        for (RSVModule module : rsvModules) {
            if (module.isGloballyEnabled()) {
                if (module.getAllowedWorlds().contains(player.getWorld().getName())) {
                    Collection<NamespacedKey> keys = module.getModuleRecipes().getRecipeKeys();
                    FileConfiguration config = module.getUserConfig().getConfig();
                    for (NamespacedKey key : keys) {
                        if (config.getBoolean("Recipes." + key.getKey() + ".Unlock")) {
                            Utils.discoverRecipe(player, Bukkit.getRecipe(key));
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        Recipe r = event.getRecipe();

        if (r != null) {
            ItemStack[] matrix = event.getInventory().getMatrix();

            if (event.isRepair()) {

                ItemStack first = null;
                ItemStack second = null;
                boolean firstRSVItem = false;
                boolean secondRSVItem = false;

                for (ItemStack item : matrix) {
                    if (Utils.isItemReal(item)) {
                        if (first == null) {
                            first = item;
                            firstRSVItem = RSVItem.isRSVItem(item);
                        }
                        else {
                            second = item;
                            secondRSVItem = RSVItem.isRSVItem(item);
                        }
                    }
                    if (!(first == null || second == null)) {
                        break;
                    }
                }

                if (firstRSVItem || secondRSVItem) {
                    if (firstRSVItem && secondRSVItem) {
                        if (RSVItem.getNameFromItem(first).equals(RSVItem.getNameFromItem(second))) {

                            boolean hasCustomDur = Utils.hasCustomDurability(first);
                            int maxDur = hasCustomDur ? Utils.getMaxCustomDurability(first) : Utils.getMaxVanillaDurability(first);

                            int firstDur = hasCustomDur ? Utils.getCustomDurability(first) : Utils.getVanillaDurability(first);
                            int secondDur = hasCustomDur ? Utils.getCustomDurability(second) : Utils.getVanillaDurability(second);

                            int total = (int) Math.min(firstDur + secondDur + Math.floor(maxDur / 20D), maxDur);

                            ItemStack result = RSVItem.getItem(RSVItem.getNameFromItem(first));
                            Utils.changeDurability(result, total - maxDur, false);

                            event.getInventory().setResult(result);
                        }
                        else {
                            event.getInventory().setResult(null);
                        }
                    }
                    else {
                        event.getInventory().setResult(null);
                    }
                }
            }
            if (r instanceof Keyed keyed) {
                NamespacedKey key = keyed.getKey();

                if (key.getNamespace().equals(NamespacedKey.MINECRAFT)) {
                    switch (key.getKey()) {
                        case "dark_prismarine", "prismarine", "prismarine_bricks", "sea_lantern" -> {
                            for (ItemStack item : matrix) {
                                if (RSVItem.isRSVItem(item)) {
                                    event.getInventory().setResult(null);
                                    break;
                                }
                            }
                        }
                        default -> {}
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSmithing(PrepareSmithingEvent event) {
        SmithingInventory inv = event.getInventory();

        if (Utils.isNetheriteRecipe(inv)) {
            ItemStack base = inv.getItem(0);

            if (RSVItem.isRSVItem(base)) {
                String rsvName = RSVItem.getNameFromItem(base);
                switch (rsvName) {
                    case "diamond_rapier", "diamond_greatsword", "diamond_longsword", "diamond_spear"
                            , "diamond_saber", "diamond_boomerang", "diamond_dagger", "diamond_glaive", "diamond_halberd"
                            , "diamond_hammer", "diamond_javelin", "diamond_lance", "diamond_mace", "diamond_pike"
                            , "diamond_quarterstaff", "diamond_tomahawk", "diamond_throwing_knife", "diamond_warhammer"
                            , "diamond_battleaxe", "diamond_longbow", "diamond_crossbow", "diamond_knife", "diamond_saw", "diamond_mattock" -> {
                        FileConfiguration userConfig = RSVModule.getModule(RSVItem.getModuleNameFromItem(base)).getUserConfig().getConfig();

                        if (userConfig.getBoolean("Recipes." + rsvName + ".Enabled.EnableAllVersions"))
                            event.setResult(Utils.getNetheriteRSVWeapon(base));
                        else {
                            if (userConfig.contains("Recipes." + rsvName + ".Enabled.Versions." + Utils.getMinecraftVersion(true))) {
                                if (userConfig.getBoolean("Recipes." + rsvName + ".Enabled.Versions." + Utils.getMinecraftVersion(true)))
                                    event.setResult(Utils.getNetheriteRSVWeapon(base));
                                else
                                    event.setResult(null);
                            }
                            else
                                event.setResult(null);
                        }
                    }
                    default -> event.setResult(null);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDurability(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();

        if (!event.isCancelled()) {
            if (RSVItem.isRSVItem(item)) {
                if (Utils.hasCustomDurability(item)) {
                    Utils.changeDurability(item, -event.getDamage(), true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onIncrementStatistics(PlayerStatisticIncrementEvent event) {
        if (!event.isCancelled()) {
            if (event.getStatistic() == Statistic.JUMP) {
                Player player = event.getPlayer();
                Location loc = player.getLocation(); // get the player's location
                Block block = loc.getBlock(); // get the block at that location

                Material blockMaterial = block.getType(); // get the material of the block
                if (!Tag.CLIMBABLE.isTagged(blockMaterial)) {
                    if (!(block.isLiquid() || player.isRiptiding() || player.isFlying() || player.isSwimming())) {
                        Bukkit.getServer().getPluginManager().callEvent(new PlayerJumpEvent(event.getPlayer()));
                    }
                }
            }
        }
    }

    /**
     * Adds anvil recipes
     * @param event The event called when a player adds items inside an anvil
     * @see Utils
     */
    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory(); // get the anvil inventory
        Set<RSVAnvilRecipe> anvilRecipes = plugin.getMiscRecipes().getAnvilRecipes();

        for (RSVAnvilRecipe recipe : anvilRecipes) {
            if (recipe.isValidRecipe(inv)) {
                recipe.useRecipe(event);
                break;
            }
        }

        ItemStack result = event.getResult();
        ItemStack first = inv.getItem(0);
        ItemStack second = inv.getItem(1);

        if (RSVItem.isRSVItem(first) || RSVItem.isRSVItem(second)) {
            if (Utils.isItemReal(result)) {
                if (RSVItem.isRSVItem(first)) {
                    if (RSVItem.isRSVItem(second)) {
                        if (RSVItem.getNameFromItem(first).equals(RSVItem.getNameFromItem(second))) {
                            if (Utils.hasCustomDurability(first)) {
                                int maxDur = Utils.getMaxCustomDurability(first);
                                int total = Math.min(Utils.getCustomDurability(first) + Utils.getCustomDurability(second), maxDur);

                                if (first.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL) || second.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                                    Utils.updateDamageLore(result, result.getItemMeta().getEnchants().entrySet());
                                }

                                int resultDur = Math.min(Utils.getCustomDurability(result), maxDur);

                                Utils.changeDurability(result,  -resultDur + total, false);
                                event.setResult(result);
                            }
                        }
                        else {
                            event.setResult(null);
                        }
                    }
                    else if (Utils.isItemReal(second)) {
                        if (second.getItemMeta() instanceof EnchantmentStorageMeta enchMeta) {
                            if (enchMeta.hasStoredEnchant(Enchantment.DAMAGE_ALL)) {
                                Utils.updateDamageLore(result, result.getItemMeta().getEnchants().entrySet());
                                event.setResult(result);
                            }
                        }
                        else if (RSVItem.getItem(RSVItem.getNameFromItem(first)).getRepairIng().test(second) && Utils.getDurability(first) < Utils.getMaxDurability(first)) {
                            int change = (int) Math.round(Utils.getMaxDurability(first) * 0.25 * second.getAmount());

                            Utils.changeDurability(result, change, false);
                            event.setResult(result);
                        }
                        else {
                            event.setResult(null);
                        }
                    }
                }
                else {
                    event.setResult(null);
                }
            }
            else {
                if (RSVItem.isRSVItem(first) && RSVItem.getItem(RSVItem.getNameFromItem(first)).getRepairIng().test(second) && Utils.getDurability(first) < Utils.getMaxDurability(first)) {
                    result = first.clone();
                    int change = Utils.getDurability(result);
                    change *= 0.25 * second.getAmount();

                    Utils.changeDurability(result, change, false);
                    event.setResult(result);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBrew(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();

        if (inv instanceof BrewerInventory brewInv) {
            ClickType click = event.getClick();
            if (click == ClickType.LEFT || click == ClickType.RIGHT) {
                ItemStack current = event.getCurrentItem(); // GETS ITEMSTACK THAT IS BEING CLICKED
                ItemStack cursor = event.getCursor(); // GETS CURRENT ITEMSTACK HELD ON MOUSE

                if (!(click == ClickType.RIGHT && current.isSimilar(cursor))) {
                    Player player = (Player) event.getView().getPlayer();

                    boolean compare = current.isSimilar(cursor);
                    ClickType type = event.getClick();

                    int currentAmount = current.getAmount();
                    int cursorAmount = cursor.getAmount();

                    int stack = current.getMaxStackSize();
                    int half = currentAmount / 2;

                    int clickedSlot = event.getSlot();

                    if (type == ClickType.LEFT) {
                        if (!Utils.isItemReal(current)) {
                            player.setItemOnCursor(current);
                            inv.setItem(clickedSlot, cursor);
                        }
                        else if (compare) {
                            int used = stack - currentAmount;
                            if (cursorAmount <= used) {
                                current.setAmount(currentAmount + cursorAmount);
                                player.setItemOnCursor(null);
                            }
                            else {
                                cursor.setAmount(cursorAmount - used);
                                current.setAmount(currentAmount + used);
                                player.setItemOnCursor(cursor);
                            }
                        }
                        else {
                            inv.setItem(clickedSlot, cursor);
                            player.setItemOnCursor(current);
                        }
                    }
                    else {
                        if (!Utils.isItemReal(current)) {
                            player.setItemOnCursor(current);
                            inv.setItem(clickedSlot, cursor);
                        }
                        else if (Utils.isItemReal(current) && !Utils.isItemReal(cursor)) {
                            ItemStack isClone = current.clone();
                            isClone.setAmount(current.getAmount() % 2 == 0 ? currentAmount - half : currentAmount - half - 1);
                            player.setItemOnCursor(isClone);

                            current.setAmount(currentAmount - half);
                        }
                        else if (compare) {
                            if ((currentAmount + 1) <= stack) {
                                cursor.setAmount(cursorAmount - 1);
                                current.setAmount(currentAmount + 1);
                            }
                        }
                        else {
                            inv.setItem(clickedSlot, cursor);
                            player.setItemOnCursor(current);
                        }
                    }

                    if (brewInv.getIngredient() != null) {
                        Set<RSVBrewingRecipe> brewingRecipes = plugin.getMiscRecipes().getBrewingRecipes();

                        for (RSVBrewingRecipe recipe : brewingRecipes) {
                            if (recipe.isValidRecipe(brewInv)) {
                                recipe.startBrewing(brewInv);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEnchant(EnchantItemEvent event) {
        if (!event.isCancelled()) {
            Utils.updateDamageLore(event.getItem(), event.getEnchantsToAdd().entrySet());
        }
    }

//    @EventHandler(priority = EventPriority.HIGHEST)
//    public void onDisenchant(InventoryClickEvent event) {
//        InventoryView view = event.getView();
//        if (view.getTopInventory() instanceof GrindstoneInventory grindInv) {
//
//            int slot = event.getSlot();
//            if (slot < 3) {
//                ItemStack cursor = event.getCursor();
//
//                if (Utils.isItemReal(cursor)) {
//                    ItemStack other = grindInv.getItem(slot == 0 ? 1 : 0);
//
//                    boolean isCursor = RSVItem.isRSVItem(cursor);
//                    boolean isOther = RSVItem.isRSVItem(other);
//
//                    int i = 2;
//                    final ItemStack copy;
//
//                    if (isCursor || isOther) {
//                        if (isCursor && isOther) {
//                            if (RSVItem.getNameFromItem(cursor).equals(RSVItem.getNameFromItem(other))) {
//                                int newDurability = -1;
//                                int maxDurability = -1;
//
//                                if (Utils.hasCustomDurability(cursor)) {
//                                    newDurability = Utils.getCustomDurability(cursor) + Utils.getCustomDurability(other);
//                                    maxDurability = Utils.getMaxCustomDurability(cursor);
//                                }
//                                else if (cursor.getItemMeta() instanceof Damageable dmg) {
//                                   newDurability = cursor.getType().getMaxDurability() * 2 - dmg.getDamage() - ((Damageable) other.getItemMeta()).getDamage();
//                                   maxDurability = cursor.getType().getMaxDurability();
//                                }
//                                ItemStack result = cursor.clone();
//                                ItemMeta meta = result.getItemMeta();
//
//                                final Set<Map.Entry<Enchantment, Integer>> entries = meta.getEnchants().entrySet();
//
//                                for (Map.Entry<Enchantment, Integer> entry : entries) {
//                                    meta.removeEnchant(entry.getKey());
//                                }
//                                result.setItemMeta(meta);
//                                Utils.updateDamageLore(result, null);
//                                if (!(newDurability == -1 || maxDurability == -1)) {
//                                    Utils.changeDurability(result, newDurability + (int) Math.floor(0.05 * maxDurability), false);
//                                }
//                                copy = result;
//                            }
//                            else {
//                                copy = null;
//                            }
//                        }
//                        else {
//                            if (isCursor && !Utils.isItemReal(other)) {
//                                ItemStack result = cursor.clone();
//                                ItemMeta meta = result.getItemMeta();
//
//                                if (meta.hasEnchants()) {
//                                    final Set<Map.Entry<Enchantment, Integer>> entries = meta.getEnchants().entrySet();
//
//                                    for (Map.Entry<Enchantment, Integer> entry : entries) {
//                                        meta.removeEnchant(entry.getKey());
//                                    }
//
//                                    result.setItemMeta(meta);
//                                    Utils.updateDamageLore(result, null);
//                                    copy = result;
//                                }
//                                else {
//                                    copy = null;
//                                }
//                            }
//                            else {
//                                copy = null;
//                            }
//                        }
//                        new BukkitRunnable() {
//                            @Override
//                            public void run() {
//                                view.setItem(i, copy);
//                            }
//                        }.runTaskLater(plugin, 1L);
//                    }
//                }
//            }
//        }
//    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            String message = event.getMessage();

            if (message.length() > 1) {
                String[] args = message.substring(1).split(" ");

                if (args[0].equalsIgnoreCase("enchant")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (Utils.isItemReal(player.getInventory().getItemInMainHand())) {
                                Utils.updateDamageLore(player.getInventory().getItemInMainHand(), player.getInventory().getItemInMainHand().getItemMeta().getEnchants().entrySet());
                            }
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onServerCommand(ServerCommandEvent event) {
        if (!event.isCancelled()) {
            String message = event.getCommand();

            if (message.length() > 1) {
                String[] args = message.substring(1).split(" ");
                if (args[0].equalsIgnoreCase("enchant")) {
                    if (args.length > 1) {
                        if (!(args[1] == null || args[1].isEmpty())) {
                            Player player = Bukkit.getPlayer(args[1]);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Utils.isItemReal(player.getInventory().getItemInMainHand())) {
                                        Utils.updateDamageLore(player.getInventory().getItemInMainHand(), player.getInventory().getItemInMainHand().getItemMeta().getEnchants().entrySet());
                                    }
                                }
                            }.runTaskLater(plugin, 1L);
                        }
                    }
                }
            }
        }
    }
}
