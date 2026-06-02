# Job Portal System

A **Java Swing** desktop application connecting students, companies, and professors on a unified job-matching platform. Built with Java 17+, JavaFX 24, and MySQL.

## Features

| Role | Capabilities |
|------|-------------|
| **Student** | Register, browse listings, apply for jobs, track status |
| **Company** | Register, post jobs, manage applications |
| **Professor** | Register, view students, monitor applications |

## Project Structure

```
job-portal-system/
├── src/job_portal_system/
│   ├── App.java                   # Entry point
│   ├── BackgroundPanel.java
│   ├── dao/                       # Data Access Objects (JDBC)
│   │   ├── DBConnection.java
│   │   ├── UserDAO.java / StudentDAO.java / CompanyDAO.java
│   │   ├── JobDAO.java / ApplicationDAO.java / ReviewDAO.java
│   ├── model/                     # Domain Models
│   │   ├── User / Student / Company / Job / Application / Review / Professor
│   │   └── enums/ (UserType, ApplicationStatus)
│   ├── service/                   # Business Logic
│   │   ├── AuthService / UserService / JobService
│   │   ├── ApplicationService / CompanyService / ReviewService
│   ├── ui/                        # Swing GUI Screens
│   │   ├── main_screen / login_screan / role_screen
│   │   ├── register_student_screan / register_company_screan
│   │   ├── register_profosor_screan / Home
│   └── util/ (CSVUtil, IdGenerator)
├── lib/                           # JARs (JavaFX24, MySQL Connector)
├── nbproject/                     # NetBeans config
├── database/schema.sql            # Run this first!
├── build.xml / manifest.mf
└── .gitignore
```

## Tech Stack
- **Java 17+** · **Java Swing** · **JavaFX 24** · **MySQL 8.x**
- **MySQL Connector/J 8.0.23** · **Apache Ant** (via NetBeans)

## Setup

**1. Database**
```sql
CREATE DATABASE job_portal;
```
```bash
mysql -u root -p job_portal < database/schema.sql
```
Update credentials in `src/job_portal_system/dao/DBConnection.java`.

**2. Run in NetBeans:** Open Project → Press F6

**3. Command Line:** `ant build && ant run`

## Architecture
```
UI Layer (Swing)  →  Service Layer  →  DAO Layer  →  MySQL
```

---
© 2025 — Job Portal System | University Final Project
