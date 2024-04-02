# StudentDatabaseManager

This is a simple console-based Java application for managing a student database using MySQL. It allows users to add, remove, and display student records.
## Introduction

This Java application connects to a MySQL database and provides a user-friendly interface for managing student records. It is implemented using JDBC (Java Database Connectivity) for database operations.

## Prerequisites
Before running this application, ensure that you have the following installed on your system:

  Java Development Kit (JDK), MySQL database server and MySQL Connector/J JDBC driver
  
## Set up the MySQL database:

  Make sure your MySQL database server is up and running.
  Create a new database named StudentDB.
  Set up a table named students with appropriate fields to store student records. You can use the following SQL script:

    CREATE TABLE students (
        id INT AUTO_INCREMENT PRIMARY KEY AUTO_INCREMENT,
        first_name VARCHAR(15) NOT NULL,
        last_name VARCHAR(15) NOT NULL,
        contact_no VARCHAR(10) NOT NULL,
        email VARCHAR(40) NOT NULL
    );
