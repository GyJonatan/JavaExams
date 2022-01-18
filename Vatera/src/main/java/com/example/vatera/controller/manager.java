package com.example.vatera.controller;

import com.example.vatera.model.Hirdető;
import com.example.vatera.model.Termek;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "manager", value = "/manager")
public class manager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Hirdető> hirdetok = (ArrayList<Hirdető>)request.getServletContext().getAttribute("Hirdetok");
        Hirdető user = (Hirdető) request.getSession().getAttribute("user");

        if (request.getParameter("Add")!=null)
        {
            //nemtudom hogy mi a pőcs a selectmany ebben a gyönyörű nyelvben
            int hash = Integer.parseInt(request.getParameter("Add"));
            for (Hirdető hirdeto: hirdetok)
            {
                for (Termek termek: hirdeto.getTermeks())
                {
                    if (termek.getHash()==hash)
                    {
                        termek.setFoglalas(user.getEmail());
                    }
                }
            }

            request.getRequestDispatcher("SearchResults.jsp").forward(request,response);
        }
        else if (request.getParameter("Remove")!=null)
        {
            int hash = Integer.parseInt(request.getParameter("Remove"));
            for (Hirdető hirdeto: hirdetok)
            {
                for (Termek termek: hirdeto.getTermeks())
                {
                    if (termek.getHash()==hash)
                    {
                        termek.setFoglalas(null);
                    }
                }
            }
            request.getRequestDispatcher("SearchResults.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("Webpage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
