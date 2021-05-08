package recursion;

import list.*;

/**
 *
 * @author Kyle Evangelisto
 */
public class Document extends Item {

    private DocType docType;

    public Document (String name, DocType docType) {
        super(name);
        this.docType = docType;
    }


    @Override
    public List<Document> getAllDocs() {
        List<Document> list = new ArrayList<>();
        list.add(this);
        return list;
    }

    @Override
    public void show() {
        System.out.println(getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
