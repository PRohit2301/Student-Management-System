# Student Management System – Secure Role-Based Web Application

## Overview
The **Student Management System** is a production-oriented, role-based web application designed using **Spring Boot** and **Spring Security**.  
It demonstrates clean backend architecture, secure authentication, RESTful API design, and relational data modeling—aligned with industry-grade engineering practices.

The system provides **Admin** and **Student** portals with strict role-based access control and end-to-end data flow from persistence to UI.

---

## Description
Role-based Student Mangement System built using Spring Boot, Spring Security, and MySQL. Admin can perform CRUD operations on student data, while students can securely log in access their personalized dashboard.

---

## Key Highlights 
- Clean **layered architecture** (Controller → Service → Repository)
- **Role-based authentication & authorization** using Spring Security
- Strong **domain modeling** with JPA & Hibernate
- Real-world **Admin-driven user provisioning**
- REST APIs designed following **HTTP semantics**
- Separation of authentication data and business data
- Scalable and extensible design

---

## Functional Capabilities

### Admin Portal
- Secure admin authentication
- Create student profiles
- Provision student login credentials
- View all student records
- Update student information
- Delete student records

### Student Portal
- Secure login using email as username
- Role-restricted access
- Personalized student dashboard

---

## Authentication & Authorization Flow
1. Admin creates a student record
2. System provisions a corresponding login account
3. Email is used as the **username**
4. Password is securely stored and validated
5. Role-based routing determines dashboard access

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate ORM

### Database
- MySQL (Relational schema with referential integrity)

### Frontend
- HTML
- CSS
- JavaScript (Fetch API)

### Tooling
- IntelliJ IDEA
- Maven
- Git & GitHub
- MySQL Workbench

---

## System Architecture
Controller Layer → Service Layer → Repository Layer → Database
↑ ↓
REST APIs Business Logic

---

## Project Structure
student-management-system
│
├── controller # REST controllers
├── service # Business logic
├── repository # JPA repositories
├── model # Domain entities
├── security # Spring Security configuration
├── resources
│ ├── application.properties
│ └── static # Frontend assets
└── pom.xml

---

## Data Model

### User Entity
- `id`
- `username` (email)
- `password`
- `role` (ADMIN / STUDENT)

### Student Entity
- `id`
- `name`
- `email`
- `password`
- `department`
- `year`
- `user_id` (One-to-One mapping)

---

## API Design (Sample)

| Method | Endpoint | Responsibility |
|------|---------|----------------|
| POST | `/api/admin/students` | Create student |
| GET | `/api/admin/students` | Fetch all students |
| PUT | `/api/admin/students/{id}` | Update student |
| DELETE | `/api/admin/students/{id}` | Delete student |
| POST | `/api/auth/login` | Authenticate user |

---

## How to Run
1. Clone the repository
```bash
git clone https://github.com/your-username/student-management-system.git
2. Configure database in application.properties
3. Run the Spring Boot application
4. Access via browser
http://localhost:8080
