🚀 REST API Automation Framework with REST-assured + TestNG + ExtentReports
This project is a lightweight API automation framework built using Java, REST-assured, TestNG, and integrated with ExtentReports for beautiful HTML reporting. It demonstrates end-to-end CRUD operations using a public mock API (reqres.in).

📁 Project Structure
bash
Copy
Edit
src/
├── main/
│   └── java/
│       ├── base/               # Request specification setup
│       ├── factory/            # Request builder methods (POST, GET, PUT, DELETE)
│       └── utils/              # Extent Report Manager and Test Listener
├── test/
│   └── java/
│       └── tests/              # All test classes with @Test methods
🛠️ Tech Stack
Tool/Library	Purpose
Java 11+	Programming Language
REST-assured	API testing library
TestNG	Test execution & lifecycle
ExtentReports	HTML Reporting
Maven	Build and dependency manager
Reqres.in	Mock API for CRUD operations

🔧 Prerequisites
Java JDK 11+

Maven 3.6+

IntelliJ or Eclipse

Internet connection (for hitting https://reqres.in)

⚙️ Setup Instructions
Clone the Repo

bash
Copy
Edit
git clone https://github.com/yourusername/api-automation-framework.git
cd api-automation-framework
Install Dependencies

bash
Copy
Edit
mvn clean install
Run the Tests

bash
Copy
Edit
mvn test
View the Report

Navigate to: target/ExtentReport.html

Open in browser for detailed test logs

🧪 Sample Test: verifyEndToEndFlow()
This test performs the following in sequence:

POST → Create a new user

GET → Validate if user exists (returns 404 as it's a mock)

PUT → Update the user's info

GET → Validate updated user (still 404 - mock behavior)

DELETE → Delete the user

GET → Confirm deletion (expect 404)

All steps are logged in ExtentReports with pass/fail status and API responses.

📷 Sample Report


📌 Key Features
Modular and reusable request methods using RequestFactory

Custom Extent HTML reporting via ExtentReportManager

Thread-safe logging using ThreadLocal

Easy environment setup using Maven

Listener support for logging failures

✅ To-Do
Add support for parallel execution

Add data-driven testing with Excel/CSV/JSON

Integrate with Jenkins for CI/CD

Add logging using SLF4J + Logback

🤝 Contributing
Feel free to fork the repo and submit a pull request. Bug reports and suggestions are welcome!

📄 License
This project is licensed under the MIT License.

