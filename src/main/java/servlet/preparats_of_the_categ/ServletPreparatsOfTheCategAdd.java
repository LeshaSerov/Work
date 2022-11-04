package servlet.preparats_of_the_categ;

import db.CategDao;
import db.PreparatDao;
import db.PreparatsOfTheCategDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/preparats_of_the_categ/add")
public class ServletPreparatsOfTheCategAdd extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Integer idCateg = Integer.parseInt(request.getParameter("categsid"));

        try {
            writer.println("<form action=\"?categsid=" + idCateg + "&action=submit\" method=\"POST\">");

//            writer.println("<form action=\"?action=submit\" method=\"POST\">");
            {
                writer.println("<select id=\"preparats\" name=\"preparatsid\">\n");
                PreparatDao.getAllPreparats().forEach((x) ->
                        writer.println("<option value=\"" + x.getId() + "\">" + x.getName() + "</option>")
                );
                writer.println("</select>");

//                writer.println("<select id=\"categs\" name=\"categsid\">\n");
//                CategDao.getAllCategs().forEach((x) ->
//                        writer.println("<option value=\"" + x.getId() + "\">" + x.getName() + "</option>")
//                );
//                writer.println("</select>");
            }
            writer.println("<input type=\"submit\" value=\"Submit\" />");
            writer.println("</form>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        Integer idCateg = Integer.parseInt(request.getParameter("categsid"));
        PreparatsOfTheCategDao.addPreparat(idPreparat, idCateg);
        response.sendRedirect("/preparats_of_the_categ?id=" + idCateg);
    }
}
