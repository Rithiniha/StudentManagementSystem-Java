# Student Management System

The Student Management System is a simple Java application to manage student records efficiently. It provides functionality for adding, viewing, updating, deleting, and sorting students, along with search capabilities by student ID or name.

**Features**

- **Add Students**: Add a new student by providing their ID, name, and grade.
- **View All Students**: Display a list of all students in the system.
- **Search by ID**: Find a specific student using their unique ID.
- **Search by Name**: Look up a student by their name (case-insensitive).
- **Update Student**: Update a student’s name or grade using their ID.
- **Remove Students**: Delete a student’s record from the system.
- **Sort Students by Name**: Display all students sorted alphabetically by name.

## How It Works

- The application uses an `ArrayList`, `HashMap`, and `TreeSet` for efficient data management:
  - `ArrayList` for storing all students.
  - `HashMap` for quick search by student ID.
  - `TreeSet` for maintaining sorted names.
- A console menu allows users to interact with the system.


