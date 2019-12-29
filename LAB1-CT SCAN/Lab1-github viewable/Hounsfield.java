package eecs2030.lab1;

/**
 * A class that represents a Hounsfield unit. Hounsfield units are the units of
 * measurement used in computed tomography (CT or CAT) scanning.
 * 
 * <p>
 * The Hounsfield scale is defined by specifying the radiodensity of air as
 * {@code -1000} Hounsfield units and the radiodensity of distilled water as
 * {@code 0} Hounsfield units. Adjacent tissues in the human body can be
 * distinguished from one another if their radiodensities differ; see
 * <a href="https://en.wikipedia.org/wiki/Hounsfield_scale">the Wikipedia
 * page</a> for a table of typical Hounsfield values for tissues of the
 * human body.
 * 
 * <p>
 * CT scanners for medical purposes typically restrict the value of reported
 * Hounsfield units to integers in the range {@code -1024} to {@code 3072} so
 * that a Hounsfield unit can be encoded as a 12-bit value. This class uses
 * the values {@code -1024} and {@code 3072} to represent the minimum and
 * maximum, respectively, allowable Hounsfield unit values.
 *
 */
public class Hounsfield {

	/**
	 * The integer value of this Hounsfield unit
	 */
	private int value;

	/**
	 * The minimum Hounsfield unit reported by medical CT scanners
	 */
	public static final int MIN_VALUE = -1024;

	/**
	 * The maximum Hounsfield unit reported by medical CT scanners
	 */
	public static final int MAX_VALUE = MIN_VALUE + 4096 - 1;

	/**
	 * Initializes this Hounsfield unit to have a value of zero.
	 */
	public Hounsfield() {
		this.value = 0;
	}

	/**
	 * Initializes this Hounsfield unit to have the specified value.
	 * 
	 * @param value
	 *            the value of this Hounsfield unit
	 * @throws IllegalArgumentException
	 *             if {@code value} is less than the minimum Hounsfield unit
	 *             reported by medical CT scanners or greater than the maximum
	 *             Hounsfield unit reported by medical CT scanners
	 */
	public Hounsfield(int value) {
		this.set(value);
	}

	/**
	 * Initializes this Hounsfield unit by copying the value from the specified
	 * other Hounsfield unit.
	 * 
	 * @param other
	 *            the Hounsfield unit to copy the value from
	 */
	public Hounsfield(Hounsfield other) {
		this.value = other.value;
	}

	/**
	 * Throws an {@code IllegalArgumentException} if the specified value is less
	 * than the minimum Hounsfield unit reported by medical CT scanners or
	 * greater than the maximum Hounsfield unit reported by medical CT scanners.
	 * 
	 * @param value
	 *            a value to check
	 * @throws IllegalArgumentException
	 *             if the specified value is less than the minimum Hounsfield
	 *             unit reported by medical CT scanners or greater than the
	 *             maximum Hounsfield unit reported by medical CT scanners.
	 */
	private static void checkValue(int value) {
		if (value < Hounsfield.MIN_VALUE) {
			throw new IllegalArgumentException("value " + value + 
					" is less than Hounsfield.MIN_VALUE");
		}
		if (value > Hounsfield.MAX_VALUE) {
			throw new IllegalArgumentException("value " + value + 
					" is greater than Hounsfield.MAX_VALUE");
		}

	}

	/**
	 * Returns the value of this Hounsfield unit.
	 * 
	 * @return the value of this Hounsfield unit
	 */
	public int get() {
		return this.value;
	}

	/**
	 * Sets the value of this Hounsfield unit to the specified value returning
	 * the value that was overwritten.
	 * 
	 * @param value
	 *            the value to set this Hounsfield unit to
	 * @return the overwritten value of this Hounsfield unit
	 * @throws IllegalArgumentException
	 *             if the specified value is less than the minimum Hounsfield
	 *             unit reported by medical CT scanners or greater than the
	 *             maximum Hounsfield unit reported by medical CT scanners.
	 */
	public int set(int value) {
		Hounsfield.checkValue(value);
		int oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	/**
	 * Returns a string representation of this Hounsfield unit. The returned
	 * string is the numeric value of this Hounsfield unit (formatted as an
	 * integer) followed by a space followed by the string {@code "HU"}.
	 */
	@Override
	public String toString() {
		return "" + this.value + " HU";
	}
}
