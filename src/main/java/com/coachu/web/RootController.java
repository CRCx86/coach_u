package com.coachu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.coachu.AuthorizedUser;
//import com.coachu.service.MealService;
//import com.coachu.util.MealsUtil;

@Controller
public class RootController {

//    @Autowired
//    private MealService mealService;

    @GetMapping("/")
    public String root() {
        return "redirect:users";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

//    @GetMapping(value = "/login")
//    public String login() {
//        return "login";
//    }

//    @GetMapping("/meals")
//    public String meals(Model model) {
//        model.addAttribute("meals",
//                MealsUtil.getWithExceeded(mealService.getAll(AuthorizedUser.id()), AuthorizedUser.getCaloriesPerDay()));
//        return "meals";
//    }
}
