# Testing using Automation Scripts for Android Movie App

This repository contains an Appium-based automation project for testing an Android app. The project uses TestNG for managing test execution and assertions.

## Table of Contents

- [Project Overview](#project-overview)
- [Tools Used](#tools-used)
- [Running Tests](#running-tests)
- [Report](#report)




## Project Overview

This project automates two main scenarios in an Android movie app:
1. Verifying that the movie title on the home screen matches the title on the movie details page.
2. Checking whether a movie's release date is in the future, based on the current date.


## Tools Used

Before running the project, ensure you have the following installed:

- **Java "21.0.2"** 
- **Maven 3.9.6** 
- **intelJ IDE**
- **Android SDK** with an emulator or a connected Android device
- **Appium Server** (installed via npm, check this [link](https://www.testbytes.net/blog/how-to-install-appium-server-and-node-on-windows-through-command-line/)).
  - appium drivers:  uiautomator2 "3.7.6"
  - appium plugins:  element-wait "3.0.2"
- **Appium Inspector** (for UI element inspection)

## Running Tests

1. **Clone the repository**
2. **Open the project in IntelliJ**
3. **Open the "Pom.xml" and update the maven dependencies** 
4. **Run the test cases from "AppJetflix.java"**

## Report
![Report.png](Demo%2FReport.png)
![Report MovieTitle.png](Demo%2FReport%20MovieTitle.png)
![Report ReleaseDate.png](Demo%2FReport%20ReleaseDate.png)
