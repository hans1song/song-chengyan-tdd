import java.util.*;

interface IUserRepository {
    User findById(String id);
    void addUser(User user);
    List<User> findAll();

} 
