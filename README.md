# blazedemo
A basic project to demonstrate a basic page object model framework for selenium. Web app under test is Blazedemo

**Prerequisite**
1. Java environment 
2. Maven 

**Tools used**
1. Java 
2. Selenium (open-source automated testing framework)   
3. TestNG (testing / assertion framework)
4. Maven (dependency manager)
5. Extent Reports (for reports and comes with screenshot if test failed)
6. WebDriverManager (driver manager)

**To run the test use the following command:**
1. mvn clean test -Dbrowser=chrome -DsuiteXmlFile=smokeTestSuitePass.xml
2. browser options are: chrome , firefox 
3. suite xml file options are: smokeTestSuitePass.xml , regressionTestSuiteFail.xml
4. smokeTestSuitePass.xml - has no issue while regressionTestSuiteFail.xml - has 1 issue to demonstrate screenshot capabilities in the extent report
  
It will generate a html report which can be accessed in the folder: {root}\TestReport.
Filename is Blazedemo-Automation-Report.html
