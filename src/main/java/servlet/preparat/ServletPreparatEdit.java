package servlet.preparat;

import db.CategDao;
import db.PharmDao;
import db.PreparatDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/preparat/edit")
public class ServletPreparatEdit extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<form action=\"/preparat/edit?action=submit&id=" + id + "\" method=\"POST\">");
            writer.println(" Name: <input name=\"name\" value=\"" + PreparatDao.getPreparat(id).getName() + "\"/>");
            writer.println("<input type=\"submit\" value=\"Submit\" />");
            writer.println("</form>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        Integer id = Integer.parseInt(request.getParameter("id"));
        PreparatDao.editPreparat(id, name);
        response.sendRedirect("/preparats");
    }
}
