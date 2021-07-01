package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorEvents implements Listener {

    private final RLCraft plugin;
    private final ArmorRunnables armorRunnables;
    private final Utils util;

    public ArmorEvents(RLCraft instance) {

        plugin = instance;
        armorRunnables = new ArmorRunnables(instance);
        util = new Utils(instance);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        armorRunnables.checkTideGuardianArmor(player);
        armorRunnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Entity damager = event.getDamager();
            if (damager instanceof EnderDragon) {
                double dragonProtection = 0;
                for (ItemStack item : player.getInventory().getArmorContents()) {
                    if (!(item == null || item.getType() == Material.AIR)) {
                        NBTItem nbti = new NBTItem(item);
                        if (nbti.hasKey("Dragon Scale Armor")) {
                            dragonProtection += 0.1;
                        } else if (nbti.hasKey("Dragonsteel Armor")) {
                            dragonProtection += 0.2;
                        }
                    }
                }
                event.setDamage(event.getDamage() * (1D - dragonProtection));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            EntityDamageEvent.DamageCause cause = event.getCause();
            if (cause.equals(EntityDamageEvent.DamageCause.DRAGON_BREATH)) {
                double dragonProtection = 0;
                for (ItemStack item : player.getInventory().getArmorContents()) {
                    if (!(item == null || item.getType() == Material.AIR)) {
                        NBTItem nbti = new NBTItem(item);
                        if (nbti.hasKey("Dragon Scale Armor")) {
                            dragonProtection += 0.1;
                        } else if (nbti.hasKey("Dragonsteel Armor")) {
                            dragonProtection += 0.2;
                        }
                    }
                }
                event.setDamage(event.getDamage() * (1D - dragonProtection));
            }
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onItemPickup(PlayerPickupItemEvent event) {
        NBTItem item = new NBTItem(event.getItem().getItemStack());
        if (item.hasKey("Tide Guardian Armor")) {
            armorRunnables.checkTideGuardianArmor(event.getPlayer());
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onItemThrow(PlayerDropItemEvent event) {
        NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
        if (item.hasKey("Tide Guardian Armor")) {
            armorRunnables.checkTideGuardianArmor(event.getPlayer());
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onClick(InventoryClickEvent event) {
        if (! (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCurrentItem());
            if (item.hasKey("Tide Guardian Armor")) {
                armorRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Tide Guardian Armor")) {
                armorRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }

    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onDragClick(InventoryDragEvent event) {
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Tide Guardian Armor")) {
                armorRunnables.checkTideGuardianArmor((Player) event.getWhoClicked());
            }
        }
    }
}
