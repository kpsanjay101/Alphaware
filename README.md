# Fresh Blog

## Purpose
Fresh Blog is a blogging platform designed to provide both users and admins with an interface to interact with blog content.

## Tech Stack
- Java
- MySQL
- Spring Boot
- Spring Security
- Swagger UI

## User Interface Functionality
1. *User Registration and Login*
   - Users can sign up for a User account.
   - Registration includes fields such as username, email, and password.
   - Registered users can securely log in to their accounts by providing email and password.

2. *Read Blogs*
   - Users can read blogs available on the platform.
   - Users can see all the Posts.
   - Users can see all the Posts Uploaded Today.
   - Users can see all Posts using Category Names.
   - Users can comment on any Posts.

3. *Search*
   - Users can search for blogs by category and heading.

## Admin Interface Functionality
1. *Admin Registration*
   - Admins can register for an admin account.
   - Registration includes fields such as username, email, and password.

2. *Access Endpoints*
   - Admins have access to all available endpoints.

## Hosting
- The application is hosted on Railway.app.
- Access the application through the provided host link: [Freah Blog Host Link](https://alphaware-production.up.railway.app/swagger-ui/index.html)

## Instruction to use Swagger API Documentation
- Register as a user with the role "customer".
- Login using the login API.
- Copy the bearer token from the response body and paste it in the "Bearer token" input box (located in the top right corner by clicking on the lock symbol) to authorize access.
- Access the available endpoints for user and admin interfaces.

## Additional Notes
- Ensure MySQL is properly configured for the application to function correctly.
- Continuous monitoring and updating of the blog content may be required for user engagement.
- Consider implementing additional features such as commenting on blogs, liking/disliking blogs, or bookmarking favorite blogs for future iterations.
