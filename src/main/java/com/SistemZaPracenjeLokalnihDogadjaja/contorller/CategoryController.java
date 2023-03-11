package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Category;
import com.SistemZaPracenjeLokalnihDogadjaja.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/createCategory")
    public String createCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "create_category";
    }

    @PostMapping
    public String saveCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/events";
    }

}
