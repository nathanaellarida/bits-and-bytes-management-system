# Bits & Bytes Management System

A Java Swing desktop application designed as a personal management system for students and professionals. It provides a suite of tools to organize daily tasks, track finances, manage schedules, and log attendance — all in one place.

---

## Features

- **User Authentication** — Secure sign-up and login system supporting up to 20 user accounts, with credentials stored via file-based I/O.
- **Dashboard** — Central hub displaying an overview of your data with quick navigation to all modules. Includes a Daily Time Record (DTR) logbook for time-in/time-out tracking.
- **Budget Planner** — Track your budget and categorize expenses into Food, Events, and Other categories with running totals.
- **To-Do List** — Organize daily tasks by day with an intuitive checklist interface.
- **Schedule / Event Planner** — Add and view upcoming events and contests with a custom calendar date picker.
- **Personal Information** — View and edit your profile details including name, position, email, age, and phone number.
- **Admin Panel** — Administrative interface for managing user accounts.
- **Contact & About** — Contact information and application details.
- **Loading Screen** — Branded loading screen on application startup.

---

## Tech Stack

| Technology | Details |
|---|---|
| Language | Java |
| UI Framework | Java Swing |
| Data Storage | File I/O (`.txt` flat files) |
| Architecture | Multi-frame Swing GUI with interface-based file I/O |

---

## Project Structure

```
BMS/                        # Main application package
├── Main.java               # Entry point — launches loading screen then login
├── LoadingScreen.java      # Startup loading animation
├── Login.java              # Login screen
├── SignUp.java             # Registration screen
├── DashBoard.java          # Main dashboard with DTR logbook
├── BudgetPlanner.java      # Budget & expense tracker
├── MyFrame2.java           # To-Do List
├── Schedule.java           # Event/contest scheduler
├── MainCalendar.java       # Calendar view
├── Calendar.java           # Calendar component
├── DateCalendarChanger.java# Date picker utility
├── PersonalInfo.java       # Personal profile viewer
├── EditPersonalInfo.java   # Profile editor
├── Admin.java              # Admin panel
├── AboutFrame.java         # About screen
├── ContactFrame.java       # Contact screen
├── FileIO*.java            # File I/O interfaces and implementations
├── CreateEmptyFile.java    # Utility for initializing user data files
└── *.txt                   # Data files (users, logbook, todo, schedule, etc.)
```

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE such as IntelliJ IDEA, NetBeans, or Eclipse (recommended)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/nathanaellarida/bits-and-bytes-management-system.git
   ```
2. Open the project in your IDE.
3. Update the hardcoded file paths in the source files to match your local directory (e.g., in `Login.java`, `DashBoard.java`, `BudgetPlanner.java`, etc.).
4. Compile and run `BMS/Main.java`.

> **Note:** Data is stored in `.txt` files within the `BMS/` directory. Make sure the application has read/write permissions to that folder.

---

## Screenshots

> _Coming soon_

---

## Authors

Developed by the **Bits & Bytes** team.

---

## License

This project is for educational purposes.
