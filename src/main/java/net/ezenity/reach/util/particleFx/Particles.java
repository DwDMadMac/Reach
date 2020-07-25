package net.ezenity.reach.util.particleFx;

import net.ezenity.reach.util.Logger;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This class is a method for implementing particles using a {@link BukkitRunnable} solution.
 */
public class Particles extends BukkitRunnable {
    /**
     * Player. Used to get player UUID.
     */
    private final Player player;
    /**
     * Particle. Used to grab the particle enums.
     */
    private Particle particle;
    /**
     * Cancel. This boolean is used to cancel the runnable.
     */
    private boolean cancel;
    /**
     * Particle Design. This String is used to determine the type of particle designed.
     */
    private String particleDesign;


    /**
     * Gets the player that enabled the particle and set the particle that is configured
     * inside the config file.
     *
     * @param player get player who enabled particle
     * @param particle spawned particle
     */
    public Particles(Player player, Particle particle, String particleDesign) {
        this.player = player;
        setParticleDesign(particleDesign);
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

    /**
     * This method will get the given string particle design. Each particle design is created within its own
     * method using mathematical computation. The sole purpose of this method is used within a switch statement
     * to ensure that the correct particle design is selected with the runnable is activated.
     *
     * @return particle design
     */
    public String getParticleDesign() {
        return particleDesign;
    }

    /**
     * This method is used to set the given string particle design. When a new particle object is created, this
     * method is implemented with the given particle design string.
     *
     * @param particleDesign set particle design
     */
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
    private boolean stopClientCrash() {
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
     * Run the given particle type using a switch statement. If a particle type that is known
     * to crash the client, the runnable will cancel and and error message will be outputted
     * to the console.
     */
    @Override
    public void run() {
        if (stopClientCrash()){
            Logger.error("This particle is known to crash clients.");
            Logger.error("Cancelling particle spawning!");
            cancel();
            return;
        }

        switch (getParticleDesign()) {
            case "sphere":
                spawnSphere();
                break;
            case "test":
                spawnOval(); // TODO
                break;
            default:
                break;
        }
    }

    /*
     * INFO:
     *  Radius:
     *      - Half the distance of the diameter (Distance from center of the circle to edge)
     *  Diameter: 2 * radius
     *      - The distance inside the circle from one end to the other
     *  Circumference: 2 * PI * radius
     *      - The line that makes the shape
     *  Area: PI * radius * radius  (Formal: PIr2)
     *      -
     */
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

    /**
     * TODO
     */
    private void spawnOval() {
        for (double circles = 0; circles <= Math.PI; circles += Math.PI / 10) {
            double radius = Math.sin(circles);
            double y = Math.cos(circles);
            for (double particleAmount = 0; particleAmount < Math.PI * 2; particleAmount += Math.PI / 4) {
                double x = Math.cos(particleAmount) * radius;
                double z = Math.sin(particleAmount) * radius;
                Location playerLoc = player.getLocation().add(x, y, z);
                player.getWorld().spawnParticle(getParticle(), playerLoc.add(0, 1, 0), 1);
            }
        }
    }
}

