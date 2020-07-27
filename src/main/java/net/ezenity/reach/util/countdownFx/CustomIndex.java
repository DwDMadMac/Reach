package net.ezenity.reach.util.countdownFx;

import java.util.Objects;

/**
 * This class is used for string manipulation. We can use this class
 * to manipulate two string objects which will return an integer
 * type value, representing the returned index. To see how this class
 * can be implemented through usage, please refer to:
 * {@link Countdown}
 */
public class CustomIndex {
    /**
     * KeyOne String. This field is the first key used for the returned index.
     */
    private final String KeyOne;
    /**
     * KeyTwo String. This field is the seconds key used for the returned index.
     */
    private final String KeyTwo;

    /**
     * The default constructor which will initialize the String fields.
     * @param keyOne set keyOne to field KeyOne
     * @param keyTwo set KeyTwo to field KeyTwo
     */
    public CustomIndex(String keyOne, String keyTwo) {
        this.KeyOne = keyOne;
        this.KeyTwo = keyTwo;
    }

    /**
     * This method determines whether the String object that invokes the method
     * is equal to the object that is passed as an argument. If the method
     * returns True, the arguments are not null and is an object of the same
     * type with the same numeric value.
     *
     * @param o get any object
     * @return True if object is not null with same object types and numeric value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomIndex that = (CustomIndex) o;
        return Objects.equals(KeyOne, that.KeyOne) &&
                Objects.equals(KeyTwo, that.KeyTwo);
    }

    /**
     * This method returns a hash code for keyOne and KeyTwo string.
     *
     * @return hash code value for the two given string objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(KeyOne, KeyTwo);
    }
}
