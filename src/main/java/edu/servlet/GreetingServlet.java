package edu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Greeting", urlPatterns = "/greeting")
public class GreetingServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(GreetingServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Greeting greeting = (Greeting) req.getSession().getAttribute("greetingEJB");

        String result = greeting.greeting();

        req.setAttribute("greeting", result);
        req.setAttribute("ejb", greeting.getClass().getCanonicalName());
        req.setAttribute("hash", greeting.hashCode());
        req.setAttribute("hash2", greeting.hashCode());


        this.getServletContext().getRequestDispatcher("/greeting.jsp").forward(req, resp);

    }

}
