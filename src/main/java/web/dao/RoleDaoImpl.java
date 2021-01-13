package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Role role) {
        em.persist(role);
    }

    @Override
    public void delete(Role role) {
        em.remove(role);

    }

    @Override
    public void edit(Role role) {
        em.merge(role);
    }

    @Override
    public Role getById(Long id) {
        return em.createQuery("SELECT r FROM Role r WHERE r.id = :id",Role.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public List<Role> rolesList() {
        return (List<Role>) em.createQuery("FROM Role").getResultList();
    }

    @Override
    public Role findRoleByName(String name) {
        return (Role) em.createQuery("SELECT r FROM Role r WHERE r.roleName = :name");
    }
}
