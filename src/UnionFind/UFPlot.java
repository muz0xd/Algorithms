package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdDraw;

public class UFPlot {
	
	private List<UFind> uf;
			
	public UFPlot (int n) {
	  uf = new ArrayList<UFind>();
	  uf.add(new QuickFindUF(n));           //0
	  uf.add(new QuickUnionUF(n));          //1
	  uf.add(new QuickWeightedUF(n));       //2
	}
	
	public void printGraph() {
	  StdDraw.setScale(0, 1300);
	  StdDraw.line(10, 10, 10, 1200);
	  StdDraw.line(10, 10, 1200, 10);
	  StdDraw.setPenRadius(0.005);
	}
	
	public static void main(String[] args) {
	  int n = StdIn.readInt();
	  UFPlot plot = new UFPlot(n);
	  UFind UfEntity;
	  plot.printGraph();
	  
	  try {
	    UfEntity = plot.uf.get(0);  // algorithm select 
	  }
	  catch (ClassCastException e) {
	    throw new ClassCastException("UFind: Inappropriate cast to specific type");
	  }
	  catch (IndexOutOfBoundsException e) {
	    throw new IndexOutOfBoundsException("no such index in algorithm list");
		}
	  
	  while (!StdIn.isEmpty()) {
	    int p, q;
	    
	    try {
	      p = StdIn.readInt();
	      q = StdIn.readInt();
	    }
	    catch (NoSuchElementException e) {
	      throw new NoSuchElementException("Mo more int elements are avialable");
	    }
	    
	    if (!UfEntity.connected(p, q)) {
	      UfEntity.union(p, q);
	      StdDraw.setPenColor(UfEntity.getColor());
	      StdDraw.point(UfEntity.getI() + 10, UfEntity.getCost() + 10);  // number of array accesses
	    }
	    
	    StdDraw.setPenColor(StdDraw.GREEN);	
	    StdDraw.point(UfEntity.getI() + 10, 
	        (double) UfEntity.getTotal()/UfEntity.getI() + 10);  // average number of array accesses 
	    //System.out.println(UfEntity.getI() + "," + 
	    //UfEntity.getCost() + ","+ UfEntity.getTotal()/UfEntity.getI());
	  }
	}
}
