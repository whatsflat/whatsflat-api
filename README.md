# whatsflat-api
API for the WhatsFlat chat app.

## Local setup

Before building or running the application the first time, the following steps are necessary:
- You need a running postgres server
- Create an empty database called "whatsflat"
- Specify your database username and password in `src/main/resources/secrets.properties`:
  ```properties
  spring.datasource.username=user
  spring.datasource.password=password
   ```

