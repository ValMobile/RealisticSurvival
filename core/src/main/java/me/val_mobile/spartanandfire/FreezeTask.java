package me.val_mobile.spartanandfire;

import me.val_mobile.data.RSVModule;
import me.val_mobile.iceandfire.IceFireModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;

public class FreezeTask extends BukkitRunnable {

    private final Entity entity;
    private final RealisticSurvivalPlugin plugin;
    private final Collection<FrozenBlock> blocks = new ArrayList<>();
    private final FileConfiguration config;
    private final boolean encaseIce;
    private final boolean playSound;
    private final PotionEffect slowness;
    private final Material frozenMaterial;
    private final Sound sound;
    private final float volume;
    private final float pitch;
    private final int duration;

    public FreezeTask(RealisticSurvivalPlugin plugin, int stage, Entity entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = RSVModule.getModule(IceFireModule.NAME).getUserConfig().getConfig();
        this.encaseIce = config.getBoolean("Dragons.IceDragon.FreezeAbility.EncaseIce.Enabled");
        this.playSound = config.getBoolean("Dragons.IceDragon.FreezeAbility.Sound.Enabled");
        int stageMultiplier = config.getInt("Dragons.IceDragon.FreezeAbility.StageMultipliers.Stage" + stage);

        int amplifier = config.getInt("Dragons.IceDragon.FreezeAbility.Slowness.Amplifier");
        int duration = config.getInt("Dragons.IceDragon.FreezeAbility.Duration.Amplifier") * stageMultiplier;
        this.slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        this.frozenMaterial = Material.valueOf(config.getString("Dragons.IceDragon.FreezeAbility.EncaseIce.Block"));
        this.sound = Sound.valueOf(config.getString("Dragons.IceDragon.FreezeAbility.Sound.Sound"));
        this.volume = (float) config.getDouble("Dragons.IceDragon.FreezeAbility.Sound.Volume");
        this.pitch = (float) config.getDouble("Dragons.IceDragon.FreezeAbility.Sound.Pitch");
        this.duration = config.getInt("Dragons.IceDragon.FreezeAbility.FrozenDuration") * stageMultiplier;
    }

    public FreezeTask(RealisticSurvivalPlugin plugin, RSVModule module, String itemName, Entity entity) {
        this.entity = entity;
        this.plugin = plugin;
        this.config = module.getUserConfig().getConfig();
        this.encaseIce = config.getBoolean("Items." + itemName + ".FreezeAbility.EncaseIce.Enabled");
        this.playSound = config.getBoolean("Items." + itemName + ".FreezeAbility.Sound.Enabled");
        int amplifier = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Amplifier");
        int duration = config.getInt("Items." + itemName + ".FreezeAbility.Slowness.Duration");
        this.slowness = new PotionEffect(PotionEffectType.SLOW, duration, amplifier);
        this.frozenMaterial = Material.valueOf(config.getString("Items." + itemName + ".FreezeAbility.EncaseIce.Block"));
        this.sound = Sound.valueOf(config.getString("Items." + itemName + ".FreezeAbility.Sound.Sound"));
        this.volume = (float) config.getDouble("Items." + itemName + ".FreezeAbility.Sound.Volume");
        this.pitch = (float) config.getDouble("Items." + itemName + ".FreezeAbility.Sound.Pitch");
        this.duration = config.getInt("Items." + itemName + ".FreezeAbility.FrozenDuration");
    }

    @Override
    public void run() {
        // add the slowness effect to the target entity
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(slowness);
            ((LivingEntity) entity).setAI(false);
        }
        // freeze the entity
        RealisticSurvivalPlugin.getUtil().setZeroKb(entity);

        // encase the entity with ice
        Location loc = entity.getLocation().clone(); // get the location

        double height = entity.getHeight();

        double dif;

        if (encaseIce) {
            for (double i = 0D; Utils.doublesEquals(height, i); i+=dif) {
                FrozenBlock block = new FrozenBlock(loc, frozenMaterial);
                dif = Math.min(height - i, 1D);
                loc = loc.add(0D, dif, 0D);
                blocks.add(block);
            }
        }

        if (playSound) {
            // play the ice break sound effect
            entity.getWorld().playSound(loc, sound, volume, pitch);
        }

        // remove the ice block after some time
        if (encaseIce) {
            new UnfreezeTask(plugin, entity, blocks, duration).start();
        }
    }

    public void start() {
        runTask(plugin);
    }
}
