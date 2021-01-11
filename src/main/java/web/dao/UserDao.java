package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(Long id);
    List<User> userList();

    User getUserByName(String name);
}
