package net.ezenity.reach.util.particleFx;

import de.slikey.effectlib.EffectManager;
//import de.slikey.effectlib.effect.SphereEffect;
import de.slikey.effectlib.util.MathUtils;
import de.slikey.effectlib.util.VectorUtils;
import net.ezenity.reach.Main;
import net.ezenity.reach.util.Logger;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * This class is a method for implementing particles using a {@link BukkitRunnable} solution.
 */
public class Particles extends BukkitRunnable {
    /**
     *
     */
    private Main plugin = Main.getInstance();
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
     *
     */
    private de.slikey.effectlib.EffectManager effectManager;
    /**
     *
     */
    private final de.slikey.effectlib.EffectLib effectLib = de.slikey.effectlib.EffectLib.instance();

    /**
     * Particles Constructor. Initialize private variables.
     */
    public Particles() {
        this.player = getPlayer();
        this.particle = getParticle();
        this.cancel = isCancelled();
        this.particleDesign = getParticleDesign();
        this.effectManager = getEffectManager();
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
     *
     * @return
     */
    public EffectManager getEffectManager() {
        return effectManager;
    }

    /**
     *
     */
    public void setEffectManager() {
        this.effectManager = new EffectManager(effectLib);
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
            case "heart":
                spawnHeartShape();
//                new SphereEffect();
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

    public int particles;
    public double xRotation;
    public double yRotation;
    public double zRotation;
    public double yFactor;
    public double xFactor;
    public double factorInnerSpike;
    public double compressYFactorTotal;
    public float compilaction;
    /**
     * Spawn star splash particles
     *
     * This first for-loop with determine the
     */
    private void spawnHeartShape() {
//        Particle particle = Particle.DOLPHIN; // Particle type spawned
//        float radius = 2; // Radius of cone
//        float lengthGrow = .05F; // Growing per iteration (0.05)
//        double angularVelocity = Math.PI / 16; // Radials per iteration (PI / 16)
//        int particles = 10; // Cone-particles per iteration (10)
//        float radiusGrow = .002F; // Growth in blocks per iteration (00.2)
//        int particlesCone = 200; // Cone size in particles per cone
//        int step = 0; // Current step. Works as counter
//        boolean randomize = true; // Randomize every cone on start (true)
//        double rotation = 0; // Start-angle or rotation of the cone
//        setEffectManager();
//        de.slikey.effectlib.effect.SphereEffect sphereEffect = new SphereEffect(getEffectManager());

//        sphereEffect.setEntity(getPlayer());
//        sphereEffect.iterations = 15 * 20;
//        sphereEffect.period = 10;
//        sphereEffect.onRun();
//        sphereEffect.start();
/*
 * Sphere Effect
 */
//        this.particle = Particle.DOLPHIN;
//        double radius = 0.6D;
//        double yOffset = 0.0D;
//        int particles = 200;
//        double radiusIncrease = 0.0D;
//
////        if (radiusIncrease != 0.0D) {
////            radius += radiusIncrease;
////        }
//
//        Location playerLoc = getPlayer().getLocation().add(0.0D, yOffset, 0.0D);
//
//        for(int i = 0; i < particles; ++i) {
//            Vector vector = RandomUtils.getRandomVector().multiply(radius);
//            playerLoc.add(vector);
//            player.getWorld().spawnParticle(getParticle(), playerLoc.add(0, 1, 0), 1);
////            playerLoc.subtract(vector);
//        }

        /*
         * heart Effect
         * TODO: Fix heart not rotating.
         */

        this.particle = getParticle();
        this.particles = 50;
        this.zRotation = 0.0D;
        this.yFactor = 1.0D;
        this.xFactor = 1.0D;
        this.factorInnerSpike = 0.8D;
        this.compressYFactorTotal = 2.0D;
        this.compilaction = 2.0F;
        Location location = getPlayer().getLocation();
        Vector vector = new Vector();

        for(int i = 0; i < this.particles; ++i) {
            float alpha = 3.1415927F / this.compilaction / (float)this.particles * (float)i;
            double phi = Math.pow((double)Math.abs(MathUtils.sin(2.0F * this.compilaction * alpha)) + this.factorInnerSpike * (double)Math.abs(MathUtils.sin(this.compilaction * alpha)), 1.0D / this.compressYFactorTotal);
            vector.setY(phi * (double)(MathUtils.sin(alpha) + MathUtils.cos(alpha)) * this.yFactor);
            vector.setZ(phi * (double)(MathUtils.cos(alpha) - MathUtils.sin(alpha)) * this.xFactor);
            VectorUtils.rotateVector(vector, this.xRotation, this.yRotation, this.zRotation);
            player.getWorld().spawnParticle(getParticle(), location.add(vector),2);
            location.subtract(vector);
        }

        Logger.info("&2onRun &f|&7 The Custom Sphere Method works");



//        for (double loopOne = 0; loopOne <= Math.PI; loopOne += Math.PI / 2) {
////            double radius = Math.sin(loopOne);
//            for (double loopTwo = 0; loopTwo < Math.PI * 2; loopTwo += Math.PI / 4) {
//                double y = Math.cos(loopTwo);
//                for (double loopThree = 0; loopThree < Math.PI; loopThree += Math.PI / 8) {
//                    double x = Math.cos(loopThree) * y;
//                    for (double loopFour = 0; loopFour < Math.PI * 2; loopFour += Math.PI / 10) {
//                        double z = Math.sin(loopFour) * radius * y;
//                        Location playerLoc = player.getLocation().add(x, y + 1, z); // '+1' centers to player & '-2' moves particle forward
//                        playerLoc.getWorld().spawnParticle(getParticle(), playerLoc, 1);
//                    }
//                }
//            }
//        }
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

