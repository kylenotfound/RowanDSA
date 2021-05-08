package recursion;

import list.*;

/**
 *
 * @author Kyle Evangelisto
 */
public abstract class Item {

    private String name;

    public Item (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** @return A list of all the documents making up this Item
     * (and all contained folders)  in any order
     */
    public abstract List<Document> getAllDocs();

    /** Display the name of this Item; also display all the
     * items which it contains, on separate lines.
     */
    public abstract void show();

}
