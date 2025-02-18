Gregorian to Hijri Converter Microservices Project
This project consists of two microservices built with Java Spring Boot for backend services and a frontend application using React. The primary purpose of the project is to convert dates from Gregorian calendar format to Hijri calendar format.

you can check this link to see demo video: https://youtu.be/5rxtsQxO3_4

for live demo:
Frontend: http://34.135.156.75/
Backend Api: http://34.135.156.75:8000/api/send
Request Body: {"date":"2024-07-10"}

 second microservice api: http://34.135.156.75:8001/api/hijri/convert


Backend:

Java Spring Boot
Spring Web MVC for RESTful APIs
WebClient for synchronous communication between microservices
Frontend:

React
Axios for API communication
Bootstrap (or other UI frameworks, if used)
Project Structure
The project is structured into two microservices:

Converter Service: Handles the conversion logic from Gregorian to Hijri calendar.

Endpoint: localhost:8001/api/send
Method: POST
Request Body: String representing Gregorian date ("yyyy-MM-dd") example for body request{"date":2024-07-10"}
Returns: String representing Hijri date or conversion result.
Frontend Service: Implements the user interface for interacting with the Converter Service.

