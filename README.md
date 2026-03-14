# 📋 Contact List Application – Selenium Automation Testing Framework.

## 📌 Project Overview

This project is a **Selenium WebDriver automation framework** built using **Java** and **TestNG** to test the [Contact List Application](https://thinking-tester-contact-list.herokuapp.com/) — a CRUD-based web application used for QA practice.

It covers functional testing, input validation, UI responsiveness checks, session management, and automated reporting.

---

## 🌐 Application Under Test

- **URL:** https://thinking-tester-contact-list.herokuapp.com/
- **Type:** Contact Management Web Application (CRUD)
- **Features Tested:** Signup, Login, Add Contact, Edit Contact, Delete Contact, Input Validation, UI & Responsiveness

---

## 🏗️ Framework Architecture

```
1.Project/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── Projectspecificmethods.java   # Base class – BeforeSuite, BeforeMethod, DataProviders
│   │   ├── pages/                             # Page Object Model (POM) classes
│   │   │   ├── LoginPage.java
│   │   │   ├── SignupPage.java
│   │   │   └── ContactPage.java
│   │   └── utils/
│   │       ├── Utilityclass.java              # WebDriver setup, Excel reader, Screenshot util
│   │       └── MyListeners.java               # TestNG Listener
│   ├── test/java/
│   │   └── test/                              # Test classes
│   │       ├── LoginTest.java
│   │       ├── SignupTest.java
│   │       ├── AddContactTest.java
│   │       ├── EditContactTest.java
│   │       ├── DeleteContactTest.java
│   │       ├── InputvalidationTest.java
│   │       ├── SessionAndNavigationTest.java
│   │       └── UIandResponsivenessTest.java
│   └── test/resources/
│       └── Data/
│           └── Logindata.xlsx                 # Excel test data
├── Screenshot/                                # Auto-captured test screenshots
├── logs/                                      # Log4j log files
└── pom.xml
```

---

## 🧪 Test Coverage

| Test Class | Scenarios Covered |
|---|---|
| `LoginTest` | Valid login, Invalid login, Empty fields, Wrong password |
| `SignupTest` | Valid signup, Existing user, Empty fields |
| `AddContactTest` | Add contact with full details using Excel data |
| `EditContactTest` | Edit contact button, Edit contact details, Cancel edit validation |
| `DeleteContactTest` | Delete contact, Alert verification, Delete confirmation |
| `InputvalidationTest` | Long text input restriction, Emoji/special character input |
| `SessionAndNavigationTest` | Session handling, Page navigation |
| `UIandResponsivenessTest` | Field alignment, Button visibility, Toast message verification |

> **Total: 20+ test scenarios across 8 test classes**

---

## 🛠️ Tech Stack

| Tool / Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Core programming language |
| Selenium WebDriver | 4.41.0 | Browser automation |
| TestNG | 7.12.0 | Test framework & execution |
| Maven | 3.x | Build & dependency management |
| Apache POI | 5.5.1 | Excel data-driven testing |
| ExtentReports | 5.1.2 | HTML test reporting |
| Log4j2 | 2.25.3 | Test execution logging |
| Git | – | Version control |

---

## ✨ Key Features

- ✅ **Page Object Model (POM)** – Clean separation of page logic and test logic
- ✅ **Data-Driven Testing** – Test data managed via Excel sheets (Login, Signup, ContactDetails, LoginDetails)
- ✅ **ExtentReports** – Auto-generated dark-themed HTML reports with test categories and author info
- ✅ **Log4j2 Logging** – Step-by-step logs for every test execution
- ✅ **Screenshot Capture** – Timestamped screenshots saved automatically on execution
- ✅ **Multi-Browser Support** – Chrome, Edge, Firefox
- ✅ **Input Validation Testing** – Long text, emoji, and special character edge cases
- ✅ **UI Responsiveness Checks** – Field alignment and button visibility assertions

---

## ▶️ How to Run

### Prerequisites
- Java JDK 17+
- Maven 3.x
- Chrome / Edge / Firefox browser installed
- Eclipse IDE or IntelliJ IDEA

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/Raghulrasu98/PROJECT-1.1.git
cd PROJECT-1.1
```

**2. Install dependencies**
```bash
mvn clean install -DskipTests
```

**3. Run all tests**
```bash
mvn test
```

**4. Run via TestNG XML** *(in Eclipse)*
- Right-click `testng.xml` → Run As → TestNG Suite

---

## 📊 Test Report

After execution, the HTML report is generated at:
```
src/test/resources/testoutput/herokureport.html
```
Open in any browser to view detailed pass/fail results with logs, categories, and author info.

---

## 📁 Excel Test Data Structure

File: `src/test/resources/Data/Logindata.xlsx`

| Sheet | Columns |
|---|---|
| Login | Username, Password, TestType, Expected |
| Signup | Username, Password, TestType, Expected |
| contactdetails | Username, Password, FirstName, LastName, Phone, City, TestType, Expected |
| logindetails | Username, Password |

---

## 👨‍💻 Author

**Raghul R**
- 📧 rrraghulrajendran@gmail.com
- 📞 9942264438
- 🎓 GUVI Certified – Java Automation Testing
- 📍 Chennai, Tamil Nadu

---

## 📜 License

This project is created for learning and portfolio purposes.
