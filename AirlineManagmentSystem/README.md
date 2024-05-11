## Airline Management System

This project implements an Airline Management System in Java. It allows users to manage various functionalities related to passengers, employees, airplanes, airports, and flights.

**Features:**

* **Passenger Management:**
    * Add new passengers
    * Search for passengers by name
    * View a list of all passengers
    * Edit existing passenger information
    * Delete passengers
* **Employee Management:**
    * Add new employees
    * Search for employees by name
    * View a list of all employees
    * Edit employee information
    * Delete employees
* **Airplane Management:**
    * Add new airplanes
    * View a list of all airplanes
    * Edit airplane information
    * Delete airplanes
* **Airport Management:**
    * Add new airports
    * View a list of all airports
    * Edit airport information
    * Delete airports
* **Flight Management:**
    * Create new flights
    * View a list of all flights
    * Delay flights
    * Book flights for passengers
    * Assign staff to flights
    * Cancel flights
    * View staff assigned to a flight
    * View passengers booked on a flight

**Technical Stack:**

* Java
* Database (details to be configured)
* Scanner class for user input

**Security Considerations:**

**Warning:** The current implementation does not use prepared statements for database interactions. This can lead to SQL injection vulnerabilities. It's **critical** to implement prepared statements for improved security. 

**Getting Started:**

1. Ensure you have a Java development environment set up (JDK and IDE).
2. Configure the database connection details in the `Database` class (`[path/to/Database.java]`).
3. Run the `Main` class (`java Main`) to start the application.

**Further Enhancements:**

* User authentication and authorization
* Flight scheduling functionalities
* Passenger booking management
* Reporting and analytics capabilities

**Disclaimer:**

This is a basic implementation for educational purposes. Real-world applications should prioritize security measures and consider the suggested enhancements.
