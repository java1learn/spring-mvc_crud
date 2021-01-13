package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(String name) {
        return roleDao.findRoleByName(name);
    }

    @Override
    public List<Role> rolesList() {
        return roleDao.rolesList();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void edit(Role role) {
        roleDao.edit(role);
    }

    @Override
    public void delete(Role role) {
        roleDao.delete(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }
}
