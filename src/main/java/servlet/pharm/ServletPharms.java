package servlet.pharm;

import db.PharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/pharms")
public class ServletPharms extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", PharmDao.getAllPharms());
        getServletContext().getRequestDispatcher("/pages/pharms.jsp").forward(request, response);
    }
}
