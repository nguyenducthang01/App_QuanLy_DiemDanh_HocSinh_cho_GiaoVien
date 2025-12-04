DROP DATABASE IF EXISTS student_attendance;
CREATE DATABASE  student_attendance;
USE student_attendance;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role INT NOT NULL -- 1,2,3
);

INSERT INTO users (username, password, role) VALUES ('admin', '123456', '2');