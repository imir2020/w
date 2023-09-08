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

    /**
     * Добавить обработку следующих запросов в модуль web:
     * <p>
     * - Получить список всех пользователей
     * <p>
     * - Вернуть информацию о пользователе по его Id
     * <p>
     * - Изменить имя пользователя по его Id
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var person = personService.getPerson(7369973181362102382L);

        resp.setContentType("text/html; charset=UTF-8");
        var writer = resp.getWriter();
        writer.println("index.jsp");
        writer.println("<html><body>");

        writer.println("<h1> Person: </h1>");
        writer.println("<p style = 'color:Tomato'> " + person.get().getName() + "</p>");
        writer.println("<h2> listPersons: </h2>");
        for (Object p :personService.listAllPersons()) {
            writer.println("<br>" + p + "</br>");
        }

        writer.println("</body></html>");
        System.out.println(resp.isCommitted());
        writer.flush();
        writer.close();
    }


}
