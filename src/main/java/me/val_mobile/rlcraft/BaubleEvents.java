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
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
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
    private final CustomConfig customConfig;

    public BaubleEvents(RLCraft instance) {

        plugin = instance;
        abilities = new BaubleAbilities(instance);
        citem = new Items(instance);
        util = new Utils(instance);
        baubleRunnables = new BaubleRunnables(instance);
        customConfig = new CustomConfig(instance);
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        util.checkBauble(player);

        baubleRunnables.getPotionRingResistanceRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingResistance.TickTime"));
        baubleRunnables.getPotionRingStrengthRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingStrength.TickTime"));
        baubleRunnables.getPotionRingSpeedRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingSpeed.TickTime"));
        baubleRunnables.getPotionRingJumpBoostRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingJumpBoost.TickTime"));
        baubleRunnables.getPotionRingHasteRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingHaste.TickTime"));
        baubleRunnables.getPotionRingRegenerationRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("PotionRingRegeneration.TickTime"));

        baubleRunnables.getScarliteRingRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("ScarliteRing.TickTime"));
        baubleRunnables.getDragonsEyeRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("DragonsEye.TickTime"));
        baubleRunnables.getMinersRingRunnable(player).runTaskTimer(plugin, 0L, customConfig.getBaubleConfig().getInt("MinersRing.TickTime"));

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
                        baubleRunnables.freezeEntity(player).runTaskLater(plugin, 1);
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
            switch (event.getCause()) {
                case FIRE:
                case FIRE_TICK:
                case LAVA:
                case HOT_FLOOR: {
                    if (inv.containsAtLeast(citem.getObsidianSkull(), 1)) {
                        event.setDamage(event.getDamage() * customConfig.getBaubleConfig().getDouble("ObsidianSkull.HeatDamageMultiplier"));
                    }
                    else if (!(itemOffHand == null || itemOffHand.getType() == Material.AIR)) {
                        if (((Damageable) itemOffHand.getItemMeta()).hasDamage()) {
                            itemOffHand = util.resetDurability(itemOffHand);
                            if (itemOffHand.getItemMeta().equals(citem.getObsidianShield())) {
                                event.setDamage(event.getDamage() * customConfig.getBaubleConfig().getDouble("ObsidianShield.HeatDamageMultiplier"));
                            }
                            else if (itemOffHand.getItemMeta().equals(citem.getAnkhShield())) {
                                event.setDamage(event.getDamage() * customConfig.getBaubleConfig().getDouble("AnkhShield.HeatDamageMultiplier"));
                            }
                        }
                    }
                }
                case ENTITY_EXPLOSION:
                case ENTITY_ATTACK:
                case ENTITY_SWEEP_ATTACK:
                case BLOCK_EXPLOSION: {
                    if (! (itemOffHand == null || itemOffHand.getType() == Material.AIR) ) {
                        itemOffHand = util.resetDurability(itemOffHand);
                        if (itemOffHand.getItemMeta().equals(citem.getCobaltShield()) ||
                                itemOffHand.getItemMeta().equals(citem.getObsidianShield()) ||
                                itemOffHand.getItemMeta().equals(citem.getAnkhShield())) {
                            baubleRunnables.freezeEntity(player);
                        }
                    }
                }
                case FALL: {
                    if (player.getInventory().containsAtLeast(citem.getBalloon(), 1))
                        if (player.getFallDistance() <= customConfig.getBaubleConfig().getDouble("Balloon.MinFallDistance")) {
                            event.setCancelled(true);
                        }
                        else {
                            event.setDamage(event.getDamage() * customConfig.getBaubleConfig().getDouble("Balloon.FallDamageMultiplier"));
                        }
                    if (player.getInventory().containsAtLeast(citem.getLuckyHorseshoe(), 1))
                        event.setCancelled(true);
                }
                case CONTACT: {
                    if (player.getInventory().containsAtLeast(citem.getPhytoprostasiaAmulet(), 1))
                        event.setCancelled(true);
                }
            }

            if (plugin.crossNecklace.containsKey(player.getUniqueId())) {
                if (plugin.crossNecklace.get(player.getUniqueId())) {
                    event.setCancelled(true);
                }
            }

            if (!event.isCancelled()) {
                if (player.getInventory().containsAtLeast(citem.getCrossNecklace(), 1)) {
                    util.setOrReplaceHashmap(plugin.crossNecklace, player.getUniqueId(), true);
                    baubleRunnables.removeInvFrames(player).runTaskLater(plugin, customConfig.getBaubleConfig().getInt("CrossNecklace.InvFrameLength"));
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
                        velocity.setY(jumpVelocity * customConfig.getBaubleConfig().getDouble("Balloon.JumpVelocityMultiplier"));
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
                double chance = customConfig.getBaubleConfig().getDouble("EnderDragonScale.DropChance");
                if (customConfig.getBaubleConfig().getBoolean("EnderDragonScale.CheckLooting")) {
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
                double chance = customConfig.getBaubleConfig().getDouble("ForbiddenFruit.DropChance");
                if (customConfig.getBaubleConfig().getBoolean("ForbiddenFruit.CheckLooting")) {
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
                double chance = customConfig.getBaubleConfig().getDouble("RingOverclocking.DropChance");
                if (customConfig.getBaubleConfig().getBoolean("RingOverclocking.CheckLooting")) {
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
                double chance = customConfig.getBaubleConfig().getDouble("Vitamins.DropChance");
                if (customConfig.getBaubleConfig().getBoolean("Vitamins.CheckLooting")) {
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
                double chance = customConfig.getBaubleConfig().getDouble("Bezoar.DropChance");
                if (customConfig.getBaubleConfig().getBoolean("Bezoar.CheckLooting")) {
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
                    case "POISON":
                        if (player.getInventory().containsAtLeast(citem.getBezoar(), 1) ||
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
                    inv.setRepairCost(customConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                    inv.setMaximumRepairCost(customConfig.getBaubleConfig().getInt("ObsidianShield.AnvilCost"));
                }
                else if (firstMeta.equals(citem.getRingofOverclocking().getItemMeta()) && secondMeta.equals(citem.getShulkerHeart().getItemMeta())) {
                    event.setResult(citem.getRingofFreeAction());
                    inv.setRepairCost(customConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                    inv.setMaximumRepairCost(customConfig.getBaubleConfig().getInt("RingFreeAction.AnvilCost"));
                }
                else if (firstMeta.equals(citem.getBezoar().getItemMeta()) && secondMeta.equals(citem.getBlackDragonScale().getItemMeta())) {
                    event.setResult(citem.getMixedColorDragonScale());
                    inv.setRepairCost(customConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                    inv.setMaximumRepairCost(customConfig.getBaubleConfig().getInt("MixedColorDragonScale.AnvilCost"));
                }
                else if (firstMeta.equals(citem.getObsidianShield().getItemMeta()) && secondMeta.equals(citem.getAnkhCharm().getItemMeta())) {
                    event.setResult(citem.getAnkhShield());
                    inv.setRepairCost(customConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                    inv.setMaximumRepairCost(customConfig.getBaubleConfig().getInt("AnkhShield.AnvilCost"));
                }
            }
        }

    }

}
