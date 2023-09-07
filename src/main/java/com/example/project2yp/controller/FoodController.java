package com.example.project2yp.controller;


import com.example.project2yp.dao.FilmDAO;
import com.example.project2yp.dao.FoodDAO;
import com.example.project2yp.models.FilmModel;
import com.example.project2yp.models.FoodModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foods")
public class FoodController {

    private final FoodDAO _foodDao;

    public FoodController(FoodDAO foodDao) {
        _foodDao = foodDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("foods", _foodDao.index());
        return "foods/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("food", _foodDao.show(id));
        return "foods/show";
    }

    @GetMapping("/new")
    public String newFilm(@ModelAttribute("food") FoodModel foodModel) {
        return "foods/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("food") FoodModel foodModel) {
        _foodDao.save(foodModel);
        return "redirect:/foods";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("food", _foodDao.show(id));
        return "foods/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute FoodModel foodModel, @PathVariable("id") int id) {
        _foodDao.update(id, foodModel);
        return "redirect:/foods";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _foodDao.delete(id);
        return "redirect:/foods";
    }
}
