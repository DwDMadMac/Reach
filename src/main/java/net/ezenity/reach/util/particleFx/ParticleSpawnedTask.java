package net.ezenity.reach.util.particleFx;

import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static net.ezenity.reach.util.countdownFx.Countdown.*;

/**
 * This class is used for custom particle spawning. Each particle is spawned as a executor which will be used
 * asynchronously and in the event the same particle is being spawned for the given hash code, this particle
 * task will not execute and continue to its pre-requites code.
 */
public class ParticleSpawnedTask {
    /**
     * This field we are using an Executor Service as a higher level replacement for working with threads directly. In this
     * case we are capable of running asynchronously tasks and manage a pool of threads. This will allow us to stop the
     * creation of new threads manually. All threads of the internal pool will be reused under the hood for revenant task.
     * This allows the particle task to run as many concurrent tasks as we want throughout the life-cycle of the application
     * with a single executor service. We are using {@link Executors#newScheduledThreadPool(int)} to create an executor
     * service backed by a thread-pool of size one. If we need to increase the pool size, we can by simply passing a larger
     * value than one.
     */
    private static final ScheduledExecutorService THREAD_EXECUTOR = Executors.newScheduledThreadPool(1);
    /**
     * We use a {@link ScheduledFuture} to represent the results of our asynchronous delayed particle computation.
     */
    private static ScheduledFuture<?> PARTICLE_HANDLER;
    /**
     * Particles instance. Used to create a custom particle utilizing a serious of getters and setters.
     */
    private static final Particles particles = new Particles();

    /**
     * We will use this method to set our given particle to the plausible demand. The particle will be set using an
     * executor asynchronously and will run until the particle spawn rate has ended. Once the timer hits it limit the
     * executor will then cancel and shutdown. Before spawning the particle, this method will check against a hashmap
     * to ensure that the currently given hash code is not running. If there is still a particle in progress or if
     * there is a cooldown(countdown) the task will not spawn and if {@link Logger#info(String)} is enabled, will output the
     * remaining time length of the countdown.
     *
     * @param player get player
     * @param particle get particle
     * @param particleDesign get particle design
     * @param cooldown get cooldown in seconds
     * @param particleSpawnedTimer get particle spawn rate in seconds
     */
    public static void setParticleTask(Player player, Particle particle, String particleDesign, int cooldown, int particleSpawnedTimer) { // TODO: Rework particle param
        if (!(System.currentTimeMillis() > getCountdown(player.getUniqueId(), particleDesign))) {
            Logger.info("Count Time  " + getCountdown(player.getUniqueId(), particleDesign));
            Logger.info("System Time " + System.currentTimeMillis());
        } else {
            particles.setParticle(particle);
            particles.setParticleDesign(particleDesign);
            particles.setPlayer(player);

            PARTICLE_HANDLER = THREAD_EXECUTOR.scheduleAtFixedRate(particles, 0, 250, TimeUnit.MILLISECONDS);

            THREAD_EXECUTOR.schedule(() -> {
                PARTICLE_HANDLER.cancel(true);
            }, particleSpawnedTimer, TimeUnit.SECONDS);

            Logger.info("==============================================================");
            Logger.info("==============================================================");
            Logger.info("Countdown no longer activated, create particle");
            Logger.info("&1Create countdown");
            setCountdown(player.getUniqueId(), particleDesign, cooldown);
            Logger.info("==============================================================");
            Logger.info("Get countdown in milliseconds " + getCountdown(player.getUniqueId(), particleDesign));
            Logger.info("System current time in milliseconds " + System.currentTimeMillis());
            Logger.info("==============================================================");
            Lang.send(player, "Countdown activated for " + particleDesign);
            Logger.info("==============================================================");

            if (PARTICLE_HANDLER.isCancelled())
                THREAD_EXECUTOR.shutdown();
        }
    }
}
