DELETE FROM user_roles;
-- DELETE FROM meals;
DELETE FROM users;
DELETE FROM workout_types;
DELETE FROM workouts;
DELETE FROM exercises;
DELETE FROM exercise_types;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO workouts (date_time, description, user_id) VALUES
  ('2015-05-30 10:00:00', 'EMOM', 100000),
  ('2015-05-30 13:00:00', 'AMRAP', 100000),
  ('2015-05-30 20:00:00', 'FORTIME', 100000),
  ('2015-05-31 10:00:00', 'HAVIEST', 100000),
  ('2015-05-31 13:00:00', 'EMOM', 100000),
  ('2015-05-31 20:00:00', 'SETS', 100000),
  ('2015-06-01 14:00:00', 'НА ВРЕМЯ', 100001),
  ('2015-06-01 21:00:00', 'БЕЗ ВРЕМЕНИ', 100001);

INSERT INTO workout_types (workout_id, type) VALUES
  (100002, 'EMOM'),
  (100003, 'AMRAP'),
  (100004, 'FORTIME'),
  (100005, 'HAVIEST'),
  (100006, 'EMOM'),
  (100007, 'SETS'),
  (100008, 'FORTIME'),
  (100009, 'NOTFORTIME');

INSERT INTO exercises (description, workout_id) VALUES
  ('отжимания в стойке на руках', 100002),
  ('приседания со штангой на плечах', 100002),
  ('фронтальные приседания', 100003),
  ('жим лежа', 100003),
  ('выходы силой на кольцах', 100003),
  ('бег', 100004),
  ('гребля', 100004),
  ('броски мяча в стену', 100004);

INSERT INTO exercise_types (exercise_id, type) VALUES
  (100010, 'GYMNASTIC'),
  (100011, 'WEIGHTLIFITNG'),
  (100012, 'WEIGHTLIFITNG'),
  (100013, 'POWERLIFTING'),
  (100014, 'GYMNASTIC'),
  (100015, 'LIGHTATHLETIC'),
  (100016, 'ROW'),
  (100017, 'LIGHTATHLETIC');

-- INSERT INTO meals (date_time, description, calories, user_id) VALUES
--   ('2015-05-30 10:00:00', 'Завтрак', 500, 100000),
--   ('2015-05-30 13:00:00', 'Обед', 1000, 100000),
--   ('2015-05-30 20:00:00', 'Ужин', 500, 100000),
--   ('2015-05-31 10:00:00', 'Завтрак', 500, 100000),
--   ('2015-05-31 13:00:00', 'Обед', 1000, 100000),
--   ('2015-05-31 20:00:00', 'Ужин', 510, 100000),
--   ('2015-06-01 14:00:00', 'Админ ланч', 510, 100001),
--   ('2015-06-01 21:00:00', 'Админ ужин', 1500, 100001);



