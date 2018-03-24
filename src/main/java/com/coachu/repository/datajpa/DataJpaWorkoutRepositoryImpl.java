package com.coachu.repository.datajpa;

import com.coachu.model.workout.Workout;
import com.coachu.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaWorkoutRepositoryImpl implements WorkoutRepository {

    @Autowired
    private CrudWorkoutRepository crudWorkoutRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    @Transactional
    public Workout save(Workout workout, int userId) {
        workout.setUser(crudUserRepository.getOne(userId));
        return crudWorkoutRepository.save(workout);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudWorkoutRepository.delete(id, userId) != 0;
    }

    @Override
    public Workout get(int id, int userId) {
        return crudWorkoutRepository.findById(id).filter(workout -> workout.getUser().getId() == userId).orElse(null);
    }

    @Override
    public List<Workout> getAll(int userdId) {
        return crudWorkoutRepository.getAll(userdId);
    }

    @Override
    public List<Workout> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userdId) {
        return null;
    }
}
