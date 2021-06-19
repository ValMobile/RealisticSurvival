package me.val_mobile.minorities_smp_extras;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Runnables {

    private final Main plugin;
    private final Items citem;
    private final BaublesAbilities abilities;
    private final Utils util = new Utils();

    public Runnables(Main instance) {
        plugin = instance;
        citem = new Items(instance);
        abilities = new BaublesAbilities(instance);
    }

    public void resetBaubleMaps(Player player) {
        if (plugin.prRes.containsKey(player.getUniqueId())) {
            plugin.prRes.replace(player.getUniqueId(), plugin.prRes.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prRes.put(player.getUniqueId(), 0);
        }

        if (plugin.prRegen.containsKey(player.getUniqueId())) {
            plugin.prRegen.replace(player.getUniqueId(), plugin.prRegen.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prRegen.put(player.getUniqueId(), 0);
        }

        if (plugin.prStrength.containsKey(player.getUniqueId())) {
            plugin.prStrength.replace(player.getUniqueId(), plugin.prStrength.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prStrength.put(player.getUniqueId(), 0);
        }

        if (plugin.prSpeed.containsKey(player.getUniqueId())) {
            plugin.prSpeed.replace(player.getUniqueId(), plugin.prSpeed.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prSpeed.put(player.getUniqueId(), 0);
        }

        if (plugin.prJump.containsKey(player.getUniqueId())) {
            plugin.prJump.replace(player.getUniqueId(), plugin.prJump.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prJump.put(player.getUniqueId(), 0);
        }

        if (plugin.prHaste.containsKey(player.getUniqueId())) {
            plugin.prHaste.replace(player.getUniqueId(), plugin.prHaste.get(player.getUniqueId()), 0);
        }
        else {
            plugin.prHaste.put(player.getUniqueId(), 0);
        }

        if (plugin.dragonsEye.containsKey(player.getUniqueId())) {
            plugin.dragonsEye.replace(player.getUniqueId(), plugin.dragonsEye.get(player.getUniqueId()), false);
        }
        else {
            plugin.dragonsEye.put(player.getUniqueId(), false);
        }

        if (plugin.scarliteRing.containsKey(player.getUniqueId())) {
            plugin.scarliteRing.replace(player.getUniqueId(), plugin.scarliteRing.get(player.getUniqueId()), false);
        }
        else {
            plugin.scarliteRing.put(player.getUniqueId(), false);
        }

    }

    public void checkBauble(Player player) {
        int prResAmount = 0;
        int prRegenAmount = 0;
        int prStrengthAmount = 0;
        int prSpeedAmount = 0;
        int prJumpAmount = 0;
        int prHasteAmount = 0;
        boolean hasDragonsEye = false;
        boolean hasScarliteRing = false;
        boolean hasMinersRing = false;

        for (int i = 0; i < 36; i++) {
            if (!(player.getInventory().getItem(i) == null || player.getInventory().getItem(i).getType() == Material.AIR) ) {
                NBTItem nbti = new NBTItem(player.getInventory().getItem(i));
                if (nbti.hasKey("Potion Effect Bauble")) {
                    switch (nbti.getString("Potion Effect Bauble")) {
                        case "Potion Ring of Resistance":
                            prResAmount++;
                            break;
                        case "Potion Ring of Regeneration":
                            prRegenAmount++;
                            break;
                        case "Potion Ring of Strength":
                            prStrengthAmount++;
                            break;
                        case "Potion Ring of Speed":
                            prSpeedAmount++;
                            break;
                        case "Potion Ring of Jump Boost":
                            prJumpAmount++;
                            break;
                        case "Dragon's Eye":
                            hasDragonsEye = true;
                            break;
                        case "Scarlite Ring":
                            hasScarliteRing = true;
                            break;
                        case "Miner's Ring":
                            hasMinersRing = true;
                            break;
                    }
                }
            }
        }
        if (plugin.prRes.containsKey(player.getUniqueId())) {
            plugin.prRes.replace(player.getUniqueId(), plugin.prRes.get(player.getUniqueId()), prResAmount);
        }
        else {
            plugin.prRes.put(player.getUniqueId(), prResAmount);
        }

        if (plugin.prRegen.containsKey(player.getUniqueId())) {
            plugin.prRegen.replace(player.getUniqueId(), plugin.prRegen.get(player.getUniqueId()), prRegenAmount);
        }
        else {
            plugin.prRegen.put(player.getUniqueId(), prRegenAmount);
        }

        if (plugin.prStrength.containsKey(player.getUniqueId())) {
            plugin.prStrength.replace(player.getUniqueId(), plugin.prStrength.get(player.getUniqueId()), prStrengthAmount);
        }
        else {
            plugin.prStrength.put(player.getUniqueId(), prStrengthAmount);
        }

        if (plugin.prSpeed.containsKey(player.getUniqueId())) {
            plugin.prSpeed.replace(player.getUniqueId(), plugin.prSpeed.get(player.getUniqueId()), prSpeedAmount);
        }
        else {
            plugin.prSpeed.put(player.getUniqueId(), prSpeedAmount);
        }

        if (plugin.prJump.containsKey(player.getUniqueId())) {
            plugin.prJump.replace(player.getUniqueId(), plugin.prJump.get(player.getUniqueId()), prJumpAmount);
        }
        else {
            plugin.prJump.put(player.getUniqueId(), prJumpAmount);
        }

        if (plugin.prHaste.containsKey(player.getUniqueId())) {
            plugin.prHaste.replace(player.getUniqueId(), plugin.prHaste.get(player.getUniqueId()), prHasteAmount);
        }
        else {
            plugin.prHaste.put(player.getUniqueId(), prHasteAmount);
        }

        if (plugin.dragonsEye.containsKey(player.getUniqueId())) {
            plugin.dragonsEye.replace(player.getUniqueId(), plugin.dragonsEye.get(player.getUniqueId()), hasDragonsEye);
        }
        else {
            plugin.dragonsEye.put(player.getUniqueId(), hasDragonsEye);
        }

        if (plugin.scarliteRing.containsKey(player.getUniqueId())) {
            plugin.scarliteRing.replace(player.getUniqueId(), plugin.scarliteRing.get(player.getUniqueId()), hasScarliteRing);
        }
        else {
            plugin.scarliteRing.put(player.getUniqueId(), hasScarliteRing);
        }

        if (plugin.minersRing.containsKey(player.getUniqueId())) {
            plugin.minersRing.replace(player.getUniqueId(), plugin.minersRing.get(player.getUniqueId()), hasMinersRing);
        }
        else {
            plugin.minersRing.put(player.getUniqueId(), hasMinersRing);
        }
    }

    public void checkTideGuardianArmor(Player player) {
        boolean hasTideGuardianArmor = false;
        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (! (item == null || item.getType() == Material.AIR)) {
                NBTItem nbti = new NBTItem(item);
                if (nbti.hasKey("Tide Guardian Armor")) {
                    hasTideGuardianArmor = true;
                    break;
                }
            }
        }
        if (plugin.tideArmor.containsKey(player.getUniqueId())) {
            plugin.tideArmor.replace(player.getUniqueId(), plugin.tideArmor.get(player.getUniqueId()), hasTideGuardianArmor);
        }
        else {
            plugin.tideArmor.put(player.getUniqueId(), hasTideGuardianArmor);
        }

    }

    public BukkitRunnable getPotionRingResistanceRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
                }
                if (plugin.prHaste.get(player.getUniqueId()) > 0) {
                    abilities.RingHasteAbility(player, plugin.prHaste.get(player.getUniqueId()));
                }
            }
        };
    }

    public BukkitRunnable getTideGuardianArmorRunnable(Player player) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    cancel();
                }
                if (player.isDead()) {
                    resetBaubleMaps(player);
                }
                if (plugin.tideArmor.get(player.getUniqueId())) {
                    abilities.TideGuardianArmorAbility(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
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
                    resetBaubleMaps(player);
                }
                if (plugin.minersRing.get(player.getUniqueId())) {
                    abilities.MinersRingAbility(player);
                }
            }
        };
    }


}
