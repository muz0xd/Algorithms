package Service;

public class Stopwatch {
    private final long start;
    
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    
    public double elapsedTime() {
        long current = System.currentTimeMillis();
        return (start - current)/1000.0; // in seconds
    }

}
