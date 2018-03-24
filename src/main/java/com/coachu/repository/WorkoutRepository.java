package com.coachu.repository;

import com.coachu.model.workout.Workout;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkoutRepository {

    Workout save(Workout workout, int userId);

    boolean delete(int id, int userId);

    Workout get(int id, int userId);

    List<Workout> getAll(int userdId);

    List<Workout> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userdId);

    default Workout getWithUser(int id, int userId){
        throw new UnsupportedOperationException();
    }
}
