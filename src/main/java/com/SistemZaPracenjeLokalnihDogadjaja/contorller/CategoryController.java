package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Category;
import com.SistemZaPracenjeLokalnihDogadjaja.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/create")
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
