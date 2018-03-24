package com.coachu.model.workout;

public enum WorkoutType {

    AMRAP,
    EMOM,
    FORTIME,
    NOTFORTIME,
    HAVIEST,
    SETS;

    @Override
    public String toString() {
        return name();
    }
}
