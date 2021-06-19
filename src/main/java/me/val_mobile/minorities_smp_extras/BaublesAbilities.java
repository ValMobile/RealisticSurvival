package me.val_mobile.minorities_smp_extras;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BaublesAbilities {

    private final Main plugin;

    public BaublesAbilities(Main instance) {
        plugin = instance;
    }

    public void DragonsEyeAbility(Player player) {
        if (!player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 220, 0));
        }
        else if (player.getPotionEffect(PotionEffectType.FIRE_RESISTANCE).getAmplifier() == 0 &&
                player.getPotionEffect(PotionEffectType.FIRE_RESISTANCE).getDuration() <= 200) {
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 220, 0));
        }

        if (!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 220, 0));
        }
        else if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getAmplifier() == 0 &&
                player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() <= 200) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 220, 0));
        }

    }

    public void RingResistanceAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;
        if (amplifier > 2) {
            amplifier = 2;
        }

        if (!player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier));
        }

        else if (player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                        duration, amplifier));
            }
        }
    }

    public void RingHasteAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;

        if (!player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amount - 1));
        }

        else if (player.getPotionEffect(PotionEffectType.FAST_DIGGING).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                    player.getPotionEffect(PotionEffectType.FAST_DIGGING).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.FAST_DIGGING).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.FAST_DIGGING).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                        duration, amplifier));
            }
        }
    }

    public void RingRegenerationAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;
        if (amplifier > 2) {
            amplifier = 2;
        }

        if (!player.hasPotionEffect(PotionEffectType.REGENERATION)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration, amplifier));
        }

        else if (player.getPotionEffect(PotionEffectType.REGENERATION).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.REGENERATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
                    player.getPotionEffect(PotionEffectType.REGENERATION).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.REGENERATION).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.REGENERATION).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
                        duration, amplifier));
            }
        }
    }

    public void RingSpeedAbility(Player player, int amount) {
        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;

        if (!player.hasPotionEffect(PotionEffectType.SPEED)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amount - 1));
        }
        else if (player.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                    player.getPotionEffect(PotionEffectType.SPEED).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.SPEED).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.SPEED).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.SPEED);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                        duration, amplifier));
            }
        }
    }

    public void RingJumpBoostAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;

        if (!player.hasPotionEffect(PotionEffectType.JUMP)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, duration, amount - 1));
        }

        else if (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                    player.getPotionEffect(PotionEffectType.JUMP).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.JUMP).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.JUMP);
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                        duration, amplifier));
            }
        }
    }

    public void RingStrengthAbility(Player player, int amount) {

        int amplifier = amount - 1;
        int duration = 270;
        int cutoff = 250;
        if (amplifier > 2) {
            amplifier = 2;
        }

        if (!player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amount - 1));
        }
        else if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
                    player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
                        duration, amplifier));
            }
        }
    }

    public void PoisonStoneAbility(LivingEntity entity) {

        int amplifier = 1;
        int duration = 270;

        if (!entity.hasPotionEffect(PotionEffectType.POISON)) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, duration, amplifier));
        }
        else if (entity.getPotionEffect(PotionEffectType.POISON).getAmplifier() < amplifier) {
            entity.removePotionEffect(PotionEffectType.POISON);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                    duration, amplifier));
        }

    }

    public void FireDragonBoneAbility(LivingEntity entity) {

        int fireTicks = 200;

        if (entity.getFireTicks() < fireTicks) {
            entity.setFireTicks(fireTicks);
        }

    }

    public void IceDragonBoneAbility(LivingEntity entity) {

        int amplifier = 4;
        int duration = 30;

        if (! (entity instanceof EnderDragon || entity instanceof Wither || entity instanceof ElderGuardian) ) {
            if (!entity.hasPotionEffect(PotionEffectType.SLOW)) {
                entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, amplifier));
            }
            else if (entity.getPotionEffect(PotionEffectType.SLOW).getAmplifier() < amplifier) {
                entity.removePotionEffect(PotionEffectType.SLOW);
                entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                        duration, amplifier));
            }
            entity.setAI(false);

            new BukkitRunnable() {
                @Override
                public void run() {
                    entity.setVelocity(new Vector());
                    entity.setAI(true);
                }
            }.runTaskLater(plugin, 1);

            Location loc = entity.getLocation();
            FallingBlock block = entity.getWorld().spawnFallingBlock(loc, Material.ICE.createBlockData());
            FallingBlock block2;
            FallingBlock block3;

            block.setDropItem(false);
            block.setHurtEntities(false);
            block.setGravity(false);
            block.setCustomName("Ice Dragon Bone Block");

            plugin.iceDragonBoneBlocks.add(block);

            if (entity.getHeight() >= 1.8) {
                if (entity.getHeight() >= 2.8) {
                    loc.setY(loc.getY() + 1.0D);
                    block2 = entity.getWorld().spawnFallingBlock(loc, Material.ICE.createBlockData());
                    loc.setY(loc.getY() + 1.0D);
                    block3 = entity.getWorld().spawnFallingBlock(loc, Material.ICE.createBlockData());

                    block2.setDropItem(false);
                    block2.setHurtEntities(false);
                    block2.setGravity(false);
                    block2.setCustomName("Ice Dragon Bone Block");

                    block3.setDropItem(false);
                    block3.setHurtEntities(false);
                    block3.setGravity(false);
                    block3.setCustomName("Ice Dragon Bone Block");

                    plugin.iceDragonBoneBlocks.add(block2);
                    plugin.iceDragonBoneBlocks.add(block3);
                }
                else {
                    loc.setY(loc.getY() + 1.0D);
                    block2 = entity.getWorld().spawnFallingBlock(loc, Material.ICE.createBlockData());

                    block2.setDropItem(false);
                    block2.setHurtEntities(false);
                    block2.setGravity(false);
                    block2.setCustomName("Ice Dragon Bone Block");

                    plugin.iceDragonBoneBlocks.add(block2);
                }
            }


            new BukkitRunnable() {
                @Override
                public void run() {
                    for (FallingBlock b : plugin.iceDragonBoneBlocks) {
                        b.remove();
                    }
                }
            }.runTaskLater(plugin, 5);
        }

    }

    public void LightningDragonBoneAbility(LivingEntity entity) {
        entity.getWorld().strikeLightning(entity.getLocation());
        new BukkitRunnable() {
            @Override
            public void run() {
                entity.setVelocity(new Vector());
            }
        }.runTaskLater(plugin, 1);
    }

    public void TideGuardianArmorAbility(Player player) {

        int amplifier = 0;
        int duration = 270;
        int cutoff = 250;

        if (!player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, duration, amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getAmplifier() < amplifier) {
            player.removePotionEffect(PotionEffectType.WATER_BREATHING);
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
                    player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration(), amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
                        duration, amplifier));
            }
        }
    }

    public void ScarliteRingAbility(Player player) {

        double healAmount = 1.0D;

        if (player.getHealth() < player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            double difference = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - player.getHealth();
            if (difference < healAmount) {
                player.setHealth(player.getHealth() + difference);
            }
            else {
                player.setHealth(player.getHealth() + healAmount);
            }
        }
    }

    public void MinersRingAbility(Player player) {

        int amplifier = 0;
        int duration = 270;
        int cutoff = 250;

        if (!player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, duration, amplifier));
        }
        else if (player.getPotionEffect(PotionEffectType.FAST_DIGGING).getAmplifier() == amplifier) {
            if (player.getPotionEffect(PotionEffectType.FAST_DIGGING).getDuration() <= cutoff) {
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                        duration, amplifier));
            }
        }
    }
}
