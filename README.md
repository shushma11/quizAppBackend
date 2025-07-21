# Quiz App Backend

A Spring Boot-based backend service for managing quizzes and questions. This application allows admins to create quizzes based on question categories and lets users attempt them, submitting answers to get scores.

---

## 🔧 Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **MySQL (any JPA-compatible DB)**

---

## 📁 Project Structure
quizAppBackend/
├── controller/
│ ├── QuestionController.java
│ └── QuizController.java
├── model/
│ ├── Question.java
│ ├── Quiz.java
│ ├── Response.java
│ └── QuestionWrapper.java
├── service/
│ ├── QuestionService.java
│ └── QuizService.java
├── dao/
│ ├── QuestionRepository.java
│ └── QuizRepository.java
└── application.properties


---

## 📦 Features

- Add new quiz questions with multiple-choice options.
- Get all questions or filter by category.
- Generate quizzes with a specific number of questions from a category.
- Retrieve quiz questions by quiz ID (excluding answers).
- Submit a quiz and receive a score based on correct answers.

---

## 🚀 How to Run Locally

1. **Clone the repository**

```bash
git clone https://github.com/shushma11/quizAppBackend.git
cd quizAppBackend


