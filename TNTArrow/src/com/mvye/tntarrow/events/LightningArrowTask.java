package com.mvye.tntarrow.events;

import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitRunnable;

public class LightningArrowTask extends BukkitRunnable {
    private Arrow arrow;
    private int tick = 0;

    public LightningArrowTask(Arrow arrow) {
        this.arrow = arrow;
    }

    @Override
    public void run() {
        if (arrow == null || arrow.isOnGround() || tick++ > 20 * 10) {
            if (arrow.isOnGround())
                arrow.getWorld().createExplosion(arrow.getLocation(), 3, false, false);
            this.cancel();
        }
        else {
            arrow.getWorld().strikeLightningEffect(arrow.getLocation());
        }
    }
}
