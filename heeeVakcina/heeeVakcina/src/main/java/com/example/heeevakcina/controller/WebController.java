package com.example.heeevakcina.controller;

import com.example.heeevakcina.model.ElojegyzesMenedzser;
import com.example.heeevakcina.model.Foglalas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @GetMapping("/")
    public String StartPage()
    {
        return "index.jsp";
    }

    @PostMapping("/taj")
    public String Taj(@RequestParam String tajszam, HttpSession session, Model model)
    {
        if(9==tajszam.length())
        {
            Foglalas foglalas= ElojegyzesMenedzser.getInstance().FindByTaj(tajszam);
            if (foglalas !=null)
            {
                session.setAttribute("tajszam",tajszam);
                return "foglalat.jsp";
            }
            else
            {
                session.setAttribute("tajszam",tajszam);
                model.addAttribute("notregisted", "Még nincs előjegyzése");
                return "main.jsp";
            }
        }
        else
        {
            model.addAttribute("error","Hibás megadás");
            return "index.jsp";
        }
    }

    @PostMapping("/elojegyzes")
    public String Elojegyzes(@RequestParam String tajszam, @RequestParam String eletkor, @RequestParam String vakcina, HttpSession session, Model model)
    {
        if(9==tajszam.length()&!eletkor.isEmpty())
        {
            if (ElojegyzesMenedzser.getInstance().FindByVakcina(vakcina).getDarab()>0)
            {
                Foglalas foglalas=new Foglalas(tajszam,Integer.parseInt(eletkor),vakcina);
                ElojegyzesMenedzser.getInstance().AddFoglalas(foglalas);
                session.setAttribute("tajszam",tajszam);
                session.setAttribute("vakcina",vakcina);
                model.addAttribute("siker","Sikeres foglalás!");
                ElojegyzesMenedzser.getInstance().FindByVakcina(vakcina).setDarab((ElojegyzesMenedzser.getInstance().FindByVakcina(vakcina).getDarab())-1);
                return "foglalat.jsp";
            }
            else
            {
                model.addAttribute("error","Nincs raktáron a választott vakcina!");
                return "main.jsp";
            }

        }
        else
        {
            model.addAttribute("error","Hibás megadás");
            return "main.jsp";
        }
    }

    @GetMapping("/remove")
    public String Troles(@RequestParam String tajszam,@RequestParam String vakcina, HttpSession session, Model model)
    {
        ElojegyzesMenedzser.getInstance().RemoveFoglalas(ElojegyzesMenedzser.getInstance().FindByTaj(tajszam));
        ElojegyzesMenedzser.getInstance().FindByVakcina(vakcina).setDarab(ElojegyzesMenedzser.getInstance().FindByVakcina(vakcina).getDarab()+1);

        session.setAttribute("tajszam",tajszam);
        model.addAttribute("torolve","Sikeres törlés");
        return "main.jsp";
    }

}
