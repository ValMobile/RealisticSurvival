package me.val_mobile.spartanandfire;

import me.val_mobile.realisticsurvival.RealisticSurvivalPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class UnfreezeTask extends BukkitRunnable {

    private final int pause;
    private final Collection<FrozenBlock> blocks;
    private final RealisticSurvivalPlugin plugin;
    private final Entity entity;

    public UnfreezeTask(RealisticSurvivalPlugin plugin, Entity entity, Collection<FrozenBlock> blocks, int pause) {
        this.blocks = blocks;
        this.plugin = plugin;
        this.pause = pause;
        this.entity = entity;
    }

    @Override
    public void run() {
        for (FrozenBlock block : blocks) {
            block.getBlock().remove();
        }

        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).setAI(true);
        }
    }

    public void start() {
        runTaskLater(plugin, pause);
    }
}
