package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of Set.
 * 
 * @author (Kyle Evangelisto)
 * @version (2020)
 */
public class HwTreeSetDriver {
    public static void main(String ... args) {
        Set <Integer> values = new TreeSet <Integer> ();

        System.out.println (values);
        System.out.println ("removing from empty tree: " + values.remove(3));

        values.add (3);
        values.add (5);
        values.add (3);
        for (int j=0; j<200; j++)
        for (int i=0; i<20; i++)
           values.add (i/3);

        System.out.println ("size is " + values.size()); // should be 7
        System.out.println ("set is " + values );

        Set <String> names = new TreeSet <String> ();

        names.add ("joseph");
        names.add ("jim");
        names.add ("jack");
        names.add ("mary");
        names.add ("jimmy");
        names.add ("sue");
        names.add ("mary");

        System.out.println (names.size() + " names");   // should be 6
        System.out.println ("set of Strings is " + names);

        // Selectively remove long names
        System.out.println ("Removing long names");
        Iterator <String> iterator = names.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3) {
                iterator.remove();
            }
        }

        System.out.println ("set of Strings is " + names);

        names.add("james");
        names.add("flora");
        iterator = names.iterator();
         for (int i = 0; i < 3; i++) {
             System.out.println (iterator.next()) ;      // flora, james, jim on separate lines
             iterator.remove();
         }
         System.out.println ("names is " + names);       //  names is [sue]
    }
}
