### Task 1.1

Write an application to reverse all words of an input text:

* Every word in the text should be reversed.
* All non-alphabetic symbols should remain in the same position.
* Tested with Latin alphabet only.

Example of output (abcd efgh):

      dcba hgfe


### Task 1.2

Take your previous task and write a JUnit test for it.

* Use Junit5 dependency
* Tests should be run with the project build
* Maven surefire plugin
* Use proper test method naming conventions
* Add support for the Sonar-lint plugin in your IDE.
* Add Editorconfig support to your project.

### Exercise 1.3

Write an integer division application that divides numbers and
Output the result to the console. Use Maven, don't forget about it
Cover your code with unit tests.

Example of output (78/4):

                _78|4
                 4 |--
                 - |19
                _38
                 36
                 --
                  2";

### Task 1.4

Write an application that takes a string and returns the number of unique characters in the string.

* It is expected that a string with the same character sequence may be passed several times to the method.
* Since the counting operation can be time-consuming, the method 
should cache the results, so that when the method is given a string 
previously encountered, it will simply retrieve the stored result. 
Use collections and maps where appropriate.

Example of output (repeat):

            "r" - 1
            "e" - 2
            "p" - 1
            "a" - 1
            "t" - 1

### Task 1.5

There are 2 log files start.log and end.log that contain 
start and end data of the best lap for each racer of 
Formula 1 - Monaco 2018 Racing. (Start and end times are 
fictional, but the best lap times are true). Data contains
only the first 20 minutes that refers to the first stage of 
the qualification.

Q1: For the first 20 minutes (Q1), all cars together on the track try 
to set the fastest time. The slowest seven cars are eliminated, earning
the bottom grid positions. Drivers are allowed to complete as many laps 
as they want during this short space of time.

Top 15 cars are going to the Q2 stage. If you are so curious, 
you can read the rules here 
https://www.thoughtco.com/developing-saga-of-formula1-qualifying-1347189

The third file abbreviations.txt contains abbreviation explanations.

Parse hint: SVF2018-05-24_12:02:58.917

SVF - racer abbreviation 2018-05-24 - date 12:02:58.917 - time

Your task is to read data from 2 files, order racers by time and print report that shows 
the top 15 racers and the rest after underline, for example:
* Daniel Ricciardo | RED BULL RACING TAG HEUER | 1:12.013
* Sebastian Vettel | FERRARI | 1:12.415

### Task 2.1

SQL
Create an application sql-jdbc-school that inserts/updates/deletes data in the database using JDBC.
Use PostgreSQL DB.

Tables (given types are Java types, use SQL analogs that fit the most:
                
                groups(
                    group_id int,
                    group_name string
                );
                    students(
                    student_id int,
                    group_id int,
                    first_name string,
                    last_name string
                );
                    courses(
                    course_id int,
                    course_name string,
                    course_description string
                );

1. Create SQL files with data:

   a. create user and database. Assign all privileges on the database to the user.
   (DB and user should be created before application runs)

   b. create a file with tables creation

2. Create a java application

   a. On startup, it should run SQL script with tables creation from previously created files.
   If tables already exist - drop them.

   b. Generate test data:

   	* 10 groups with randomly generated names. The name should contain 2 characters, hyphen, 2 numbers

   	* Create 10 courses (math, biology, etc)

   	* 200 students. Take 20 first names and 20 last names and randomly combine them to generate students.

   	* Randomly assign students to groups. Each group could contain from 10 to 30 students. 
   It is possible that some groups will be without students or students without groups

   	* Create relation MANY-TO-MANY between tables STUDENTS and COURSES. Randomly assign from 1 to 3 courses for each student

3. Write SQL Queries, it should be available from the application menu:
   a. Find all groups with less or equals student count
   b. Find all students related to course with given name
   c. Add new student
   d. Delete student by STUDENT_ID
   e. Add a student to the course (from a list)
   f. Remove the student from one of his or her course