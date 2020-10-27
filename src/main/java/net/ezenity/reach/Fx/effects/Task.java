package net.ezenity.reach.Fx.effects;

import net.ezenity.reach.Main;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static net.ezenity.reach.Fx.countdown.Countdown.*;

/**
 * This class is used for custom particle spawning. Each particle is spawned as a executor which will be used
 * asynchronously and in the event the same particle is being spawned for the given hash code, this particle
 * task will not execute and continue to its pre-requites code.
 *
 * @author anthonymmacallister
 * @version 2.0.0
 * @since 1.0.0
 */
public class Task extends Particles{
    /**
     * This field we are using an Executor Service as a higher level replacement for working with threads directly. In this
     * case we are capable of running asynchronously tasks and manage a pool of threads. This will allow us to stop the
     * creation of new threads manually. All threads of the internal pool will be reused under the hood for revenant task.
     * This allows the particle task to run as many concurrent tasks as we want throughout the life-cycle of the application
     * with a single executor service. We are using {@link Executors#newScheduledThreadPool(int)} to create an executor
     * service backed by a thread-pool of size one. If we need to increase the pool size, we can by simply passing a larger
     * value than one.
     */
    private final ScheduledExecutorService THREAD_EXECUTOR = Executors.newScheduledThreadPool(1);
    /**
     * We use a {@link ScheduledFuture} to represent the results of our asynchronous delayed particle computation.
     */
    private ScheduledFuture<?> PARTICLE_HANDLER;
    /**
     * Particles instance. Used to create a custom particle utilizing a serious of getters and setters.
     */
    private final Particles particles = new Particles();

    /**
     * We will use this method to set our given particle to the plausible demand. The particle will be set using an
     * executor asynchronously and will run until the particle spawn rate has ended. Once the timer hits its limit the
     * executor will then cancel and shutdown. Before spawning the particle, this method will check against a hashmap
     * to ensure that the currently given hash code is not running. If there is still a particle in progress or if
     * there is a cooldown(countdown), the task will not spawn and if {@link Logger#info(String)} is enabled, will output the
     * remaining time length of the countdown.
     * <p>
     * Setting Location. If you are wanting to set the particle to a players location, set the location param to 'null'. This
     * will automatically set the particles location to the players center.
     *
     * @param player get player
     * @param particle get particle
     * @param location get particle location
     * @param designString get particle design
     * @param cooldown get cooldown in seconds
     * @param spawnedTimer get particle spawn rate in seconds
     */
    public void set(Player player, Particle particle, Location location, String designString, int cooldown, int spawnedTimer) { // TODO: Rework particle param
        if (!(System.currentTimeMillis() > getCountdown(player.getUniqueId(), designString))) {
            Main.getReachLogger().info("Count Time  " + getCountdown(player.getUniqueId(), designString));
            Main.getReachLogger().info("System Time " + System.currentTimeMillis());
        } else {
            particles.set(particle);
            particles.setDesignString(designString);
            particles.setPlayer(player);
            particles.setLocation(location);

            PARTICLE_HANDLER = THREAD_EXECUTOR.scheduleAtFixedRate(particles, 0, 250, TimeUnit.MILLISECONDS);

            THREAD_EXECUTOR.schedule(() -> {
                PARTICLE_HANDLER.cancel(true);
            }, spawnedTimer, TimeUnit.SECONDS);

            Main.getReachLogger().info("==============================================================");
            Main.getReachLogger().info("==============================================================");
            Main.getReachLogger().info("Countdown no longer activated, create particle");
            Main.getReachLogger().info("&1Create countdown");
            setCountdown(player.getUniqueId(), designString, cooldown);
            Main.getReachLogger().info("==============================================================");
            Main.getReachLogger().info("Get countdown in milliseconds " + getCountdown(player.getUniqueId(), designString));
            Main.getReachLogger().info("System current time in milliseconds " + System.currentTimeMillis());
            Main.getReachLogger().info("==============================================================");
            Main.getReachLang().send(player, "Countdown activated for " + designString);
            Main.getReachLogger().info("==============================================================");

            if (PARTICLE_HANDLER.isCancelled())
                THREAD_EXECUTOR.shutdown();
        }
    }
}
