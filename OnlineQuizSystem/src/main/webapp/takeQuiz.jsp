<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Take Quiz</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	<header id="navbar" class="header">
		<div class="logo">Quiz System</div>
		<h1 class="title" id="titlequiz">Take Quiz</h1>
		<nav class="nav-links">
	        <a href="leaderboard" class="nav-link">Leaderboard</a>
			<a href="index.jsp" class="nav-link">Home</a>
		</nav>
	</header>
    <div class="quiz-page">
        <form action="submitQuiz" method="post" class="quiz-form">
            <div class="quiz-form-group">
                <label for="studentName" class="quiz-label">Enter Your Name:</label>
                <input type="text" id="studentName" name="studentName" class="quiz-input" required><br><br>
            </div>

            <c:forEach var="question" items="${questions}">
                <div class="quiz-question-group">
                    <h3 class="quiz-question">Q${question.id}: ${question.questionText}</h3>
                    <c:forEach var="option" items="${optionsMap[question.id]}">
                        <div class="quiz-option-item">
                            <input type="radio" id="option_${option.optionId}" 
                                   name="answer_${question.id}" 
                                   value="${option.optionId}" 
                                   class="quiz-option-input" 
                                   required>
                            <label for="option_${option.optionId}" class="quiz-option-label">
                                ${option.optionText}
                            </label>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>

            <input type="submit" value="Submit Quiz" class="quiz-submit-btn">
        </form>
    </div>
</body>
</html>
