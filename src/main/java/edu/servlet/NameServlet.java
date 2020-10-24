package edu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Name", urlPatterns = "/name")
public class NameServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(NameServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("Name: " + name);

        Object greetingEJB = req.getSession().getAttribute("greetingEJB");
        Greeting greeting;

        try {
            if (greetingEJB == null) {
                log.info("*** There is no greeting in user session");
                InitialContext ic = new InitialContext();
                greeting = (Greeting) ic.lookup("java:module/GreetingImpl");
                req.getSession().setAttribute("greetingEJB", greeting);
            } else {
                log.info("*** Three is greeting in user session. using it.");
                greeting = (Greeting) greetingEJB;
            }

            greeting.setName(name);

            resp.getWriter().write("OK");

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
