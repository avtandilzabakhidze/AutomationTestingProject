# AutomationTestingProject

## Overview
This project is an automated testing suite developed in **Java** using the **Selenium** framework, **TestNG** for test execution and **Allure** for reporting. The tests validate the functionality of the [SauceDemo](https://www.saucedemo.com/) website, ensuring its critical features work as expected.

## Features Tested

### 1. Login Functionality
- Validates login with various user roles and credentials.
- Verifies error messages for:
  - Incorrect credentials.
  - Empty username or password fields.
  - Locked-out user scenarios.

### 2. Product Management
- Add, remove and validate products in the cart.
- Sort products by:
  - Name (A-Z and Z-A).
  - Price (Low-High and High-Low).

### 3. Order Processing
- Tests the entire checkout process:
  - Valid details result in successful order placement.
  - Missing details display error messages.
- Validates total price calculations, including taxes.

## Highlights

### 1. **Allure Reports**
The project integrates **Allure Reporting** to provide:
- Step-by-step logs of each test execution.
- Detailed visual insights into test success and failure rates.

### 2. **Screenshots on Failure**
- The `BaseAction` class includes a `takeScreenshot()` method to capture screenshots whenever a test fails.
- This ensures easier and faster debugging by highlighting the exact state of the application during a failure.
