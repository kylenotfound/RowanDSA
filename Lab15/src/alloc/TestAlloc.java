package allocDriver;
import alloc.*;

/**
 * Test the memory allocator.
 * 
 * @author (sdb) 
 * @version (2020)
 */ 
public class TestAlloc {
   public static void main(String ... args) {
       int v1, v2, v3, v4, v5;
       Memory mem = new Memory();
       System.out.println (mem);
       System.out.println ();
       v1 = mem.allocate (100);
       v2 = mem.allocate (200);
       v3 = mem.allocate (300);
       v4 = mem.allocate (400);
       v5 = mem.allocate (500);
       System.out.println (mem);
       System.out.println ();  
       
       mem.free (v4);
       mem.free (v2);
       System.out.println (mem);
       System.out.println ();
       
       v2 = mem.allocate(250);
       v4 = mem.allocate (200);
       System.out.println (mem);
    }
       
}
