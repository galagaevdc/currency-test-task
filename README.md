## About
This assignment aims to assess your proficiency with Java Spring Boot in building services. 
Your comprehension of instructions, coding standards, design, API creation, testing, and documentation will be evaluated.
Your code should be clear, easy for other developers to understand and extend. 

## Deadlines
Do NOT spend more than 2 or 3 hours on this project.
Submit whatever you have at the end of this duration.
Prioritize writing accurate code over voluminous code.
Your code should illustrate your application design skills and code quality.

**If you have questions about the test, draw your own conclusions based on what makes sense from your perspective.**

## Evaluation Criteria (In order of importance)
- Clean, self-documenting code
- Usage of Spring Boot
- Docker utilization
- Business logic tests
- Git with meaningful commit messages
- Documentation: README.md

Share your implementation through a git repository
## Technical Test
Develop a service to manage a catalog of books.
- The database can be pre-populated with a given list of books in json file **(catalog.json)**. File can be too large to process in memory.
- This service should be able to accept new book entries and update existing entries based on ISBN.
- The service should expose APIs to add, update, and fetch book details.
- Implement validation to ensure that all book entries have a valid ISBN, title and genres.
- Include a Dockerfile to containerize your service.
- The service must handle certain signals correctly. For example, it should gracefully shutdown on SIGTERM.
- Give at least one example for each type of test that you think is needed for your assignment. 
- Your README should explain how to run your service and execute the tests.

## Bonus Points
- Implement basic authentication for your service.
- Implement pagination functionality for the API.
- Expose a Swagger UI or Spring Rest Docs for your API documentation.

Good luck with your implementation, and adhere to the time constraint of 2-3 hours.
