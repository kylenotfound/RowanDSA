package hashDriver;
import hash.*;

/**
 * Test the HashTable class, using Book as the generic type.
 * 
 * @author (Kyle Evangelisto)
 * @version (2021)
 */ 
public class LabHashBooks {
   public static void main(String ... args) {
       HashTable <Book> library = new HashTable <Book> ();
       
        library.put (new Book ("Java", "Barnes", 300, new Date(12,20,1985))); //0
        library.put (new Book ("Java", "Barnes", 300, new Date(1,2,1995))); //1
        library.put (new Book ("Java", "Barnes", 310, new Date(12,20,2000))); //2
        library.put (new Book ("Compilers", "Bergmann", 306, new Date(12,20,1985))); //3
        library.put (new Book ("Networks", "Stallings", 500, new Date(12,20,1985))); //4
        library.put (new Book ("Java", "Barnes", 305, new Date(12,20,1985))); //5
      
        Date date = new Date (12,20,1985);
        if (library.isEmpty()) {
            System.err.println("Not correct -> The library is Empty 1");
        }
        if (!library.containsKey(new Book ("Java", "Barnes", 0, date))) {
            System.err.println("Not correct -> The library doesn't have Java Barnes 2");
        }
            
        System.out.println("The size of our library is " + library.size());
        
        System.out.println(library.get(new Book ("Compilers", "Bergmann", 0, date)));
        
        if (!library.remove(new Book("Java", "Barnes", 0, date))) {
            System.err.println("Not correct 3");
        }
        if (!library.remove(new Book ("Java", "Barnes", 0, date))) {
            System.err.println("Not correct 4");
        }
        if (library.remove(new Book ("Java", "Barnes", 0, date))) {
            System.err.println("Not correct 5");
        }
             
        library.clear();
        if (!library.isEmpty()) {
            System.err.println("Not correct 6");
        }
            
        library.put (new Book ("Java", "Barnes", 305, date));
        if (library.size() != 1) {
            System.err.println("Not correct 7");
        }
        
   }
        
}
