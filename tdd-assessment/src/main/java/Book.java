

public class Book {
    String id;
    String title;
    int CopiesAvailable;

    public String getId() {
        return id;
    }
    public Book(String id, String title, int CopiesAvailable) {
        this.id = id;
        this.title = title;
        this.CopiesAvailable = CopiesAvailable;
    }
    public String getTitle() {
        return title;
    }
    public int getCopiesAvailable() {
        return CopiesAvailable;
    }
    public void setCopiesAvailable(int copiesAvailable) {
        CopiesAvailable = copiesAvailable;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Book() {
    }
    

}
