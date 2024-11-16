# Car Management Application

This application is a full-stack solution for managing cars. It includes backend services for user authentication, car creation, viewing, editing, and deleting cars, along with frontend components for interacting with these services.

## Features
1. User can login/signup.
2. Users can add a car with up to 10 images, title, description, and tags.
3. Users can view a list of all their cars.
4. Users can globally search through all cars (search by title, description, or tags).
5. Users can view details of a specific car.
6. Users can update a car’s title, description, tags, or images.
7. Users can delete a car.

---

## Backend

### Technologies Used
- Java
- Spring Boot
- JPA (Java Persistence API)
- MySQL

### Setting Up the Backend

#### Prerequisites
- Install Java: `brew install java`
- Install Maven: `brew install maven`
- Install MySQL: `brew install mysql`

#### Steps
1. Clone the repository:
git clone <repository-url> cd carExpo/backend

sql
`
2. Configure the database:
- Update `application.properties` file with your MySQL credentials:
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/car_management
  spring.datasource.username=<your-username>   # root
  spring.datasource.password=<your-password>   #empty
  ```
3. Create the required tables in the MySQL database:
```sql
brew services start mysql
mysql -u root -p      #launches a mysql terminal
#no need to add any password just press enter when it asks for one
CREATE DATABASE car_management;
USE car_management;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    tags TINYTEXT,
    user_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE images (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);
```
Build and run the backend:
arduino
`
mvn clean install
mvn spring-boot:run
`
API Endpoints
User Management
```
POST /api/users/register: Register a new user.
POST /api/users/login: Login with username and password.
GET /api/users/{id}: Get a user by ID.
GET /api/users: Get all users (Admin).
DELETE /api/users/{id}: Delete a user by ID.
```

Car Management
```
POST /api/cars: Add a new car (requires userId parameter).
GET /api/cars: Get all cars for a user (requires userId parameter).
GET /api/cars/{id}: Get details of a specific car.
PUT /api/cars/{id}: Update car details.
DELETE /api/cars/{id}: Delete a car.
GET /api/cars/search: Search cars globally (requires keyword parameter).
```
Images Management

```
POST /api/images/upload: Upload an image for a car (requires carId).
GET /api/images/{carId}: Get all images for a car.
```
# Frontend
Technologies Used
```
React.js
Axios for API calls
CSS for styling
Setting Up the Frontend
```
Prerequisites
Install Node.js: 
```
brew install node
```
Install npm: ```
brew install npm
```
Steps
Navigate to the frontend directory:
bash
`
cd carExpo/frontend`
Install dependencies:

```
npm install
```
Start the frontend:

```
npm start
```
Folder Structure

```
car-management-frontend/
├── public/
│   ├── index.html
├── src/
│   ├── App.js
│   ├── index.js
│   ├── components/
│   │   ├── SignUp.js
│   │   ├── Login.js
│   │   ├── CarList.js
│   │   ├── CarDetails.js
│   │   ├── AddCar.js
│   │   └── SearchBar.js
│   ├── services/
│   │   └── api.js
│   ├── styles/
│   │   ├── App.css
│   │   ├── CarList.css
│   │   ├── SignUp.css
│   │   └── common.css
```
Deployment
Backend Deployment
Use a cloud provider like AWS, GCP, or Heroku to host the backend.
Make sure to configure environment variables for database credentials on the server.
Frontend Deployment
Use Vercel or Netlify to deploy the React frontend.
Update the API base URL in api.js to point to the hosted backend.
Usage
Start the backend by running:
arduino

mvn spring-boot:run
Start the frontend by running:

`
npm start`
Access the application at `http://localhost:3000`
