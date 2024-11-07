# Trending Financial Insights Platform

## Project Overview
The Trending Financial Insights Platform is a Spring Boot and React-based application designed to analyze and display real-time financial trends. It integrates with the RapidAPI Yahoo Finance API to fetch trending ticker data, allowing users to gain insights into current financial movements.

## Features
- Fetches real-time trending ticker data from the Yahoo Finance API via RapidAPI.
- Displays trends and key financial information on a React-based frontend dashboard.
- Java Spring Boot backend to handle API calls and data processing.
- Designed with microservices and containerization best practices.

## Technologies Used
### Backend
- **Java**: Core language for backend development.
- **Spring Boot**: For building the REST API services.
- **Maven**: Dependency management and build tool.
- **Docker**: Containerize the application.

### Frontend
- **React (TypeScript)**: User interface to display trending insights.
- **CSS**: Styling for the frontend components.

## Prerequisites
- **Java 11 or higher**
- **Maven**
- **Node.js and npm** (for React)
- **Docker** (optional for containerization)

## Setup and Installation
1. **Clone the Repository**
   ```bash
   git clone https://github.com/JUnelus/Trending-Financial-Insights-Platform.git
   cd Trending-Financial-Insights-Platform
   ```

2. **Backend Setup (Spring Boot)**:
    - Navigate to the backend folder.
    - Create a `pom.xml` file if not present and configure it as per the provided example.
    - Run the application:
      ```bash
      mvn spring-boot:run
      ```

3. **Frontend Setup (React)**:
    - Navigate to the `frontend-app` directory.
    - Install dependencies:
      ```bash
      npm install
      ```
    - Start the React app:
      ```bash
      npm start
      ```

4. **Docker Setup (Optional)**:
    - Ensure Docker is running.
    - Build and run the Docker container:
      ```bash
      docker build -t trending-financial-insights .
      docker run -p 8080:8080 trending-financial-insights
      ```

## Usage
1. Start the backend server (Spring Boot).
2. Start the frontend server (React).
3. Open your browser and navigate to `http://localhost:3000` to view the dashboard.

## API Integration
This project utilizes the Yahoo Finance API via RapidAPI. Update the API key in the backend configuration file or environment variables to authenticate requests.

## Sample Code Snippet (Backend - Fetching Data)
```java
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-trending-tickers?region=US"))
    .header("x-rapidapi-key", "<YOUR_RAPIDAPI_KEY>")
    .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
    .method("GET", HttpRequest.BodyPublishers.noBody())
    .build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

## Troubleshooting
- **CORS Errors**: Ensure that CORS is configured on the backend.
- **Dependency Issues**: Run `mvn clean install` to resolve Maven dependencies.

## License
This project is open-source and available for modification and use.

## Contact
For inquiries, reach out to the project maintainer.