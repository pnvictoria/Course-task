INSERT INTO groups (group_name)
SELECT 'Group ' || (ROW_NUMBER() OVER ())::text
FROM generate_series(1, 10)
ORDER BY random();

INSERT INTO courses (course_name, course_description)
VALUES ('Math', 'Math course description'),
       ('Biology', 'Biology course description'),
       ('Chemistry', 'Chemistry course description'),
       ('History', 'History course description'),
       ('Physics', 'Physics course description'),
       ('Art', 'Art course description'),
       ('Music', 'Music course description'),
       ('English', 'English course description'),
       ('Computer Science', 'Computer Science course description'),
       ('Psychology', 'Psychology course description');
	   
	   
-- Create temporary tables to store first and last names
CREATE TEMPORARY TABLE first_names (name VARCHAR(255));
INSERT INTO first_names VALUES ('John'), ('Mary'), ('David'), ('Linda'), ('Michael'), 
                                ('Sarah'), ('Robert'), ('Karen'), ('James'), ('Susan'),
                                ('Daniel'), ('Nancy'), ('Christopher'), ('Lisa'), ('Paul'),
                                ('Jennifer'), ('Steven'), ('Elizabeth'), ('Kevin'), ('Laura');

CREATE TEMPORARY TABLE last_names (name VARCHAR(255));
INSERT INTO last_names VALUES ('Smith'), ('Johnson'), ('Brown'), ('Taylor'), ('Miller'),
                               ('Anderson'), ('Wilson'), ('Moore'), ('Jackson'), ('Martin'),
                               ('Lee'), ('Garcia'), ('Martinez'), ('Davis'), ('Rodriguez'),
                               ('Clark'), ('Hill'), ('Scott'), ('Young'), ('Allen');

-- Insert 200 students with random first and last names
INSERT INTO students (group_id, first_name, last_name)
SELECT 
    FLOOR(RANDOM() * 10) + 1, -- randomly assign to one of the 10 groups
    (SELECT name FROM first_names ORDER BY RANDOM() LIMIT 1), -- random first name
    (SELECT name FROM last_names ORDER BY RANDOM() LIMIT 1) -- random last name
FROM generate_series(1, 200);

-- Update each student with a random group ID
UPDATE students
SET group_id = FLOOR(RANDOM() * 10) + 1; -- randomly assign to one of the 10 groups

-- Assign each group a random number of students between 10 and 30
UPDATE groups
SET group_name = CONCAT(group_name, ' (', 
                        (SELECT COUNT(*) FROM students WHERE students.group_id = groups.group_id),
                        ' students)')
WHERE group_id IN (
    SELECT DISTINCT ON (group_id) group_id
    FROM students
    ORDER BY group_id, RANDOM()
    LIMIT 10
);

-- Insert random course enrollments for each student
INSERT INTO student_courses (student_id, course_id)
SELECT s.student_id, c.course_id
FROM students s
CROSS JOIN courses c
WHERE random() <= 0.5 -- 50% chance of enrolling in each course
GROUP BY s.student_id, c.course_id
HAVING COUNT(*) <= 3; -- maximum of 3 courses per student