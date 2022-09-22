package UnionFind;

import java.awt.Color;

public interface UFind {

	/**
	 * Returns the canonical element of the set containing element {@code p}.
	 *
	 * @param  p an element
	 * @return the canonical element of the set containing {@code p}
	 * @throws IllegalArgumentException unless {@code 0 <= p < n}
	 */
	int find(int p);

	/**
	 * Returns the number of sets.
	 *
	 * @return the number of sets (between {@code 1} and {@code n})
	 */
	int count();

	/**
	 * Returns true if the two elements are in the same set.
	 *
	 * @param  p one element
	 * @param  q the other element
	 * @return {@code true} if {@code p} and {@code q} are in the same set;
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException unless
	 *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	boolean connected(int p, int q);

	/**
	 * Merges the set containing element {@code p} with the 
	 * the set containing element {@code q}.
	 *
	 * @param  p one element
	 * @param  q the other element
	 * @throws IllegalArgumentException unless
	 *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	void union(int p, int q);
	
	public int getCost();

	public int getTotal();

	public int getI();
	
	public Color getColor();

}