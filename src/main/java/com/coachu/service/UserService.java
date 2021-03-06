package com.coachu.service;


import com.coachu.model.user.User;
import com.coachu.to.UserTo;
import com.coachu.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void update(UserTo user);

    List<User> getAll();

    void enable(int id, boolean enable);

    User getWithWorkouts(int id);
}