# Student Directory Application

## Overview

This repository contains my implementation of a student directory application, extended with a Swing-based graphical user interface (GUI). The application allows users to create new student entries, search for entries by Andrew ID, first name, or last name, and delete entries. The core functionality is built upon a previous assignment, which managed student data using a data access object (DAO) pattern. The Swing interface enhances user interaction with the application.

## Description

The Student Directory application provides a comprehensive solution for managing student data. Users can load initial data from a CSV file, add new student entries, search for students by various criteria, and delete entries. The application displays results and error messages in a scrollable text area.

## Features

### Core Functionality
- **Student Class**: Models a student with first name, last name, Andrew ID, and phone number.
- **Directory Class**: Manages a collection of students using three maps for efficient searching:
  - **Map 1**: Maps Andrew ID to Student object.
  - **Map 2**: Maps first name to a list of Student objects.
  - **Map 3**: Maps last name to a list of Student objects.

### GUI Components
- **Text Fields**: Fields for entering first name, last name, Andrew ID, and phone number.
- **Buttons**:
  - `Search By Andrew ID`: Searches for a student by Andrew ID.
  - `Search By First Name`: Searches for students by first name.
  - `Search By Last Name`: Searches for students by last name.
  - `Add`: Adds a new student entry.
  - `Delete`: Deletes a student entry by Andrew ID.
- **Results Area**: A scrollable text area that displays search results, added entries, deleted entries, and error messages.

### Data Management
- **Load Data**: Loads initial data from a CSV file specified as a command line parameter. The CSV file should have the following format:
  ```plaintext
  "First Name","Last Name","Andrew ID","Phone Number"
  "Terry","Lee","eunsunl","412-268-1078"
  "Jeffrey","Eppinger","je0k","412-268-7688"

- **Search Functionality**:
- **By Andrew ID**: Displays a student's details if a match is found, otherwise shows an error message.
- **By First Name/Last Name**: Displays a list of matching students if any are found, otherwise shows an error message.
- **Add New Entry**: Allows users to add a new student entry with the specified details. Required fields are first name, last name, and Andrew ID. Phone number is optional.
- **Delete Entry**: Allows users to delete a student entry by Andrew ID. Displays the details of the deleted entry or an error message if no match is found.

### Error Handling
- **Input Validation**: Ensures that required fields are not empty and that Andrew ID is unique when adding a new entry.
- **Error Messages**: Displays specific error messages for missing fields, duplicate Andrew IDs, and other input errors.

### UI Fine Points
- **Focus Management**: The focus is set to the search key text field when the window opens.
- **Enter Key Shortcut**: Pressing the Enter key in the search key text field executes the search by Andrew ID action.
- **Text Field and Area Management**: Clears text fields after successful operations. Keeps the Results area content after successful operations and clears it after errors.
- **Scrollable Results Area**: Ensures the Results area is scrollable to handle many lines of output.

## Implementation Details

To deepen my understanding of GUI development, data management, and data access patterns, I implemented this project with specific constraints and rules:

- **Swing Development**: Built a responsive and interactive GUI using Swing components.
- **CSV Data Loading**: Implemented functionality to load initial data from a CSV file.
- **DAO Pattern**: Utilized the data access object pattern for managing student data with the `Student` and `Directory` classes.
- **Error Handling**: Developed comprehensive error handling to ensure robust data validation and user feedback.
- **Scroll Pane**: Used a scroll pane for the Results area to handle large amounts of text.

## Usage

To use the Student Directory application, compile and run the `DirectoryDriver.java` file. Optionally, provide a CSV file as a command line parameter to load initial data.

## Learnings

- **Swing Development**: I learned to create a responsive and interactive GUI using Swing components.
- **Data Management**: I developed skills in handling CSV data and managing in-memory data structures.
- **DAO Pattern**: I gained experience in implementing and using the data access object pattern for efficient data management.
- **Event Handling**: I gained experience in handling user interactions and updating the GUI based on events.
- **Error Handling**: I implemented robust error handling to provide meaningful feedback to users.

## Conclusion

This project was a valuable experience in developing a desktop application using Swing and managing data effectively with a DAO pattern. The Student Directory application demonstrates my ability to create interactive applications with a focus on usability and data integrity.
