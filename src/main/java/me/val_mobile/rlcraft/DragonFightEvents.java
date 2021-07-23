package me.val_mobile.rlcraft;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
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
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
/**
 * DragonFightEvents is a class containing listener methods
 * that activate special dragon attacks based on each dragon's breed
 * @author Val_Mobile
 * @version 1.2
 * @since 1.0
 */
public class DragonFightEvents implements Listener {

    /**
     * Dependency injecting the main, util, and runnable classes for use
     * The util class must be injected because its non-static methods are needed
     */
    private final RLCraft plugin;
    private final Utils util;
    private final DragonFightRunnables dragonFightRunnables;

    // constructing the DragonFightEvents class
    public DragonFightEvents(RLCraft instance) {
        plugin = instance;
        util = new Utils(instance);
        dragonFightRunnables = new DragonFightRunnables(instance);
    }

    /**
     * Adds ice and fire info when a dragon spawns, which includes
     * breed, stage, and age.
     * @param event The event called when an entity spawns
     * @see Utils
     */
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        // if the entity spawned is an ender dragon
        if (event.getEntity() instanceof EnderDragon) {
            Entity entity = event.getEntity(); // get the entity

            // add ice and fire information to the dragon
            util.addDragonContainers(entity);
        }
    }

    /**
     * Changes the vanilla dragon fireball attack to a special breath
     * or explosion attack
     * @param event The event called when a projectile is launched
     * @see DragonFightRunnables
     * @see Utils
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        // if the projectile launched is a dragon fireball
        if (event.getEntity() instanceof DragonFireball) {
            Entity fireBall = event.getEntity(); // get the fireball
            Entity dragon = (Entity) ((Projectile)fireBall).getShooter(); // get the dragon that shot the fireball

            Random r = new Random(); // create a random variable to perform calculations
            Double random = r.nextDouble(); // generate a double with a random value from 0.0 to 1.0

            // if the dragon does not have ice and fire data
            if (!util.checkDragonContainers(dragon)) {
                // add ice and fire data to the dragon
                util.addDragonContainers(dragon);
            }

            String dragonBreed = util.getDragonType(dragon); // get the breed of the dragon

            // if the dragon's breed is fire
            if (dragonBreed.equals("Fire")) {
                // check if the dragon's fireball attack should be replaced with a special attack
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance"))) {
                    // check if the dragon's special attack should be a breath attack
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.FireDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the fire breath attack
                                dragonFightRunnables.getFireDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                // remove the original fireball to make it appear like the dragon is breathing fire
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    // if the dragon's special attack should be an explosion attack
                    else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the fire explosion attack
                                // remove the original fireball to make it appear like the dragon is breathing fire
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                }

            }
            // if the dragon's breed is ice
            else if (dragonBreed.equals("Ice")) {
                // check if the dragon's fireball attack should be replaced with a special attack
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance"))) {
                    // check if the dragon's special attack should be a breath attack
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.IceDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the fire breath attack
                                dragonFightRunnables.getIceDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                // remove the original fireball to make it appear like the dragon is breathing ice
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    // if the dragon's special attack should be an explosion attack
                    else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the ice explosion attack
                                // remove the original fireball to make it appear like the dragon is breathing ice
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                }
            }
            // if the dragon's breed is lightning
            else {
                // check if the dragon's fireball attack should be replaced with a special attack
                if (!(random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance"))) {
                    // check if the dragon's special attack should be a breath attack
                    if (random <= CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.NormalAttack.Chance") + CustomConfig.getMobConfig().getDouble("Dragons.LightningDragon.BreathAttack.Chance")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the lightning breath attack
                                dragonFightRunnables.getLightningDragonBreathRunnable(dragon, fireBall).runTaskTimer(plugin, 0L, 1L);
                                // remove the original fireball to make it appear like the dragon is shooting lightning
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                    // if the dragon's special attack should be an explosion attack
                    else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                // create the lightning explosion attack
                                // remove the original fireball to make it appear like the dragon is shooting lightning
                                fireBall.remove();
                            }
                        }.runTaskLater(plugin, 2);
                    }
                }
            }
        }
    }

    /**
     * Drops Ice and Fire loot upon dragon, elder guardian, and wither death
     * @param event The event called when an entity dies
     * @see Utils
     * @see CustomConfig
     * @see CustomItems
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        // if the entity that died was a dragon
        if (event.getEntity() instanceof EnderDragon) {

            Collection<ItemStack> drops = new ArrayList<>();  // create a collection to store all the loot to drop

            Entity entity = event.getEntity(); // get the dragon
            World world = entity.getWorld(); // get the world of the dragon
            Location loc = entity.getLocation(); // get the location of the dragon

            // if the dragon does not have ice and fire data
            if (!util.checkDragonContainers(entity)) {
                // add ice and fire data to the dragon
                util.addDragonContainers(entity);
            }


            String dragonBreed = util.getDragonType(entity);  // get the breed of the dragon
            int stage = util.getDragonStage(entity); // get the stage of the dragon

            /**
             * Check if recursive drop rates are enabled for dragons.
             * Recursive drop rates favor more balanced drop rates. If a lot of scales drop,
             * less bones will drop and vice versa. This drop algorithm is more consistent with what is used
             * in the canonical Ice and Fire mod.
             */
            if (CustomConfig.getMobConfig().getBoolean("Dragons.RecursiveDropRates.Enabled")) {
                Random r = new Random(); // create a random variable to perform calcalations

                /**
                 * Scale amount is between the minimum and maximum specified values.
                 * Bone amount is calculated by subtracting the scale amount and adding a minimum bone amount.
                 * Adding a minimum value ensures that at least 1 bone will drop.
                 * Dragon flesh and blood amounts are determined by multiplying the scale amount
                 * by a specified multiplier.
                 */
                int scaleAmount = (int) Math.round(r.nextDouble() *
                        (CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales") ))
                        + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinScales");
                int boneAmount = CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MaxScales") - scaleAmount + CustomConfig.getMobConfig().getInt("Dragons.RecursiveDropRates.MinBones");
                int bloodAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.BloodMultiplier"));
                int fleshAmount = (int) Math.round(scaleAmount * CustomConfig.getMobConfig().getDouble("Dragons.RecursiveDropRates.FleshMultiplier"));

                // create and add the bone to the drop list
                ItemStack bone = CustomItems.getDragonBone();
                bone.setAmount(boneAmount);

                drops.add(bone);

                // if the dragon's breed is fire
                if (dragonBreed.equals("Fire")) {

                    // create fire dragon loot, scales are determined later
                    ItemStack heart = CustomItems.getFireDragonHeart();
                    ItemStack blood = CustomItems.getFireDragonBlood();
                    ItemStack flesh = CustomItems.getFireDragonFlesh();
                    ItemStack skull = CustomItems.getFireDragonSkull();

                    // resize the blood and flesh amounts
                    blood.setAmount(bloodAmount);
                    flesh.setAmount(fleshAmount);

                    // add a lore to the dragon skull showing the breed and stage
                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    // add the items into the drop collection
                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    /**
                     * Randomly determine what scale color to use. There
                     * are 4 scale colors for the fire dragon.
                     */
                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    //
                    switch (scaleColor) {
                        case 0: {
                            ItemStack bronzeScale = CustomItems.getDragonScaleBronze();
                            bronzeScale.setAmount(scaleAmount);
                            drops.add(bronzeScale);
                            break;
                        }
                        case 1: {
                            ItemStack grayScale = CustomItems.getDragonScaleGray();
                            grayScale.setAmount(scaleAmount);
                            drops.add(grayScale);
                            break;
                        }
                        case 2: {
                            ItemStack greenScale = CustomItems.getDragonScaleGreen();
                            greenScale.setAmount(scaleAmount);
                            drops.add(greenScale);
                            break;
                        }
                        case 3: {
                            ItemStack redScale = CustomItems.getDragonScaleRed();
                            redScale.setAmount(scaleAmount);
                            drops.add(redScale);
                            break;
                        }
                    }

                }
                // Ice Dragon
                else if (dragonBreed.equals("Ice")) {

                    ItemStack heart = CustomItems.getIceDragonHeart();
                    ItemStack blood = CustomItems.getIceDragonBlood();
                    ItemStack flesh = CustomItems.getIceDragonFlesh();
                    ItemStack skull = CustomItems.getIceDragonSkull();

                    blood.setAmount(bloodAmount);
                    flesh.setAmount(fleshAmount);

                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack blueScale = CustomItems.getDragonScaleBlue();
                            blueScale.setAmount(scaleAmount);
                            drops.add(blueScale);
                            break;
                        }
                        case 1: {
                            ItemStack sapphireScale = CustomItems.getDragonScaleSapphire();
                            sapphireScale.setAmount(scaleAmount);
                            drops.add(sapphireScale);
                            break;
                        }
                        case 2: {
                            ItemStack silverScale = CustomItems.getDragonScaleSilver();
                            silverScale.setAmount(scaleAmount);
                            drops.add(silverScale);
                            break;
                        }
                        case 3: {
                            ItemStack whiteScale = CustomItems.getDragonScaleWhite();
                            whiteScale.setAmount(scaleAmount);
                            drops.add(whiteScale);
                            break;
                        }
                    }

                }
                // Lightning Dragon
                else if (dragonBreed.equals("Lightning")) {

                    ItemStack heart = CustomItems.getLightningDragonHeart();
                    ItemStack blood = CustomItems.getLightningDragonBlood();
                    ItemStack flesh = CustomItems.getLightningDragonFlesh();
                    ItemStack skull = CustomItems.getLightningDragonSkull();

                    blood.setAmount(bloodAmount);
                    flesh.setAmount(fleshAmount);

                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack amethystScale = CustomItems.getDragonScaleAmethyst();
                            amethystScale.setAmount(scaleAmount);
                            drops.add(amethystScale);
                            break;
                        }
                        case 1: {
                            ItemStack blackScale = CustomItems.getDragonScaleBlack();
                            blackScale.setAmount(scaleAmount);
                            drops.add(blackScale);
                            break;
                        }
                        case 2: {
                            ItemStack copperScale = CustomItems.getDragonScaleCopper();
                            copperScale.setAmount(scaleAmount);
                            drops.add(copperScale);
                            break;
                        }
                        case 3: {
                            ItemStack electricScale = CustomItems.getDragonScaleElectric();
                            electricScale.setAmount(scaleAmount);
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
                bone.setAmount(boneAmount);

                drops.add(bone);

                // Fire Dragon
                if (dragonBreed.equals("Fire")) {

                    ItemStack heart = CustomItems.getFireDragonHeart();
                    ItemStack blood = CustomItems.getFireDragonBlood();
                    ItemStack flesh = CustomItems.getFireDragonFlesh();
                    ItemStack skull = CustomItems.getFireDragonSkull();

                    blood.setAmount(scaleAmount);
                    flesh.setAmount(scaleAmount);

                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack bronzeScale = CustomItems.getDragonScaleBronze();
                            bronzeScale.setAmount(scaleAmount);
                            drops.add(bronzeScale);
                            break;
                        }
                        case 1: {
                            ItemStack grayScale = CustomItems.getDragonScaleGray();
                            grayScale.setAmount(scaleAmount);
                            drops.add(grayScale);
                            break;
                        }
                        case 2: {
                            ItemStack greenScale = CustomItems.getDragonScaleGreen();
                            greenScale.setAmount(scaleAmount);
                            drops.add(greenScale);
                            break;
                        }
                        case 3: {
                            ItemStack redScale = CustomItems.getDragonScaleRed();
                            redScale.setAmount(scaleAmount);
                            drops.add(redScale);
                            break;
                        }
                    }

                }
                // Ice Dragon
                else if (dragonBreed.equals("Ice")) {

                    ItemStack heart = CustomItems.getIceDragonHeart();
                    ItemStack blood = CustomItems.getIceDragonBlood();
                    ItemStack flesh = CustomItems.getIceDragonFlesh();
                    ItemStack skull = CustomItems.getIceDragonSkull();

                    blood.setAmount(bloodAmount);
                    flesh.setAmount(fleshAmount);

                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);


                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack blueScale = CustomItems.getDragonScaleBlue();
                            blueScale.setAmount(scaleAmount);
                            drops.add(blueScale);
                            break;
                        }
                        case 1: {
                            ItemStack sapphireScale = CustomItems.getDragonScaleSapphire();
                            sapphireScale.setAmount(scaleAmount);
                            drops.add(sapphireScale);
                            break;
                        }
                        case 2: {
                            ItemStack silverScale = CustomItems.getDragonScaleSilver();
                            silverScale.setAmount(scaleAmount);
                            drops.add(silverScale);
                            break;
                        }
                        case 3: {
                            ItemStack whiteScale = CustomItems.getDragonScaleWhite();
                            whiteScale.setAmount(scaleAmount);
                            drops.add(whiteScale);
                            break;
                        }
                    }

                }
                // Lightning Dragon
                else if (dragonBreed.equals("Lightning")) {

                    ItemStack heart = CustomItems.getLightningDragonHeart();
                    ItemStack blood = CustomItems.getLightningDragonBlood();
                    ItemStack flesh = CustomItems.getLightningDragonFlesh();
                    ItemStack skull = CustomItems.getLightningDragonSkull();

                    blood.setAmount(bloodAmount);
                    flesh.setAmount(fleshAmount);

                    Utils.addDragonSkullLore(skull, stage, dragonBreed);

                    drops.add(blood);
                    drops.add(flesh);
                    drops.add(heart);
                    drops.add(skull);

                    int scaleColor = (int) Math.round(r.nextDouble() * 3);

                    switch (scaleColor) {
                        case 0: {
                            ItemStack amethystScale = CustomItems.getDragonScaleAmethyst();
                            amethystScale.setAmount(scaleAmount);
                            drops.add(amethystScale);
                            break;
                        }
                        case 1: {
                            ItemStack blackScale = CustomItems.getDragonScaleBlack();
                            blackScale.setAmount(scaleAmount);
                            drops.add(blackScale);
                            break;
                        }
                        case 2: {
                            ItemStack copperScale = CustomItems.getDragonScaleCopper();
                            copperScale.setAmount(scaleAmount);
                            drops.add(copperScale);
                            break;
                        }
                        case 3: {
                            ItemStack electricScale = CustomItems.getDragonScaleElectric();
                            electricScale.setAmount(scaleAmount);
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

    @EventHandler
    public void onChunkGenerate(ChunkLoadEvent event) throws IOException {
        // check if chunk was newly generated
        if (event.isNewChunk()) {
            // check if the chunk was generated in the overworld
            if (event.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                Chunk chunk = event.getChunk(); // get chunk
                Block middleBlock = chunk.getBlock(8, 0, 8); // get the block in the middle of the chunk
                Biome biome = middleBlock.getBiome(); // get the biome of the block which is also the biome of the chunk

                switch (biome) {
                    // check if biome is a jungle, badlands, or savanna
                    case JUNGLE:
                    case JUNGLE_HILLS:
                    case JUNGLE_EDGE:
                    case BAMBOO_JUNGLE:
                    case BAMBOO_JUNGLE_HILLS:
                    case MODIFIED_JUNGLE:
                    case MODIFIED_JUNGLE_EDGE:
                    case BADLANDS:
                    case BADLANDS_PLATEAU:
                    case ERODED_BADLANDS:
                    case MODIFIED_BADLANDS_PLATEAU:
                    case SAVANNA:
                    case SAVANNA_PLATEAU:
                    case SHATTERED_SAVANNA:
                    case SHATTERED_SAVANNA_PLATEAU: {
                        // generate lightning dragon nest

                    }
                    case OCEAN:
                    case COLD_OCEAN:
                    case DEEP_COLD_OCEAN:
                    case DEEP_FROZEN_OCEAN:
                    case DEEP_LUKEWARM_OCEAN:
                    case DEEP_OCEAN:
                    case DEEP_WARM_OCEAN:
                    case FROZEN_OCEAN:
                    case LUKEWARM_OCEAN:
                    case WARM_OCEAN: {

                    }
                    default:
                        Double temperature = middleBlock.getTemperature(); // get temperature of chunk

                        // check if biome is warm
                        if (temperature > -0.5) {
                            // generate fire dragon nest
                            Random r = new Random();

                            if (r.nextDouble() <= 0.2) {

                                Location location = middleBlock.getLocation().clone();
                                location.setY(60);
                                int iteration = 0;

                                Block block = location.getBlock();
                                Material material = block.getType();

                                while (!(block == null || material.equals(Material.AIR)) || material.isFlammable()) {
                                    if (iteration > 40) {
                                        return;
                                    }
                                    iteration++;
                                    location.setY(location.getY() + 1.0);
                                }

                                location.setY(location.getY() - 1.0);

                                Schematics.pasteSchematic(Schematics.getFireDragonNest(), location, true);
                            }
                        }
                        // check if biome is cold
                        else if (temperature <= -0.5) {
                            // generate ice dragon nest
                        }
                }
            }
        }
    }
}
