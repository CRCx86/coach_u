package com.coachu.service;

import com.coachu.model.workout.Workout;
import com.coachu.util.exception.NotFoundException;

import java.util.List;

public interface WorkoutService {

    Workout get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    //TODO: добавить метод между датой

    List<Workout> getAll(int userId);

    Workout update(Workout workout, int userId) throws NotFoundException;

    Workout create(Workout workout, int userId);

    //TODO to add getWithUser method

}
