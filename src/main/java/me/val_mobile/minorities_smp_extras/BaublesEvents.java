package me.val_mobile.minorities_smp_extras;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BaublesEvents implements Listener {

    private final Main plugin;
    private final Items citem;
    private final BaublesAbilities abilities;
    private final Runnables runnables;
    private final Recipes recipes;
    private final Utils util = new Utils();

    public BaublesEvents(Main instance) {

        plugin = instance;
        abilities = new BaublesAbilities(instance);
        citem = new Items(instance);
        recipes = new Recipes(instance);
        runnables = new Runnables(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        runnables.resetBaubleMaps(player);
        runnables.checkBauble(player);
        runnables.checkTideGuardianArmor(player);

        runnables.getPotionRingResistanceRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getPotionRingStrengthRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getPotionRingSpeedRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getPotionRingJumpBoostRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getPotionRingHasteRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getPotionRingRegenerationRunnable(player).runTaskTimer(plugin, 0L, 20L);

        runnables.getTideGuardianArmorRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getScarliteRingRunnable(player).runTaskTimer(plugin, 0L, 200L);
        runnables.getDragonsEyeRunnable(player).runTaskTimer(plugin, 0L, 20L);
        runnables.getMinersRingRunnable(player).runTaskTimer(plugin, 0L, 20L);

        if (plugin.getConfig().getBoolean("flintTools")) {
            player.discoverRecipe(recipes.getFlintAxeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintKnifeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintShovelRecipe().getKey());
            player.discoverRecipe(recipes.getFlintPickaxeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintHoeRecipe().getKey());
        }
        
        if (plugin.getConfig().getBoolean("noTreePunching")) {
            player.discoverRecipe(recipes.getCobblestoneRecipe().getKey());
            player.discoverRecipe(recipes.getPlantStringRecipe().getKey());
        }

        if (plugin.getConfig().getBoolean("dragons.enabled")) {
            player.discoverRecipe(recipes.getFireDragonsteelIngotRecipe().getKey());
            player.discoverRecipe(recipes.getIceDragonsteelIngotRecipe().getKey());
            player.discoverRecipe(recipes.getLightningDragonsteelIngotRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBlueRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBronzeRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsGrayRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsGreenRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsRedRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsSapphireRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsSilverRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsWhiteRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsAmethystRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBlackRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsCopperRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsElectricRecipe().getKey());

            player.discoverRecipe(recipes.getDragonBonePickaxeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneShovelRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneHoeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneBowRecipe().getKey());
            player.discoverRecipe(recipes.getFlamedDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getIceDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getLightningDragonBoneSwordRecipe().getKey());
            
        }
        if (plugin.getConfig().getBoolean("seaSerpents.enabled")) {
            player.discoverRecipe(recipes.getTideGuardianHelmetBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsBlueRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsBronzeRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsDeepBlueRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetGreenRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateGreenRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsGreenRecipe().getKey());
            player.discoverRecipe(recipes.getideGuardianBootsGreenRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetPurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplatePurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsPurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsPurpleRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsRedRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsTealRecipe().getKey());
            
        }
        if (plugin.getConfig().getBoolean("baubles")) {
            player.discoverRecipe(recipes.getBalloonRecipe().getKey());
            player.discoverRecipe(recipes.getCobaltShieldRecipe().getKey());
            player.discoverRecipe(recipes.getObsidianSkullRecipe().getKey());
            player.discoverRecipe(recipes.getSunglassesRecipe().getKey());
            player.discoverRecipe(recipes.getCrackedBlackDragonScaleRecipe().getKey());
            player.discoverRecipe(recipes.getBlackDragonScaleRecipe().getKey());
            player.discoverRecipe(recipes.getAnkhCharmRecipe().getKey());
            player.discoverRecipe(recipes.getWarpedScrollRecipe().getKey());
        }
        
        
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        NBTItem item = new NBTItem(event.getItem().getItemStack());
        if (item.hasKey("Potion Effect Bauble")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    runnables.checkBauble(event.getPlayer());
                }
            }.runTaskLater(plugin, 1L);
        }
        else if (item.hasKey("Tide Guardian Armor")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    runnables.checkTideGuardianArmor(event.getPlayer());
                }
            }.runTaskLater(plugin, 1L);
        }
    }

    @EventHandler
    public void onItemThrow(PlayerDropItemEvent event) {
        NBTItem item = new NBTItem(event.getItemDrop().getItemStack());
        if (item.hasKey("Potion Effect Bauble")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    runnables.checkBauble(event.getPlayer());
                }
            }.runTaskLater(plugin, 1L);
        }
        else if (item.hasKey("Tide Guardian Armor")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    runnables.checkTideGuardianArmor(event.getPlayer());
                }
            }.runTaskLater(plugin, 1L);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (! (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCurrentItem());
            if (item.hasKey("Potion Effect Bauble")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        runnables.checkBauble((Player) event.getWhoClicked());
                    }
                }.runTaskLater(plugin, 1L);
            }
            else if (item.hasKey("Tide Guardian Armor")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        runnables.checkTideGuardianArmor((Player) event.getWhoClicked());
                    }
                }.runTaskLater(plugin, 1L);
            }
        }

    }

    @EventHandler
    public void onDragClick(InventoryDragEvent event) {
        if (! (event.getCursor() == null || event.getCursor().getType() == Material.AIR) ) {
            NBTItem item = new NBTItem(event.getCursor());
            if (item.hasKey("Potion Effect Bauble")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        runnables.checkBauble((Player) event.getWhoClicked());
                    }
                }.runTaskLater(plugin, 1L);
            }
            else if (item.hasKey("Tide Guardian Armor")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        runnables.checkTideGuardianArmor((Player) event.getWhoClicked());
                    }
                }.runTaskLater(plugin, 1L);
            }
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {
        if(event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            Player player = (Player) event.getTarget();
            if (player.getInventory().contains(citem.getEnderQueensCrown()))
                event.setCancelled(true);
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (event.getEntity() instanceof Enderman) {
                if (player.getInventory().containsAtLeast(citem.getPoisonStone(), 1)) {
                    abilities.PoisonStoneAbility((LivingEntity) event.getEntity());
                }
            }
            if (! (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) ) {
                NBTItem item = new NBTItem(player.getInventory().getItemInMainHand());
                if (item.hasKey("Dragon Weapon")) {
                    switch (item.getString("Dragon Weapon")) {
                        case "Fire Dragon Bone":
                            if (event.getEntity() instanceof EnderDragon) {
                                event.setDamage(event.getDamage() + 8.0D);
                            }
                            abilities.FireDragonBoneAbility((LivingEntity) event.getEntity());
                            break;
                        case "Ice Dragon Bone":
                            if (event.getEntity() instanceof EnderDragon) {
                                event.setDamage(event.getDamage() + 8.0D);
                            }
                            abilities.IceDragonBoneAbility((LivingEntity) event.getEntity());
                            break;
                        case "Lightning Dragon Bone":
                            if (event.getEntity() instanceof EnderDragon) {
                                event.setDamage(event.getDamage() + 8.0D);
                            }
                            abilities.LightningDragonBoneAbility((LivingEntity) event.getEntity());
                            break;
                        case "Fire Dragonsteel":
                            break;
                        case "Ice Dragonsteel":
                            break;
                        case "Lightning Dragonsteel":
                            break;
                    }
                }
            }

        }
        else if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getInventory().contains(citem.getCobaltShield()) ||
                    player.getInventory().contains(citem.getObsidianShield()) ||
                    player.getInventory().contains(citem.getAnkhShield())) {
                Vector vector = new Vector();
                player.setVelocity(vector);

                new BukkitRunnable() {
                    public void run() {
                        player.setVelocity(vector);
                    }
                }.runTaskLater(plugin, 1L);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE) ||
                    event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) ||
                    event.getCause().equals(EntityDamageEvent.DamageCause.LAVA) ||
                    event.getCause().equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
                if (player.getInventory().containsAtLeast(citem.getObsidianSkull(), 1) ||
                        player.getInventory().containsAtLeast(citem.getObsidianShield(), 1) ||
                        player.getInventory().containsAtLeast(citem.getAnkhShield(), 1)) {
                    event.setDamage(event.getDamage() * 0.25);
                }

            }
            else if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) ||
                    event.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
                if (player.getInventory().containsAtLeast(citem.getCobaltShield(), 1) ||
                        player.getInventory().containsAtLeast(citem.getObsidianShield(), 1) ||
                        player.getInventory().containsAtLeast(citem.getAnkhShield(), 1)) {
                    Vector vector = new Vector();
                    player.setVelocity(vector);

                    new BukkitRunnable() {
                        public void run() {
                            player.setVelocity(vector);
                        }
                    }.runTaskLater(plugin, 1L);
                }
            }
            else if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                if (player.getInventory().containsAtLeast(citem.getBalloon(), 1))
                    event.setDamage(event.getDamage() * 0.25);
                if (player.getInventory().containsAtLeast(citem.getLuckyHorseshoe(), 1))
                    event.setDamage(0.0D);
            }
            else if (event.getCause().equals(EntityDamageEvent.DamageCause.CONTACT)) {
                if (player.getInventory().containsAtLeast(citem.getPhytoprostasiaAmulet(), 1))
                    event.setDamage(0.0D);
            }

            if (player.getInventory().containsAtLeast(citem.getCrossNecklace(), 1)) {
                new BukkitRunnable() {
                    public void run() {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30, 255));
                    }
                }.runTaskLater(plugin, 1L);

            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
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
                        && Double.compare(velocity.getY(), jumpVelocity) == 0)
                {
                    if (!player.isInWater() && !player.isRiptiding()) {
                        velocity.setY(jumpVelocity * 2.0D);
                        player.setVelocity(velocity);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getNewEffect() != null) {
                if (event.getNewEffect().getType().equals(PotionEffectType.HUNGER)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getForbiddenFruit()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.SLOW)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getRingofOverclocking()) || player.getInventory().contains(citem.getRingofFreeAction()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.POISON)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getBezoar()) || player.getInventory().contains(citem.getMixedColorDragonScale()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.WITHER)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getBlackDragonScale()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.SLOW_DIGGING)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getVitamins()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.BLINDNESS)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getSunglasses()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
                if (event.getNewEffect().getType().equals(PotionEffectType.LEVITATION)) {
                    Player player = (Player) event.getEntity();
                    if (player.getInventory().contains(citem.getShulkerHeart()) || player.getInventory().contains(citem.getRingofFreeAction()) || player.getInventory().contains(citem.getAnkhCharm()) || player.getInventory().contains(citem.getAnkhShield()))
                        event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onConsume(PlayerItemConsumeEvent event) {
        if (event.getItem().getItemMeta().equals(citem.getBattleBurrito().getItemMeta())) {
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
        if (! (event.getInventory().getItem(0) == null || event.getInventory().getItem(0).getType() == Material.AIR) ) {
            if (! (event.getInventory().getItem(1) == null || event.getInventory().getItem(1).getType() == Material.AIR) ) {
                ItemStack firstItem = util.resetDurability(event.getInventory().getItem(0));
                ItemStack secondItem = util.resetDurability(event.getInventory().getItem(1));

                if (firstItem.getItemMeta().equals(citem.getCobaltShield().getItemMeta()) && secondItem.getItemMeta().equals(citem.getObsidianSkull().getItemMeta())) {
                    event.setResult(citem.getObsidianShield());
                    event.getInventory().setRepairCost(10);
                    event.getInventory().setMaximumRepairCost(10);
                } else if (firstItem.getItemMeta().equals(citem.getRingofOverclocking().getItemMeta()) && secondItem.getItemMeta().equals(citem.getShulkerHeart().getItemMeta())) {
                    event.setResult(citem.getRingofFreeAction());
                    event.getInventory().setRepairCost(10);
                    event.getInventory().setMaximumRepairCost(10);
                } else if (firstItem.getItemMeta().equals(citem.getBezoar().getItemMeta()) && secondItem.getItemMeta().equals(citem.getBlackDragonScale().getItemMeta())) {
                    event.setResult(citem.getMixedColorDragonScale());
                    event.getInventory().setRepairCost(10);
                    event.getInventory().setMaximumRepairCost(10);
                } else if (firstItem.getItemMeta().equals(citem.getObsidianShield().getItemMeta()) && secondItem.getItemMeta().equals(citem.getAnkhCharm().getItemMeta())) {
                    event.setResult(citem.getAnkhShield());
                    event.getInventory().setRepairCost(10);
                    event.getInventory().setMaximumRepairCost(10);
                }
            }
        }

    }

//    @EventHandler
//    public void onBrew(BrewEvent event) {
//        if (event.getContents().getIngredient().getItemMeta().equals(citem.getWarpedScroll().getItemMeta())) {
//            event.getContents().set
//        }
//    }
}
