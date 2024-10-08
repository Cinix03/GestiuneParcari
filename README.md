Overview

This JavaFX application enables the management of parking facilities by allowing users to add and remove parking locations. The main interface features a dynamic table displaying details such as parking name, address, surface area, total spots, and available spots. Additionally, users can double-click on any parking location in the table to open a new window, where the parking layout is represented by an X-by-Y grid. In this grid, each button represents a parking spot, and clicking a button toggles its status between occupied and free, with the button color indicating the current state (red for occupied, green for free).

The application also includes a pie chart that visually represents the ratio of free to occupied parking spaces, which updates automatically based on the current data.

OOP Principles Used

The application leverages several fundamental Object-Oriented Programming principles:

Encapsulation: The application's core data and behavior are organized into classes such as Parcare, which encapsulate the logic for managing parking facilities.
Polymorphism: This principle is demonstrated through method overriding. For example, the class FereastraPieChart extends the Application class from JavaFX and overrides the start(Stage stage) method to implement custom behavior for initializing the GUI and setting up observers. Despite being treated as an Application, the object will execute the start() method defined in FereastraPieChart at runtime, allowing for dynamic method invocation based on the actual object type.
Inheritance: The class hierarchy allows for code reuse and specialization, where FereastraVizualizareLocuri inherits from Application and adds specific functionality needed for the parking management context.
Observer Design Pattern: The application uses this pattern to keep the UI components, like the pie chart and multiple open windows, synchronized. Changes in parking data are automatically propagated to all observers, ensuring that the data displayed is always up to date.
This description highlights the core functionalities of the application and explains how key OOP principles, including encapsulation, polymorphism, inheritance, and the Observer pattern, are applied in its development.
<img width="747" alt="Screenshot 2024-09-03 at 17 58 06" src="https://github.com/user-attachments/assets/b5ed7e3f-cf98-41b7-8962-c82824e16b36">
