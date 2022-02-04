package com.mvye.particlecommand.events;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Particle.DustTransition;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleTask extends BukkitRunnable {
    private Player player;
    private Location location;
    private double tick = 0;

    public ParticleTask(Player player) {
        this.player = player;
        this.location = player.getLocation();
    }

    @Override
    public void run() {
        tick = tick + 0.1*Math.PI;
        DustTransition dustTransition = new DustTransition(Color.fromRGB(129, 201, 151), Color.fromRGB(129, 195, 201), 5.0F);
        for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32) {
            double x = tick*Math.cos(theta);
            double y = 0;
            double z = tick*Math.sin(theta);
            location.add(x,y,z);
            player.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, dustTransition);
            location.subtract(x,y,z);
        }

        if (tick > 20) {
            this.cancel();
        }
    }
}
