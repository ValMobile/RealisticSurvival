package me.val_mobile.rlcraft;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DragonFightEvents implements Listener {

    private final RLCraft plugin;
    private final Utils util;
    private final DragonFightRunnables dragonFightRunnables;
    public DragonFightEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        dragonFightRunnables = new DragonFightRunnables(instance);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            Entity entity = event.getEntity();
            util.addDragonContainers(entity);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof DragonFireball) {
            Entity acidBall = event.getEntity();
            Entity dragon = (Entity) ((Projectile)acidBall).getShooter();

            Random r = new Random();
            Double random = r.nextDouble();

            if (!util.checkDragonContainers(dragon)) {
                util.addDragonContainers(dragon);
            }
            String dragonType = util.getDragonType(dragon);

            if (dragonType.equals("Fire")) {
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance"))) {
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonFightRunnables.getFireDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                }
            }
            else if (dragonType.equals("Ice")) {
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance"))) {
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonFightRunnables.getIceDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    else {

                    }
                }
            }
            else {
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance"))) {
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                dragonFightRunnables.getLightningDragonBreathRunnable(dragon, acidBall).runTaskTimer(plugin, 0L, 1L);
                                acidBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    else {

                    }
                }
            }
        }


    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntity() instanceof EnderDragon) {

            List<ItemStack> drops = new ArrayList<>();

            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();
            if (!util.checkDragonContainers(entity)) {
                util.addDragonContainers(entity);
            }

            String dragonType = util.getDragonType(entity);
            int stage = util.getDragonStage(entity);

            if (CustomConfig.getMobConfig().getBoolean("Dragons.RecursiveDropRates.Enabled")) {
                // Determining if the dragon is fire or ice-blooded and
                // how many scales, dragonbones, and blood to drop
                Random r = new Random();

                int scaleAmount = (int) Math.round(r.nextDouble() *
                        (CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales") ))
                        + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales");
                int boneAmount = CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - scaleAmount + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinBones");
                int bloodAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.BloodMultiplier"));
                int fleshAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.FleshMultiplier"));

                ItemStack bone = CustomItems.getDragonBone();
                Utils.resizeItem(bone, boneAmount);

                drops.add(bone);

                // Fire Dragon
                if (dragonType.equals("Fire")) {

                    ItemStack heart = CustomItems.getFireDragonHeart();
                    ItemStack blood = CustomItems.getFireDragonBlood();
                    ItemStack flesh = CustomItems.getFireDragonFlesh();
                    ItemStack skull = CustomItems.getFireDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack bronzeScale = CustomItems.getDragonScaleBronze();
                            Utils.resizeItem(bronzeScale, scaleAmount);
                            drops.add(bronzeScale);
                            break;
                        }
                        case 1: {
                            ItemStack grayScale = CustomItems.getDragonScaleGray();
                            Utils.resizeItem(grayScale, scaleAmount);
                            drops.add(grayScale);
                            break;
                        }
                        case 2: {
                            ItemStack greenScale = CustomItems.getDragonScaleGreen();
                            Utils.resizeItem(greenScale, scaleAmount);
                            drops.add(greenScale);
                            break;
                        }
                        case 3: {
                            ItemStack redScale = CustomItems.getDragonScaleRed();
                            Utils.resizeItem(redScale, scaleAmount);
                            drops.add(redScale);
                            break;
                        }
                    }

                }
                // Ice Dragon
                else if (dragonType.equals("Ice")) {

                    ItemStack heart = CustomItems.getIceDragonHeart();
                    ItemStack blood = CustomItems.getIceDragonBlood();
                    ItemStack flesh = CustomItems.getIceDragonFlesh();
                    ItemStack skull = CustomItems.getIceDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack blueScale = CustomItems.getDragonScaleBlue();
                            Utils.resizeItem(blueScale, scaleAmount);
                            drops.add(blueScale);
                            break;
                        }
                        case 1: {
                            ItemStack sapphireScale = CustomItems.getDragonScaleSapphire();
                            Utils.resizeItem(sapphireScale, scaleAmount);
                            drops.add(sapphireScale);
                            break;
                        }
                        case 2: {
                            ItemStack silverScale = CustomItems.getDragonScaleSilver();
                            Utils.resizeItem(silverScale, scaleAmount);
                            drops.add(silverScale);
                            break;
                        }
                        case 3: {
                            ItemStack whiteScale = CustomItems.getDragonScaleWhite();
                            Utils.resizeItem(whiteScale, scaleAmount);
                            drops.add(whiteScale);
                            break;
                        }
                    }

                }
                // Lightning Dragon
                else if (dragonType.equals("Lightning")) {

                    ItemStack heart = CustomItems.getLightningDragonHeart();
                    ItemStack blood = CustomItems.getLightningDragonBlood();
                    ItemStack flesh = CustomItems.getLightningDragonFlesh();
                    ItemStack skull = CustomItems.getLightningDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack amethystScale = CustomItems.getDragonScaleAmethyst();
                            Utils.resizeItem(amethystScale, scaleAmount);
                            drops.add(amethystScale);
                            break;
                        }
                        case 1: {
                            ItemStack blackScale = CustomItems.getDragonScaleBlack();
                            Utils.resizeItem(blackScale, scaleAmount);
                            drops.add(blackScale);
                            break;
                        }
                        case 2: {
                            ItemStack copperScale = CustomItems.getDragonScaleCopper();
                            Utils.resizeItem(copperScale, scaleAmount);
                            drops.add(copperScale);
                            break;
                        }
                        case 3: {
                            ItemStack electricScale = CustomItems.getDragonScaleElectric();
                            Utils.resizeItem(electricScale, scaleAmount);
                            drops.add(electricScale);
                            break;
                        }
                    }

                }
            }
            else {
                Random r = new Random();
                int scaleAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxScales") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinScales");
                int boneAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBones") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBones");
                int bloodAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxBlood") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinBlood");
                int fleshAmount = (int) Math.round(r.nextDouble() *
                        (plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MaxFlesh") - plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh") ))
                        + plugin.getConfig().getInt("Dragons.SpecifiedDropRates.MinFlesh");

                ItemStack bone = CustomItems.getDragonBone();
                Utils.resizeItem(bone, boneAmount);

                drops.add(bone);

                // Fire Dragon
                if (dragonType.equals("Fire")) {

                    ItemStack heart = CustomItems.getFireDragonHeart();
                    ItemStack blood = CustomItems.getFireDragonBlood();
                    ItemStack flesh = CustomItems.getFireDragonFlesh();
                    ItemStack skull = CustomItems.getFireDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack bronzeScale = CustomItems.getDragonScaleBronze();
                            Utils.resizeItem(bronzeScale, scaleAmount);
                            drops.add(bronzeScale);
                            break;
                        }
                        case 1: {
                            ItemStack grayScale = CustomItems.getDragonScaleGray();
                            Utils.resizeItem(grayScale, scaleAmount);
                            drops.add(grayScale);
                            break;
                        }
                        case 2: {
                            ItemStack greenScale = CustomItems.getDragonScaleGreen();
                            Utils.resizeItem(greenScale, scaleAmount);
                            drops.add(greenScale);
                            break;
                        }
                        case 3: {
                            ItemStack redScale = CustomItems.getDragonScaleRed();
                            Utils.resizeItem(redScale, scaleAmount);
                            drops.add(redScale);
                            break;
                        }
                    }

                }
                // Ice Dragon
                else if (dragonType.equals("Ice")) {

                    ItemStack heart = CustomItems.getIceDragonHeart();
                    ItemStack blood = CustomItems.getIceDragonBlood();
                    ItemStack flesh = CustomItems.getIceDragonFlesh();
                    ItemStack skull = CustomItems.getIceDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);


                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack blueScale = CustomItems.getDragonScaleBlue();
                            Utils.resizeItem(blueScale, scaleAmount);
                            drops.add(blueScale);
                            break;
                        }
                        case 1: {
                            ItemStack sapphireScale = CustomItems.getDragonScaleSapphire();
                            Utils.resizeItem(sapphireScale, scaleAmount);
                            drops.add(sapphireScale);
                            break;
                        }
                        case 2: {
                            ItemStack silverScale = CustomItems.getDragonScaleSilver();
                            Utils.resizeItem(silverScale, scaleAmount);
                            drops.add(silverScale);
                            break;
                        }
                        case 3: {
                            ItemStack whiteScale = CustomItems.getDragonScaleWhite();
                            Utils.resizeItem(whiteScale, scaleAmount);
                            drops.add(whiteScale);
                            break;
                        }
                    }

                }
                // Lightning Dragon
                else if (dragonType.equals("Lightning")) {

                    ItemStack heart = CustomItems.getLightningDragonHeart();
                    ItemStack blood = CustomItems.getLightningDragonBlood();
                    ItemStack flesh = CustomItems.getLightningDragonFlesh();
                    ItemStack skull = CustomItems.getLightningDragonSkull();
                    Utils.resizeItem(blood, bloodAmount);
                    Utils.resizeItem(flesh, fleshAmount);
                    Utils.addDragonSkullLore(skull, stage, dragonType);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack amethystScale = CustomItems.getDragonScaleAmethyst();
                            Utils.resizeItem(amethystScale, scaleAmount);
                            drops.add(amethystScale);
                            break;
                        }
                        case 1: {
                            ItemStack blackScale = CustomItems.getDragonScaleBlack();
                            Utils.resizeItem(blackScale, scaleAmount);
                            drops.add(blackScale);
                            break;
                        }
                        case 2: {
                            ItemStack copperScale = CustomItems.getDragonScaleCopper();
                            Utils.resizeItem(copperScale, scaleAmount);
                            drops.add(copperScale);
                            break;
                        }
                        case 3: {
                            ItemStack electricScale = CustomItems.getDragonScaleElectric();
                            Utils.resizeItem(electricScale, scaleAmount);
                            drops.add(electricScale);
                            break;
                        }
                    }

                }
            }

            for (ItemStack item : drops) {
                world.dropItemNaturally(loc, item);
            }

        }

    }
}
