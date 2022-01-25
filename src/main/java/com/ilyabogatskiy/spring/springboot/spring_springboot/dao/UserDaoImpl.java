package com.ilyabogatskiy.spring.springboot.spring_springboot.dao;

import com.ilyabogatskiy.spring.springboot.spring_springboot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) { entityManager.persist(user); }

    @Override
    public void updateUser(User updateUser) { entityManager.merge(updateUser); }

    @Override
    public User getUserById(Long id) { return entityManager.find(User.class,id); }

    @Override
    public User getByName(String name) {
        User user = entityManager
                .createQuery("SELECT user FROM User user JOIN FETCH user.roles WHERE user.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
        return user;
    }

    @Override
    public void removeUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT DISTINCT user FROM User user JOIN FETCH user.roles", User.class).getResultList();
    }
}
