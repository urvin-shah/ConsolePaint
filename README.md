# Console Paint
This application will allow draw canvas and other shapes.

## Table of contents
* [General info](#general-info)
* [Assmuptions](#assumptions)  
* [Technologies](#technologies)
* [Setup](#setup)
* [Code coverage](#code-coverage)

## General info
The program will ask to enter appropriate allowed commands as below :

* Create a new canvas
* Start drawing on the canvas by issuing various commands.
* Quit

| Command | Description |
| --------|-------------|
| C w h   | Should create a new canvas of width w and height h. |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines Horizontal and vertical lines will be drawn using the 'x' character.|
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner and vertical lines will be drawn using the 'x' character. |
| B x y c | Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the "bucket fill" tool in paint programs.|
| Q | Should quit the program. |

## Assumptions

* User will have to enter positive integer number to draw the Canvas
* Only Horizontal and Vertical lines can be drawn.
* Lines can be drawn inside the Canvas only, so the co-ordinates which are mismatching to the canvas will result into provide error message.
* Rectangle can be drawn inside the Canvas only, so the co-ordinates which are mismatching to the canvas will result into provide error message.
* Bucket fill command will expect the x,y co-ordinates must be within the range of the Canvas only, so the co-ordinates which are mismatching to the canvas will result into provide error message.
* Bucket fill will fill with the given color(character) inside the canvas. It will replace all ' ' char.

## Technologies
Project is created with:
* Java 8
* Maven

Below maven dependency used:
- Junit (used for unit and integration testing)
- System-Lambda (Used to read the output text of System.out.println for printGameBoard())
- Surefire to run the JUnit testcases.
## Setup
To run the project locally using maven
###Prerequisites
* Maven
* JDK 8

####Please follow below steps to run the project through maven locally:

1 Run below maven command from source directory to create jar file
```
$ mvn clean install
```
2 Run below command to locate the generated jar file.
```
$ cd target/
```
3 Run below java command to run the application from jar file
```
$ java -jar ConsolePaint-1.0.jar
```
4 Application will start and display the empty message. And ask Player 1 to throw the red disc in column (1-7).
```
Welcome to Console Application !!!
Please apply below Commands :
1. C w h  : To Create a new canvas of width w and height h. |
2. L x1 y1 x2 y2 : To draw a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines Horizontal and vertical lines will be drawn using the 'x' character.
3. R x1 y1 x2 y2 : To draw a new rectangle, whose upper left corner is (x1,y1) and lower right corner and vertical lines will be drawn using the 'x' character. 
4. B x y c : To fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the "bucket fill" tool in paint programs.
5. Q To quit the program. 
```
4 Please make sure to enter valid Command else it will display error message and ask to enter the command again.
```
Please Enter Paint Command:t 45 45
Invalid command, This command is not supported by this application

Please Enter Paint Command:
```

##Code coverage
We are following TDD approach for development.

Test Case result of Surefire report:
```
[INFO] Results:
[INFO]
[INFO] Tests run: 20, Failures: 0, Errors: 0, Skipped: 0
[INFO]
```
Note: I wrote the Unit test cases for the required classes only.