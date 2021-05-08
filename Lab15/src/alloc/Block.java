package alloc;

/**
 * A block of memory has a starting address and a size.
 * @author Kyle Evangelisto
 */
public class Block implements Comparable<Block> {

    int start, size;

    Block (int start, int size) {
        this.start = start;
        this.size = size;
    }

    public String toString() {
        return "(" + start + "." + size + ")";
    }


    //had to implement this for lab 15, intellij generated
    public int compareTo(Block block) {
        return Integer.compare(block.size, size);
    }
}
