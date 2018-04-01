package com.coachu;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.coachu.model.user.User;
import com.coachu.to.UserTo;
import com.coachu.util.UserUtil;

import static java.util.Objects.requireNonNull;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        //this.userTo = UserUtil.asTo(user);
        this.user = user;
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public int getId() {
        return user.getId();
    }

    public static int id() {
//        return get().userTo.getId();
        return get().user.getId();
    }

    public static int getCaloriesPerDay() {
//        return get().userTo.getCaloriesPerDay();
        return get().user.getCaloriesPerDay();
    }

//    public UserTo getUserTo() {
//        return userTo;
//    }

    public void update(User newUser) {
        user = newUser;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
//        return userTo.toString();
        return user.toString();
    }
}