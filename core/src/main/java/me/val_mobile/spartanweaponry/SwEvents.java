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
package me.val_mobile.spartanweaponry;

import me.val_mobile.data.ModuleEvents;
import me.val_mobile.data.RSVModule;
import me.val_mobile.rsv.RSVPlugin;
import me.val_mobile.spartanandfire.SfModule;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class SwEvents extends ModuleEvents implements Listener {


    private final RSVPlugin plugin;

    public SwEvents(SwModule module, RSVPlugin plugin) {
        super(module, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (shouldEventBeRan(player)) {
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            ItemStack itemOffHand = player.getInventory().getItemInOffHand();
            if (RSVItem.isRSVItem(itemMainHand) && Utils.isItemReal(itemOffHand)) {
                checkAndRunTask(player, itemMainHand);
            }
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (!event.isCancelled()) {
            if (shooter != null) {
                if (shooter instanceof LivingEntity living) {
                    if (shouldEventBeRan(living) && shouldEventBeRan(projectile)) {
                        if (living.getEquipment() != null) {
                            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

                            if (RSVItem.isRSVItem(itemMainHand)) {
                                String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);
                                if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                                    FileConfiguration config = moduleName.equals(SwModule.NAME) ? RSVModule.getModule(SwModule.NAME).getUserConfig().getConfig() : RSVModule.getModule(SfModule.NAME).getUserConfig().getConfig();
                                    String name = RSVItem.getNameFromItem(itemMainHand);
                                    String type = name.substring(name.lastIndexOf("_") + 1);
                                    if (type.equals("longbow") || type.equals("crossbow")) {
                                        double multiplier = config.getDouble("Items." + name + ".ArrowVelocityMultiplier");
                                        projectile.setVelocity(projectile.getVelocity().multiply(multiplier));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity defender = event.getEntity();
        Entity attacker = event.getDamager();

        if (shouldEventBeRan(defender) && shouldEventBeRan(attacker)) {
            double damage = event.getDamage();

            if (attacker instanceof AbstractArrow || attacker instanceof Firework) {
                Projectile arrow = (Projectile) event.getDamager();
                if (arrow.getShooter() != null) {
                    if (arrow.getShooter() instanceof LivingEntity living) {
                        if (living.getEquipment() != null) {
                            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();
                            if (RSVItem.isRSVItem(itemMainHand)) {
                                FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)).getUserConfig().getConfig();

                                String name = RSVItem.getNameFromItem(itemMainHand);
                                String type = name.substring(name.lastIndexOf("_") + 1);
                                if (type.equals("longbow") || type.equals("crossbow")) {
                                    double multiplier = config.getDouble("Items." + name + ".AttackDamageMultiplier");
                                    damage *= multiplier;
                                }
                            }
                        }
                    }
                }
            }
            else if (attacker instanceof LivingEntity livingAttacker) {
                if (livingAttacker.getEquipment() != null) {
                    ItemStack itemMainHand = livingAttacker.getEquipment().getItemInMainHand();
                    if (RSVItem.isRSVItem(itemMainHand)) {
                        String moduleName = RSVItem.getModuleNameFromItem(itemMainHand);

                        if (moduleName.equals(SwModule.NAME) || moduleName.equals(SfModule.NAME)) {
                            FileConfiguration config = RSVModule.getModule(moduleName).getUserConfig().getConfig();

                            String name = RSVItem.getNameFromItem(itemMainHand);
                            String type = name.substring(name.lastIndexOf("_") + 1);

                            switch (type) {
                                case "rapier" -> {
                                    if (!Utils.hasArmor(defender)) {
                                        damage *= config.getDouble("Items." + name + ".UnarmoredDamageMultiplier");
                                    }
                                }
                                case "katana" -> {
                                    if (!Utils.hasChestplate(defender)) {
                                        damage *= config.getDouble("Items." + name + ".ChestDamageMultiplier");
                                    }
                                }
                                case "dagger" -> {
                                    if (Utils.wasBackstabbed(attacker, defender)) {
                                        damage *= config.getDouble("Items." + name + ".BackstabDamageMultiplier");
                                    }
                                }
                                case "lance" -> {
                                    double sweepMultiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");

                                    double ridingMultiplier = config.getDouble("Items." + name + ".RidingDamageBonus");

                                    if (attacker.getVehicle() != null) {
                                        damage *= ridingMultiplier;
                                    }

                                    List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                                    if (config.getBoolean("Items." + name + ".Sweep")) {
                                        new SweepAttackTask(plugin, entities, attacker, defender, damage * sweepMultiplier, config.getBoolean("PreventSweepAttackingPets")).start();
                                    }
                                }
                                case "greatsword", "longsword", "saber", "glaive", "quarterstaff" -> {
                                    List<Entity> entities = defender.getNearbyEntities(1.0, 0.25, 1.0);

                                    double multiplier = config.getDouble("Items." + name + ".SweepingDamageMultiplier");
                                    if (config.getBoolean("Items." + name + ".Sweep")) {
                                        new SweepAttackTask(plugin, entities, attacker, defender, damage * multiplier, config.getBoolean("PreventSweepAttackingPets")).start();
                                    }
                                }
                                case "hammer" -> {
                                    if (defender instanceof LivingEntity living) {
                                        int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                        int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                        PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);
                                        if (living.getEquipment() != null) {
                                            if (!Utils.isItemReal(living.getEquipment().getHelmet())) {
                                                living.addPotionEffect(nausea);
                                            }
                                        }
                                        else {
                                            living.addPotionEffect(nausea);
                                        }
                                    }

                                    double kbMultiplier = config.getDouble("Items." + name + ".KnockbackMultiplier");
                                    Utils.setKbMultiplier(defender, kbMultiplier);
                                }
                                case "warhammer" -> {
                                    double armorPiercing = config.getDouble("Items." + name + ".ArmorPiercing");
                                    double dif = event.getFinalDamage() - event.getDamage();

                                    damage += dif * armorPiercing;
                                }
                                case "club" -> {
                                    if (defender instanceof LivingEntity living) {
                                        int duration = config.getInt("Items." + name + ".Nausea.Duration");
                                        int amplifier = config.getInt("Items." + name + ".Nausea.Amplifier");

                                        PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier);
                                        if (living.getEquipment() != null) {
                                            if (!Utils.isItemReal(living.getEquipment().getHelmet())) {
                                                living.addPotionEffect(nausea);
                                            }
                                        }
                                        else {
                                            living.addPotionEffect(nausea);
                                        }
                                    }
                                }
                                case "halberd" -> {
                                    int shieldCooldown = config.getInt("Items." + name + ".ShieldBreach.Cooldown");
                                    double chance = config.getDouble("Items." + name + ".ShieldBreach.Chance");
                                    if (defender instanceof Player player)
                                        if (player.isBlocking())
                                            if (Utils.roll(chance)) {
                                                player.setCooldown(Material.SHIELD, shieldCooldown);
                                            }
                                }
                                case "mace" -> {
                                    if (defender instanceof LivingEntity)
                                        if (Utils.isUndead(defender))
                                            damage *= config.getDouble("Items." + name + ".UndeadDamageMultiplier");
                                }
                                default -> {}
                            }

                            if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK && !config.getBoolean("Items." + name + ".Sweep")) {
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }

            if (defender instanceof LivingEntity living) {
                if (living.getEquipment() != null) {
                    ItemStack itemMainHand = living.getEquipment().getItemInMainHand();

                    if (RSVItem.isRSVItem(itemMainHand)) {
                        FileConfiguration config = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)).getUserConfig().getConfig();
                        String name = RSVItem.getNameFromItem(itemMainHand);
                        String type = name.substring(name.lastIndexOf("_") + 1);
                        if (type.equals("saber") || type.equals("rapier")) {
                            double multiplier = 1D - config.getDouble("Items." + name + ".Protection.PercentAbsorbed");
                            int decrement = config.getInt("Items." + name + ".Protection.DamageDurability");

                            damage *= multiplier;
                            Utils.changeDurability(itemMainHand, -decrement, true);
                        }
                    }
                }

            }
            event.setDamage(damage);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onTarget(EntityTargetEvent event) {
        if (!event.isCancelled()) {
            Entity entity = event.getEntity();
            Entity target = event.getTarget();
            if (target != null) {
                if (shouldEventBeRan(entity) && shouldEventBeRan(target)) {
                    if (entity instanceof LivingEntity living && !(entity instanceof Player)) {
                        if (living.getEquipment() != null) {
                            ItemStack itemMainHand = living.getEquipment().getItemInMainHand();
                            if (RSVItem.isRSVItem(itemMainHand)) {
                                String name = RSVItem.getNameFromItem(itemMainHand);

                                if (name.contains("_")) {
                                    String type = name.substring(name.lastIndexOf("_") + 1);

                                    boolean isThrowing;
                                    switch (type) {
                                        case "greatsword", "spear", "halberd", "pike", "lance" -> {
                                            if (!EntityLongAttackTask.hasTask(living.getUniqueId())) {
                                                new EntityLongAttackTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, living, itemMainHand, target).start();
                                            }
                                            isThrowing = false;
                                        }
                                        case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = true;
                                        default -> isThrowing = name.endsWith("throwing_knife");
                                    }

                                    if (isThrowing) {
                                        if (!EntityPrepareThrowTask.hasTask(living.getUniqueId())) {
                                            new EntityPrepareThrowTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, living, itemMainHand).start();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (shouldEventBeRan(player)) {
            if (event.getAction() == Action.LEFT_CLICK_AIR) {
                ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                if (RSVItem.isRSVItem(itemMainHand)) {
                    String name = RSVItem.getNameFromItem(itemMainHand);

                    if (name.contains("_")) {
                        String type = name.substring(name.lastIndexOf("_") + 1);

                        RSVModule module = RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand));

                        if (module.getUserConfig() != null) {
                            FileConfiguration config = module.getUserConfig().getConfig();

                            boolean isThrowing = false;
                            switch (type) {
                                case "greatsword", "spear", "halberd", "pike", "lance" -> {
                                    double range = config.getDouble("Items." + name + ".Reach");

                                    Location eye = player.getEyeLocation();
                                    Predicate<Entity> filter = entity -> !entity.getUniqueId().equals(player.getUniqueId());
                                    RayTraceResult result = player.getWorld().rayTrace(eye, eye.getDirection(), range, FluidCollisionMode.NEVER, false, 0, filter);

                                    if (result != null) {
                                        Entity defender = result.getHitEntity();
                                        if (defender != null) {
                                            Utils.attack(player, defender);
                                        }
                                    }
                                }
                                case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = !player.isSneaking();
                                default -> isThrowing = name.endsWith("throwing_knife") && !player.isSneaking();
                            }

                            if (isThrowing) {
                                boolean rotateWeapon = config.getBoolean("Items." + name + ".ThrownAttributes.Rotate");
                                boolean returnWeaponCollideBlocks = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingBlock");
                                boolean returnWeaponCollideEntities = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterHittingEntity");
                                boolean returnWeaponTooFar = config.getBoolean("Items." + name + ".ThrownAttributes.ReturnAfterTravelingMaxDistance");
                                boolean piercing = config.getBoolean("Items." + name + ".ThrownAttributes.Piercing");
                                double maxDistance = config.getDouble("Items." + name + ".ThrownAttributes.MaxDistance");
                                Location loc = player.getEyeLocation().add(player.getLocation().getDirection());

                                Vector velocity = loc.getDirection().normalize().multiply(config.getDouble("Items." + name + ".ThrownAttributes.Velocity"));

                                if (player.getGameMode() == GameMode.ADVENTURE || player.getGameMode() == GameMode.SURVIVAL) {
                                    Utils.changeDurability(itemMainHand, -1, true);
                                }

                                if (RSVItem.isRSVItem(itemMainHand)) {
                                    new ThrowWeaponTask(module, plugin, player, itemMainHand, maxDistance, rotateWeapon, piercing, returnWeaponCollideBlocks, returnWeaponCollideEntities, returnWeaponTooFar, velocity).start();
                                    player.getInventory().setItemInMainHand(null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemHeld(PlayerItemHeldEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            if (shouldEventBeRan(player)) {
                ItemStack item = player.getInventory().getItem(event.getNewSlot());
                checkAndRunTask(player, item);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemPickup(EntityPickupItemEvent event) {
        if (!event.isCancelled()) {
            LivingEntity entity = event.getEntity();
            if (shouldEventBeRan(entity)) {
                ItemStack item = event.getItem().getItemStack();
                checkAndRunTask(entity, item);

                if (!(entity instanceof Player)) {
                    if (entity.getEquipment() != null) {
                        ItemStack itemMainHand = entity.getEquipment().getItemInMainHand();
                        if (RSVItem.isRSVItem(itemMainHand)) {
                            String name = RSVItem.getNameFromItem(itemMainHand);

                            if (name.contains("_")) {
                                String type = name.substring(name.lastIndexOf("_") + 1);

                                boolean isThrowing;
                                switch (type) {
                                    case "greatsword", "spear", "halberd", "pike", "lance" -> {
                                        if (!EntityLongAttackTask.hasTask(entity.getUniqueId())) {
                                            new EntityLongAttackTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, entity, itemMainHand, null).start();
                                        }
                                        isThrowing = false;
                                    }
                                    case "dagger", "tomahawk", "javelin", "boomerang", "throwing_knife" -> isThrowing = true;
                                    default -> isThrowing = name.endsWith("throwing_knife");
                                }

                                if (isThrowing) {
                                    if (!EntityPrepareThrowTask.hasTask(entity.getUniqueId())) {
                                        new EntityPrepareThrowTask(RSVModule.getModule(RSVItem.getModuleNameFromItem(itemMainHand)), plugin, entity, itemMainHand).start();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onClick(InventoryClickEvent event) {
        if (!event.isCancelled()) {
            Player player = (Player) event.getWhoClicked();
            if (shouldEventBeRan(player)) {
                ItemStack cursor = event.getCursor();

                int heldSlot = player.getInventory().getHeldItemSlot();
                int rawSlot = event.getRawSlot();
                int slot = event.getSlot();

                if (rawSlot == 45) {
                    if (Utils.isItemReal(cursor)) {
                        ItemStack mainHand = player.getInventory().getItemInMainHand();

                        checkAndRunTask(player, mainHand);
                    }
                }

                if (slot == heldSlot) {
                    if (Utils.isItemReal(player.getInventory().getItemInOffHand())) {
                        checkAndRunTask(player, cursor);
                    }
                }

                if (event.isShiftClick()) {
                    if (event.getView().getTopInventory().getType() != InventoryType.PLAYER) {
                        if (Utils.isItemReal(player.getInventory().getItemInOffHand())) {
                            checkAndRunTask(player, event.getCurrentItem());
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemSwap(PlayerSwapHandItemsEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            if (shouldEventBeRan(player)) {
                ItemStack item = event.getMainHandItem();
                checkAndRunTask(player, item);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();

            String message = event.getMessage();

            if (message.length() > 1) {
                String[] args = message.substring(1).split(" ");

                if (args[0].equalsIgnoreCase("rsv") || args[0].equalsIgnoreCase("realisticsurvival")) {
                    if (args.length > 3) {
                        if (args[1].equalsIgnoreCase("give")) {
                            if (RSVItem.isRSVItem(args[3])) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        checkAndRunTask(player, player.getInventory().getItemInMainHand());
                                    }
                                }.runTaskLater(plugin, 1L);
                            }
                        }
                    }
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
                if (args[0].equalsIgnoreCase("rsv") || args[0].equalsIgnoreCase("realisticsurvival")) {
                    if (args.length > 3) {
                        if (args[1].equalsIgnoreCase("give")) {
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null && RSVItem.isRSVItem(args[3])) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        checkAndRunTask(player, player.getInventory().getItemInMainHand());
                                    }
                                }.runTaskLater(plugin, 1L);
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkAndRunTask(LivingEntity entity, ItemStack item) {
        if (RSVItem.isRSVItem(item)) {
            String name = RSVItem.getNameFromItem(item);
            String type = name.substring(name.lastIndexOf("_") + 1);
            RSVModule module = RSVModule.getModule(RSVItem.getModuleNameFromItem(item));

            switch (type) {
                case "longsword", "katana", "greatsword", "warhammer", "halberd", "pike", "battleaxe", "glaive" -> {
                    if (entity != null) {
                        UUID id = entity.getUniqueId();
                        if (!TwoHandedTask.hasTask(id)) {
                            new TwoHandedTask(module, plugin, entity, name).start();
                        }
                    }
                }
                default -> {}
            }
        }
    }
}