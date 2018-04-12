package com.coachu.web.workout;

import com.coachu.View;
import com.coachu.model.workout.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = WorkoutRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkoutRestController extends AbstractWorkoutController{
    static final String REST_URL = "/rest/profile/workouts";

    @Override
    @GetMapping("/{id}")
    public Workout get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping
    public List<Workout> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Validated(View.Web.class) @RequestBody Workout workout, @PathVariable("id") int id) {
        super.update(workout, id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Workout> createWithLocation(@Validated(View.Web.class) @RequestBody Workout workout) {
        Workout created = super.create(workout);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
