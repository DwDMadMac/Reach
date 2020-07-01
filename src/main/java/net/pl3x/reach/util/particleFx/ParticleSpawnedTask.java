package net.pl3x.reach.util.particleFx;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ParticleSpawnedTask {
    private static final ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
    private static ScheduledFuture<?> particleHandler;

    public static void setParticleTask(Player player, Particle particle, String particleDesign) {
        Particles customParticle = new Particles(player, particle, particleDesign);
        particleHandler = scheduled.scheduleAtFixedRate(customParticle, 0 ,250, TimeUnit.MILLISECONDS);
        scheduled.schedule(() -> {
            particleHandler.cancel(true);
        }, 10, TimeUnit.SECONDS);

        if (particleHandler.isCancelled()){
            scheduled.shutdown();
        }
    }
}
