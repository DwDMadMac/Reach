package net.pl3x.reach.util.particleFx;

import net.pl3x.reach.Main;
import net.pl3x.reach.util.Logger;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Particles extends BukkitRunnable {
    private final Player player;
    private Particle particle;
    private boolean cancel;
    private Main plugin = Main.getInstance();
    private String particleDesign;
    // Sphere Design
    private double[][] coordinates;


    /**
     * Gets the player that enabled the particle and set
     * the particle that is configured inside the config
     * file.
     *
     * @param player get player who enabled particle
     * @param particle spawned particle
     */
    public Particles(Player player, Particle particle, String particleDesign) {
        this.player = player;
        this.particleDesign = particleDesign;
        Particle particleType = null;

        try {
            particleType = particle;
        } catch (IllegalArgumentException e){
            Logger.error("onParticles | Particle type invalid. Cancelling Particle task. Printstack below");
            e.printStackTrace();
            setCancel(true);
        }
        setParticle(particleType);
    }

    public String getParticleDesign() {
        return particleDesign;
    }

    public void setParticleDesign(String particleDesign) {
        this.particleDesign = particleDesign;
    }

    /**
     * Get the particle type
     *
     * @return particle type
     */
    public Particle getParticle() {
        return particle;
    }

    /**
     * This will set the given particle type
     *
     * @param particle get particle type
     */
    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    /**
     * Check to see if the particle type is cancelled
     *
     * @return true if cancelled or false if not cancelled
     */
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Set particle to true or false to enabled
     * or disable the particle task
     *
     * @param cancel cancel particle, true or false
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Check for the particle types. This will ensure
     * that the client will not crash. If a user tries
     * to use one of the given particle types it will
     * stop the particle and prevent the client from
     * crashing.
     *
     * @return true or false depending on particle type
     */
    public boolean stopClientCrash() {
        switch (getParticle()) {
            case ITEM_CRACK:
            case BLOCK_CRACK:
            case BLOCK_DUST:
                return true;
            default:
                return false;
        }
    }

    /**
     * Make cancel true
     */
    @Override
    public void cancel() {
        cancel = true;
        super.cancel();
    }

    /**
     * Run the given particle type
     */
    @Override
    public void run() {
        if (stopClientCrash()){
            Logger.error("This particle is known to crash clients.");
            Logger.error("Cancelling particle spawning!");
            cancel();
            return;
        }

        switch (particleDesign) {
            case "sphere":
                spawnSphere();
                break;
            case "test":
//                spawnShape(); // TODO
                break;
            default:
                break;
        }
    }

    /**
     * Spawn sphere shape particles
     *
     * This first for-loop will determine the amount of circles you are
     * wanting to surround the player with. You can change this amount
     * by altering the last digit within the for-loop. Careful not to
     * increase the amount of circles to high which will cause the player
     * to lag a bit. Using amount 1 - 100 seem to be okay. Use at your
     * own discretion.
     *
     * The second for-loop will determine the amount of particles that
     * will spawn within the circle around the player. You can change
     * this amount by altering the last digit within the for-loop.
     * Increasing this number can make it appear as the circle (ring)
     * around the player is solid. Increasing this number may also
     * create lag for the players around the spawned particle.
     */
    private void spawnSphere() {
        for (double circles = 0; circles <= Math.PI; circles += Math.PI / 5) {
            double radius = Math.sin(circles);
            double y = Math.cos(circles);
            for (double particleAmount = 0; particleAmount < Math.PI * 2; particleAmount += Math.PI / 8) {
                double x = Math.cos(particleAmount) * radius;
                double z = Math.sin(particleAmount) * radius;
                Location location = player.getLocation().add(x, y + 1, z); // '+ 1' after the y-axis will center the sphere around the player
                player.getWorld().spawnParticle(getParticle(), location, 0);
            }
        }
    }
}
