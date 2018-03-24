package com.coachu.repository.datajpa;

import com.coachu.model.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudWorkoutRepository extends JpaRepository<Workout, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Workout w WHERE w.id=:id AND w.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    Workout save(Workout item);

    @Query("SELECT w FROM Workout w WHERE w.user.id=:userId ORDER BY w.dateTime DESC")
    List<Workout> getAll(@Param("userId") int userId);

    //TODO: добавить методы между датой и по пользователю
}
