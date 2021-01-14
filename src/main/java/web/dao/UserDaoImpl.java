package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> userList() {
        return (List<User>) em.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUserByName(String login) {
        return em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class).setParameter("login", login).getSingleResult();
    }


}
