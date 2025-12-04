
-- Tạo bảng student
CREATE TABLE student (
  student_id INT PRIMARY KEY,
  student_name VARCHAR(100)
);

-- Tạo bảng teacher
CREATE TABLE teacher (
  teacher_id INT PRIMARY KEY,
  teacher_name VARCHAR(100)
);

-- Tạo bảng class
CREATE TABLE class (
  class_id INT PRIMARY KEY,
  class_name VARCHAR(100),
  teacher_id INT,
  s_location VARCHAR(100),
  FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

-- Tạo bảng student_schedule
CREATE TABLE student_schedule (
  s_id INT AUTO_INCREMENT PRIMARY KEY,
  s_name VARCHAR(100),
  s_tstart TIME,
  s_tend TIME,
  s_daybegin DATE,
  s_dayend DATE,
  student_id INT,
  teacher_id INT,
  s_location VARCHAR(100),
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

-- Chèn dữ liệu mẫu vào bảng student
INSERT INTO student (student_id, student_name) VALUES
(725105187, 'Nguyen A'),
(725105188, 'Nguyen B'),
(725105189, 'Nguyen C');

-- Chèn dữ liệu mẫu vào bảng teacher
INSERT INTO teacher (teacher_id, teacher_name) VALUES
(1, 'Tran D'),
(2, 'Le E');

-- Chèn dữ liệu mẫu vào bảng class
INSERT INTO class (class_id, class_name, teacher_id, s_location) VALUES
(1, 'Lập trình Java', 1, 'Phòng 101'),
(2, 'Lập trình Python', 2, 'Phòng 102');

-- Chèn dữ liệu vào bảng student_schedule
INSERT INTO student_schedule (s_name, s_tstart, s_tend, s_daybegin, s_dayend, student_id, teacher_id, s_location)
SELECT 
    c.class_name AS s_name,
    MAKETIME(FLOOR(RAND() * 5 + 8), 0, 0) AS s_tstart, -- Từ 08:00 đến 12:00
    MAKETIME(FLOOR(RAND() * 2 + 10), 0, 0) AS s_tend,   -- Từ 10:00 đến 12:00
    CURDATE() AS s_daybegin,
    DATE_ADD(CURDATE(), INTERVAL 3 MONTH) AS s_dayend,
    s.student_id,
    c.teacher_id,
    c.s_location
FROM
    student s
JOIN
    class c ON 1=1 -- Gán mỗi sinh viên vào mỗi lớp (nhiều bản ghi)
LIMIT 10; -- Chèn 10 bản ghi để minh hoạ
