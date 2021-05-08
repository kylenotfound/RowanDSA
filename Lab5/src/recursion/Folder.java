package recursion;
import list.*;

/**
 *
 * @author Kyle Evangelisto
 */
public class Folder extends Item {

    private List<Item> itemList;

    public Folder (String name) {
        super(name);
        itemList = new ArrayList<>();
    }


    //add an item to our list
    public void addItem (Item item) {
        itemList.add(item);
    }


    //utilize add all to get all items from a list of doc
    @Override
    public List<Document> getAllDocs() {
        Iterator<Item> iterator = itemList.iterator();
        List<Document> documentList = new ArrayList<>();
        if (itemList.size() > 0) {
            while (iterator.hasNext()) {
                documentList.addAll(iterator.next().getAllDocs());
            }
        }
        return documentList;
    }

    //show all the items
    @Override
    public void show() {
        System.out.println(getName() + ": ");
        Iterator<Item> it = itemList.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
