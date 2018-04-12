package com.coachu.repository;

import com.coachu.model.user.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    //TODO: переписать на workouts
    default User getWithWorkouts(int id){
        throw new UnsupportedOperationException();
    }
}