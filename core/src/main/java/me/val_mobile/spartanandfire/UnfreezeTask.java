package me.val_mobile.spartanandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class UnfreezeTask extends BukkitRunnable {

    private final int pause;
    private final Collection<FrozenBlock> blocks;
    private final RealisticSurvivalPlugin plugin;

    public UnfreezeTask(RealisticSurvivalPlugin plugin, Collection<FrozenBlock> blocks, int pause) {
        this.blocks = blocks;
        this.plugin = plugin;
        this.pause = pause;
    }

    @Override
    public void run() {
        for (FrozenBlock block : blocks) {
            block.getBlock().remove();
        }
    }

    public void start() {
        runTaskLater(plugin, pause);
    }
}
