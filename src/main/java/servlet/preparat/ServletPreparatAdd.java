package servlet.preparat;

import db.PharmDao;
import db.PreparatDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/preparat/add")
public class ServletPreparatAdd extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<form action=\"/preparat/add?action=submit\" method=\"POST\">");
            writer.println(" Name: <input name=\"name\" />");
            writer.println("<input type=\"submit\" value=\"Submit\" />");
            writer.println("</form>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        PreparatDao.addPreparat(name);
        response.sendRedirect("/preparats");
    }
}
