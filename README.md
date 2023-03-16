# AutoTestReportPortal

## How to run:
### On Local Machine:
#### 1 - Clone the Project
#### 2 - Open CMD in Project folder
#### 3 - Enter the commands:
- **Run CucumberTestRunner:**
> mvn clean test -Dbrowser="chrome/firefox" (default is chrome)

### On Remote:
#### 1 - Download Selenium Grid( v4.8.1) and put the file into any folder
#### 2 - Run the command in the folder stored file Selenium Grid
> java -jar selenium-server-4.8.1.jar standalone
#### 3 - On IDE, run the command:
> mvn clean test -DisRemote=true
#### 4 - Open link "http://localhost:4444/ui#" to observe the sessions running.

## Allure Report:
Allure results will appear in "target/allure-results" folder. To generate html report and automatically open it in a web browser, run the following command:
> allure serve target/allure-results

TBD