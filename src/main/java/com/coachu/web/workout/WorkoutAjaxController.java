package com.coachu.web.workout;

import com.coachu.View;
import com.coachu.model.workout.Workout;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/workouts")
public class WorkoutAjaxController extends AbstractWorkoutController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Workout> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Workout get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Validated(View.Web.class) Workout workout) {
        if (workout.isNew()) {
            super.create(workout);
        }else {
            super.update(workout, workout.getId());
        }
    }
}
