# Code-Sharing-Platform
Platform where you can share public/private code
Made with Spring Boot, Spring Data JPA, REST, H2 Database and Thymeleaf

### Add new Code Snippet
Request `POST /api/code/new`

Response:
![img_4.png](img/img_4.png)

Request: `GET /code/47cf19b5-7808-4545-9e13-882bfe1daedb`

Response:
![img_3.png](img/img_3.png)
>The views and seconds left decrease every time the code is accessed


### Check the latest snippet ordered by creation timestamp
Request: `GET /api/code/latest`

Response:
![img_5.png](img/img_5.png)

Request: `GET /code/latest`

Response:
![img_2.png](img/img_2.png)
> Only shows snippets that don't have any restrictions


### Publish new code snippet with GUI
Request: `GET /code/new`

Response:
![img_1.png](img/img_1.png)

### Access saved snippets on H2 datebase
![img.png](img/img.png)
