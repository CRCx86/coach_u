package com.coachu.model.exercise;

import com.coachu.model.abstractentity.AbstractNamedEntity;
import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Exercise extends AbstractNamedEntity {

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<ExerciseType> exerciseTypes;

    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    public Exercise() {
    }

    public Exercise(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getExerciseTypes());
    }

    public Exercise(Integer id, String name, ExerciseType exerciseType, ExerciseType ... exerciseTypes) {
        this(id, name, EnumSet.of(exerciseType, exerciseTypes));
    }

    public Exercise(Integer id, String name, Collection<ExerciseType> exerciseTypes) {
        super(id, name);
        setExerciseTypes(exerciseTypes);
    }

    public void setExerciseTypes(Collection<ExerciseType> exerciseTypes) {
        this.exerciseTypes = CollectionUtils.isEmpty(exerciseTypes) ? Collections.emptySet() : EnumSet.copyOf(exerciseTypes);
    }

    public Set<ExerciseType> getExerciseTypes() {
        return exerciseTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseTypes=" + exerciseTypes +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
