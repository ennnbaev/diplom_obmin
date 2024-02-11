package com.example1.demo.dao;

import com.example1.demo.domain.User5;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UserDao
{
    private EntityManager entityManager;

    @PersistenceContext public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public User5 saveUser(User5 user5)
    {
        entityManager.persist(user5);
        return user5;
    }

    public User5 findByName(String username){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User5> query = builder.createQuery(User5.class);
        Root<User5> root = query.from(User5.class);
        query.select(root).where(builder.equal(root.get("username"), username));
        List<User5> user5List = entityManager.createQuery(query).getResultList();
        return user5List.isEmpty() ? null : user5List.get(0);

    }

    public User5 findByEmail(String email){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User5> query = builder.createQuery(User5.class);
        Root<User5> root = query.from(User5.class);
        query.select(root)
                .where(builder.equal(root.get("email"), email));
        List<User5> user5List = entityManager.createQuery(query)
                .getResultList();
        return user5List.isEmpty() ? null : user5List.get(0);

    }
}
