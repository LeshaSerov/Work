package servlets;

import domain.Pharm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/categs")
public class ServletCateg  extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("id", "Tom");
//        request.setAttribute("address", "");
        getServletContext().getRequestDispatcher("/pages/categs.jsp").forward(request, response);

//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        try {
//
//        }
//        finally {
//            writer.close();
//        }
    }

}