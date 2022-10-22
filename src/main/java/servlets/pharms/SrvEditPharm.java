package servlets.pharms;

import db.Imitator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pharms/edit")
public class SrvEditPharm  extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Integer id = Integer.parseInt(request.getParameter("id"));
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<form action=\"/pharms/edit?action=submit&id=" + id + "\" method=\"POST\">");
            writer.println(" Name: <input name=\"address\" />");
            writer.println("<input type=\"submit\" value=\"Submit\" />");
            writer.println("</form>");
        }
        finally {
            writer.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Imitator.editPharm(id, address);
        response.sendRedirect("/pharms");
    }
}
