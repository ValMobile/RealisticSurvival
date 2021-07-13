package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class SeaSerpentGearEvents implements Listener {

    private final RLCraft plugin;
    private final SeaSerpentGearRunnables seaSerpentGearRunnables;
    public SeaSerpentGearEvents(RLCraft instance) {
        plugin = instance;
        seaSerpentGearRunnables = new SeaSerpentGearRunnables(instance);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        seaSerpentGearRunnables.checkTideGuardianArmor(player);
        seaSerpentGearRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, Utils.convertSecondsIntoTicks(1.5));

        for (Recipe r : Recipes.getSeaSerpentRecipes()) {
            if (r instanceof ShapedRecipe) {
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            else if (r instanceof ShapelessRecipe) {
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
            }
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onItemPickup(PlayerPickupItemEvent event) {
        NBTItem item = new NBTItem(event.getItem().getItemStack());
        if (item.hasKey("Tide Guardian Armor")) {
            seaSerpentGearRunnables.checkTideGuardianArmor(event.getPlayer());
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onItemThrow(PlayerDropItemEvent event) {
        NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
        if (item.hasKey("Tide Guardian Armor")) {
            seaSerpentGearRunnables.checkTideGuardianArmor(event.getPlayer());
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onClick(InventoryClickEvent event) {
        if (! (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCurrentItem());
            if (item.hasKey("Tide Guardian Armor")) {
                seaSerpentGearRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Tide Guardian Armor")) {
                seaSerpentGearRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }

    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onDragClick(InventoryDragEvent event) {
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Tide Guardian Armor")) {
                seaSerpentGearRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }
    }
}
