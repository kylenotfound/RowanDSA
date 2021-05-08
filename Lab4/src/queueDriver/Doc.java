package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (Kyle Evangelisto)
 * @version (2020)
 */
public class Doc {
    private int size; // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size) {
        this.size = size;
    }
    
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Doc [" + "size = " + size + ']';
    }
}
