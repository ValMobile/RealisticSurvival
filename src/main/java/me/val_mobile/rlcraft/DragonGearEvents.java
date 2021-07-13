package me.val_mobile.rlcraft;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.projectiles.ProjectileSource;

import java.util.List;

public class DragonGearEvents implements Listener {

    private final RLCraft plugin;
    private final Utils util;
    private final DragonGearAbilities dragonGearAbilities;
    public DragonGearEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        dragonGearAbilities = new DragonGearAbilities(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (Recipe r : Recipes.getDragonRecipes()) {
            if (r instanceof ShapedRecipe) {
                player.discoverRecipe(((ShapedRecipe) r).getKey());
            }
            else if (r instanceof ShapelessRecipe) {
                player.discoverRecipe(((ShapelessRecipe) r).getKey());
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
                            dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.DragonScale.DamageReduction");
                        }
                        else if (nbti.hasKey("Dragonsteel Armor")) {
                            dragonProtection += CustomConfig.getIceFireGearConfig().getDouble("Abilities.Dragonsteel.DamageReduction");
                        }
                    }
                }
                event.setDamage(event.getDamage() * (1D - dragonProtection));
            }
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
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
                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.FlamedDragonBone.BonusDamage"));
                                }
                            }
                            dragonGearAbilities.FireDragonBoneAbility((LivingEntity) entity);
                            break;
                        case "Ice Dragon Bone":
                            if (entity instanceof EnderDragon) {
                                if (!util.checkDragonContainers(entity)) {
                                    util.addDragonContainers(entity);
                                }
                                String dragonType = util.getDragonType(entity);

                                if (dragonType.equals("Fire")) {
                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.IcedDragonBone.BonusDamage"));
                                }
                            }
                            dragonGearAbilities.IceDragonBoneAbility((LivingEntity) entity);
                            break;
                        case "Lightning Dragon Bone":
                            if (entity instanceof EnderDragon) {
                                if (!util.checkDragonContainers(entity)) {
                                    util.addDragonContainers(entity);
                                }
                                String dragonType = util.getDragonType(entity);

                                if (dragonType.equals("Ice") || dragonType.equals("Fire")) {
                                    event.setDamage(event.getDamage() + CustomConfig.getIceFireGearConfig().getDouble("Abilities.LightningDragonBone.BonusDamage"));
                                }
                            }
                            dragonGearAbilities.LightningDragonBoneAbility((LivingEntity) entity, player);
                            break;
                        case "Fire Dragonsteel":
                            dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                            break;
                        case "Ice Dragonsteel":
                            dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                            break;
                        case "Lightning Dragonsteel":
                            dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                            break;
                    }
                }
                if (item.hasKey("Spartan's Weapon")) {
                    switch (item.getString("Spartan's Weapon")) {
                        case "Rapier":
                            if (!Utils.hasArmor((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * 3.0D);
                            }
                            break;
                        case "Katana":
                            if (!Utils.hasChestplate((LivingEntity) entity)) {
                                event.setDamage(event.getDamage() * 2.0D);
                            }
                            break;
                    }
                }
            }
        }
        else if (event.getDamager() instanceof Arrow) {
            Projectile arrow = (Projectile) event.getDamager();
            Entity entity = event.getEntity();
            Entity shooter = (Entity) arrow.getShooter();
            if (! (shooter == null) ) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                    if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                        NBTItem item = new NBTItem(itemMainHand);
                        if (item.hasKey("Dragon Weapon")) {
                            switch (item.getString("Dragon Weapon")) {
                                case "Dragon Bone":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.DragonBoneCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.DragonBoneLongbow.attackDamageMultiplier"));
                                                break;
                                            case "Bow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.DragonBoneBow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
                                    break;
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
                                    dragonGearAbilities.FireDragonBoneAbility((LivingEntity) entity);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.FlamedDragonBoneCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
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
                                    dragonGearAbilities.IceDragonBoneAbility((LivingEntity) entity);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.IcedDragonBoneCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.IcedDragonBoneLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
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
                                    dragonGearAbilities.LightningDragonBoneAbility((LivingEntity) entity, player);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.LightningDragonBoneCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.LightningDragonBoneLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
                                    break;
                                case "Fire Dragonsteel":
                                    dragonGearAbilities.FireDragonsteelAbility((LivingEntity) entity);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.FireDragonsteelCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.FireDragonsteelLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
                                    break;
                                case "Ice Dragonsteel":
                                    dragonGearAbilities.IceDragonsteelAbility((LivingEntity) entity);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.IceDragonsteelCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.IceDragonsteelLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
                                    break;
                                case "Lightning Dragonsteel":
                                    dragonGearAbilities.LightningDragonsteelAbility((LivingEntity) entity, player);
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.LightningDragonsteelCrossbow.attackDamageMultiplier"));
                                                break;
                                            case "Longbow":
                                                event.setDamage(event.getDamage() * plugin.getConfig().getDouble("weapons.LightningDragonsteelLongbow.attackDamageMultiplier"));
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
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

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();
        if (!(projectile == null)) {
            if (!(shooter == null)) {
                if (shooter instanceof Player) {
                    Player player = (Player) shooter;
                    ItemStack itemMainHand = player.getInventory().getItemInMainHand();
                    if (!(itemMainHand == null || itemMainHand.getType() == Material.AIR)) {
                        NBTItem item = new NBTItem(itemMainHand);
                        if (item.hasKey("Dragon Weapon")) {
                            switch (item.getString("Dragon Weapon")) {
                                case "Dragon Bone":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.DragonBoneCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.DragonBoneLongbow.velocityMultiplier")));
                                                break;
                                            case "Bow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.DragonBoneBow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                                case "Fire Dragon Bone":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.FlamedDragonBoneCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.FlamedDragonBoneLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                case "Ice Dragon Bone":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.IcedDragonBoneCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.IcedDragonBoneLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                                case "Lightning Dragon Bone":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.LightningDragonBoneCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.LightningDragonBoneLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                                case "Fire Dragonsteel":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.FireDragonsteelCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.FireDragonsteelLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                                case "Ice Dragonsteel":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.IceDragonsteelCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.IceDragonsteelLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                                case "Lightning Dragonsteel":
                                    if (item.hasKey("Spartan's Weapon")) {
                                        switch (item.getString("Spartan's Weapon")) {
                                            case "Crossbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.LightningDragonsteelCrossbow.velocityMultiplier")));
                                                break;
                                            case "Longbow":
                                                projectile.setVelocity(projectile.getVelocity().multiply(plugin.getConfig().getDouble("weapons.LightningDragonsteelLongbow.velocityMultiplier")));
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
}
