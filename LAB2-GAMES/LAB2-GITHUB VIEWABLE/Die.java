package eecs2030.lab2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


/**
 * A class to represent 6-sided dice with possibly non-standard
 * numbering of the faces. A die has 6 faces with each face having
 * an integer value. A die has a current value that is equal to one
 * of the face values (analogous to the uppermost face on a physical
 * die). Rolling a die sets its current value to one of the face
 * values chosen uniformly randomly.
 *
 */
public class Die implements Comparable<Die> {

	/**
	 * A random number generator to simulate rolling the die.
	 * DO NOT CHANGE THE DECLARATION OF rng. THE UNIT TESTS RELY
	 * ON BEGIN ABLE TO ACCESS THE RANDOM NUMBER GENERATOR.
	 */
	Random rng = new Random();
	
	/**
	 * The array of face values.
	 */
	private int[] faces;
	
	
	/**
	 * The current value of the die.
	 */
	private int value;
	
	/**
	 * The number of faces on a die.
	 */
	public static int NUMBER_OF_FACES = 6;
	
	/**
	 * Initializes this die to have the standard numbering of faces
	 * (1, 2, 3, 4, 5, 6) and to have a current value equal to 1.
	 */
	public Die() {
		this.faces = new int[NUMBER_OF_FACES];
		for (int i = 0; i < this.faces.length; i++) {
			this.faces[i] = i + 1;
		}
		this.value = 1;
	}
	
	
	/**
	 * Returns true if the elements in <code>a</code> are in ascending
	 * order.
	 * 
	 * <p>
	 * Specifically, this method returns true if and only if
	 * <code>a[i]</code> is greater than or equal to <code>a[i - 1]</code>
	 * for all indices <code>i</code> greater than 0.
	 * 
	 * @param a a non-empty array
	 * @return true if the elements in a are in ascending order, false
	 * otherwise
	 * @pre. a.length != 0
	 */
	private static boolean isInAscendingOrder(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Initializes this die to have the specified face values and
	 * to have a current value equal to the value of the first face.
	 * The array <code>faces</code> must have length equal to 6 and the
	 * elements must be in ascending order.
	 * 
	 * @param faces an array of 6 face values
	 * @pre. faces.length == 6 and the elements of the array faces must be in
	 * ascending order
	 * @throws IllegalArgumentException if the preconditions are not
	 * satisfied
	 * 
	 */
	public Die(int[] faces) {
		if (faces.length != 6) {
			throw new IllegalArgumentException();
		}
		if (!Die.isInAscendingOrder(faces)) {
			throw new IllegalArgumentException();
		}
		this.faces = Arrays.copyOf(faces, NUMBER_OF_FACES);
		this.value = this.faces[0];
	}
	
	/**
	 * Sets the current value equal to the value of the specified face
	 * index. The faces are indexed with the face having the smallest value
	 * having index <code>0</code> and the face having the greatest value
	 * having index <code>NUMBER_OF_FACES - 1</code>.  
	 * 
	 * @param face a 0-based face index
	 * @pre. face is a valid index for the die
	 * @throws IllegalArgumentException if face is not a valid index
	 * for the die
	 */
	public void setValueToFace(int face) {
		if (face < 0 || face >= NUMBER_OF_FACES) {
			throw new IllegalArgumentException();
		}
		this.value = this.faces[face];
	}
	
	/**
	 * Returns the current value of this die.
	 * 
	 * @return the current value of this die
	 */
	public int value() {
		return this.value;
	}
	
	/**
	 * Rolls the die to a random face changing the value of the die.
	 * 
	 * @return the new value of the die
	 */
	public int roll() {
		int idx = rng.nextInt(Die.NUMBER_OF_FACES);
		this.value = this.faces[idx];
		return this.value;
	}
	
	/**
	 * Compares this die to another die by their current values.
	 * The result is a negative integer if this die has a smaller current
	 * value than the other die, a positive integer if this die has a
	 * greater current value than the the other nickel, and zero otherwise.
	 * 
	 * @return a negative integer, 0, or a positive integer if the current
	 * value of this die is less than, equal to, or greater than, respectively, the 
	 * current value of the other die
	 *  
	 */
	@Override
	public int compareTo(Die other) {
		if (this.value < other.value) {
			return -1;
		}
		else if (this.value > other.value) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Compares this die to the specified object for equality. The
	 * result is true if <code>obj</code> is a die with a current
	 * value equal to the current value of this die and both dice
	 * have identical faces, false otherwise.
	 * 
	 * @return true if obj is a die with a current
	 * value equal to the current value of this die and both
	 * dice have identical faces, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Die other = (Die) obj;
		return this.value() == other.value() && Arrays.equals(this.faces, other.faces);
	}
	
	/**
	 * Returns a hash code for this die.
	 * 
	 * @return a hash code for this die
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.faces);
	}
}
