package com.example.project2yp.controller;


import com.example.project2yp.dao.AlcoholDAO;
import com.example.project2yp.dao.WatchDAO;
import com.example.project2yp.models.AlcoholModel;
import com.example.project2yp.models.WatchModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/watches")
public class WatchController {

    private final WatchDAO _watchDao;

    public WatchController(WatchDAO watchDAO) {
        _watchDao = watchDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("watches", _watchDao.index());
        return "watches/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("watch", _watchDao.show(id));
        return "watches/show";
    }

    @GetMapping("/new")
    public String newWatch(@ModelAttribute("watch") WatchModel watch) {
        return "watches/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("watch") WatchModel watch) {
        _watchDao.save(watch);
        return "redirect:/watches";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("watch", _watchDao.show(id));
        return "watches/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute WatchModel watch, @PathVariable("id") int id) {
        _watchDao.update(id, watch);
        return "redirect:/watches";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _watchDao.delete(id);
        return "redirect:/watches";
    }
}
