public class User{
    String id;
    String name;
    boolean priority;
    

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public User(String id, String name, boolean priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }
    public User(String id, String name) {
        this(id, name, false);
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public User() {
    }
    


}