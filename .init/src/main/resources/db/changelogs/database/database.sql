DROP SCHEMA IF EXISTS rh CASCADE;

CREATE SCHEMA rh;

CREATE TABLE IF NOT EXISTS rh.position
(
    id SERIAL PRIMARY KEY,
    position_title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS rh.subdivision
(
    id SERIAL PRIMARY KEY,
    subdivision_title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS rh.state
(
    id SERIAL PRIMARY KEY,
    subdivision_id INTEGER NOT NULL REFERENCES rh.subdivision ON DELETE CASCADE,
    position_id INTEGER NOT NULL REFERENCES rh.position ON DELETE CASCADE,
    state_amount INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS rh.employee
(
    id SERIAL PRIMARY KEY,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    rank VARCHAR(255) NOT NULL ,
    position_id INTEGER NOT NULL REFERENCES rh.position ON DELETE CASCADE,
    subdivision_id INTEGER NOT NULL REFERENCES rh.subdivision ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS rh.position_log
(
    id SERIAL PRIMARY KEY,
    getting_date DATE NOT NULL,
    employee_id INTEGER NOT NULL REFERENCES rh.employee ON DELETE CASCADE,
    position_id INTEGER NOT NULL REFERENCES rh.position ON DELETE CASCADE,
    subdivision_id INTEGER NOT NULL REFERENCES rh.subdivision ON DELETE CASCADE,
    order_publisher VARCHAR(255) NOT NULL,
    order_number INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS rh.rank_log
(
    id SERIAL PRIMARY KEY,
    getting_date DATE NOT NULL,
    employee_id INTEGER NOT NULL REFERENCES rh.employee ON DELETE CASCADE,
    rank VARCHAR(255) NOT NULL,
    order_publisher VARCHAR(255) NOT NULL,
    order_number INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS rh.user
(
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);