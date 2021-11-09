package com.mvye.particlecommandmm.events;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleTask extends BukkitRunnable {

    private Player player;
    private Location location;
    private double tick = 0; // timer, used to limit amount of times ran

    public ParticleTask(Player player) {
        this.player = player;
        this.location = player.getLocation();
    }

    @Override
    public void run() {
        tick = tick + 0.1*Math.PI;
        for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32) {
            double x = tick*Math.cos(theta); // Makes a circle
            double y = Math.exp(-0.1*tick) * Math.sin(tick) + 1.5; // Makes the circle go up and down
            double z = tick*Math.sin(theta); // Makes a circle
            location.add(x,y,z);
            player.spawnParticle(Particle.GLOW, location, 1); // spawns a particle at location for the player
            location.subtract(x,y,z);
        }
        if (tick > 20) {
            this.cancel();
        }
    }
}
