package com.coachu.model.exercise;

public enum ExerciseType {

    WEIGHTLIFITNG,  // ТЯЖЕЛАЯ АТЛЕТИКА
    POWERLIFTING,   // ПАУЭРЛИФТИНГ
    GYMNASTIC,      // ГИМНАСТИКА
    ROW,            // ГРЕБЛЯ
    LIGHTATHLETIC,  // ЛЕГКАЯ АТЛЕТИКА
    SWIMM,          // ПЛАВАНИЕ
    STRONGMAN;      // СТРОНГМЕН

    @Override
    public String toString() {
        return name();
    }
}
