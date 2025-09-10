<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leaderboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	<header id="navbar" class="header">
		<div class="logo">Quiz System</div>
			<h1 class="title">Leaderboard</h1>
			<nav class="nav-links">
				<a href="takeQuiz" class="nav-link">Take Quiz</a>
				<a href="index.jsp" class="nav-link">Home</a>
			</nav>
	</header>
	<div class="leaderboard-container">
    <div class="leaderboard-page">
        <table class="leaderboard-table">
            <thead>
                <tr>
                    <th class="leaderboard-header">Rank</th>
                    <th class="leaderboard-header">Student Name</th>
                    <th class="leaderboard-header">Score</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${results}" varStatus="status">
                    <tr class="leaderboard-row">
                        <td class="leaderboard-cell">${status.index + 1}</td>
                        <td class="leaderboard-cell">${result.studentName}</td>
                        <td class="leaderboard-cell">${result.score}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	</div>
</body>
</html>
