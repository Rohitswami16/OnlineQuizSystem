# 📝 OnlineQuizSystem

A simple web-based quiz application built using Java, JSP, Servlets, and MySQL. The application allows students to take quizzes and view their results and leaderboard. An admin can log in to add questions.

## 🌐 GitHub Repository

[Click here to view the repository](https://github.com/Rohitswami16/OnlineQuizSystem)

---

## ✅ Features

- **👨‍💻 Admin Panel**
  - 🔐 Login functionality for admin.
  - ➕ Add quiz questions.
  
- **👩‍🎓 Student Interface**
  - 📝 Take quizzes without the need for login.
  - 📊 View quiz results after completion.
  - 🏆 View leaderboard with top scores.

- **🛠️ Technologies Used**
  - **Frontend:** HTML, CSS, JavaScript, JSP  
  - **Backend:** Java (Servlets, JSP)  
  - **Database:** MySQL  
  - **Server:** Apache Tomcat  
  - **Build Tool:** Maven

---

## 📦 Dependencies

The project uses the following libraries, managed by Maven:

- `javax.servlet:javax.servlet-api` - For Servlet support.
- `javax.servlet.jsp:javax.servlet.jsp-api` - For JSP pages.
- `com.mysql:mysql-connector-j` - For connecting with MySQL database.
- `javax.servlet:jstl` - For JSP Standard Tag Library support.

These are defined in the `pom.xml`.

---

## ⚙️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Rohitswami16/OnlineQuizSystem.git

2. **Import into your IDE**
   - Open the project in **Eclipse** or **STS (Spring Tool Suite)**.
   - Configure **Apache Tomcat** server.

3. **Setup MySQL Database**
   - Create a database (e.g., `OnlineQuizSystem_Database`).
   - Create tables manually using the code provided.

4. **Run the project**
   - Deploy the project on **Tomcat**.
   - Open your browser and visit:  
     `(http://localhost:8080/OnlineQuizSystem/)`

```
quiz-project/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/quiz/
│       │       ├── controller/  # Servlets handling requests
│       │       │   ├── AdminLoginController.java
│       │       │   ├── AdminPanelController.java
│       │       │   ├── HomeController.java
│       │       │   ├── LeaderboardController.java
│       │       │   ├── QuizController.java
│       │       │   └── ResultController.java
│       │       ├── dao/  # Data Access Objects for database interaction
│       │       │   ├── AdminDAO.java
│       │       │   ├── OptionDAO.java
│       │       │   ├── QuestionDAO.java
│       │       │   └── ResultDAO.java
│       │       ├── model/  # Java classes representing data models
│       │       │   ├── Admin.java
│       │       │   ├── Option.java
│       │       │   ├── Question.java
│       │       │   └── Results.java
│       │       └── util/  # Utility classes like DB connection
│       │           └── DBConnection.java
│       ├── resources/ # Configuration files
│       │   └── application.properties
│       └── webapp/ # Frontend files
│           ├── adminLogin.jsp
│           ├── adminPanel.jsp
│           ├── index.js
│           ├── index.jsp
│           ├── leaderboard.jsp
│           ├── style.css
│           └── takeQuiz.jsp
├── pom.xml  # Maven build file
└── README.md

```
---

## 📸 Screenshots

<table>
  <tr>
    <td align="center">
      <img width="965" height="400" alt="Home" src="https://github.com/user-attachments/assets/e7a94cef-818e-4d6d-a95b-9334ce35f5a6" /><br><b>Home</b>      
    </td>
    <td align="center">
      <img width="965" height="400" alt="Admin Login" src="https://github.com/user-attachments/assets/b7529415-27f3-4417-91c4-3ead64673aa1" /><br><b>Admin Login</b>
    </td>
    <td align="center">
      <img width="965" height="400" alt="Add Question" src="https://github.com/user-attachments/assets/4c77c8b7-bf8c-4c9b-bf7d-349ddd8a9b55" /><br><b>Add Question</b>      
    </td>
  </tr>
</table>
<table>
  <tr>
    <td align="center">
      <img width="965" height="400" alt="Quiz" src="https://github.com/user-attachments/assets/c88027ef-8e5b-4368-ba60-64099224750b" /><br><b>Quiz</b>
    </td>
    <td align="center">
      <img width="965" height="400" alt="Result" src="https://github.com/user-attachments/assets/459fe3a4-aaac-40e3-b7a0-21882fd32e0c" /><br><b>Result</b>      
    </td>
    <td align="center">
    <img width="965" height="400" alt="Leaderboard" src="https://github.com/user-attachments/assets/191c884d-4331-431d-a5c7-f2f958fb6770" /><br><b>Leaderboard</b>
    </td>
  </tr>
</table>

---
## Author

**Rohit Swami**  
GitHub: [@Rohitswami16](https://github.com/Rohitswami16)

