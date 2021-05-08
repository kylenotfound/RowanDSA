package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (Kyle Evangelisto)
 * @version (2020)
 */
public class Printer {
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private boolean available;
    private int pages;

    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id) {
        this.speed = speed;
        this.id = id;
        docs = new Queue<Doc>();
        available = true;
    }

    /** Add a document to this printer's queue 
       Display the document and printer on stdout.
       */
    public void add (Doc doc) {
        docs.add(doc);
        //////////// Do not change this println statement ///////////////
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     */
    public void print() {
        if (!docs.isEmpty()) {
            if(available) {
                pages = docs.peek().size();
                available = false;
            }
            pages -= speed;

            if(pages <= 0) {
                System.out.println("Print task completed on " + id + ": for " + docs.remove());
                available = true;
            }
        }

    }

    @Override
    public String toString() {
        return id + ", speed: " + speed + ", docs in queue: " + docs.size();
    }
}
