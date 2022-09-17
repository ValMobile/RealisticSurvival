package me.val_mobile.tan;

import me.val_mobile.data.RSVModule;
import me.val_mobile.data.RSVPlayer;
import me.val_mobile.data.toughasnails.DataModule;
import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import me.val_mobile.utils.RSVEnchants;
import me.val_mobile.utils.RSVItem;
import me.val_mobile.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class TemperatureCalculateTask extends BukkitRunnable {

    private final FileConfiguration config;

    private final RealisticSurvivalPlugin plugin;
    private final static HashMap<UUID, TemperatureCalculateTask> tasks = new HashMap<>();
    private final static HashMap<UUID, Boolean> players = new HashMap<>();
    private final RSVPlayer player;
    private final Collection<String> allowedWorlds;
    private double equilibriumTemp;
    private double regulate = 0D;
    private double change = 0D;
    private double temp;
    private final DataModule module;
    public static final double MINIMUM_TEMPERATURE = 0.0;
    public static final double MAXIMUM_TEMPERATURE = 25.0;

    public static final double NEUTRAL_TEMPERATURE = 12.5;

    public TemperatureCalculateTask(RealisticSurvivalPlugin plugin, RSVPlayer player) {
        this.plugin = plugin;
        this.config = RSVModule.getModule(TanModule.NAME).getUserConfig().getConfig();
        this.player = player;
        this.allowedWorlds = RSVModule.getModule(TanModule.NAME).getAllowedWorlds();
        this.module = ((DataModule) this.player.getDataModuleFromName(TanModule.NAME));
        this.temp = module.getTemperature();
        tasks.put(player.getPlayer().getUniqueId(), this);
    }

    @Override
    public void run() {
        Player player = this.player.getPlayer();
        GameMode mode = player.getGameMode(); // get the gamemode

        if (mode == GameMode.SURVIVAL || mode == GameMode.ADVENTURE || !player.isOnline() && allowedWorlds.contains(player.getWorld().toString())) {
            double oldTemp = temp;
            regulate = 0D;
            change = 0D;
            World pWorld = player.getWorld();
            Location pLoc = player.getLocation();
            Block pBlock = pLoc.getBlock();
            double px = pLoc.getX();
            double py = pLoc.getY();
            double pz = pLoc.getZ();

            double biomeTemp = pWorld.getTemperature((int) px, (int) py, (int) pz); // create a variable to store the temperature

            if (biomeTemp <= 0.30) {
                if (biomeTemp < -0.01) {
                    biomeTemp *= 30;
                }
                else if (biomeTemp > 0.01) {
                    biomeTemp *= -20;
                }
                else {
                    biomeTemp -= 0.1;
                    biomeTemp *= 20;
                }
            }

            double daytimeChange = 3 * (biomeTemp + Utils.getDayMultiplier(pWorld));
            change += daytimeChange;

            double tempMaxChange = config.getDouble("Temperature.Environment.MaxChange");
            int cubeLength = config.getInt("Temperature.Environment.CubeLength");

            for (int x = -(cubeLength - 1); x < cubeLength; x++) {
                for (int y = -(cubeLength - 1); y < cubeLength; y++) {
                    for (int z = -(cubeLength - 1); z < cubeLength; z++) {
                        Location loc = new Location(player.getWorld(), px + x, py + y, pz + z);
                        Block block = loc.getBlock();

                        if (block != null) {
                            String path = "Temperature.Environment.Blocks";
                            ConfigurationSection section = config.getConfigurationSection(path);

                            String material = block.getBlockData().getMaterial().toString();
                            if (section.getKeys(false).contains(material)) {
                                add(path + "." + material);
                            }
                        }
                    }
                }
            }

            if (pBlock.isLiquid()) {
                if (pBlock.getBlockData().getMaterial() == Material.LAVA) {
                    add("Temperature.Environment.SubmergedLava");
                }
                else {
                    add("Temperature.Environment.SubmergedWater");
                }
            }

            if (Utils.isExposedToSky(player)) {
                if (pWorld.hasStorm()) {
                    add("Temperature.Environment.Storming");
                }
                add("Temperature.Environment.Housed");

            }

            if (player.getFireTicks() > 0) {
                add("Temperature.Environment.Burning");
            }

            for (ItemStack item : player.getInventory().getArmorContents()) {
                if (Utils.isItemReal(item)) {
                    ItemMeta meta = item.getItemMeta();

                    if (RSVItem.isRSVItem(item)) {
                        String itemName = RSVItem.getNameFromItem(item);

                        switch (itemName) {
                            case "wool_hood":
                            case "wool_boots":
                            case "wool_pants":
                            case "wool_jacket":
                            case "jelled_slime_helmet":
                            case "jelled_slime_chestplate":
                            case "jelled_slime_leggings":
                            case "jelled_slime_boots": {
                                add("Temperature.Armor." + itemName);
                                break;
                            }
                        }
                    }
                    else {
                        Material mat = item.getType();
                        if (Utils.isArmor(mat)) {
                            add("Temperature.Armor." + mat);
                        }
                    }

                    if (meta.hasEnchant(RSVEnchants.COOLING)) {
                        add("Temperature.Enchantments.Cooling");
                    }

                    if (meta.hasEnchant(RSVEnchants.WARMING)) {
                        add("Temperature.Enchantments.Warming");
                    }

                    if (meta.hasEnchant(RSVEnchants.OZZY_LINER)) {
                        add("Temperature.Enchantments.OzzyLiner");
                    }
                }
            }

            double normalTemp = temp + change;
            double regulatedTemp = temp;

            if (normalTemp != NEUTRAL_TEMPERATURE) {
                if (normalTemp > NEUTRAL_TEMPERATURE) {
                    regulatedTemp = Math.max(normalTemp - regulate, NEUTRAL_TEMPERATURE);

                }
                else {
                    regulatedTemp = Math.min(normalTemp + regulate, NEUTRAL_TEMPERATURE);
                }
            }

            equilibriumTemp = regulatedTemp;

            if (Math.abs(temp - regulatedTemp) < tempMaxChange) {
                temp = regulatedTemp;
            }
            else {
                temp = regulatedTemp > temp ? temp + tempMaxChange : temp - tempMaxChange;
            }

            if (temp != NEUTRAL_TEMPERATURE) {
                if (temp < NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.cold")) {
                    temp = NEUTRAL_TEMPERATURE;
                }
                if (temp > NEUTRAL_TEMPERATURE && player.hasPermission("realisticsurvival.toughasnails.resistance.hot")) {
                    temp = NEUTRAL_TEMPERATURE;
                }
            }

            if (temp <= config.getDouble("Temperature.Hypothermia.Temperature")) {
                if (HypothermiaTask.getPlayers().containsKey(player.getUniqueId())) {
                    if (!HypothermiaTask.getPlayers().get(player.getUniqueId())) {
                        new HypothermiaTask(plugin, this.player).startRunnable();
                    }
                }
                else {
                    new HypothermiaTask(plugin, this.player).startRunnable();
                }
            }

            if (temp >= config.getDouble("Temperature.Hyperthermia.Temperature")) {
                if (HyperthermiaTask.getPlayers().containsKey(player.getUniqueId())) {
                    if (!HyperthermiaTask.getPlayers().get(player.getUniqueId())) {
                        new HyperthermiaTask(plugin, this.player).startRunnable();
                    }
                }
                else {
                    new HyperthermiaTask(plugin, this.player).startRunnable();
                }
            }

            if (temp != oldTemp) {
                Bukkit.getServer().getPluginManager().callEvent(new TemperatureChangeEvent(player, oldTemp, temp));
            }
            module.setTemperature(temp);
        }
        // if the player is in creative or spectator
        else {
            // update static hashmap values and cancel the runnable
            players.put(player.getUniqueId(), false);
            tasks.remove(player.getUniqueId());
            cancel();
        }
    }

    public void add(String configPath) {
        double amount = config.getDouble(configPath + ".Value");

        if (config.contains(configPath + ".Enabled")) {
            if (config.getBoolean(configPath + ".Enabled")) {
                if (config.getBoolean(configPath + ".IsRegulatory")) {
                    regulate += amount;
                }
                else {
                    change += amount;
                }
            }
        }
        else {
            if (config.getBoolean(configPath + ".IsRegulatory")) {
                regulate += amount;
            }
            else {
                change += amount;
            }
        }
    }

    public void start() {
        int tickSpeed = config.getInt("Temperature.CalculateTickSpeed"); // get the tick speed
        this.runTaskTimer(plugin, 0L, tickSpeed);
        players.put(player.getPlayer().getUniqueId(), true);
    }

    public static HashMap<UUID, Boolean> getPlayers() {
        return players;
    }

    public static HashMap<UUID, TemperatureCalculateTask> getTasks() {
        return tasks;
    }

    public double getEquilibriumTemp() {
        return equilibriumTemp;
    }
}
