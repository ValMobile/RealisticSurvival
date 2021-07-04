package me.val_mobile.rlcraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiscEvents implements Listener {

    private final RLCraft plugin;
    private final Recipes recipes;
    private final Items citem;
    private final Utils util;

    public MiscEvents(RLCraft instance) {

        plugin = instance;
        recipes = new Recipes(instance);
        citem = new Items(instance);
        util = new Utils(instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (plugin.getConfig().getBoolean("ResourcePack.Enabled")) {
            player.setResourcePack(plugin.getConfig().getString("ResourcePack.URL"));
        }

        if (plugin.getConfig().getBoolean("FlintTools")) {
            player.discoverRecipe(recipes.getFlintAxeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintKnifeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintShovelRecipe().getKey());
            player.discoverRecipe(recipes.getFlintPickaxeRecipe().getKey());
            player.discoverRecipe(recipes.getFlintHoeRecipe().getKey());
        }

        if (plugin.getConfig().getBoolean("NoTreePunching")) {
            player.discoverRecipe(recipes.getCobblestoneRecipe().getKey());
            player.discoverRecipe(recipes.getPlantStringRecipe().getKey());
        }

        if (plugin.getConfig().getBoolean("Dragons")) {
            player.discoverRecipe(recipes.getFireDragonsteelIngotRecipe().getKey());
            player.discoverRecipe(recipes.getIceDragonsteelIngotRecipe().getKey());
            player.discoverRecipe(recipes.getLightningDragonsteelIngotRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBlueRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBlueRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBronzeRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsGrayRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsGrayRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsGreenRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsGreenRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsRedRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsRedRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsSapphireRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsSapphireRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsSilverRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsSilverRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsWhiteRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsWhiteRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsAmethystRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsAmethystRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsBlackRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsBlackRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsCopperRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsCopperRecipe().getKey());

            player.discoverRecipe(recipes.getDragonScaleHelmetElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleChestplateElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleLeggingsElectricRecipe().getKey());
            player.discoverRecipe(recipes.getDragonScaleBootsElectricRecipe().getKey());

            player.discoverRecipe(recipes.getDragonBonePickaxeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneShovelRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneHoeRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getDragonBoneBowRecipe().getKey());
            player.discoverRecipe(recipes.getFlamedDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getIceDragonBoneSwordRecipe().getKey());
            player.discoverRecipe(recipes.getLightningDragonBoneSwordRecipe().getKey());
        }
        if (plugin.getConfig().getBoolean("SeaSerpents")) {
            player.discoverRecipe(recipes.getTideGuardianHelmetBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsBlueRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsBronzeRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsBronzeRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsDeepBlueRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsDeepBlueRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetGreenRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateGreenRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsGreenRecipe().getKey());
            player.discoverRecipe(recipes.getideGuardianBootsGreenRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetPurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplatePurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsPurpleRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsPurpleRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsRedRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsRedRecipe().getKey());

            player.discoverRecipe(recipes.getTideGuardianHelmetTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianChestplateTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianLeggingsTealRecipe().getKey());
            player.discoverRecipe(recipes.getTideGuardianBootsTealRecipe().getKey());

        }
        if (plugin.getConfig().getBoolean("Baubles")) {
            player.discoverRecipe(recipes.getBalloonRecipe().getKey());
            player.discoverRecipe(recipes.getCobaltShieldRecipe().getKey());
            player.discoverRecipe(recipes.getObsidianSkullRecipe().getKey());
            player.discoverRecipe(recipes.getSunglassesRecipe().getKey());
            player.discoverRecipe(recipes.getCrackedBlackDragonScaleRecipe().getKey());
            player.discoverRecipe(recipes.getBlackDragonScaleRecipe().getKey());
            player.discoverRecipe(recipes.getAnkhCharmRecipe().getKey());
            player.discoverRecipe(recipes.getWarpedScrollRecipe().getKey());
        }


    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getItemMeta().equals(citem.getBattleBurrito().getItemMeta())) {
            Player player = event.getPlayer();

            int speedAmplifier = 2;
            int speedDuration = 500;

            int regenAmplifier = 2;
            int regenDuration = 500;

            int strengthAmplifier = 2;
            int strengthDuration = 500;

            int resAmplifier = 2;
            int resDuration = 1000;

            int absorptionAmplifier = 2;
            int absorptionDuration = 2000;

            int fireResAmplifier = 2;
            int fireResDuration = 2000;

            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, speedAmplifier, speedDuration);
            PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, regenAmplifier, regenDuration);
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, strengthAmplifier, strengthDuration);
            PotionEffect res = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, resAmplifier, resDuration);
            PotionEffect absorption = new PotionEffect(PotionEffectType.ABSORPTION, absorptionAmplifier, absorptionDuration);
            PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResAmplifier, fireResDuration);

            util.addOrStackPotionEffect(player, speed);
            util.addOrStackPotionEffect(player, regen);
            util.addOrStackPotionEffect(player, strength);
            util.addOrStackPotionEffect(player, res);
            util.addOrStackPotionEffect(player, absorption);
            util.addOrStackPotionEffect(player, fireRes);
        }
    }
}
