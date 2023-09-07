package com.example.project2yp.controller;


import com.example.project2yp.dao.AlcoholDAO;
import com.example.project2yp.dao.FilmDAO;
import com.example.project2yp.models.AlcoholModel;
import com.example.project2yp.models.FilmModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmDAO _filmDao;

    public FilmController(FilmDAO filmDAO) {
        _filmDao = filmDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("films", _filmDao.index());
        return "films/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("film", _filmDao.show(id));
        return "films/show";
    }

    @GetMapping("/new")
    public String newFilm(@ModelAttribute("film") FilmModel film) {
        return "films/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("film") FilmModel film) {
        _filmDao.save(film);
        return "redirect:/films";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("film", _filmDao.show(id));
        return "films/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute FilmModel film, @PathVariable("id") int id) {
        _filmDao.update(id, film);
        return "redirect:/films";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _filmDao.delete(id);
        return "redirect:/films";
    }
}
