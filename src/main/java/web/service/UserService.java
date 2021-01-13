package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> userList();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getByName(String name);
    User getById(Long id);
}
