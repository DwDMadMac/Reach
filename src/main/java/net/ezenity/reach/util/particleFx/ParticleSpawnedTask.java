package net.ezenity.reach.util.particleFx;

import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static net.ezenity.reach.util.CountdownFx.*;

public class ParticleSpawnedTask {
    private static final ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
    private static ScheduledFuture<?> particleHandler;

    public static void setParticleTask(Player player, Particle particle, String particleDesign) {
        if (countdownSecondsRemaining(player.getUniqueId(), particleDesign) == 0)
            removeCountdowns(player.getUniqueId(), particleDesign);

        if (!countdownActive(player.getUniqueId(), particleDesign)) {
            Logger.info("Countdown no longer activated, create particle");
            Particles customParticle = new Particles(player, particle, particleDesign);
            particleHandler = scheduled.scheduleAtFixedRate(customParticle, 0, 250, TimeUnit.MILLISECONDS);
            scheduled.schedule(() -> {
                particleHandler.cancel(true);
            }, 1, TimeUnit.SECONDS);
            Logger.info("&1Create countdown");
            setCountdown(player.getUniqueId(), particleDesign, 10);
        }

        if (particleHandler.isCancelled())
            scheduled.shutdown();
        Lang.send(player, "Countdown activated for " + particleDesign);
    }
}
