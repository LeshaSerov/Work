package servlet.preparats_of_the_pharm;

import db.PreparatsOfTheCategDao;
import db.PreparatsOfThePharmDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/preparats_of_the_pharm/delete")
public class ServletPreparatsOfThePharmDelete extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idPharm = Integer.parseInt(request.getParameter("pharmsid"));
        Integer idPreparat = Integer.parseInt(request.getParameter("preparatsid"));
        PreparatsOfThePharmDao.deletePreparat(idPharm, idPreparat);
        response.sendRedirect("/preparats_of_the_pharm?id=" + idPharm);
    }

}
