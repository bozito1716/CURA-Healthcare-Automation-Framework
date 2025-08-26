# 🏥 Healthcare Web Automation Framework

This project is a **BDD Automation Framework** built with **Cucumber, Selenium, and TestNG**.  
It is designed to test a **Healthcare web application** with full support for **cross-browser execution**, **parallel testing**, and **Jenkins integration**.

---

## 🚀 Features
- **Cucumber (BDD)** with Gherkin syntax for readable test scenarios  
- **Page Object Model (POM)** for scalable and maintainable code  
- **TestNG** for test execution and parallelization  
- **Cross-browser support** (Chrome, Firefox, Edge, etc.)  
- **Jenkins integration** for CI/CD pipelines  
- **Detailed Cucumber Reports** with screenshots on failed steps  
- **Parallel execution** to reduce overall test run time  

---

## 📌 Test Coverage
The framework currently covers critical flows in the Healthcare web app:

1. **Login Page**
   - Valid login
   - Invalid login (incorrect credentials, empty fields, etc.)

2. **Book Appointment Page**
   - Multiple appointment booking scenarios  
   - More than **180 step definitions** implemented  

---

## 📂 Project Structure
```
CURA_Healthcare_Project
├── .idea/                         # IDE settings (ignored in git)
├── screenshots/                   # Failure screenshots
├── src
│   ├── main
│   │   └── java
│   │       ├── Drivers/           # WebDriver executables (chromedriver, geckodriver)
│   │       ├── org/example/       # Base package
│   │       ├── pageObjects/       # Page Object classes
│   │       │   ├── Base_PO.java
│   │       │   ├── Book_Appointment_PO.java
│   │       │   └── Login_PO.java
│   │       └── stepDefinitions/   # Step Definitions
│   │           ├── base/
│   │           │   └── Hooks.java
│   │           ├── Appointment_Button_Steps.java
│   │           ├── Book_Appointment_Steps.java
│   │           └── Login_Page_Steps.java
│   │
│   └── resources/                 # Feature files, configs
│
├── test
│   └── java
│       └── runners/               # Runners
│           ├── testng/            # TestNG suite
│           │   └── testng.xml
│           ├── MainRunner.java
│           └── cura_healthcare.java
│
└── pom.xml                        # Maven dependencies
```

---

## ⚙️ Tech Stack
- **Java** (programming language)
- **Selenium WebDriver** (UI automation)
- **Cucumber** (BDD framework)
- **TestNG** (test runner & parallel execution)
- **Maven** (build tool & dependency management)
- **Jenkins** (CI/CD integration)

---

## 📸 Screenshots & Reports

### ❌ Failed Step with Screenshot
When a test step fails, a screenshot is automatically captured and attached to the Cucumber report.

![Failed Step Screenshot](screenshots/failed_step.png)

### 📊 Cucumber HTML Report
An HTML execution report is generated after each run:

![Cucumber Report](screenshots/cucumber_report.png)

----

## ▶️ How to Run the Tests
### Run with Maven
```bash
mvn clean test
```

### Run with TestNG
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run with Tags
```bash
mvn test -Dcucumber.filter.tags="@Login"
```

---

## 📊 Reports
- **Cucumber HTML Reports** are generated under:
  ```
  /reports/cucumber-html-report
  ```
- **Screenshots** are automatically captured for failed steps and attached to the reports.

---

## 🔄 Jenkins Integration
This project is fully integrated with Jenkins:
- Supports **parameterized builds** for browser selection  
- Runs **parallel execution** for faster feedback  
- Generates **HTML & JSON reports** accessible in Jenkins  

---

## 🤝 Contributing
This framework was built as a portfolio project to demonstrate **QA Automation best practices**.  
Contributions and feedback are welcome!

---

## 👨‍💻 Author
**Luiz Lopes**  
📧 Contact: luizlopes1716@gmail.com
🔗 LinkedIn: https://www.linkedin.com/in/luiz-lopes-fonseca-neto/  
