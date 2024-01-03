
# Heatwave Website

This Spring Boot project is designed to manage information about furnaces and buying and selling HVAC Furnaces online. It also provides secure user authentication for accessing and manipulating the furnace data. The application includes functionalities such as viewing, adding, editing, deleting furnace details buying and selling furnaces.



## Project Structure

The project is organized into several packages:

### 1. `ca.sheridancollege.heidarik.beans`

This package contains the following Java classes representing entities in the application:

- **Furnace:** Represents information about a furnace, including its ID, ASIN, brand, wattage, price, weight, and description.

- **User:** Represents user details, including user ID, email, encrypted password, and enabled status.

### 2. `ca.sheridancollege.heidarik.controllers`

This package contains the following:

- **HomeController:** Handles requests related to the application's home page, including secure and login pages. It manages operations such as viewing, adding, editing, and deleting furnace details.

### 3. `ca.sheridancollege.heidarik.database`

This package deals with database access and includes:

- **DatabaseAccess:** Manages database operations such as inserting, retrieving, updating, and deleting furnace details. It also handles user-related queries for authentication and authorization.

### 4. `ca.sheridancollege.heidarik.security`

The security package manages security configurations and includes:

- **SecurityConfig:** Configures Spring Security settings, defines access rules, and sets up user authentication.

- **UserDetailsServiceImpl:** Implements the `UserDetailsService` interface to load user-specific data during authentication.

### 5. `templates`

This directory contains Thymeleaf HTML templates for various pages, such as login, home, and permission-denied.

### 6. `static`

The static directory includes CSS files for styling the HTML pages.

## Database Schema

The project uses an H2 database and consists of the following tables:

- **furnace:** Stores information about furnaces, including ASIN, brand, wattage, price, weight, and description.

- **sec_user:** Manages user accounts, including email, encrypted password, and enabled status.

- **sec_role:** Stores user roles for authorization.

- **user_role:** Maintains the relationship between users and roles.




## Security

The project implements Spring Security for user authentication and authorization. It includes role-based access control to secure different parts of the application.

## Badges

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-11-blue)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)



## Authors

- [@kianousho](https://github.com/kianousho/HVAC_Website)


Feel free to give any feedback or explore and customize the project to meet your specific requirements!


## Usage/Examples

```javascript
To run the project, ensure that you have the necessary dependencies and an H2 database configured.
You can use the provided SQL scripts to populate the database with sample data.
feel free to add your desired user and make any changes!

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kia-heidari-b1b458268/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/young_ramati)

