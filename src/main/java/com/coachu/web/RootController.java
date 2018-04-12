package com.coachu.web;

import com.coachu.model.user.User;
import com.coachu.to.UserTo;
import com.coachu.util.UserUtil;
import com.coachu.web.user.AbstractUserController;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.coachu.AuthorizedUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import static com.coachu.web.ExceptionInfoHandler.EXCEPTION_DUPLICATE_EMAIL;

@Controller
public class RootController extends AbstractUserController {

    @GetMapping("/")
    public String root() {
        return "redirect:workouts";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/workouts")
    public String workouts() {
        return "workouts";
    }

    @GetMapping("/profile")
    public String profile(ModelMap model, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        model.addAttribute("userTo", authorizedUser.getUserTo());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        if (result.hasErrors()) {
            return "profile";
        }

        try {
            super.update(userTo, authorizedUser.getId());
            authorizedUser.update(userTo);
            status.setComplete();
            return "redirect:workouts";
        }catch (DataIntegrityViolationException ex) {
            result.rejectValue("email", EXCEPTION_DUPLICATE_EMAIL);
            return "profile";
        }
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        }
        try {
            super.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login?message=app.registered&username=" + userTo.getEmail();
        } catch (DataIntegrityViolationException  ex) {
            result.rejectValue("email", EXCEPTION_DUPLICATE_EMAIL);
            model.addAttribute("register", true);
            return "profile";
        }
    }

}
