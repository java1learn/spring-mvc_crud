package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(String name);

    List<Role> rolesList();

    void add(Role role);

    void edit(Role role);

    void delete(Role role);

    Role getById(Long id);

}
