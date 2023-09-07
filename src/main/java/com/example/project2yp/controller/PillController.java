package com.example.project2yp.controller;


import com.example.project2yp.dao.FoodDAO;
import com.example.project2yp.dao.PillsDAO;
import com.example.project2yp.models.FoodModel;
import com.example.project2yp.models.PillsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pills")
public class PillController {
    private final PillsDAO _pillDao;

    public PillController(PillsDAO pillsDAO) {
        _pillDao = pillsDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("pills", _pillDao.index());
        return "pills/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("pill", _pillDao.show(id));
        return "pills/show";
    }

    @GetMapping("/new")
    public String newPill(@ModelAttribute("pill") PillsModel pillsModel) {
        return "pills/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("pill") PillsModel pillsModel) {
        _pillDao.save(pillsModel);
        return "redirect:/pills";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("pill", _pillDao.show(id));
        return "pills/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute PillsModel pillsModel, @PathVariable("id") int id) {
        _pillDao.update(id, pillsModel);
        return "redirect:/pills";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _pillDao.delete(id);
        return "redirect:/pills";
    }
}
