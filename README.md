# Covid Tracker
This project exposes APIs developed using spring boot from a sample covid dataset

**Dependencies Used**
- Spring Batch - Read CSV File and populate to HSQL database
- Spring JPA

**RESTful endpoints**
- Dashboard summary - http://localhost:8080/api/v1/dashboardSummary
- Individual state summary - http://localhost:8080/api/v1/summary/{stateName}
