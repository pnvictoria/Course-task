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