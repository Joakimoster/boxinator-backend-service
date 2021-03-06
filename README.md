# Boxinator
This repository presents a small software application where the user is able to send boxes through a form to different locations on the world, and later see the boxes presented in a table view. The application contains of two views, one for sending boxes and one for viewing all of the dispatched boxes. The form includes a name for a box, a weight, a color where the user can choose a color through a Color picker and lastly countries within a dropdown menu. 

## Setup description
The project is setup with a Java spring boot application which serves as a REST api together with MySQL database for storing data. React 18 is used as a front framework together with Redux toolkit for state management. In order to make this project up and running we need to do a couple of manual steps to get started.
  
  ### Create and setup the MySql database. This step require some manual steps to get running. 
  
  1. Begin with open up MySql shell/command line and enter your credentials.
  2. To create a new database for the project use following command: CREATE DATABASE IF NOT EXISTS boxinator;
  3. Follow aforementioned step by entering this command: USE boxinator;
  4. In the boxinator repository github page there is a database folder with a script.sql file containing syntax for creating a table. Copy that and use it in the shell/command line.
  5. These steps should have created a new database. Use this command to see the columns: SHOW COLUMNS FROM boxinator.box;

  ### Initialize backend and connect to database. The Java Spring boot application needs following steps to connect towards the database and to run the application.
  
  1. Navigate through the folders in the repository to the "application.properties" file which will be located at boxinator\src\main\resources. Here you will need to swap the variables spring.datasource username and password to match your MySql credentials.
  2. Navigate to api/box/repository/BoxRepository file which will be located at boxinator\src\main\java\com\Joakim\boxinator\api\box\repository and replace the Username and password String variables to match your credentials same as aforementied step. 
  3. Navigate to the test folder and into api/boxrepository/BoxrepositoryTest test file and replace the same String variables for username and password to match the same credentials as you replaced in the aforementied step.
  4. Start the backend by following command in the terminal when you are in the src folder: mvn spring-boot:run, (maven required) else shortcommand "alt+f10". 
  5. To run tests for the backend, run this command: mvn clean test from the boxinator folder.

  ### The frontend of this project is located at https://github.com/Joakimoster/boxinator-frontend. Follow the steps to get the front-end up and running.


## Techonlogies
* Java 17 
* MySQL
* React 18 
* Redux toolkit

## Author
Joakim ??sterberg
