package me.val_mobile.rlcraft;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.MultiLineChart;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

public class BStats {

    private static final int ID = 12158;
    private final Metrics metrics;

    public BStats(RLCraft instance) {
        metrics = new Metrics(instance, ID);
    }

    public void recordData() {
        metrics.addCustomChart(new MultiLineChart("players_and_servers", () -> {
            Map<String, Integer> valueMap = new HashMap<>();
            valueMap.put("servers", 1);
            valueMap.put("players", Bukkit.getOnlinePlayers().size());
            return valueMap;
        }));
    }
}
