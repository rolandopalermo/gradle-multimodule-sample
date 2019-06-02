# What you'll need
* JDK 1.8
* Gradle 5.3
* IntelliJ

# Stack
* Spring Boot
* Spring Data REST
* Spring Data JPA

# Usage

```bash
$ cd /gradle-multimodule-sample
$ gradle bootRun
```

# Samples
## Request
Get a book by id
* GET http://localhost:8080/gradle-multimodule-sample/books/:id

## Response
```json
{
    "id": 1,
    "title": "Java SE 8 for the Really Impatient",
    "description": "Eagerly anticipated by millions of programmers, Java SE 8 is the most important Java update in many years."
}
```

## Request
Create a book
* POST http://localhost:8080/gradle-multimodule-sample/books

```json
{
    "title": "Java SE 8 for the Really Impatient",
    "description": "Eagerly anticipated by millions of programmers, Java SE 8 is the most important Java update in many years."
}
```

## Response
```json
{
    "id": 1,
    "title": "Java SE 8 for the Really Impatient",
    "description": "Eagerly anticipated by millions of programmers, Java SE 8 is the most important Java update in many years."
}
```