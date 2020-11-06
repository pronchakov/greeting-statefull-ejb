package edu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Name", urlPatterns = "/name")
public class CatServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CatServlet.class);

    @PersistenceUnit(unitName = "cat-unit")
    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cat cat = new Cat();
        cat.setId(568L);
        cat.setName("Gingerыч");
        cat.setBirth(new Date());

        entityManager.getTransaction().begin();

        entityManager.persist(cat);

        Cat catFind = entityManager.find(Cat.class, 2L);
        log.info("Cat id: {}, name: {}, birth: {}", catFind.getId(), catFind.getName(), catFind.getBirth());

        entityManager.getTransaction().commit();

    }

}
