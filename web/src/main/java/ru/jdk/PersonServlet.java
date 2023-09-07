package ru.jdk;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.imir.PersonService;

import java.io.IOException;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
    private final PersonService personService = new PersonService();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var person = personService.getPerson(7369973181362102382L);

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");

        writer.println("<h1> Person: </h1>");
        writer.println("<p style = 'color:Tomato'> " + person.get().getName() + "</p>");

        writer.println("</body></html>");
        writer.close();
    }


}
