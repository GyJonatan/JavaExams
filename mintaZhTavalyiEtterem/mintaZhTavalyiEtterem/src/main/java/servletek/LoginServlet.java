package servletek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import oe.java.etterem.model.Etterem;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("bejelentkezett", request.getParameter("email"));
        if (request.getServletContext().getAttribute("etterem") == null) {
            request.getServletContext().setAttribute("etterem", new Etterem());
        }
        request.getRequestDispatcher("mainPage.jsp").forward(request,response);
    }
}
