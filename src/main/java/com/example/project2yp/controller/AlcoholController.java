package com.example.project2yp.controller;


import com.example.project2yp.dao.AlcoholDAO;
import com.example.project2yp.models.AlcoholModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drinks")
public class AlcoholController {

    private final AlcoholDAO _alcoholDao;

    public AlcoholController(AlcoholDAO alcoholDao) {
        _alcoholDao = alcoholDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("drinks", _alcoholDao.index());
        return "drinks/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("drink", _alcoholDao.show(id));
        return "drinks/show";
    }

    @GetMapping("/new")
    public String newDrink(@ModelAttribute("drink") AlcoholModel alc) {
        return "drinks/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("drink") AlcoholModel alc) {
        _alcoholDao.save(alc);
        return "redirect:/drinks";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("drink", _alcoholDao.show(id));
        return "drinks/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute AlcoholModel alc, @PathVariable("id") int id) {
        _alcoholDao.update(id, alc);
        return "redirect:/drinks";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _alcoholDao.delete(id);
        return "redirect:/drinks";
    }
}
