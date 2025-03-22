# **Parking Lot Management System**

## **Overview**
The **Parking Lot Management System** is a Java-based application designed to manage parking spots and vehicles in a parking lot. It allows users to:
- Park vehicles (cars, bikes, trucks).
- Unpark vehicles.
- View available parking spots.
- Persist data to a binary file for future use.

The system is built using **Object-Oriented Programming (OOP)** principles and follows a **layered architecture** (Controller → Service → Repository). It also uses the **Builder Pattern** for creating parking spots and **Java Serialization** for data persistence.

---

## **Features**
1. **Park a Vehicle**:
   - Users can park vehicles of different types (car, bike, truck).
   - The system automatically assigns an available parking spot.

2. **Unpark a Vehicle**:
   - Users can unpark a vehicle by specifying the parking spot ID.

3. **View Available Spots**:
   - Users can view all available parking spots for a specific vehicle type.

4. **Data Persistence**:
   - All data (parking spots and parked vehicles) is saved to a binary file (`parking_lot_data.bin`).
   - Data is automatically loaded when the application starts.

5. **Exception Handling**:
   - Custom exceptions are used to handle errors (e.g., parking lot full, spot not found).

6. **Builder Pattern**:
   - Parking spots are created using the **Builder Pattern** for better readability and flexibility.

---

## **Technologies Used**
- **Java**: Core programming language.
- **OOP Principles**: Encapsulation, Inheritance, Polymorphism, Abstraction.
- **Design Patterns**: Builder Pattern, Layered Architecture.
- **File Handling**: Java Serialization for saving and loading data.

---

## **Project Structure**
The project is organized into the following packages:

src
└── com
└── parkinglot
├── controller
│ └── ParkingLotController.java
├── exception
│ ├── ParkingLotFullException.java
│ ├── ParkingSpotNotFoundException.java
│ └── DataAccessException.java
├── factory
│ └── VehicleFactory.java
├── model
│ ├── Vehicle.java
│ ├── Car.java
│ ├── Bike.java
│ ├── Truck.java
│ ├── ParkingSpot.java
│ └── VehicleType.java
├── repository
│ ├── ParkingLotRepository.java
│ └── ParkingSpotRepository.java
├── service
│ ├── ParkingLotService.java
│ └── FeeCalculationService.java
├── utils
│ ├── DateUtils.java
│ └── FileUtils.java
└── Main.java


---

## **How to Run the Project**

### **Prerequisites**
- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed.
- **IDE**: Use an IDE like IntelliJ IDEA, Eclipse, or VS Code for easier setup.

### **Steps**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/parking_management_system.git
   cd parking_management_system

===== Parking Lot Management System =====
1. Park a Vehicle
2. Unpark a Vehicle
3. View Available Spots
4. Load Data from File
5. Exit
Enter your choice: 1
Enter vehicle type (CAR, BIKE, TRUCK): CAR
Enter vehicle license plate: ABC123
Vehicle parked successfully: ABC123

===== Parking Lot Management System =====
1. Park a Vehicle
2. Unpark a Vehicle
3. View Available Spots
4. Load Data from File
5. Exit
Enter your choice: 2
Enter parking spot ID: spot1
Vehicle unparked successfully from spot: spot1

===== Parking Lot Management System =====
1. Park a Vehicle
2. Unpark a Vehicle
3. View Available Spots
4. Load Data from File
5. Exit
Enter your choice: 3

Available Parking Spots:
Spot ID: spot1, Type: CAR
Spot ID: spot2, Type: BIKE
Spot ID: spot3, Type: TRUCK

===== Parking Lot Management System =====
1. Park a Vehicle
2. Unpark a Vehicle
3. View Available Spots
4. Load Data from File
5. Exit
Enter your choice: 3

Available Parking Spots:
Spot ID: spot1, Type: CAR
Spot ID: spot2, Type: BIKE
Spot ID: spot3, Type: TRUCK
