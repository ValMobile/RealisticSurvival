package me.val_mobile.rlcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

public final class RLCraft extends JavaPlugin {

    private final int resourceID = 93795;
    private final Recipes recipes = new Recipes(this);
    private final MiscEvents recipeEvents = new MiscEvents(this);
    private final NoTreePunching noTreePunching = new NoTreePunching(this);
    private final DragonEvents dragonEvents = new DragonEvents(this);
    private final SeaSerpentDrops seaSerpentDrops = new SeaSerpentDrops(this);
    private final WitherDrops witherDrops = new WitherDrops(this);
    private final BaubleEvents baubleEvents = new BaubleEvents(this);
    private final ItemEvents itemEvents = new ItemEvents(this);
    private final ArmorEvents armorEvents = new ArmorEvents(this);
    private final CustomConfig customConfig = new CustomConfig(this);
    private final Commands commands = new Commands(this);
    private final Tab tabCompleter = new Tab();

    // Hashmaps for saving player and potion effect bauble amounts
    HashMap<UUID, Integer> prRes = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> prRegen = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> prStrength = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> prSpeed = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> prJump = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> prHaste = new HashMap<UUID, Integer>();

    HashMap<UUID, Boolean> tideArmor = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> dragonsEye = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> scarliteRing = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> minersRing = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> crossNecklace = new HashMap<>();


    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        customConfig.createSpartanWeaponryConfig();
        customConfig.createBaubleConfig();
        customConfig.createIceFireGearConfig();
        customConfig.createMobLootConfig();
        customConfig.createNoTreePunchingConfig();

        Logger logger = this.getLogger();
        new UpdateChecker(this, resourceID).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ChatColor.translateAlternateColorCodes('&', "&aYou are running the latest version"));
            } else {
                logger.info(ChatColor.translateAlternateColorCodes('&', "&aThere is a new update available: https://www.spigotmc.org/resources/rlcraft-1-17-baubles-dragons-sea-serpents.93795/history"));
            }
        });

        PluginManager pm = this.getServer().getPluginManager();
        
        if (this.getConfig().getBoolean("UnlockRecipes")) {
            pm.registerEvents(recipeEvents, this);
        }

        if (this.getConfig().getBoolean("FlintTools")) {
            Bukkit.addRecipe(recipes.getFlintAxeRecipe());
            Bukkit.addRecipe(recipes.getFlintKnifeRecipe());
            Bukkit.addRecipe(recipes.getFlintShovelRecipe());
            Bukkit.addRecipe(recipes.getFlintPickaxeRecipe());
            Bukkit.addRecipe(recipes.getFlintHoeRecipe());

        }

        if (this.getConfig().getBoolean("NoTreePunching")) {
            Bukkit.addRecipe(recipes.getCobblestoneRecipe());
            Bukkit.addRecipe(recipes.getPlantStringRecipe());

            pm.registerEvents(noTreePunching, this);
        }

        if (this.getConfig().getBoolean("Dragons")) {
            Bukkit.addRecipe(recipes.getFireDragonsteelIngotRecipe());
            Bukkit.addRecipe(recipes.getIceDragonsteelIngotRecipe());
            Bukkit.addRecipe(recipes.getLightningDragonsteelIngotRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetBlueRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateBlueRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsBlueRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsBlueRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetBronzeRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateBronzeRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsBronzeRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsBronzeRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetGrayRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateGrayRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsGrayRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsGrayRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetGreenRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateGreenRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsGreenRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsGreenRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetRedRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateRedRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsRedRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsRedRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetSapphireRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateSapphireRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsSapphireRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsSapphireRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetSilverRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateSilverRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsSilverRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsSilverRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetWhiteRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateWhiteRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsWhiteRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsWhiteRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetAmethystRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateAmethystRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsAmethystRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsAmethystRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetBlackRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateBlackRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsBlackRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsBlackRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetCopperRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateCopperRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsCopperRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsCopperRecipe());

            Bukkit.addRecipe(recipes.getDragonScaleHelmetElectricRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleChestplateElectricRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleLeggingsElectricRecipe());
            Bukkit.addRecipe(recipes.getDragonScaleBootsElectricRecipe());

            Bukkit.addRecipe(recipes.getDragonBonePickaxeRecipe());
            Bukkit.addRecipe(recipes.getDragonBoneShovelRecipe());
            Bukkit.addRecipe(recipes.getDragonBoneHoeRecipe());
            Bukkit.addRecipe(recipes.getDragonBoneSwordRecipe());
            Bukkit.addRecipe(recipes.getDragonBoneBowRecipe());
            Bukkit.addRecipe(recipes.getFlamedDragonBoneSwordRecipe());
            Bukkit.addRecipe(recipes.getIceDragonBoneSwordRecipe());
            Bukkit.addRecipe(recipes.getLightningDragonBoneSwordRecipe());

            pm.registerEvents(dragonEvents, this);
            pm.registerEvents(itemEvents, this);
        }
        if (this.getConfig().getBoolean("SeaSerpents")) {
            Bukkit.addRecipe(recipes.getTideGuardianHelmetBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsBlueRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetBronzeRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateBronzeRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsBronzeRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsBronzeRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetDeepBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateDeepBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsDeepBlueRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsDeepBlueRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetGreenRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateGreenRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsGreenRecipe());
            Bukkit.addRecipe(recipes.getideGuardianBootsGreenRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetPurpleRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplatePurpleRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsPurpleRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsPurpleRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetRedRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateRedRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsRedRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsRedRecipe());

            Bukkit.addRecipe(recipes.getTideGuardianHelmetTealRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianChestplateTealRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianLeggingsTealRecipe());
            Bukkit.addRecipe(recipes.getTideGuardianBootsTealRecipe());

            pm.registerEvents(seaSerpentDrops, this);
            pm.registerEvents(armorEvents, this);
        }

        if (this.getConfig().getBoolean("Witherbones")) {
            pm.registerEvents(witherDrops, this);
        }

        if (this.getConfig().getBoolean("Baubles")) {
            Bukkit.addRecipe(recipes.getBalloonRecipe());
            Bukkit.addRecipe(recipes.getSunglassesRecipe());
            Bukkit.addRecipe(recipes.getCobaltShieldRecipe());
            Bukkit.addRecipe(recipes.getObsidianSkullRecipe());
            Bukkit.addRecipe(recipes.getCrackedBlackDragonScaleRecipe());
            Bukkit.addRecipe(recipes.getBlackDragonScaleRecipe());
            Bukkit.addRecipe(recipes.getAnkhCharmRecipe());
            Bukkit.addRecipe(recipes.getWarpedScrollRecipe());

            pm.registerEvents(baubleEvents, this);
        }

        this.getCommand("RLCraft").setExecutor(commands);
        this.getCommand("RLCraft").setTabCompleter(tabCompleter);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
