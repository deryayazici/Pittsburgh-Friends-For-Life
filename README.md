# Pittsburgh Friends For Life

A **Full Stack Web Application** designed for an animal shelter management system, allowing users to **adopt animals, volunteer, and donate online.**

## Project Overview

This project was developed by a **team of four** in an **Agile environment** using **Java, PostgreSQL, Spring Boot, Vue.js, HTML, CSS, and JavaScript.** The web application provides a **user-friendly interface** with functionalities for searching adoptable animals, submitting adoption applications, volunteering, and making donations.


## Tech Stack
**1. Backend**

- **Java & Spring Boot:** Handles server-side logic and API endpoints.

- **PostgreSQL:** Manages animal shelter data.

- **Spring Security:** Manages authentication & authorization.

**2. Frontend**

- **Vue.js:** Provides a dynamic and interactive user interface.

- **HTML, CSS, JavaScript:** Structures and styles the application.

**3. Testing & Deployment**

- **JUnit:** Unit testing for backend services.

- **Postman:** API testing.

## Setup Instructions 

**1. Clone the repository**

```bash
git clone https://github.com/deryayazici/Pittsburgh-Friends-For-Life.git
cd Pittsburgh-Friends-For-Life
```

**2. Backend Setup (Spring Boot)**

1. Navigate to the backend directory:
``` bash
 cd backend
```

2. Configure the database connection in
``` application.properties```.

3. Build and run the application:
``` bash
 mvn sprig-boot:run
```


**3. Frontend Setup(Vue.js)**

1. Navigate to the frontend directory:
``` bash
 cd frontend
```

2. Install dependencies:
``` bash
npm install
```

3. Run the development server:
```bash
 npm run dev
```

**4. Access the Application**

- **Frontend**: ```http://localhost:5173/```
- **Backend API**: ```http://localhost:8080/```



## Key Features

- **User Authentication:** Login-based functionalities for adopters, volunteers, and donators.

- **Animal Search:** Browse adoptable animals with detailed profiles.

- **Adoption Process:** Submit adoption applications online.

- **Volunteer Oppportunities:** Apply to work at the shelter.

- **Online Donations:** Donate to support the shelter.

- **Admin Dashboard:** Manage adoption requests and volunteer applications.



## Testing

Run unit tests for the backend:

``` bash
 mvn test
```
