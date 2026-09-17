# Campus Resource Management System

A command-line Java application for managing campus resources such as laboratories, classrooms, and equipment. The project demonstrates object-oriented programming, collections, validation, file persistence, exception handling, modular design, and reporting.

## Modules
1. Resource Management — add, update, remove, and list resources.
2. Booking Management — create, cancel, and inspect bookings with conflict detection.
3. Reporting & Persistence — generate utilization reports and save/load data from files.

## Requirements
- Java JDK 17 or newer
- Terminal / command prompt

## Run
```bash
javac -d out src/campus/*.java
java -cp out campus.Main
```

On first run, the program creates `data/resources.csv` and `data/bookings.csv`.

## Test
```bash
javac -d out src/campus/*.java
java -cp out campus.TestRunner
```

## Project Structure
```text
.
├── README.md
├── statement.md
├── data/
│   ├── resources.csv
│   └── bookings.csv
└── src/
    └── campus/
        ├── Main.java
        ├── Resource.java
        ├── Booking.java
        ├── ResourceType.java
        ├── ResourceStatus.java
        ├── ResourceManager.java
        ├── BookingManager.java
        ├── ReportService.java
        ├── DataStore.java
        ├── InputValidator.java
        └── TestRunner.java
```
