package com.coachu.web.workout;

import com.coachu.AuthorizedUser;
import com.coachu.model.workout.Workout;
import com.coachu.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractWorkoutController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private WorkoutService service;

    public Workout get(int id) {
        int userId = AuthorizedUser.id();
        log.info("get workout {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public List<Workout> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll workouts for user{}", userId);
        return service.getAll(userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        service.delete(id, userId);
    }
}
