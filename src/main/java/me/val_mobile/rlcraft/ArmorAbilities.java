package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorAbilities {

    private final Utils util;
    public ArmorAbilities(RLCraft instance) {
        util = new Utils(instance);
    }

    public void TideGuardianArmorAbility(Player player) {

        int amplifier = 0;
        int duration = 270;
        PotionEffect effect = new PotionEffect(PotionEffectType.WATER_BREATHING, duration, amplifier);
        util.addOrStackPotionEffect(player, effect);
    }
}
