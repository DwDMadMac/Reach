package net.ezenity.reach.Fx.effects;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;

import net.ezenity.reach.Main;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This class is a method for implementing particles using a {@link BukkitRunnable} solution.
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 1.0.0
 */
public class Particles extends BukkitRunnable {
    /**
     * Initialize plugin instance. We use this to initialize an {@link EffectManager} on
     * the fly with each particle effect. This allow a more dynamic approach, rather than
     * creating an effect manager on plugin load. Since effects are going to run purely
     * on a per usage approach, this is more ideal.
     */
    private final Main plugin = Main.getInstance();
    /**
     * Player. Used to get player UUID.
     */
    private Player player;
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
    private String designString;
    /**
     * Particle Location. This will set the location for the given particle that is going to be spawned.
     */
    private Location location;
    /**
     * Design particles. This field is the designing of all particles that are being spawned, which uses
     * {@link Effect} library to creates its types and properties.
     */
    private final Design design = new Design(this);

    /**
     * Particles Constructor. Initialize private variables.
     */
    public Particles() {
        this.player = getPlayer();
        this.particle = get();
        this.cancel = isCancelled();
        this.designString = getDesignString();
        this.location = getLocation();

        getEffectManager();
    }

    /**
     * Get the player that enabled the particle.
     *
     * @return player that enabled particle.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the particle to the player initializing the particle
     *
     * @param player set player to particle
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * This method will get the given string particle design. Each particle design is created within its own
     * method using mathematical computation. The sole purpose of this method is used within a switch statement
     * to ensure that the correct particle design is selected with the runnable is activated.
     *
     * @return particle design
     */
    public String getDesignString() {
        return designString;
    }

    /**
     * This method is used to set the given string particle design. When a new particle object is created, this
     * method is implemented with the given particle design string.
     *
     * @param particleDesign set particle design
     */
    public void setDesignString(String particleDesign) {
        this.designString = particleDesign;
    }

    /**
     * Get the particle type from the {@link Particle} enum list.
     *
     * @return particle type
     */
    public Particle get() {
        return particle;
    }

    /**
     * This will set the given particle type. If the particle type is invalid, print stacktrace and the particle
     * event will be cancelled.
     *
     * @param particle get particle type
     */
    public void set(Particle particle) {
        try {
            this.particle = particle;
        } catch (IllegalArgumentException e){
            Main.getReachLogger().error("onParticles | Particle type invalid. Cancelling Particle task. Print Stacktrace below");
            e.printStackTrace();
            setCancel(true);
        }
    }

    /**
     * Initialize an {@link EffectManager} to the 'Reach' plugin. This is used inline with particle designs.
     *
     * @return plugin effect manager
     */
    public EffectManager getEffectManager() {
        return new EffectManager(plugin);
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
     * Get the location of the spawned particle, so that it may spawn the particles are proper given location.
     *
     * @return spawned particle location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location for the spawning particle. This is mainly used for setting a particle
     * to anything other than an entity. If wanting to spawn a particle to an entity, I
     * suggest using {@link #getPlayer()} method while using the
     * {@link de.slikey.effectlib.Effect#setEntity(Entity)} method. You can see and example
     * inside the {@link Design#doubleSphere()} method.
     *
     * @param location set particle to location.
     */
    public void setLocation(Location location) {
        this.location = location;
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
        switch (get()) {
            case ITEM_CRACK:
            case BLOCK_CRACK:
            case BLOCK_DUST:
                return true;
            default:
                return false;
        }
    }

    /**
     * Make cancel true for the particle task that is currently running.
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
            Main.getReachLogger().error("This particle is known to crash clients.");
            Main.getReachLogger().error("Cancelling particle spawning!");
            cancel();
            return;
        }

        switch (getDesignString()) {
            case "basicSphere":
                design.basicSphere();
                break;
            case "doubleSphere":
                design.doubleSphere();
                break;
            case "explode":
                design.explode();
                break;
            default:
                break;
        }
    }
}

