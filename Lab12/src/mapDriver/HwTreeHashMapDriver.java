package mapDriver;
import map.*;

/**
 * Test the TreeMap and HashMap classes
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HwTreeHashMapDriver {
    public static void main(String ... args) {
	    Map <String, String> names;
	    names = new TreeMap <String, String> ();
        testMap (names);
        names = new HashMap <String, String> ();
        testMap (names);
    }
    
    private static void testMap (Map<String, String> names) {
        if (!names.isEmpty())
            System.err.println ("isEmpty incorrect");
        
        names.put ("sue", "609");
        names.put ("jim", "856");
        names.put ("sarah", "215");
        names.put ("will", "856");
        names.put ("stu", "609");
        names.put ("van", "856");
        names.put ("jim", "215");
        
        if ( names.isEmpty()) {
            System.err.println("isEmpty incorrect");
        }
        if (! names.containsKey ("van")) {
            System.err.println("containsKey incorrect");
        }
        if (names.containsKey ("joe")) {
            System.err.println("containsKey incorrect");
        }
        if (! (names.size() == 6)) {
            System.err.println("Size is incorrect");
        }
        if (!(names.get ("jim").equals("215"))) {
            System.err.println("Incorrect value for jim");
        }
        
        System.out.println ("sue's area code is " + names.remove ("sue"));  // 609
        if (! ( names.size() == 5)) {
            System.err.println("Size is incorrect");
        }
        if (names.get ("sue") != null) {
            System.err.println("Incorrect value for sue");
        }
        
        // optional: Implement a toString() method for maps.
        System.out.println (names);     // Hint: Entry needs a toString() method
}
  
}
