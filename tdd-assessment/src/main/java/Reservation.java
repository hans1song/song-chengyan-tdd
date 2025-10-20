public class Reservation{
    String userId;
    String bookId;

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Reservation(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
    public Reservation() {
    }
    
} 
