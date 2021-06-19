package me.val_mobile.minorities_smp_extras;

import org.bukkit.Bukkit;
import org.bukkit.entity.FallingBlock;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private final Recipes recipes = new Recipes(this);
    private final DragonDrops dragonDrops = new DragonDrops(this);
    private final SeaSerpentDrops seaSerpentDrops = new SeaSerpentDrops(this);
    private final WitherDrops witherDrops = new WitherDrops(this);
    private final NoTreePunching noTreePunching = new NoTreePunching(this);
    private final BaublesEvents baublesEvents = new BaublesEvents(this);
    private final DragonFight dragonFight = new DragonFight(this);
    private final Commands commands = new Commands(this);
    private final Tab tabCompleter = new Tab();

    List<FallingBlock> iceDragonBoneBlocks = new ArrayList<>();
    List<FallingBlock> iceDragonsteelBlocks = new ArrayList<>();

    String dragon;


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


    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        if (this.getConfig().getBoolean("flintTools")) {
            Bukkit.addRecipe(recipes.getFlintAxeRecipe());
            Bukkit.addRecipe(recipes.getFlintKnifeRecipe());
            Bukkit.addRecipe(recipes.getFlintShovelRecipe());
            Bukkit.addRecipe(recipes.getFlintPickaxeRecipe());
            Bukkit.addRecipe(recipes.getFlintHoeRecipe());

        }

        if (this.getConfig().getBoolean("noTreePunching")) {
            Bukkit.addRecipe(recipes.getCobblestoneRecipe());
            Bukkit.addRecipe(recipes.getPlantStringRecipe());

            this.getServer().getPluginManager().registerEvents(noTreePunching, this);
        }

        if (this.getConfig().getBoolean("dragons.enabled")) {
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

            this.getServer().getPluginManager().registerEvents(dragonDrops, this);
        }
        if (this.getConfig().getBoolean("seaSerpents.enabled")) {
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

            this.getServer().getPluginManager().registerEvents(seaSerpentDrops, this);
        }

        if (this.getConfig().getBoolean("witherbones.enabled")) {
            this.getServer().getPluginManager().registerEvents(witherDrops, this);
        }

        if (this.getConfig().getBoolean("baubles")) {
            Bukkit.addRecipe(recipes.getBalloonRecipe());
            Bukkit.addRecipe(recipes.getSunglassesRecipe());
            Bukkit.addRecipe(recipes.getCobaltShieldRecipe());
            Bukkit.addRecipe(recipes.getObsidianSkullRecipe());
            Bukkit.addRecipe(recipes.getCrackedBlackDragonScaleRecipe());
            Bukkit.addRecipe(recipes.getBlackDragonScaleRecipe());
            Bukkit.addRecipe(recipes.getAnkhCharmRecipe());
            Bukkit.addRecipe(recipes.getWarpedScrollRecipe());

            this.getServer().getPluginManager().registerEvents(baublesEvents, this);
            this.getServer().getPluginManager().registerEvents(dragonFight, this);
        }


        this.getCommand("MinoritiesSMP").setExecutor(commands);
        this.getCommand("MinoritiesSMP").setTabCompleter(tabCompleter);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
