package com.kellyprojects.ob_hibernate_project.dao;

import com.kellyprojects.ob_hibernate_project.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements  UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAllActive() {
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria=builder.createQuery(User.class);
        Root<User> root=criteria.from(User.class);

        Predicate isActive=builder.isTrue(root.get("Active"));

        criteria.select(root).where(isActive);
        return entityManager.createQuery(criteria).getResultList();
    }
}
