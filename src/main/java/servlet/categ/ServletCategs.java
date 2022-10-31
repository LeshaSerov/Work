package servlet.categ;

import db.CategDao;
import db.PharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/categs")
public class ServletCategs extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", CategDao.getAllCategs());
        getServletContext().getRequestDispatcher("/pages/categs.jsp").forward(request, response);
    }
}
