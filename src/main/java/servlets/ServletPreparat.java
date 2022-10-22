package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats")
public class ServletPreparat extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("id", "Tom");
//        request.setAttribute("address", "");
        getServletContext().getRequestDispatcher("/pages/preparats.jsp").forward(request, response);

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