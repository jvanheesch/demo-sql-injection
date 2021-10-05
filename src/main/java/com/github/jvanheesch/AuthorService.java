package com.github.jvanheesch;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AuthorService {
    private final EntityManager em;

    public AuthorService(EntityManager em) {
        this.em = em;
    }

    public List<Author> findByNameSafe(String name) {
        return em.createQuery("SELECT a FROM Author a WHERE a.name = :authorName", Author.class)
                .setParameter("authorName", name)
                .getResultList();
    }

    public List<Author> findByNameUnsafe(String name) {
        String format = String.format("SELECT a FROM Author a WHERE a.name = '%s'", name);
        return em.createQuery(format, Author.class)
                .getResultList();
    }
}
