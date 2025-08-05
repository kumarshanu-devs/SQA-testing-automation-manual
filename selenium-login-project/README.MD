Selenium Login Form Automation ProjectOverviewThis project demonstrates a simple yet robust framework for automating web UI tests using Selenium WebDriver with Java. It tests the functionality of a login form, covering scenarios for successful and failed login attempts.The framework is built using industry-standard tools and design patterns, making it a great example for showcasing QA automation skills.FeaturesAutomated testing of a sample login form.Successful Login: Verifies that a user with valid credentials can log in.Failed Login: Verifies that appropriate error messages are displayed for:Invalid passwords.Empty credentials.Page Object Model (POM): Separates test logic from UI interaction for better maintenance and readability.Automated Reporting: TestNG generates detailed reports of test execution results.Cross-Platform: Runs on any machine with the prerequisites installed, as it uses a local HTML file for testing.Technology StackLanguage: Java 11Automation Tool: Selenium WebDriverTest Framework: TestNGBuild & Dependency Management: Apache MavenDriver Management: WebDriverManager (automatically handles browser drivers)Project Structureselenium-login-project/
├── pom.xml                 # Maven configuration (dependencies, plugins)
├── src/
│   └── test/
│       ├── java/
│       │   └── com/example/
│       │       ├── pages/
│       │       │   └── LoginPage.java   # Page Object for the login page
│       │       └── tests/
│       │           └── LoginTest.java   # TestNG test class with all test cases
│       └── resources/
│           └── login.html      # The local web page used for testing
├── testng.xml              # TestNG suite configuration
└── README.md               # This file
How to Run the TestsPrerequisitesJava Development Kit (JDK) 11 or higher installed.Apache Maven installed.Google Chrome browser installed.StepsClone the Repositorygit clone <your-repo-url>
cd selenium-login-project
Run from Command LineOpen a terminal or command prompt in the project's root directory and run the following Maven command:mvn clean test
Maven will download all dependencies, compile the code, and run the tests defined in testng.xml.View ReportsAfter the tests have run, TestNG reports can be found in the target/surefire-reports directory. Open the emailable-report.html or index.html file in a web browser to see the results.Run from an IDE (e.g., IntelliJ IDEA)Open IntelliJ and select File > Open....Navigate to the project's root folder and open it. IntelliJ will automatically recognize it as a Maven project.Allow the IDE to import dependencies.To run the tests, you can either:Right-click on the testng.xml file and select Run '.../testng.xml'.Right-click on the LoginTest.java file and select Run 'LoginTest'.