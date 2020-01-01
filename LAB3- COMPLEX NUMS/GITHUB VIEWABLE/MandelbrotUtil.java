package eecs2030.lab3;

public class MandelbrotUtil {
	
	private MandelbrotUtil() {
		
	}
	
	
	/**
	 * Return the number of iterations for which z(n + 1) = z(n) * z(n) + c
	 * remains bounded where z(0) = 0 + 0i. z(n + 1) is bounded if its magnitude
	 * is less than or equal to 2. Returns 1 if the magnitude of c
	 * is greater than 2. Returns max if the magnitude
	 * of z(n + 1) is less than or equal to 2 after max iterations.
	 * 
	 * <p>
	 * If z(n + 1) remains bounded after max iterations then c is assumed to
	 * be in the Mandelbrot set.
	 * 
	 * @param c a complex number
	 * @param max the maximum number of iterations to attempt
	 * @return the number of iterations for which z(n + 1) = z(n) * z(n) + c
	 * remains bounded where z(0) = 0.0 + 0.0i. 
	 * @pre. max is greater than 0
	 */
	public static int mandelbrotIterations(Complex c, int max) {
		Complex z = new Complex(0.0, 0.0);
		for (int t = 0; t < max; t++) {
			if (z.mag() > 2.0) {
				return t;
			}
			z = z.multiply(z).add(c);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Complex c = new Complex(0.0, 5.0);
		System.out.println(mandelbrotIterations(c, 100));
	}
}
