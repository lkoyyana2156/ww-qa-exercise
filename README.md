# WW QA Exercise
## Steps to run the test locally
* Clone the repo
* Make sure you have the latest chrome browser(89) since the chromedriver in project only supports 89
   * If you're using earlier version of chrome browser, please download the relative driver from [Download ChromeDriver](https://chromedriver.chromium.org/downloads)
   * Replace the chromedriver.exe file in /QaExercise/supportingbinaries/chromedriver_win32 with the file downloaded in above step
* Install TestNG if it is not already installed in the eclipse IDE
* Right click on the testng.xml file and select Run As -> TestNG Suite
 
## Notes
* I used Page object model to setup the project
* I added all the validation in one test method as it wasn't clear in the email to write separate tests or not
* I added three methods to get the Schedule from the Studio Details page as it wasn't clear in email whether to return just Studio schedule or both Studio and Virtual
   * Test method prints schedules for Studio, Virtual and Combined
