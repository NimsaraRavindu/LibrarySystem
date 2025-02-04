package edu.icet.ecom.controller;
import edu.icet.ecom.model.User;
import java.util.List;
public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    User searchUser(String id);
    List<User> getAll();
    boolean deleteUser(String id);
}
