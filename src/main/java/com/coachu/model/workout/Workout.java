package com.coachu.model.workout;

import com.coachu.View;
import com.coachu.model.abstractentity.AbstractBaseEntity;
import com.coachu.model.user.User;
import com.coachu.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "workouts", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_time"}, name = "workouts_unique_user_datetime_idx")})
public class Workout extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    @SafeHtml(groups = {View.Web.class})
    private String description;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "workout_types", joinColumns = @JoinColumn(name = "workout_id"))
    @Column(name = "type")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<WorkoutType> workoutTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Workout() {
    }

    public Workout(Workout workout) {
        this(null, workout.getDateTime(), workout.getWorkoutTypes());
    }

    public Workout(Integer id, String name, LocalDateTime dateTime, WorkoutType workoutType, WorkoutType ... workoutTypes) {
        this(id, dateTime, EnumSet.of(workoutType, workoutTypes));
    }

    public Workout(Integer id, LocalDateTime dateTime, Collection<WorkoutType> workoutTypes) {
        super(id);
        this.dateTime = dateTime;
        setWorkoutTypes(workoutTypes);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<WorkoutType> getWorkoutTypes() {
        return workoutTypes;
    }

    public void setWorkoutTypes(Collection<WorkoutType> workoutTypes) {
        this.workoutTypes = CollectionUtils.isEmpty(workoutTypes) ? Collections.emptySet() : EnumSet.copyOf(workoutTypes);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonGetter
    @JsonView()
    @JsonFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    public LocalDateTime getDateTimeUI() {
        return dateTime;
    }

    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    public void setDateTimeUI(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", workoutTypes=" + workoutTypes +
                ", id=" + id +
                '}';
    }
}
