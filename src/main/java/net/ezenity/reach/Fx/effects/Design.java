package net.ezenity.reach.Fx.effects;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.CircleEffect;
import de.slikey.effectlib.effect.ExplodeEffect;

import net.ezenity.reach.Main;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

/**
 * Design Particles.
 * <p>
 * Using a {@link Effect} library to create custom particle designs, along with
 * mathematical equation. to create the desired shape and/or size.
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 1.2.0
 */
public class Design {
    private final Particles particles;

    public Design(Particles particles) {
        this.particles = particles;
    }

    public Particles particles() {
        return particles;
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
    public void basicSphere() {
        for (double circles = 0; circles <= Math.PI; circles += Math.PI / 5) {
            double radius = Math.sin(circles);
            double y = Math.cos(circles);
            for (double particleAmount = 0; particleAmount < Math.PI * 2; particleAmount += Math.PI / 8) {
                double x = Math.cos(particleAmount) * radius;
                double z = Math.sin(particleAmount) * radius;
                Location location = particles().getPlayer().getLocation().add(x, y + 1, z); // '+ 1' after the y-axis will center the sphere around the player
                particles().getPlayer().getWorld().spawnParticle(particles().get(), location, 0);
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
                !particles().get().equals(Particle.REDSTONE) &&
                        !particles().get().equals(Particle.SPELL_MOB) &&
                        !particles().get().equals(Particle.SPELL_MOB_AMBIENT)
        ) {
            Main.getReachLogger().error("doubleSphere &f|&4 " + particles().getPlayer().getDisplayName() + "&7 activated &6'&fdoubleSphere&6'&7 method.");
            Main.getReachLogger().error("doubleSphere &f|&4 " + particles().get().toString() + " &7is not one of the qualifying particles. " +
                    "&7Please user one of the following particles: &6REDSTONE&7, &6SPELL_MOB&7, &6SPELL_MOB_AMBIENT&7.");
            return;
        } else {
            Main.getReachLogger().info("doubleSphere &f|&7 The following particle: &6" + particles.get().toString() + " &7is allowed, continue.");
        }
        final CircleEffect CIRCLE_A = new CircleEffect(particles().getEffectManager());
        final CircleEffect CIRCLE_B = new CircleEffect(particles().getEffectManager());
        /*
         * This will set the particle for each circle.
         */
        CIRCLE_A.particle = particles().get();
        CIRCLE_B.particle = particles().get();
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
        if (particles().getLocation() == null) {
            CIRCLE_A.setEntity(particles().getPlayer());
            CIRCLE_B.setEntity(particles().getPlayer());
        } else {
            CIRCLE_A.setLocation(particles().getLocation());
            CIRCLE_B.setLocation(particles().getLocation());
        }
        /*
         * Start both of the effects
         */
        CIRCLE_A.start();
        CIRCLE_B.start();
    }

    /**
     * Spawn explosion particles
     * <p>
     * This will create an explosion sound along with two identical explosions to display a more
     * dramatic effect. If the location is null the effect will be displayed on the given player
     * and if the location is set then it will be displayed on that set location.
     */
    public void explode() {
        final ExplodeEffect EXPLODE = new ExplodeEffect(particles().getEffectManager());
        /*
         * Can have the option in spawning to different particles. Both particles
         * spawn at the same location and at the same time.
         *
         * TODO: Experiment with color particles to see if we can get some cool results.
         */
        EXPLODE.particle1 = particles().get();
        EXPLODE.particle2 = particles().get();
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
        if (particles().getLocation() == null) {
            EXPLODE.setEntity(particles().getPlayer());
        } else {
            EXPLODE.setLocation(particles().getLocation());
        }
        /*
         * Start the particle effect.
         */
        EXPLODE.start();
    }
}
