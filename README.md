# whatsflat-api
API for the WhatsFlat chat app.

## Local setup

### Prerequisites
- Java 17
- A running postgres server

### Before building or running the application the first time, the following steps are necessary:
- Create an empty database called "whatsflat"
- Specify your database username and password in **src/main/resources/secrets.properties**:
  ```properties
  spring.datasource.username=user
  spring.datasource.password=password
  ```
