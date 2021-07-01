package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;

public class BaubleEvents implements Listener {

    private final RLCraft plugin;
    private final Items citem;
    private final BaubleAbilities abilities;
    private final BaubleRunnables baubleRunnables;
    private final Utils util;

    public BaubleEvents(RLCraft instance) {

        plugin = instance;
        abilities = new BaubleAbilities(instance);
        citem = new Items(instance);
        util = new Utils(instance);
        baubleRunnables = new BaubleRunnables(instance);
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        util.checkBauble(player);

        baubleRunnables.getPotionRingResistanceRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getPotionRingStrengthRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getPotionRingSpeedRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getPotionRingJumpBoostRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getPotionRingHasteRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getPotionRingRegenerationRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));

        baubleRunnables.getScarliteRingRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(15));
        baubleRunnables.getDragonsEyeRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));
        baubleRunnables.getMinersRingRunnable(player).runTaskTimer(plugin, 0L, util.convertSecondsIntoTicks(1.5));

    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        NBTItem item = new NBTItem(event.getItem().getItemStack());
        if (item.hasKey("Potion Effect Bauble")) {
            util.checkBauble(event.getPlayer());
        }
    }

    @EventHandler
    public void onItemThrow(PlayerDropItemEvent event) {
        NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
        if (item.hasKey("Potion Effect Bauble")) {
            util.checkBauble(event.getPlayer());
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (! (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCurrentItem());
            if (item.hasKey("Potion Effect Bauble")) {
                util.checkBauble((Player) event.getWhoClicked());
            }
        }
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Potion Effect Bauble")) {
                util.checkBauble((Player) event.getWhoClicked());
            }
        }

    }

    @EventHandler
    public void onDragClick(InventoryDragEvent event) {
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Potion Effect Bauble")) {
                util.checkBauble((Player) event.getWhoClicked());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTarget(EntityTargetEvent event) {
        if(event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget();
            if (player.getInventory().contains(citem.getEnderQueensCrown()))
                event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            Entity entity = event.getEntity();
            if (player.getInventory().containsAtLeast(citem.getPoisonStone(), 1)) {
                abilities.PoisonStoneAbility((LivingEntity) entity);
            }

        }
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            NBTItem itemOffHand = null;
            if (! (player.getInventory().getItemInOffHand() == null || player.getInventory().getItemInOffHand().getType() == Material.AIR) ) {
                itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
            }
            if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                if (itemOffHand.hasKey("Bauble")) {
                    String bauble = itemOffHand.getString("Bauble");
                    if (bauble.equals("Cobalt Shield") ||
                            bauble.equals("Obsidian Shield") ||
                            bauble.equals("Ankh Shield")) {
                        baubleRunnables.freezeEntity(player).runTaskLater(plugin, util.convertSecondsIntoTicks(0.05));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            EntityDamageEvent.DamageCause cause = event.getCause();
            Player player = (Player) event.getEntity();
            PlayerInventory inv = player.getInventory();
            ItemStack itemOffHand = null;
            if (!(inv.getItemInOffHand() == null || inv.getItemInOffHand().getType() == Material.AIR)) {
                itemOffHand = inv.getItemInOffHand();
            }

            if (cause.equals(EntityDamageEvent.DamageCause.FIRE) ||
                    cause.equals(EntityDamageEvent.DamageCause.FIRE_TICK) ||
                    cause.equals(EntityDamageEvent.DamageCause.LAVA) ||
                    cause.equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
                if (inv.containsAtLeast(citem.getObsidianSkull(), 1)) {
                    event.setDamage(event.getDamage() * 0.25);
                }
                else if (! (itemOffHand == null || itemOffHand.getType() == Material.AIR) ) {
                    if (((Damageable) itemOffHand.getItemMeta()).hasDamage()) {
                        itemOffHand = util.resetDurability(itemOffHand);
                        if (itemOffHand.getItemMeta().equals(citem.getObsidianShield()) ||
                                itemOffHand.getItemMeta().equals(citem.getAnkhShield())) {
                            event.setDamage(event.getDamage() * 0.25);
                        }
                    }
                }

            }
            else if (cause.equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) ||
                    cause.equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
                if (! (itemOffHand == null || itemOffHand.getType() == Material.AIR) ) {
                    itemOffHand = util.resetDurability(itemOffHand);
                    if (itemOffHand.getItemMeta().equals(citem.getCobaltShield()) ||
                            itemOffHand.getItemMeta().equals(citem.getObsidianShield()) ||
                            itemOffHand.getItemMeta().equals(citem.getAnkhShield())) {
                        baubleRunnables.freezeEntity(player);
                    }
                }
            }
            else if (cause.equals(EntityDamageEvent.DamageCause.FALL)) {
                if (player.getInventory().containsAtLeast(citem.getBalloon(), 1))
                    if (player.getFallDistance() <= 8.0D) {
                        event.setCancelled(true);
                    }
                    else {
                        event.setDamage(event.getDamage() * 0.25);
                    }
                if (player.getInventory().containsAtLeast(citem.getLuckyHorseshoe(), 1))
                    event.setCancelled(true);
            }
            else if (cause.equals(EntityDamageEvent.DamageCause.CONTACT)) {
                if (player.getInventory().containsAtLeast(citem.getPhytoprostasiaAmulet(), 1))
                    event.setCancelled(true);
            }

            if (util.playerInCrossNecklace(player)) {
                if (plugin.crossNecklace.get(player.getUniqueId())) {
                    event.setCancelled(true);
                }
            }

            if (!event.isCancelled()) {
                if (player.getInventory().containsAtLeast(citem.getCrossNecklace(), 1)) {
                    if (util.playerInCrossNecklace(player)) {
                        plugin.crossNecklace.replace(player.getUniqueId(), true);
                    }
                    else {
                        plugin.crossNecklace.put(player.getUniqueId(), true);
                    }
                    baubleRunnables.removeInvFrames(player).runTaskLater(plugin, util.convertSecondsIntoTicks(1.2));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        if (event.getPlayer().getInventory().containsAtLeast(citem.getBalloon(), 1)) {
            Player player = event.getPlayer();
            Vector velocity = player.getVelocity();
            // Check if the player is moving "up"
            if (velocity.getY() > 0)
            {
                // Default jump velocity
                double jumpVelocity = (double) 0.42D; // Default jump velocity
                if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                    PotionEffect jumpPotion = player.getPotionEffect(PotionEffectType.JUMP);
                    // If player has jump potion add it to jump velocity
                    jumpVelocity += ((double) jumpPotion.getAmplifier() + 1) * 0.1D;

                }
                // Check if player is not on ladder and if jump velocity calculated is equals to player Y velocity
                if (player.getLocation().getBlock().getType() != Material.LADDER &&
                        player.getLocation().getBlock().getType() != Material.VINE &&
                        player.getLocation().getBlock().getType() != Material.TWISTING_VINES &&
                        player.getLocation().getBlock().getType() != Material.WEEPING_VINES
                        && Math.abs(velocity.getY() - jumpVelocity) <= 0.01)
                {
                    if ( !(player.isInWater() || player.isRiptiding() || player.isFlying()) ) {
                        velocity.setY(jumpVelocity * 2.0D);
                        player.setVelocity(velocity);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        switch (event.getEntity().getType()) {
            case ENDER_DRAGON: {
                Random r = new Random();
                double chance = plugin.getConfig().getDouble("baubles.EnderDragonScale.dropChance");
                if (plugin.getConfig().getBoolean("baubles.EnderDragonScale.checkLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (!(player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR)) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getEnderDragonScale());
                }
                break;
            }
            case HUSK: {
                Random r = new Random();
                double chance = plugin.getConfig().getDouble("baubles.ForbiddenFruit.dropChance");
                if (plugin.getConfig().getBoolean("baubles.ForbiddenFruit.checkLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (!(player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR)) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getForbiddenFruit());
                }
                break;
            }
            case STRAY: {
                Random r = new Random();
                double chance = plugin.getConfig().getDouble("baubles.RingOverclocking.dropChance");
                if (plugin.getConfig().getBoolean("baubles.RingOverclocking.checkLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getRingofOverclocking());
                }
                break;
            }
            case ELDER_GUARDIAN: {
                Random r = new Random();
                double chance = plugin.getConfig().getDouble("baubles.Vitamins.dropChance");
                if (plugin.getConfig().getBoolean("baubles.Vitamins.checkLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getVitamins());
                }
                break;
            }
            case CAVE_SPIDER: {
                Random r = new Random();
                double chance = plugin.getConfig().getDouble("baubles.Bezoar.dropChance");
                if (plugin.getConfig().getBoolean("baubles.Bezoar.checkLooting")) {
                    if (!(event.getEntity().getKiller() == null)) {
                        Player player = event.getEntity().getKiller();
                        if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                            ItemMeta meta = itemMainHand.getItemMeta();
                            if (meta.hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
                                int lootingLvl = meta.getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
                                chance += lootingLvl * 0.01;
                            }
                        }
                    }
                }
                if (r.nextDouble() <= chance) {
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                            citem.getBezoar());
                }
                break;
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            PotionEffect newEffect = event.getNewEffect();
            NBTItem itemOffHand = null;
            if (! (player.getInventory().getItemInOffHand() == null || player.getInventory().getItemInOffHand().getType() == Material.AIR) ) {
                itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                if (itemOffHand.hasKey("Bauble")) {

                }
            }
            if (newEffect != null) {
                switch (newEffect.getType().getName()) {
                    case "HUNGER":
                        if (player.getInventory().containsAtLeast(citem.getForbiddenFruit(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "SLOW":
                        if (player.getInventory().containsAtLeast(citem.getRingofOverclocking(), 1) ||
                                player.getInventory().containsAtLeast(citem.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhShield(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "POISON":
                        if (player.getInventory().containsAtLeast(citem.getBezoar(), 1) ||
                                player.getInventory().containsAtLeast(citem.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhShield(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "WITHER":
                        if (player.getInventory().containsAtLeast(citem.getBlackDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(citem.getMixedColorDragonScale(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "SLOW_DIGGING":
                        if (player.getInventory().containsAtLeast(citem.getVitamins(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "BLINDNESS":
                        if (player.getInventory().containsAtLeast(citem.getSunglasses(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                    case "LEVITATION":
                        if (player.getInventory().containsAtLeast(citem.getShulkerHeart(), 1) ||
                                player.getInventory().containsAtLeast(citem.getRingofFreeAction(), 1) ||
                                player.getInventory().containsAtLeast(citem.getAnkhCharm(), 1)) {
                            event.setCancelled(true);
                        }
                        if (!(itemOffHand == null || itemOffHand.getItem().getType() == Material.AIR)) {
                            itemOffHand = new NBTItem(player.getInventory().getItemInOffHand());
                            if (itemOffHand.hasKey("Bauble")) {
                                if (itemOffHand.getString("Bauble").equals("Ankh Shield")) {
                                    event.setCancelled(true);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getItemMeta().equals(citem.getBattleBurrito().getItemMeta())) {
            Player player = event.getPlayer();
            if (!player.hasPotionEffect(PotionEffectType.SPEED)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.SPEED);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.SPEED).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.SPEED).getDuration() < 500) {
                player.removePotionEffect(PotionEffectType.SPEED);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 2));
            }

            if (!player.hasPotionEffect(PotionEffectType.REGENERATION)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.REGENERATION).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.REGENERATION).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.REGENERATION).getDuration() < 500) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 2));
            }

            if (!player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getDuration() < 500) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
            }

            if (!player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getDuration() < 500) {
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 2));
            }

            if (!player.hasPotionEffect(PotionEffectType.ABSORPTION)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.ABSORPTION).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.ABSORPTION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.ABSORPTION).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.ABSORPTION).getDuration() < 1000) {
                player.removePotionEffect(PotionEffectType.ABSORPTION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2000, 2));
            }

            if (!player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.FIRE_RESISTANCE).getAmplifier() < 2) {
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2));
            }
            else if (player.getPotionEffect(PotionEffectType.FIRE_RESISTANCE).getAmplifier() == 2 &&
                    player.getPotionEffect(PotionEffectType.FIRE_RESISTANCE).getDuration() < 500) {
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2));
            }
        }
    }

    @EventHandler
    public void inAnvil(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory();
        if (! (inv.getItem(0) == null || inv.getItem(0).getType() == Material.AIR) ) {
            if (! (inv.getItem(1) == null || inv.getItem(1).getType() == Material.AIR) ) {
                ItemStack firstItem = inv.getItem(0);
                ItemStack secondItem = inv.getItem(1);

                ItemMeta firstMeta = firstItem.getItemMeta();
                ItemMeta secondMeta = secondItem.getItemMeta();

                if (((Damageable) firstMeta).hasDamage()) {
                    ((Damageable) firstMeta).setDamage(0);
                }
                if (((Damageable) secondMeta).hasDamage()) {
                    ((Damageable) secondMeta).setDamage(0);
                }

                if (firstMeta.equals(citem.getCobaltShield().getItemMeta()) && secondMeta.equals(citem.getObsidianSkull().getItemMeta())) {
                    event.setResult(citem.getObsidianShield());
                    inv.setRepairCost(10);
                    inv.setMaximumRepairCost(10);
                }
                else if (firstMeta.equals(citem.getRingofOverclocking().getItemMeta()) && secondMeta.equals(citem.getShulkerHeart().getItemMeta())) {
                    event.setResult(citem.getRingofFreeAction());
                    inv.setRepairCost(10);
                    inv.setMaximumRepairCost(10);
                }
                else if (firstMeta.equals(citem.getBezoar().getItemMeta()) && secondMeta.equals(citem.getBlackDragonScale().getItemMeta())) {
                    event.setResult(citem.getMixedColorDragonScale());
                    inv.setRepairCost(10);
                    inv.setMaximumRepairCost(10);
                }
                else if (firstMeta.equals(citem.getObsidianShield().getItemMeta()) && secondMeta.equals(citem.getAnkhCharm().getItemMeta())) {
                    event.setResult(citem.getAnkhShield());
                    inv.setRepairCost(10);
                    inv.setMaximumRepairCost(10);
                }
            }
        }

    }

}
