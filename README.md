# BDD Test Cucumber Automation Framework for Veeva Assignment

## Description

This project is a comprehensive automation testing framework for the Veeva automation assignment. It implements Behavior-Driven Development (BDD) using Cucumber, providing extensive test coverage for both CP and DP functionalities.

The framework is designed to test a wide range of features to access websites, handle elements, test windows and create files.

## Tech Stack

- **Programming Language**: Java
- **Automation Tool**: Selenium WebDriver
- **BDD Framework**: Cucumber
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Reporting**: Allure Cucumber
- **Additional libraries**: WebDriverManager ...

## Execution

- Use TestRunner java class file, provide the tag of the case intended to be executed. Run the tests as TestNG.
- No need of setting up a separate chrome driver, it's handled within the code itself. 
- Please setup dependencies before the run, missed few steps due to project deadline collided with office work. Can explain the logics during the walkthrough discussion
- Framework Architectural diagram and Artifacts text file are added to ArchitecturalFrameworkDiagramandArtifacts folder for reference.
- Attached the pass reports of all the four cases mentioned in assignment for reference in PassedReports folder attached in framework zip file.

## Key Features

1. **Cucumber BDD**
   - Feature files written in Gherkin syntax for clear test case documentation
   - Step definitions mapping features to code
   - Encourages collaboration between technical and non-technical team members
  
2.  **Page Object Model (POM)**
    - implements the POM design pattern for improved maintainability and reusability
    - Separates page elements and actions for cleaner code structure

4. **GitHub Actions CI**
   - Continuous Integration setup using GitHub Actions
   - Automated test execution on push or pull requests in branch master

5. **Cross-Browser and Multi-Environment Testing**
   - Supports tests across multiple browsers (Chrome, Firefox, Safari, Edge)
   - Configurable for different test environments (Production ....)

6. **Data Generation**
   - Utilizes libraries like JavaFaker for dynamic test data creation
   - Generates realistic user information, product details, and order data
  
7. **Parallel Execution**
   - Supports concurrent execution of test scenarios
   - Configurable thread count for optimal performance

8. **Allure Reporting**
   - Comprehensive test reports with Allure Cucumber integration
   - Detailed step-by-step test execution logs
   - Visual representations of test results and trends
     
9. **Screenshot Capture**
    - Automatic capture of screenshots on test failure
    - Embedded screenshots in Allure reports for easy debugging
	     
10. **Log4j **
    - Records important information like error messages and user inputs in a program
    - an open source software library, a package of prewritten code that developers can freely use.
	
11. **TestNG**
	- Purpose: Runs the test methods defined in the TestNG runner class and generate reports.
	
	

   
