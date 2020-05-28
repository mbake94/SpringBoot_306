package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.management.MonitorInfo;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("alldirectors", directorRepository.findAll());

        return "list";
    }

    @RequestMapping("/newdirector")
    public String newDirector(Model model){
        model.addAttribute("director", new Director());

        return "newdirector";
    }

    @PostMapping("/process")
    public String process(@ModelAttribute("director") Director director){
        directorRepository.save(director);

        return "redirect:/list";
    }
    @RequestMapping("/newmovie")
    public String newMovie(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("alldirectors", directorRepository.findAll());

        return "newmovie";
    }
    @PostMapping("/processmovie")
    public String processmovie(@ModelAttribute("movie") Movie movie){
        movieRepository.save(movie);
        return "redirect:/list";
    }

}
