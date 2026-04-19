# Vehicle Rental System

This is my first project.

A JavaFX-based vehicle rental management application built with Maven. This system allows users to browse, book, and manage rental vehicles (cars, bikes, and trucks) with a role-based access control system.

## Project Overview

This is a college submission project that demonstrates core Object-Oriented Programming (OOP) concepts including **interfaces**, **composition**, and **polymorphism**. The application provides a user-friendly GUI for customers to rent vehicles and displays real-time inventory management.

## Features

### User-Facing Features
- **Role-Based Login**: Separate access for users and admins
- **Vehicle Gallery**: Browse available vehicles filtered by type (Car, Truck, Bike)
- **Real-Time Availability**: View current status of each vehicle
- **Booking System**: 
  - Select start and end dates
  - Automatic price calculation based on rental duration
  - Past-date validation to prevent invalid bookings
- **Return Management**: Return rented vehicles and make them available again
- **Booking Summary**: View confirmed booking details with total rental cost

### Admin Features
- Vehicle management and status tracking
- Monitor total rentals and availability

### Technical Features
- **OOP Design**: Interface-based rental system with multiple vehicle implementations
- **Composition Pattern**: Vehicles class manages collections of different vehicle types
- **Session Management**: In-memory user session handling
- **Dynamic UI Updates**: Real-time TilePane refresh after booking/return actions
- **Professional CSS Styling**: McLaren-inspired dark theme with orange accents

## Architecture

### Core Classes

**Models:**
- `Rental.java` - Interface defining rental operations
- `Vehicle Implementations` - `Car.java`, `Truck.java`, `Bike.java` (implement Rental)
- `Vehicles.java` - Composition class managing all vehicle collections
- `Users.java` - User model with name, username, password, role
- `Booking.java` - Booking data model (session-scoped static fields)

**Controllers & Managers:**
- `Main.java` - Application entry point
- `control.java` - Login and scene switching logic
- `LoginControl.java` - Authentication handler
- `UserPanel.java` - Gallery display and rental card management
- `BookManager.java` - Booking form and date validation

**Utilities:**
- `Session.java` - Global session holder for current user and shared vehicle instance

### UI Components
- `Main.fxml` - Welcome/splash screen
- `Access.fxml` - Login interface
- `User.fxml` - Vehicle gallery with ChoiceBox filter and TilePane display
- `VehicleGallary.fxml` - Booking panel with date pickers and summary
- `Admin.fxml` - Admin dashboard (template)
- `application.css` - Styling with McLaren racing theme

## Technology Stack

- **Language**: Java 25
- **Framework**: JavaFX (v25)
- **Build Tool**: Maven
- **Build Management**: Maven Compiler Plugin 3.11.0
- **IDE**: NetBeans / VS Code (with JavaFX support)

## Project Structure

```
src/
├── main/
│   ├── java/application/
│   │   ├── Main.java
│   │   ├── Rental.java (Interface)
│   │   ├── Car.java
│   │   ├── Bike.java
│   │   ├── Truck.java
│   │   ├── Vehicles.java
│   │   ├── Users.java
│   │   ├── Booking.java
│   │   ├── Session.java
│   │   ├── control.java
│   │   ├── LoginControl.java
│   │   ├── UserPanel.java
│   │   ├── BookManager.java
│   └── resources/
│       ├── Main.fxml
│       ├── Access.fxml
│       ├── User.fxml
│       ├── VehicleGallary.fxml
│       ├── Admin.fxml
│       ├── application.css
│       └── captain-puffy.jpg
└── pom.xml
```

## How to Build & Run

### Prerequisites
- Java 25 (JDK)
- Maven 3.6+

### Build
```bash
mvn clean install
```

### Run
```bash
mvn javafx:run
```

## Usage Guide

### 1. Login
- **Username**: `user` or `admin`
- **Password**: `123`
- Select role and click Login

### 2. Browse Vehicles (User)
- Select vehicle type from ChoiceBox: Car, Truck, or Bike
- View all available vehicles in the gallery
- Each card shows: Model, Price/Day, Status, Vehicle ID

### 3. Rent a Vehicle
- Click **Rent** button on desired vehicle card
- A booking panel opens on the right side
- Select **From** date (today or future)
- Select **To** date (after From date)
- Total price calculates automatically: `(days × pricePerDay)`
- Click **Book** to confirm booking

### 4. Manage Rented Vehicles
- Booked items show a **Return** button instead of Rent
- Click **Return** to make vehicle available again
- System auto-refreshes gallery after each action

## Data Model

### Vehicle Data (In-Memory)
**Cars (5):**
- Hyundai i20 @ ₹1800/day
- Honda City @ ₹2200/day
- Maruti Swift @ ₹1500/day (pre-booked)
- Toyota Fortuner @ ₹4500/day
- Mahindra XUV @ ₹3000/day

**Trucks (3):**
- Eicher Pro 1100 @ ₹2500/day
- Tata Ace @ ₹2000/day
- Ashok Leyland @ ₹3000/day (pre-booked)

**Bikes (4):**
- Yamaha FZ @ ₹700/day
- Hero MotoCorp @ ₹600/day
- Bajaj Pulsar @ ₹650/day (pre-booked)
- Honda CB Shine @ ₹750/day

## Key OOP Concepts Demonstrated

1. **Interface Usage**: `Rental` interface defines common vehicle behavior
2. **Composition**: `Vehicles` class contains lists of Car, Truck, and Bike objects
3. **Polymorphism**: Different vehicle types implement the same rental interface
4. **Encapsulation**: Private methods and controlled access to vehicle data
5. **Single Responsibility**: Each class handles one specific concern (UI, data, logic)

## Features in Detail

### Date Validation
- Start date: Cannot be in the past
- End date: Must be after or equal to start date + 1 day
- Automatically disables invalid dates in calendar picker

### Price Calculation
- Formula: `Total Price = Days × Price Per Day`
- Minimum rental: 1 day
- Example: Renting Honda City (₹2200/day) for 3 days = ₹6600

### Session Management
- Current user stored in `Session.currentUser`
- Shared vehicle instance in `Session.vehicles` ensures data consistency
- Booking details held in static `Booking` class fields

### UI Refresh Flow
1. User completes booking
2. Booking window closes automatically
3. User gallery auto-refreshes
4. Vehicle status updates (Available → Booked or vice versa)

## Known Limitations & Future Enhancements

**Current Limitations:**
- In-memory data only (no database persistence)
- No email/SMS notifications
- No payment integration
- Single-user session (no concurrent users)

**Planned Features:**
- MySQL/PostgreSQL database integration
- Admin panel for vehicle CRUD operations
- User profile management
- Booking history and cancellation tracking
- Late fee calculation
- Vehicle ratings and reviews
- Payment gateway integration
- Email confirmation system

## Testing Scenarios

1. **Valid Booking**: Login as user → Select Car → Choose future dates → Book successfully
2. **Status Change**: Book vehicle → Return to gallery → Item shows as Booked → Return item → Item shows as Available
3. **Date Validation**: Try selecting past date → Date is disabled
4. **Filter by Type**: Select different vehicle types from ChoiceBox → Gallery updates instantly
5. **Error Handling**: Try booking already-booked item → System prevents action

## Author
- **Name**: Yuvi
- **Project Type**: College Submission
- **Date**: April 2026

## License
This project is for educational purposes.

---

**For questions or enhancements**, refer to the code structure and OOP principles demonstrated throughout the application.
