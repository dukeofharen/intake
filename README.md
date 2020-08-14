# README intake excercise

This repository contains the code for the calculator. It has an Angular frontend and a Java (Spring Boot) backend.

## Angular frontend

### How to run application

- Make sure you have Node.js installed.
- Go to "aegon-opdracht-frontend" in your terminal.
- If this is the first time running, execute `npm install` to install all dependencies.
- To run the application, run `npm start`.
- Go to http://localhost:4200 in your browser to view the application.

### How to run unit tests

- If the steps above are executed, just run `npm run test` from the terminal to run all tests.

## Java backend

### How to run application

- Make sure you have at least JDK 11 installed and that the `JAVA_HOME` environment variable is set.
- Go to "aegon-opdracht-backend" in your terminal.
- On a Unix based system, you might need to execute the command `chmod +x mvnw` to make the Maven wrapper script executable.
- Run the command `./mvnw spring-boot:run` (Linux/Mac) or `.\mvnw.cmd spring-boot:run` (Windows) to start the API.

If both the frontend and backend run, you can now make calculations using the frontend.

### How to run unit tests

- In the same folder, run the command `./mvnw test` (Linux/Mac) or `.\mvnw.cmd test` (Windows) to run the unit tests.