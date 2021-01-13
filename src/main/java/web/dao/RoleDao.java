package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleDao {
    void add(Role role);
    void delete(Role role);
    void edit(Role role);
    Role getById(Long id);
    List<Role> rolesList();
    Role findRoleByName(String name);
}
