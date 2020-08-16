package net.ezenity.reach.util.particleFx;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.CircleEffect;
import de.slikey.effectlib.effect.ExplodeEffect;
import net.ezenity.reach.Main;
import net.ezenity.reach.util.Logger;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This class is a method for implementing particles using a {@link BukkitRunnable} solution.
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
    private String particleDesign;
    /**
     * Particle Location. This will set the location for the given particle that is going to be spawned.
     */
    private Location location;

    /**
     * Particles Constructor. Initialize private variables.
     */
    public Particles() {
        this.player = getPlayer();
        this.particle = getParticle();
        this.cancel = isCancelled();
        this.particleDesign = getParticleDesign();
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
     * This will set the given particle type. If the particle type is invalid, print stacktrace & the particle
     * event will be cancelled.
     *
     * @param particle get particle type
     */
    public void setParticle(Particle particle) {
        try {
            this.particle = particle;
        } catch (IllegalArgumentException e){
            Logger.error("onParticles | Particle type invalid. Cancelling Particle task. Printstack below");
            e.printStackTrace();
            setCancel(true);
        }
    }

    /**
     * Initialize an {@link EffectManager} to the 'Reach' plugin.
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
     * Get the location of the spawned particle.
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
     * inside the {@link #doubleSphere()} method.
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
            case "basicSphere":
                basicSphere();
                break;
            case "doubleSphere":
                doubleSphere();
                break;
            case "explode":
                explodeEffect();
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
    private void basicSphere() {
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
     * Spawn double sphere shape particles
     *
     * This will allow you to spawn two circles at the same time. Due to being only able to change the color
     * of three available particles as of 1.8, this particle design will be limited to the following
     * particles:
     * <ul>
     *     <li>REDSTONE</li>
     *     <li>SPELL_MOB</li>
     *     <li>SPELL_MOB_AMBIENT</li>
     * </ul>
     */
    public void doubleSphere() {
        if (
            !getParticle().equals(Particle.REDSTONE) &&
            !getParticle().equals(Particle.SPELL_MOB) &&
            !getParticle().equals(Particle.SPELL_MOB_AMBIENT)
        ) {
            Logger.error("doubleSphere &f|&4 " + getPlayer().getDisplayName() + "&7 activated &6'&fdoubleSphere&6'&7 method.");
            Logger.error("doubleSphere &f|&4 " + getParticle().toString() + " &7is not one of the qualifying particles. " +
                    "&7Please user one of the following particles: &6REDSTONE&7, &6SPELL_MOB&7, &6SPELL_MOB_AMBIENT&7.");
            return;
        } else {
            Logger.info("doubleSphere &f|&7 The following particle: &6" + getParticle().toString() + " &7is allowed, continue.");
        }
        final CircleEffect CIRCLE_A = new CircleEffect(getEffectManager());
        final CircleEffect CIRCLE_B = new CircleEffect(getEffectManager());
        /*
         * This will set the particle for each circle.
         */
        CIRCLE_A.particle = getParticle();
        CIRCLE_B.particle = getParticle();
        /*
         * INSTANT: Makes a circle ring
         * REPEATING: Makes a full circle
         */
        CIRCLE_A.type = EffectType.REPEATING;
        CIRCLE_B.type = EffectType.REPEATING;
        /*
         * The circle radius start to lag after 3.0F
         */
        CIRCLE_A.radius = 1.8F;
        CIRCLE_B.radius = 1.8F;
        /*
         * Determine the amount of particles that will spawn within
         * the circle.
         */
        CIRCLE_A.particles = 2;
        CIRCLE_B.particles = 2;
        /*
         * Makes circle complete. 'False' will give a ring circle
         * and depending on the 'zRotation' setting will determine
         * the location of the ring circles.
         *
         * Making this setting hardcoded so that it may not be
         * altered.
         */
        CIRCLE_A.wholeCircle = true;
        CIRCLE_B.wholeCircle = true;
        /*
         * This ensures that the circle is created. Without the
         * rotation enabled the circle does not fill, regardless
         * of the 'wholeCircle' settings.
         *
         * Making this setting hardcoded so that it may not be
         * altered.
         */
        CIRCLE_A.enableRotation = true;
        CIRCLE_B.enableRotation = true;
        /*
         * I am not sure what this does, nothing different happens when I try
         * different values.
         */
        CIRCLE_A.iterations = 50;
        CIRCLE_B.iterations = 50;
        /*
         * This is to be worked with EffectType.REPEATING.
         * This will slow down the completion of the circle.
         * DEFAULT: 2
         */
        CIRCLE_A.period = 2;
        CIRCLE_B.period = 2;
        /*
         * Change the color of the particle
         */
        CIRCLE_A.color = Color.GREEN;
        CIRCLE_B.color = Color.BLUE;
        /*
         * Ensures that the circles do not cross each other
         */
        CIRCLE_A.zRotation = 1.5D;
        CIRCLE_B.zRotation = 0.0D;
        /*
         * TODO: Make config so that this effect can be applied to other objects
         *
         * Apply the circle to an entity. Do not use Dynamic Location; causes player
         * to lag and makes everything really sluggish.
         */
        if (getLocation() == null) {
            CIRCLE_A.setEntity(getPlayer());
            CIRCLE_B.setEntity(getPlayer());
        } else {
            CIRCLE_A.setLocation(getLocation());
            CIRCLE_B.setLocation(getLocation());
        }
        /*
         * Start both of the effects
         */
        CIRCLE_A.start();
        CIRCLE_B.start();
    }



    /**
     * Spawn explosion particles
     */
    private void explodeEffect() {
        ExplodeEffect EXPLODE = new ExplodeEffect(getEffectManager());
        /*
         * Can have the option in spawning to different particles. Both particles
         * spawn at the same location and at the same time.
         *
         * TODO: Experiment with color particles to see if we can get some cool results.
         */
        EXPLODE.particle1 = getParticle();
        EXPLODE.particle2 = getParticle();
        /*
         * Amount of exploding particles to display in total
         */
        EXPLODE.amount = 10;
        /*
         * The explosion sound explodes 5 times. Use that as a reference for potentially
         * other sounds with out experiments.
         */
        EXPLODE.sound = Sound.ENTITY_GENERIC_EXPLODE;
        /*
         * Leave as is, we want the explosion to be right away.
         */
        EXPLODE.type = EffectType.INSTANT;
        /*
         * Default: 0.5F
         *
         * How fast to output the particles. Cannot use this with the particles we can color.
         * Since it is deprecated, not sure how much longer this will be available for.
         */
        EXPLODE.speed = 0.2F;
        /*
         * If the location is not set then it will fall back to spawning the particle on the
         * players center location.
         */
        if (getLocation() == null) {
            EXPLODE.setEntity(getPlayer());
        } else {
            EXPLODE.setLocation(getLocation());
        }
        /*
         * Start the particle effect.
         */
        EXPLODE.start();
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
//
//        for (double polarAngle = 0.0; polarAngle < 360.0; polarAngle = polarAngle + 10.0){
//            for (double elevationAngle = 0.0; elevationAngle < 180.0; elevationAngle = elevationAngle + 59.0){
//                double dx = radius * Math.sin(Math.toRadians(elevationAngle)) * Math.cos(Math.toRadians(polarAngle));
//                double dy = radius * Math.sin(Math.toRadians(elevationAngle)) * Math.sin(Math.toRadians(polarAngle));
//                double dz = radius * Math.cos(Math.toRadians(elevationAngle));
////                location = player.getLocation().add(dx,dy,dz);
////                player.getWorld().spawnParticle(getParticle(), location.add());
//                player.getWorld().spawnParticle(getParticle(), location, 1, dx, dy, dz);
//            }
//        }
    }

    public void getDesign(Player player, String particleDesign) {
        if (particle.equals(Particle.DOLPHIN) && particleDesign.equalsIgnoreCase("sphere")) { // Sphere
            /*
             * New sphere Design
             */
//            coordinates = new double[11 + 10 * 2][];
//            int arrayLocation = 0;
//
//            double y = player.getLocation().getY();
//            double x = player.getLocation().getX();
//            double z = player.getLocation().getZ();
//
//
//
//            for (double coord : coordinates[arrayLocation++]){
//                coord = new double[] {x, y, z};
//                Location playerLoc = player.getLocation().add(coord);
//                player.spawnParticle(getParticle(), player.getLocation(coord));
//            }


            /*
             * Old sphere design
             */
            for (double i = 0; i <= Math.PI; i += Math.PI / 10) { // Last digit being amount of circles
                double radius = Math.sin(i);
                double y = Math.cos(i);
                for (double a = 0; a < Math.PI * 2; a += Math.PI / 60) {
                    double x = Math.cos(a) * radius;
                    double z = Math.sin(a) * radius;

//                    player.getWorld().spawnParticle(getParticle(), player.getLocation().clone().add(x,y,z), 1);
                    Location playerLoc = player.getLocation().add(x, y, z);
                    player.spawnParticle(getParticle(), playerLoc.add(0, 1, 0), 1);
                    player.getLocation().subtract(x, y, z);
                }
            }
        } else  if (particle.equals(Particle.PORTAL) && particleDesign.equalsIgnoreCase("treeSpawner")) { // Tree Spawner
            for (double i = 0; i <= Math.PI; i += Math.PI / 10){
                double radius = Math.sin(i);
                double y = Math.cos(i);
                for (double a = 0; a < Math.PI * 2; a += Math.PI / 4){
                    double x = Math.cos(a) * radius;
                    double z = Math.sin(a) * radius;
                    Location playerLoc = player.getLocation().add(x,y,z);
                    player.getWorld().spawnParticle(getParticle(), playerLoc.add(0,1,0), 1);
                }
            }
        }
    }
}

