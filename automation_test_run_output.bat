@echo off
echo Running tests...
mvn clean test
echo.
echo Generating Allure report...
mvn allure:report
echo.
echo Allure report generated at: target\allure-report\index.html
echo.
echo Opening Allure report in browser...
start "" "target\allure-report\index.html"
pause