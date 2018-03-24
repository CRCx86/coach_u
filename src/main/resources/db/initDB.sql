DROP TABLE IF EXISTS exercise_types;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS workout_types;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL,
  calories_per_day INTEGER DEFAULT 2000    NOT NULL

);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE workouts
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id       INTEGER NOT NULL,
  date_time     TIMESTAMP NOT NULL,
  description   TEXT NOT NULL,
  -- exercise_id   INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) on DELETE CASCADE
  -- FOREIGN KEY (exercise_id) REFERENCES exercise(id) on DELETE CASCADE,
  -- FOREIGN KEY (workout_id) REFERENCES workout_type (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX workouts_unique_user_datetime_idx ON workouts (user_id, date_time);

CREATE TABLE workout_types
(
  workout_id INTEGER NOT NULL,
  type       VARCHAR,
  CONSTRAINT workout_type_idx UNIQUE (workout_id, type),
  FOREIGN KEY (workout_id) REFERENCES workouts(id) ON DELETE CASCADE
);


CREATE TABLE exercises
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  workout_id   INTEGER NOT NULL,
  description  TEXT NOT NULL,
  FOREIGN KEY (workout_id) REFERENCES workouts (id) on DELETE CASCADE
);

CREATE TABLE exercise_types
(
  exercise_id  INTEGER NOT NULL,
  type         VARCHAR,
  CONSTRAINT exercise_type_idx UNIQUE (exercise_id, type),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id) ON DELETE CASCADE
);



