package eecs2030.lab1;

/**
 * A class that represents a windowed view of Hounsfield units. A Hounsfield
 * window is defined by two values: (1) the window level, and (2) the window
 * width. The window level is the Hounsfield unit value that the window is
 * centered on. The window width is the range of Hounsfield unit values that the
 * window is focused on.
 * 
 * <p>
 * A window has a lower and upper bound. The lower bound is defined as the
 * window level minus half the window width:
 * 
 * <p>
 * lo = level - (width / 2)
 * 
 * <p>
 * The upper bound is defined as the window level plus half the window width:
 * 
 * <p>
 * hi = level + (width / 2)
 * 
 * <p>
 * Hounsfield units are mapped by the window to a real number in the range of
 * {@code 0} to {@code 1}. A Hounsfield unit with a value less than lo is mapped
 * to the value {@code 0}. A Hounsfield unit with a value greater than hi is
 * mapped to the value {@code 1}. A Hounsfield unit with a value v between lo
 * and hi is mapped to the value:
 * 
 * <p>
 * (v - lo) / width
 * 
 *
 */
public class HounsfieldWindow {

	/**
	 * The window level
	 */
	private int level;

	/**
	 * The window width
	 */
	private int width;

	/**
	 * The lower bound of this window
	 */
	private double lo;

	/**
	 * The upper bound of this window
	 */
	private double hi;

	/**
	 * Initializes this window to have a level of {@code 0} and a width of
	 * {@code 400}.
	 */
	public HounsfieldWindow() {
		this(0, 400);
	}

	/**
	 * Initializes this window to have the specified level and width.
	 * 
	 * @param level the level of this window
	 * @param width the width of this window
	 * @throws IllegalArgumentException if level is less than Hounsfield.MIN_VALUE
	 *                                  or if level is greater than
	 *                                  Hounsfield.MAX_VALUE
	 * @throws IllegalArgumentException if width is less than 1
	 */
	public HounsfieldWindow(int level, int width) {
		this.setLevel(level);
		this.setWidth(width);
	}

	/**
	 * Returns the level of this window.
	 * 
	 * @return the level of this window
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Returns the width of this window.
	 * 
	 * @return the width of this window
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the lower and upper bounds of this window based on the window level and
	 * window width.
	 */
	private void setBounds() {
		this.lo = this.level - 0.5 * this.width;
		this.hi = this.level + 0.5 * this.width;
	}

	/**
	 * Sets the level of this window to the specified value returning the value that
	 * was overwritten.
	 * 
	 * @param level the level of this window
	 * @return the overwritten value of the window level
	 * @throws IllegalArgumentException if level is less than Hounsfield.MIN_VALUE
	 *                                  or if level is greater than
	 *                                  Hounsfield.MAX_VALUE
	 */
	public int setLevel(int level) {
		if (level < Hounsfield.MIN_VALUE) {
			throw new IllegalArgumentException("level is less than Hounsfield.MIN_VALUE");
		}
		if (level > Hounsfield.MAX_VALUE) {
			throw new IllegalArgumentException("level is greater than Hounsfield.MAX_VALUE");
		}
		int oldLevel = this.level;
		this.level = level;
		this.setBounds();
		return oldLevel;
	}

	/**
	 * Sets the width of this window to the specified value returning the value that
	 * was overwritten.
	 * 
	 * @param width the width of this window
	 * @return the overwritten value of the window width
	 * @throws IllegalArgumentException if width is less than 1
	 */
	public int setWidth(int width) {
		if (width < 1) {
			throw new IllegalArgumentException("width is less than 1");
		}
		int oldWidth = this.width;
		this.width = width;
		this.setBounds();
		return oldWidth;
	}

	/**
	 * Maps the value of the specified Hounsfield unit to a value between zero and
	 * one; see the class description for details.
	 * 
	 * @param h a Hounsfield unit
	 * @return a value betwee 0 and 1
	 */
	public double map(Hounsfield h) {
		double result = 0.0;
		int val = h.get();
		if (val < this.lo) {
			result = 0.0;
		} else if (val > this.hi) {
			result = 1.0;
		} else {
			result = (val - this.lo) / this.width;
		}
		return result;
	}
	
	
}
