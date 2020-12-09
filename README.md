# CSAM PL11 - Practical Tutorial on Static Code Analysis


Follow the following steps to run [SonarQube](https://www.sonarqube.org) in Java Projects:

1. Clone this repository in your computer.

2. **SonarQube**:
    1. Log in into SonarQube: [http://10.3.2.190:8080/](http://10.3.2.190:8080/)
    2. Create a project on SonarQube. You will need to create/use the key to configure the project.

3. Project **bookstore**:
    1. Edit the [`build.xml`](bookstore/build.xml), to change the `sonar.projectKey` and `sonar.projectName` properties. Replace YOUR_NUMBER by your student number.
    2. Edit the [`build.xml`](bookstore/build.xml), to change the `login` property using the the key information provided by SonarQube.

4. Project **webgoat** and **wsvd-bench**:
    1. Edit the [`pom.xml`](webgoat/pom.xml), to change the `<name>` property. Replace YOUR_NUMBER by your student number.
    2. Edit the [`add-sonarqube.sh`](webgoat/add-sonarqube.sh) with the key information provided by SonarQube.


5. Build the docker images in your computer, with the following script: [build.sh](build.sh). 
6. Run the container with the following script: "run.sh". If the script runs successfully, you will be inside the Docker container with the projects.
7. Run the `build-bookstore.sh` to build this project. This file is in the `bookstore` folder, where you are when you ented the container, and it is the only project that this step is required.
8. Run the `add-sonarqube.sh` for each one of the project. It will run ant/maven, and invoke SonarQube profile, which analyses the source code and send the results to SonarQube.
9. Analyze the results in the Web Interface of SonarQube. If you fix any issue, you can perform another analysis by the SonarQube.


**Authors**:

* José D'Abruzzo Pereira <josep@dei.uc.pt>
* Nuno Antunes <nmsa@dei.uc.pt>
