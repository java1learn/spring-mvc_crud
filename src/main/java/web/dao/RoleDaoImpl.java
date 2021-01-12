package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Role findRoleByName(String name) {
        return (Role) em.createQuery("SELECT r FROM Role r WHERE r.roleName = :name");
    }
}
