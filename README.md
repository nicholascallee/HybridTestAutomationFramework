# HybridTestAutomationFramework
Java based automation framework for ui, api, and database focused testing using the PAGE OBJECT MODEL methodology. 

## Notable Features
- Configurable browser and environment types
- Dynamic property file switching based on environment
- Selenium based item selection methods
- Event holder handles initialization of required page event classes
- Test Base class handles webdriver initialization, extent reporting, and config and environment variable injection.
- Configurable automatic retry of failed tests

## Example Test Case for user login
Verify the user can login to [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)
- Step 1: open the web browser
- Step 2: navigate to [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)
- Step 3: enter the username "Admin" into the username field
- Step 4: enter the password "admin123" into the password field
- Step 5: click the login button
- Step 6: verify the page has logged into the website
  - Step 6A: check that the top right of the page contains the correct username for the credentials entered. (in our case, Paul Collings is correct)

### Example Automated UI Test and Report for user login
![image](https://github.com/nicholascallee/HybridTestAutomationFramework/assets/141438641/db7e10b9-6592-43a6-92d3-27bcde700089)

![image](https://github.com/nicholascallee/HybridTestAutomationFramework/assets/141438641/3d242132-8d6a-4c6a-9468-972a25bd3085)


### Packages used
- TestNG
- Selenium
- Extent Reports
- Web Driver Manager

### Sources
[Building Selenium Java Framework from Scratch using Page Object Model | TestNG | Mini Project](https://www.youtube.com/watch?v=L7P5fqW2kck)
