# 🎁 Customer Rewards RESTful API

This project is a Spring Boot-based RESTful service that calculates **monthly and total reward points** earned by customers based on their purchase transactions.

Customers earn:
- 🪙 **2 points** for every $1 spent **over $100** in a transaction
- 🪙 **1 point** for every $1 spent **over $50** in a transaction

> Example: A $120 purchase earns **90 points** → 2×20 + 1×50

---

## 💡 Features

- ✅ Fetch rewards by `userId` or `userName`
- ✅ Add new transactions via REST API
- ✅ Monthly breakdown and total reward points
- ✅ MySQL database integration

---

## 🧑‍💻 API Endpoints

### `GET /api/rewards`

Returns reward points for a given customer.

**Query Parameters:**
- `userId` (optional)
- `userName` (optional)

**Example Request:**
```
GET /api/rewards?userId=U001
```

**Example Response:**
```json
{
  "userId": "U001",
  "userName": "Alice",
  "monthlyPoints": {
    "JANUARY": 90,
    "FEBRUARY": 25,
    "MARCH": 250
  },
  "totalPoints": 365
}
```

---

### `POST /api/rewards`

Adds a new transaction.

**Example Request Body:**
```json
{
  "transactionId": "T008",
  "userId": "U004",
  "userName": "David",
  "amount": 150.0,
  "date": "2025-04-12"
}
```

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Lombok

---

## 🗃️ Database Setup (MySQL)

### 📌 Step 1: Create the Database
```sql
CREATE DATABASE rewards_db;
```

### 📌 Step 2: Create the Table
```sql
CREATE TABLE transactions (
  transaction_id VARCHAR(50) PRIMARY KEY,
  user_id VARCHAR(50) NOT NULL,
  user_name VARCHAR(100) NOT NULL,
  amount DOUBLE NOT NULL,
  date DATE NOT NULL
);
```

### 📌 Step 3: Configure `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rewards_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Running the App

Run with Maven:
```bash
./mvnw spring-boot:run
```

Or run `RewardsApplication.java` from your IDE.

---

## 🧪 Example cURL Commands

### Add a transaction:
```bash
curl -X POST http://localhost:8080/api/rewards \
  -H "Content-Type: application/json" \
  -d '{"transactionId":"T009","userId":"U005","userName":"Emma","amount":180,"date":"2025-04-13"}'
```

### Get rewards:
```bash
curl "http://localhost:8080/api/rewards?userName=Emma"
```

---


