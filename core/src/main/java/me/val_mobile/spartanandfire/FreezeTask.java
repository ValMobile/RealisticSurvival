package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;

public class FreezeTask extends BukkitRunnable {

    private final Entity entity;
    private final String itemName;
    private final RealisticSurvivalPlugin plugin;
    private final Collection<FrozenBlock> blocks = new ArrayList<>();
    private final FileConfiguration config;
    private final UnfreezeTask unfreezeTask;

    public FreezeTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Entity entity) {
        this.entity = entity;
        this.itemName = itemName;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.unfreezeTask = new UnfreezeTask(plugin, blocks, config.getInt("Items." + itemName + ".FreezeAbility.FrozenDuration"));
    }

    @Override
    public void run() {
        // store the duration and amplifier of the slowness effect
        int amplifier = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Amplifier");
        int duration = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Duration");

        // create the slowness effect using the duration and amplifier variables
        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);

        // add the slowness effect to the target entity
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(slowness);
        }

        // freeze the entity
        new Utils(plugin).freezeEntity(entity);

        // encase the entity with ice
        Location loc = entity.getLocation().clone(); // get the location
        Material material = Material.valueOf(config.getString("Items." + itemName + ".FreezeAbility.Block")); // get the material

        double height = entity.getHeight();

        double dif;
        for (double i = 0D; Utils.doublesEquals(height, i); i+=dif) {
            FrozenBlock block = new FrozenBlock(loc, material);
            dif = (height - i > 1D) ? 1D : height - i;
            loc = loc.add(0D, dif, 0D);
            blocks.add(block);
        }

        // play the ice break sound effect
        entity.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, 1);

        // remove the ice block after some time
       unfreezeTask.start();
    }

    public void start() {
        runTask(plugin);
    }
}
