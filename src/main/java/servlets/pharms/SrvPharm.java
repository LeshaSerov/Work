package servlets.pharms;

import db.Imitator;
import domain.Pharm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/pharms")
public class SrvPharm extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Imitator.addPharm(new Pharm(1, "a"));
        Imitator.addPharm(new Pharm(2, "b"));
        Imitator.addPharm(new Pharm(3, "c"));
        Imitator.addPharm(new Pharm(4, "d"));
        Imitator.addPharm(new Pharm(5, "e"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", Imitator.getPharmList());
        getServletContext().getRequestDispatcher("/pages/pharms.jsp").forward(request, response);
    }

}
