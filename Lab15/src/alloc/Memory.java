package alloc;

import list.*;
import queue.*;

/**
 * Simulate the allocation and freeing of memory
 * @author Kyle Evangelisto
 */
public class Memory {

    //Blocks which are in use, not available
    List<Block> allocated = new LinkedList<>();

    //Available blocks
    List<Block> free = new LinkedList<>();

    static final int MAX = 4096;

    public Memory () {
        free.add(new Block(0, MAX));
    }

    /**
     * Allocate a block of the given size, if possible.
     * Algorithm, first-fit.
     * @param size
     * @return its position in memory, or -1 id not possible.
     */
    public int allocate (int size) {
        Block b, newBlock = null;
        QueueADT<Block> freeQueue = new PriorityQueue<>();
        Iterator<Block> freeIterator = free.iterator();
        while (freeIterator.hasNext()) {
            freeQueue.add(freeIterator.next());
        }
        while(!freeQueue.isEmpty()) {
            b = freeQueue.remove();
            if (b.size >= size) {
                newBlock = new Block(b.start, size);
                allocated.add(newBlock);
                b.start = b.start + size;
                b.size = b.size - size;
                if (b.size == 0) {
                    int indexOfB = free.indexOf(b);
                    free.remove(indexOfB);
                }
                return newBlock.start;
            }
        }
        return -1;
    }

    /**
     * Make the block at the given start position available
     * @param start
     * @return true iff there is such a block.
     */
    public boolean free (int start) {
        Block b;
        Iterator<Block> iterator = allocated.iterator();
        while (iterator.hasNext()) {
            b = iterator.next();
            if (b.start == start) {
                iterator.remove();
                free.add(0, b); //Add the beginning
                coalescence(b);
                return true;
            }
        }
        return false;
    }

    private void coalescence(Block initialBlock) {
        Block newBlock;
        Iterator <Block> iterator = free.iterator();
        while(iterator.hasNext()) {
            newBlock = iterator.next();
            //check the initial < new
            if(initialBlock.start < newBlock.start) {
                if ((initialBlock.start + initialBlock.size) == newBlock.start) {
                    initialBlock.size += newBlock.size;
                    iterator.remove();
                }
            }
            //check new < initial
            if(newBlock.start < initialBlock.start) {
                if ((newBlock.start + newBlock.size) == initialBlock.start) {
                    initialBlock.size += newBlock.size;
                    initialBlock.start = newBlock.start;
                    iterator.remove();
                }
            }
        }
    }

    /**
     * For Hw29
     * @param numbers (List of Integers)
     * @return the smallest value in a given list of integers
     */
    public int smallest (List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    //Lab 15 toString method
    public String toString() {
        return allocated.toString() + "\n" + free.toString();
    }

}
