package servlets;

import domain.TD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<TD> numberList = new ArrayList<>();
        numberList.add(new TD(1));
        numberList.add(new TD(2));
        numberList.add(new TD(3));
        request.setAttribute("list", numberList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
