package Sort;

import java.lang.Comparable;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
    
	public static <T extends Comparable<T>>  void sort (T[] a) {
	  int N = a.length;
	  for (int i = 0; i < N; i++) {
	    int min = i;
	    for (int j = i+1; j < N; j++)
	      if (less(a[j], a[min])) min = j;
	    exch(a, i, min);
		};
	}

	private static <T extends Comparable<T>> boolean less (T v, T w) {
	  return v.compareTo((T) w) < 0;
	}
	
	private static <T extends Comparable<T>> void exch (T[] a, int i, int min) {
	  T t = a[i];
	  a[i] = a[min];
	  a[min] = t;
	}
	
	private static <T extends Comparable<T>> void show (T[] a) {
	  for (int i = 0; i < a.length; i++) 
	    StdOut.print(a[i] + " ");
	  StdOut.println();
	}
	
	public static <T extends Comparable<T>> boolean isSorted (T[] a) {
	  for (int i = 0; i < a.length; i++)
	    if (less(a[i], a[i+1])) return false;
	  return true;
	}
	
	public static void main(String[] args) {
	  String[] a = new In().readAllStrings();
	  sort(a);
	  assert isSorted(a);
	  show(a);
	}
}