Payroll System Simulation in Java

This Java code implements a basic payroll system with an inheritance-based design, suitable for various types of employees, including hourly, salaried, and executive employees. It contains an Employee base class with attributes and methods to manage employee information and a default bonus calculation method. Derived classes override this behavior to fit their respective pay structures.

Classes and Functionalities:

Employee: The base class for all employee types, with attributes for employee ID, name, and designation. It includes:

A constructor for initializing the employee attributes.
Getters for retrieving employee details.
A calculateBonus method, which is overridden by subclasses.
A displayInfo method to print the employee's basic details.
HourlyEmployee: Represents employees paid by the hour. It includes:

Attributes for hourly rate and hours worked.
A calculateWeeklySalary method to compute weekly earnings.
An overridden calculateBonus method that awards a 10% bonus of the weekly salary.
A displayInfo method to show hourly employee details, weekly salary, and bonus.
SalariedEmployee: Represents employees with a fixed monthly salary. It includes:

An attribute for the monthly salary.
A calculateWeeklySalary method that computes the salary on a weekly basis.
An overridden calculateBonus method that awards a 20% bonus of the weekly salary.
A displayInfo method to show salaried employee details, including the monthly salary, weekly salary, and bonus.
ExecutiveEmployee: Extends SalariedEmployee to represent executives with an additional annual bonus percentage. It includes:

An attribute for bonus percentage.
An overridden calculateBonus method, calculating an annual bonus based on a specified percentage of the yearly salary.
A displayInfo method to display executive-specific details, such as the monthly salary, weekly salary, bonus percentage, and annual bonus.
PayrollSystem (Main class): Instantiates different employee types and displays their details.

This project demonstrates the use of inheritance, method overriding, and encapsulation to implement an extensible payroll system.
