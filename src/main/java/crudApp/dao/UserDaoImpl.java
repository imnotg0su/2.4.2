package crudApp.dao;

import crudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(id);
    }

    @Override
    public void edit(int id) {
        entityManager.merge(id);
//        User toChangUser = userById(id);
//        toChangUser.setName(changedUser.getName());
//        toChangUser.setSurname(changedUser.getSurname());
//        toChangUser.setAge(changedUser.getAge());
//        toChangUser.setStatus(changedUser.getStatus());
    }

    @Override
    public User userById(int id) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class).setParameter("id", id).getSingleResult();
    }
}
