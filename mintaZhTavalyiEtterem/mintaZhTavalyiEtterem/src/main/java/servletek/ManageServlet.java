package servletek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import oe.java.etterem.model.Etterem;

import java.io.IOException;

@WebServlet(name = "ManageServlet", value = "/ManageServlet")
public class ManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Etterem etterem = (Etterem) request.getServletContext().getAttribute("etterem");
        if ("ok".equals(request.getParameter("foglalas"))) {
            etterem.setFoglalasok(Integer.parseInt(request.getParameter("foglalasi")), Integer.parseInt(request.getParameter("foglalasj")), request.getSession().getAttribute("bejelentkezett").toString());
        }
        if ("ok".equals(request.getParameter("torles"))) {
            etterem.setFoglalasok(Integer.parseInt(request.getParameter("foglalasi")), Integer.parseInt(request.getParameter("foglalasj")), null);
        }

        request.getRequestDispatcher("mainPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
