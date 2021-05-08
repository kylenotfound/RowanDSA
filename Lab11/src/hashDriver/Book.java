package hashDriver;

/**
 *
 * @author Kyle Evangelisto
 */
public class Book {
    private String title, author;
    private int pageCount;
    private Date copyRightDate;

    public Book (String title, String author, int pageCount, Date copyRightDate){
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.copyRightDate = copyRightDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Date getCopyRightDate() {
        return copyRightDate;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Book)){
            return false;
        }
        Book other = (Book) obj;
        return getTitle().equals(other.getTitle()) &&
                getAuthor().equals(other.getAuthor()) &&
                getCopyRightDate().equals(other.getCopyRightDate());
    }

    public int hashCode(){
        return getTitle().hashCode() + getAuthor().hashCode();
    }

    public String toString() {
        return "Book Title = " + getTitle() + "\n" +
                "Author = " + getAuthor() + "\n" +
                "Page Count = " + getPageCount() + "\n" +
                "Published Date = " + getCopyRightDate() + "\n\n";
    }
}
