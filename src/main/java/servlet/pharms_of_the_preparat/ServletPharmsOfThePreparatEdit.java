package servlet.pharms_of_the_preparat;

import db.PharmDao;
import db.PreparatDao;
import db.PreparatsOfThePharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pharms_of_the_preparat/edit")
public class ServletPharmsOfThePreparatEdit extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Integer idPharm = Integer.parseInt(request.getParameter("pharmsid"));
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<form action=\"?pharmsid=" + idPharm + "&preparatsid=" +idPreparat + "&action=submit\" method=\"POST\">");
            {
                writer.println(" Количество: <input name=\"value\"/>");
            }
            writer.println("<input type=\"submit\" value=\"Submit\" />");
            writer.println("</form>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idPharm = Integer.parseInt(request.getParameter("pharmsid"));
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        Integer value = Integer.parseInt(request.getParameter("value"));
        PreparatsOfThePharmDao.editPreparat(idPharm, idPreparat, value);
        response.sendRedirect("/pharms_of_the_preparat?id=" + idPreparat);
    }
}
