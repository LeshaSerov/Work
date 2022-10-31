package servlet.categ;

import db.CategDao;
import db.PharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/categ/edit")
public class ServletCategEdit extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<form action=\"/categ/edit?action=submit&id=" + id + "\" method=\"POST\">");
            writer.println(" Name: <input name=\"name\" value=\"" + CategDao.getCateg(id).getName() + "\"/>");
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
        CategDao.editCateg(id, name);
        response.sendRedirect("/categs");
    }
}
