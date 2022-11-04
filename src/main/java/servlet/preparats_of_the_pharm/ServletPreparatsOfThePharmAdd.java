package servlet.preparats_of_the_pharm;

import db.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/preparats_of_the_pharm/add")
public class ServletPreparatsOfThePharmAdd extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Integer idPharm = Integer.parseInt(request.getParameter("pharmsid"));

        try {
            writer.println("<form action=\"?pharmsid=" + idPharm + "&action=submit\" method=\"POST\">");

//            writer.println("<form action=\"?action=submit\" method=\"POST\">");
            {
                writer.println("<select id=\"preparats\" name=\"preparatsid\">\n");
                PreparatDao.getAllPreparats().forEach((x) ->
                        writer.println("<option value=\"" + x.getId() + "\">" + x.getName() + "</option>")
                );
                writer.println("</select>");

//                writer.println("<select id=\"pharms\" name=\"pharmsid\">\n");
//                PharmDao.getAllPharms().forEach((x) ->
//                        writer.println("<option value=\"" + x.getId() + "\">" + x.getAddress() + "</option>")
//                );
//                writer.println("</select>");

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
        PreparatsOfThePharmDao.addPreparat(idPharm, idPreparat, value);
        response.sendRedirect("/preparats_of_the_pharm?id=" + idPharm);
    }

}
