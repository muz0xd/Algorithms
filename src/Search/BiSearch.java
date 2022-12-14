package Search;

public class BiSearch {
	
	public static int rank (int a[], int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (hi >= lo) {
			int mid = (lo + hi) / 2;
			if (key == a[mid]) return mid;   // key found!
			if (key > a[mid]) lo = mid + 1;  // key isn't in the middle of array, that's why it's in high or low part of array respectively.  
			else hi = mid - 1;
		}
		return -1;
	}
	
	public static void main (String[] args) {
		int[] a = {1, 3, 5, 6, 8, 9, 12};
		int key = 12;
		System.out.print(rank(a, key));
	}
}
