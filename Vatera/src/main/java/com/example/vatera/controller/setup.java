package com.example.vatera.controller;

import com.example.vatera.model.Hirdető;
import com.example.vatera.model.Termek;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import  com.example.vatera.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "setup", value = "/setup")
public class setup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getServletContext().getAttribute("Hirdetok")==null)
        {
            ArrayList<String> keywords = new ArrayList<>();
            keywords.add("bútor");
            keywords.add("jármű");
            keywords.add("elektronika");

            Termek.setKeywordArray(keywords);

            ArrayList<Hirdető> hirdetőArrayList = new ArrayList<>();

            Hirdető berci = new Hirdető();
            berci.setEmail("berci");
            ArrayList<Termek> termekek = new ArrayList<>();
            Termek a = new Termek();
            a.setKeyWord(Termek.getKeywordArray().get(0));
            a.setName("asztal");
            a.setPrice(2000);
            a.setHash();
            Termek b = new Termek();
            b.setKeyWord(Termek.getKeywordArray().get(1));
            b.setName("lada");
            b.setPrice(20000);
            b.setHash();
            termekek.add(a);
            termekek.add(b);
            berci.setTermeks(termekek);

            Hirdető bela = new Hirdető();
            bela.setEmail("belus");
            ArrayList<Termek> belatermekek = new ArrayList<>();
            Termek c = new Termek();
            c.setKeyWord(Termek.getKeywordArray().get(2));
            c.setName("leptop");
            c.setPrice(5000);
            c.setHash();
            Termek d = new Termek();
            d.setKeyWord(Termek.getKeywordArray().get(1));
            d.setName("pozso");
            d.setPrice(1);
            d.setFoglalas(berci.getEmail());
            d.setHash();
            belatermekek.add(c);
            belatermekek.add(d);
            bela.setTermeks(belatermekek);

            hirdetőArrayList.add(berci);
            hirdetőArrayList.add(bela);

            request.getServletContext().setAttribute("Hirdetok",hirdetőArrayList);
        }

        ArrayList<Hirdető> hirdetok = (ArrayList<Hirdető>)request.getServletContext().getAttribute("Hirdetok");
        String email = request.getParameter("email");

        Hirdető user = hirdetok.stream().filter(t->t.getEmail().equals(email)).findFirst().orElse(null);
        if (user != null)
        {
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("manager").forward(request,response);
        }
        else
        {
            request.setAttribute("message","invalid login");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
