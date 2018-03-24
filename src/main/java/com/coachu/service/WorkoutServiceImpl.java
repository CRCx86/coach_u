package com.coachu.service;

import com.coachu.model.workout.Workout;
import com.coachu.repository.WorkoutRepository;
import com.coachu.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository repository;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository repository) {
        this.repository = repository;
    }

    @Override
    public Workout get(int id, int userId) throws NotFoundException {
        return repository.get(id, userId);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        repository.delete(id, userId);
    }

    @Override
    public List<Workout> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Workout update(Workout workout, int userId) throws NotFoundException {
        return repository.save(workout, userId);
    }

    @Override
    public Workout create(Workout workout, int userId) {
        return repository.save(workout, userId);
    }
}
