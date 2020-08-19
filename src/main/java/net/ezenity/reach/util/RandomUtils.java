package net.ezenity.reach.util;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Random Utilities. This class is framework for creating random objects.
 *
 * @author anthonymmacallister
 * @version 1.0.0
 */
public final class RandomUtils {
    /**
     * Static Random. Gets a random system time in nano seconds.
     */
    public static final Random random = new Random(System.nanoTime());

    /**
     * Constructor. Utilized for creating new objects.
     */
    private RandomUtils() {}

    /**
     * Gets a random vector location.
     * <p>
     * Normalize a vector with x, y, z elements. Each location will find a random double
     * and then mutliply that by 2 and finally minus it by 1.
     *
     * @return random vector location for x, y, z
     */
    public static Vector getRandomVector() {
        double x = random.nextDouble() * 2.0D - 1.0D;
        double y = random.nextDouble() * 2.0D - 1.0D;
        double z = random.nextDouble() * 2.0D - 1.0D;
        return (new Vector(x, y, z)).normalize();
    }

    /**
     * Get random circle vector.
     *
     * To get circles in random locations we use a portion of PI and multiple that by 2
     * and a random double. This amount is applied to the x and y coordinates, whereas
     * x coordinates returns the cosine of its angle and z coordinates returns the sine
     * of its angle. We leave the y coordinates set to 0.
     *
     * @return random circle vectors
     */
    public static Vector getRandomCircleVector() {
        double rnd = random.nextDouble() * 2.0D * 3.14159_26535_89793D;
        double x = Math.cos(rnd);
        double z = Math.sin(rnd);
        return new Vector(x, 0.0D, z);
    }

    /**
     * Random materials.
     *
     * This will get random materials. This is a good usage for applying flashing random items
     * inside a custom portal.
     *
     * @param materials get an array of materials.
     * @return random materials in the order it is perceived.
     */
    public static Material getRandomMaterial(Material[] materials) {
        return materials[random.nextInt(materials.length)];
    }

    /**
     * Random Angel.
     *
     * This method will get a random angel based off of portion of PI
     *
     * @return random angel.
     */
    public static double getRandomAngle() {
        return random.nextDouble() * 2.0D * 3.141592653589793D;
    }
}
