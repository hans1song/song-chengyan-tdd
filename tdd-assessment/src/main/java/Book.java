import java.util.List;

public class Book {
    String id;
    String title;
    int CopiesAvailable;
    List<String> waitingList;


    public String getId() {
        return id;
    }
    public Book(String id, String title, int CopiesAvailable) {
        this.id = id;
        this.title = title;
        this.CopiesAvailable = CopiesAvailable;
        this.waitingList = new java.util.ArrayList<>();
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
    
    public List<String> getWaitingList() {
        return waitingList;
    }
    public void setWaitingList(List<String> waitingList) {
        this.waitingList = waitingList;
    }

    

}
