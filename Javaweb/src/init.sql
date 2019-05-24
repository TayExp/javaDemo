-- init tables

DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS classes;

CREATE TABLE classes (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE students (
	id BIGINT NOT NULL AUTO_INCREMENT,
	class_id BIGINT NOT NULL,
	name VARCHAR(10) NOT NULL,
	gender CHAR(1) NOT NULL,
	CONSTRAINT fk_class_id FOREIGH KEY (class_id) REFERENCES classes(id),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--init data:
INSERT INTO classes (name) VALUES ('一班')；
INSERT INTO classes (name) VALUES ('二班')；
INSERT INTO classes (name) VALUES ('三班')；
INSERT INTO classes (name) VALUES ('四班')；

INSERT INTO students (class_id, name, gender) VALUES (1, '小1', 'M') ；
INSERT INTO students (class_id, name, gender) VALUES (1, '小11', 'F') ；
INSERT INTO students (class_id, name, gender) VALUES (1, '小111', 'M') ；
INSERT INTO students (class_id, name, gender) VALUES (2, '小2', 'M') ；
INSERT INTO students (class_id, name, gender) VALUES (2, '小22', 'F') ；
INSERT INTO students (class_id, name, gender) VALUES (3, '小3', 'M') ；
INSERT INTO students (class_id, name, gender) VALUES (3, '小33', 'F') ；
INSERT INTO students (class_id, name, gender) VALUES (4, '小4', 'F') ；
INSERT INTO students (class_id, name, gender) VALUES (4, '小44', 'M') ；