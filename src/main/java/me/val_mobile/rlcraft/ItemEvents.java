package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemEvents implements Listener {

    private final ItemAbilities itemAbilities;
    private final DragonRunnables dragonRunnables;
    private final Utils util;
    public ItemEvents(RLCraft instance) {

        dragonRunnables = new DragonRunnables(instance);
        util = new Utils(instance);
        itemAbilities = new ItemAbilities(instance);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Entity entity = event.getEntity();

            if (! (itemMainHand == null || itemMainHand.getType() == Material.AIR) ) {
                NBTItem item = new NBTItem(itemMainHand);
                if (item.hasKey("Dragon Weapon")) {
                    switch (item.getString("Dragon Weapon")) {
                        case "Fire Dragon Bone":
                            if (entity instanceof EnderDragon) {
                                if (!util.checkDragonContainers(entity)) {
                                    util.addDragonContainers(entity);
                                }
                                String dragonType = util.getDragonType(entity);

                                if (dragonType.equals("Ice")) {
                                    event.setDamage(event.getDamage() + 8.0D);
                                }
                            }
                            itemAbilities.FireDragonBoneAbility((LivingEntity) entity);
                            break;
                        case "Ice Dragon Bone":
                            if (entity instanceof EnderDragon) {
                                if (!util.checkDragonContainers(entity)) {
                                    util.addDragonContainers(entity);
                                }
                                String dragonType = util.getDragonType(entity);

                                if (dragonType.equals("Fire")) {
                                    event.setDamage(event.getDamage() + 8.0D);
                                }
                            }
                            itemAbilities.IceDragonBoneAbility((LivingEntity) entity);
                            break;
                        case "Lightning Dragon Bone":
                            if (entity instanceof EnderDragon) {
                                if (!util.checkDragonContainers(entity)) {
                                    util.addDragonContainers(entity);
                                }
                                String dragonType = util.getDragonType(entity);

                                if (dragonType.equals("Ice") || dragonType.equals("Fire")) {
                                    event.setDamage(event.getDamage() + 4.0D);
                                }
                            }
                            itemAbilities.LightningDragonBoneAbility((LivingEntity) entity);
                            break;
                        case "Fire Dragonsteel":
                            itemAbilities.FireDragonsteelAbility((LivingEntity) entity);
                            break;
                        case "Ice Dragonsteel":
                            itemAbilities.IceDragonsteelAbility((LivingEntity) entity);
                            break;
                        case "Lightning Dragonsteel":
                            itemAbilities.LightningDragonsteelAbility((LivingEntity) entity);
                            break;
                    }
                }
                if (item.hasKey("Spartan's Weapon")) {
                    switch (item.getString("Spartan's Weapon")) {
                        case "Rapier":
                            if (!itemAbilities.hasArmor((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * 3.0D);
                            }
                            break;
                        case "Katana":
                            if (!itemAbilities.hasChestplate((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * 2.0D);
                            }
                            break;
                    }
                }
            }
        }
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            Entity entity = event.getEntity();

            if (! (itemMainHand == null || itemMainHand.getType() == Material.AIR) ) {
                NBTItem item = new NBTItem(itemMainHand);
                if (item.hasKey("Spartan's Weapon")) {
                    switch (item.getString("Spartan's Weapon")) {
                        case "Rapier":
                            event.setDamage(event.getDamage() * 0.75D);
                            util.subtractDurability(itemMainHand);
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerHit(PlayerInteractEvent event) {
        if (! (event.getItem() == null || event.getItem().getType() == Material.AIR) ) {
            Player player = event.getPlayer();
            NBTItem item = new NBTItem(event.getItem());
            if (item.hasKey("Spartan's Weapon")) {
                switch (item.getString("Spartan's Weapon")) {
                    case "Greatsword":
                        List<Entity> list = player.getNearbyEntities(6, 6, 6);
                        for (Entity e : list) {
                            if (player.hasLineOfSight(e)) {
                                if (e.getLocation().toVector().distance(player.getLocation().toVector()) > 3) {
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    }
}
