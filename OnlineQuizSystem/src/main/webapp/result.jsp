<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<header id="navbar" class="header">
			<div class="logo">Quiz System</div>
				<h1 class="title">Quiz Result</h1>
				<nav class="nav-links">
					<a href="leaderboard" class="nav-link">Leaderboard</a>
					<a href="takeQuiz" class="nav-link">Take Quiz</a>
					<a href="index.jsp" class="nav-link">Home</a>
				</nav>
		</header>
    <div class="result-container">
		<div class="result-page">
        <p class="result-student-name">Student Name: <strong>${studentName}</strong></p>
        <p class="result-score">Your Score: <strong>${score} / ${totalQuestions}</strong></p>
    </div>
	</div>
</body>
</html>
