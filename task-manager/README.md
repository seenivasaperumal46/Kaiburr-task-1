# 📘 Kaiburr Assessment Task 1 – Task Execution API (Spring Boot + MongoDB)

##  📌Overview
This project is a Spring Boot REST API designed for managing and executing tasks, developed as part of the Kaiburr Internship Assessment. Each task can store a shell command and its execution history. MongoDB is used as the database.

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data MongoDB
- MongoDB (local)
- Maven
- Postman (for testing)

---

## 📁 Project Structure

 com.kaiburr.task_manager
 
```
com/
└── kaiburr/
    └── task_manager/
        ├── controller/         # API layer (REST endpoints)
        │   └── TaskController.java
        │
        ├── model/              # Task & TaskExecution classes
        │   ├── Task.java
        │   └── TaskExecution.java
        │
        ├── repository/         # MongoRepository interface
        │   └── TaskRepository.java
        │
        └── service/            # Business logic (CRUD + execute logic)
            └── TaskService.java

```


---

## 🧪 API Endpoints

| Method | Endpoint           | Description                                |
|--------|--------------------|--------------------------------------------|
| GET    | `/tasks`           | Get all tasks                              |
| GET    | `/tasks?id={id}`   | Get task by ID                             |
| PUT    | `/tasks`           | Create a new task                          |
| DELETE | `/tasks/{id}`      | Delete a task                              |
| PUT    | `/tasks/{id}/run`  | Replace task and execute shell command     |

---

## 📦 Sample Request Payloads

### ➕ Create a Task (`PUT /tasks`)
```json
{
  "id": "123",
  "name": "Print Hello",
  "owner": "John Smith",
  "command": "echo Hello World"
}
```
 ### 🚀 Execute a Task (PUT /tasks/{"id"}/run)
 ```json
{
  "id": "123",
  "name": "Print Hello",
  "owner": "John Smith",
  "command": "echo Hello World"
}
```

---

### ✅ Expected Response
 ```json
{
  "id": "123",
  "name": "Print Hello",
  "owner": "John Smith",
  "command": "echo Hello World",
  "taskExecutions": [
    {
      "startTime": "2025-06-10T08:00:00Z",
      "endTime": "2025-06-10T08:00:01Z",
      "output": "Hello World\n"
    }
  ]
}
```
---

## 🧰 Prerequisites
 - Java 17+
 - MongoDB running locally (localhost:27017)
 - Maven
 - IntelliJ or VS Code

---

## ⚙️ How to Run
 - #### Clean and install
```mvn clean install```

 - #### Run Spring Boot app
```mvn spring-boot:run```

---
## 🔍 MongoDB Config
 - #### In application.properties:
```
spring.data.mongodb.uri=mongodb://localhost:27017/kaiburr
server.port=8080
```
## 📸 Screenshot Guidelines

### 🔹 Delete_task.
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/delete_task.png)

### 🔹 Execute the task.
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/execute_the_task%20by%20shell.png)

### 🔹 Find Task by Name.
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/find_task%20by%20name.png)

### 🔹 Get All Task .
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/get_task.png)

### 🔹 Get Task_by_id.
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/get_task_by_id.png)

### 🔹 Put Task.
![POST API](https://github.com/seenivasaperumal46/kaiburr_task1/blob/998039cfb95469d56f7ac0bd6b9f930019a11671/put_task.png)

---

# ✅ Status
 - Task 1 Completed Successfully.

---







