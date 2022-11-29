package Sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//Taking every h-th entry yields a sorted subsequence. Array to be h-sorted. h-value from, for example, 364 ... to 1
public class Shell {
    public static <T extends Comparable<T>>  void sort (T[] a) {
        int N = a.length;
        int h =1;
        while (h < N/3) h = 3*h + 1;        // 1, 4, 13, 40, 121, 364, 1093 ..   
        while (h >= 1) {                    // h-sort the array
            for (int i = h; i < N; i++) {   // Insert a[i] among a[i-h], a[i-2h], a[i-3h].. . 
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
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
