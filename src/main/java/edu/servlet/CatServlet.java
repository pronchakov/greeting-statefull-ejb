package edu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
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

    public void setEntityManager(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Cat cat = entityManager.find(Cat.class, 2L);
//
//        log.info("Cat id: {}, name: {}, birth: {}", cat.getId(), cat.getName(), cat.getBirth());

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cat cat = new Cat();
        cat.setId(567L);
        cat.setName("Gingerыч");
        cat.setBirth(new Date());

        entityManager.getTransaction().begin();

        entityManager.persist(cat);

        entityManager.getTransaction().commit();

    }

}
