package me.val_mobile.rlcraft;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BaubleRunnables {

    private final RLCraft plugin;
    private final BaubleAbilities abilities;
    private final BaseRunnables baseRunnables;

    public BaubleRunnables(RLCraft instance) {
        plugin = instance;
        abilities = new BaubleAbilities(instance);
        baseRunnables = new BaseRunnables(instance);
    }

    public BukkitRunnable getPotionRingResistanceRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prRes.get(player.getUniqueId()) > 0) {
                    abilities.RingResistanceAbility(player, plugin.prRes.get(player.getUniqueId()));
                }

            }
        };
    }

    public BukkitRunnable getPotionRingRegenerationRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prRegen.get(player.getUniqueId()) > 0) {
                    abilities.RingRegenerationAbility(player, plugin.prRegen.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getPotionRingStrengthRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prStrength.get(player.getUniqueId()) > 0) {
                    abilities.RingStrengthAbility(player, plugin.prStrength.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getPotionRingSpeedRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prSpeed.get(player.getUniqueId()) > 0) {
                    abilities.RingSpeedAbility(player, plugin.prSpeed.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getPotionRingJumpBoostRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prJump.get(player.getUniqueId()) > 0) {
                    abilities.RingJumpBoostAbility(player, plugin.prJump.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getPotionRingHasteRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.prHaste.get(player.getUniqueId()) > 0) {
                    abilities.RingHasteAbility(player, plugin.prHaste.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getDragonsEyeRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.dragonsEye.get(player.getUniqueId())) {
                    abilities.DragonsEyeAbility(player);
                }
            }
        };
    }

    public BukkitRunnable getScarliteRingRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.scarliteRing.get(player.getUniqueId())) {
                    abilities.ScarliteRingAbility(player);
                }
            }
        };
    }

    public BukkitRunnable getMinersRingRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    baseRunnables.resetBaubleMaps(player);
                }
                if (plugin.minersRing.get(player.getUniqueId())) {
                    abilities.MinersRingAbility(player);
                }
            }
        };
    }

    public BukkitRunnable freezeEntity(Entity entity) {
        return new BukkitRunnable() {
            public void run() {
                entity.setVelocity(new Vector());
            }
        };
    }

    public BukkitRunnable removeInvFrames(Player player) {
        return new BukkitRunnable() {
            public void run() {
                plugin.crossNecklace.replace(player.getUniqueId(), false);
            }
        };
    }

}
