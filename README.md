# Boxinator
This repository presents a small software application where the user is able to send boxes through a form to different locations on the world, and later see the boxes presented in a table view. The application contains of two views, one for sending boxes and one for viewing all of the dispatched boxes. The form includes a name for a box, a weight, a color where the user can choose a color through a Color picker and lastly country locations within a dropdown menu. 

## Setup description
The project is setup with a Java spring boot application which serves as a REST api together with MySQL database for storing data. React 18 is used as a front framework together with Redux. In order to make this project up and running we need to do a couple of manual steps to get started.
  
  #Create and setup the MySql database. This step require some manual steps and work to get running. 
  
  1. Begin with open up MySql shell/command line and use your credentials.
  2. To create a new database for the project use following command: CREATE DATABASE IF NOT EXISTS boxinator;
  3. Follow aforementioned step by entering this command: USE boxinator;
  4. In the boxinator repository page there is a database folder with a script.sql file containing syntax for creating a table. Copy that and use it in the shell.
  5. These steps should have created a new database. Use this command to see the columns: SHOW COLUMNS FROM boxinator.box;


  

## Techonlogies
* Java 17 
* MySQL
* React 18 
* Redux toolkit

## Author
Joakim Österberg
