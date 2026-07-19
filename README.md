# Spring Boot - Creating api (CRUD operation) - Simple product management with Spring boot

A simple and robust RESTful API built using Spring Boot to manage products. This project demonstrates full CRUD (Create, Read, Update, Delete) capabilities, clean architecture, and deployment practices.

---

### Features

*   **Create Product:** Add new products with details (ID, name, price, quantity, etc.).
*   **Read Product:** Retrieve all products or search for a specific product by its ID.
*   **Update Product:** Modify existing product details seamlessly.
*   **Delete Product:** Remove products from the inventory.

### Tech Stack

*   **Backend:** Java, Spring Boot (Spring Web, Spring Data JPA)
*   **Database:** H2 (In-Memory) / MySQL *(Adjust based on your setup)*
*   **Tools:** Maven, Postman (for API testing)

---

### Deployment

This application is deployed and hosted on an **AWS EC2 (Elastic Compute Cloud)** instance. 

### Deployment Preview
*(Screenshot of the active deployment, EC2 instance dashboard, or live API response will be added below)*

<img width="960" height="504" alt="image" src="https://github.com/user-attachments/assets/48b69fc4-2ff0-4ca5-80c8-224dea61351d" />


---

### API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/products` | Create a new product |
| **GET** | `/api/products` | Get all products |
| **GET** | `/api/products/{id}` | Get product by ID |
| **PUT** | `/api/products/{id}` | Update an existing product |
| **DELETE** | `/api/products/{id}` | Delete a product |
