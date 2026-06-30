# ☕ Protein Evolution Backend

<p>
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/Spring%20Boot-4-green.svg" alt="Spring Boot Version">
  </a>
  <a href="https://www.java.com/">
    <img src="https://img.shields.io/badge/Java-21-orange.svg" alt="Java Version">
  </a>
  <a href="https://www.postgresql.org/">
    <img src="https://img.shields.io/badge/PostgreSQL-16-blue.svg" alt="PostgreSQL">
  </a>
  <a href="https://www.docker.com/">
    <img src="https://img.shields.io/badge/Docker-supported-blue.svg" alt="Docker">
  </a>
</p>

RESTful backend API developed with Spring Boot for managing protein analysis results.

This project provides persistence, business logic, and API communication between the frontend application and the Python bioinformatics analyzer.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Architecture](#project-architecture)
- [Technologies](#technologies)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Testing](#testing)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## Overview

**Protein Evolution Backend** is the backend component of the *Protein Evolution Explorer* platform.

The application manages protein analysis workflows by:

* **Processing Requests:** Receiving FASTA analysis requests.
* **Service Communication:** Communicating with the Python Protein Analyzer service.
* **Data Persistence:** Persisting protein analysis results.
* **API Exposure:** Exposing REST endpoints consumed by the React frontend.

The backend follows a layered architecture using Spring Boot, Spring Data JPA, and Hibernate.

---

## Features

### Protein Management
Provides functionality for:
* Uploading FASTA files for analysis.
* Storing protein analysis results.
* Retrieving analyzed proteins and detailed information.
* Managing persistent biological data.

### API Layer
Provides REST endpoints for:
* Protein analysis requests.
* Protein listing and detail retrieval.
* Health monitoring.

### Persistence Layer
Handles:
* Database communication.
* Entity mapping with JPA/Hibernate.
* Protein analysis storage and JSON data persistence for biological properties.

### External Integration
Communicates with the Python analyzer service:
* Sends FASTA files.
* Receives structured protein analysis data.
* Converts results into backend entities.

---

## Project Architecture

The backend follows a layered architecture:

```text
src/main/java/com/proteinevolution/backend/
├── controller/
│   ├── ProteinController.java
│   └── HealthController.java
├── service/
│   ├── ProteinService.java
│   ├── ProteinAnalysisService.java
│   └── HealthService.java
├── repository/
│   └── ProteinAnalysisRepository.java
├── model/
│   └── ProteinAnalysis.java
├── dto/
│   ├── ProteinResponse.java
│   ├── ProteinAnalysisResponse.java
│   └── ProteinAnalysisDetailResponse.java
├── client/
│   └── PythonAnalyzerClient.java
├── config/
│   ├── CorsConfig.java
│   └── OpenApiConfig.java
└── exception/
└── GlobalExceptionHandler.java
```

### Core Components

* **Controller Layer:** Handles HTTP requests and exposes REST endpoints.
* **Service Layer:** Contains business logic and application workflows.
* **Repository Layer:** Handles database access through Spring Data JPA.
* **DTO Layer:** Controls API responses and separates internal models from external communication.
* **Client Layer:** Handles communication with the Python bioinformatics analyzer.

---

## Technologies

* **Language:** Java 21
* **Framework:** Spring Boot
* **Persistence:** Spring Data JPA, Hibernate
* **Database:** PostgreSQL
* **Build Tool:** Maven
* **API Documentation:** OpenAPI / Swagger
* **Containerization:** Docker
* **Development Tools:** Git, IntelliJ IDEA

---

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/fran9300/protein-evolution-backend.git
   cd protein-evolution-backend
   ```

2. **Run with Maven:**
   Ensure Java 21 is installed in your system, then execute:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on:
👉 **http://localhost:8080**

---

## API Endpoints

### Health Check
* **Method:** GET
* **Path:** `/api/health`
* **Example response:**
  ```json
  {
  "status": "UP"
  }
  ```

### Protein Analysis
* **Method:** POST
* **Path:** `/api/proteins/analyze`
* **Description:** Receives a FASTA file and returns protein analysis data.

### Get All Proteins
* **Method:** GET
* **Path:** `/api/proteins`
* **Description:** Returns stored protein analyses.

### Get Protein Detail
* **Method:** GET
* **Path:** `/api/proteins/{id}`
* **Description:** Returns complete information about a specific protein analysis.

---

## Database

The application uses PostgreSQL for persistence.

* **Main Entity:** `ProteinAnalysis`

Stores the following fields:
* Protein identifier
* Sequence length
* Molecular weight and pI
* Hydrophobicity, instability index, and aliphatic index
* Amino acid composition and structural properties

---

## Testing

To execute the application test suite (includes context loading, validation, and API workflows), run:
```bash
mvn test
```

---

## Future Improvements

* [ ] Docker Compose integration with all services.
* [ ] Authentication and authorization implementation.
* [ ] Database migrations with Flyway.
* [ ] Advanced protein search functionalities.
* [ ] Pagination and filtering for data listings.
* [ ] Production deployment workflows.

---

## Author

**Francisco Kin**
* Bioinformatics Student | Backend Development | Data Analysis
* **GitHub:** [@fran9300](https://github.com/fran9300)