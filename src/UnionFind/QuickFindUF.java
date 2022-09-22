package UnionFind;

import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;

public class QuickFindUF implements UFind{
	public Color color = StdDraw.BLUE;
	private int cost;
	private int total;
	private int i;
	private int[] id;  
	private int count;     // number of components

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each element is in its own set.
     *
     * @param  n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickFindUF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param  p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
    	validate(p);
    	cost++;
        return id[p];
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }
  
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
    public boolean connected(int p, int q) {
    	boolean res = (find(p) == find(q));
    	i++;
    	cost = 0;
    	return res;
    }
  
    /**
     * Merges the set containing element {@code p} with the 
     * the set containing element {@code q}.
     *
     * @param  p one element
     * @param  q the other element
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
    	cost = 0;
     	int pID = id[p];
    	int qID = id[q];
    	cost += 2;
     	if (pID == qID) return;
     	for (int i = 0; i < id.length; i++) {
     		cost++;
			if (id[i] == pID) {
				id[i] = qID;
				cost++;	
			}
     	}
     	total += cost;
     	count--;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    }

	public int getCost() {
		return cost;
	}

	public int getTotal() {
		return total;
	}

	public int getI() {
		return i;
	}
	
	public Color getColor() {
		return color;
	}
}
