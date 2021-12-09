package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@RequiredArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDAO {

    private final EntityManagerFactory emf;

    @Override
    public Author getById(Long id) {
        Author author = getEntityManager().find(Author.class, id);

        return author;
    }

    @Override
    public Author getByName(String firstName, String lastName) {
        TypedQuery<Author> query = getEntityManager().createQuery("SELECT a FROM Author a "
                + "WHERE a.firstName = :firstName "
                + "AND a.lastName = :lastName", Author.class);

        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        Author author = query.getSingleResult();

        return author;
    }

    @Override
    public Author saveNewAuthor(Author newAuthor) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(newAuthor);
        em.flush();

        em.getTransaction().commit();

        return newAuthor;
    }

    @Override
    public Author updateAuthor(Author savedAuthor) {
        EntityManager em = getEntityManager();

        em.joinTransaction();
        em.merge(savedAuthor);
        em.flush();
        em.close();

        return em.find(Author.class, savedAuthor.getId());
    }

    @Override
    public void deleteAuthor(Long id) {
        EntityManager em = getEntityManager();

        Author authorToDelete = em.find(Author.class, id);

        em.getTransaction().begin();

        em.remove(authorToDelete);
        em.flush();
        em.close();

        em.getTransaction().commit();
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
