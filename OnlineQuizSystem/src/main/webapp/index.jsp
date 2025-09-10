<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
   	response.setHeader("Pragma", "no-cache"); 
   	response.setHeader("Expires", "0");
    if ("true".equals(request.getParameter("logout"))) {
        if (session != null) {
            session.invalidate();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header id="navbar" class="header">
        <div class="logo">Quiz System</div>
        <nav class="nav-links">
            <a href="leaderboard" class="nav-link">Leaderboard</a>
            <a href="takeQuiz" class="nav-link">Take Quiz</a>
            <a href="adminLogin.jsp" class="nav-link">Admin Login</a>
        </nav>
    </header>

    <div id="container" class="container">
        <h1 id="main-title" class="main-title">Welcome to Online Quiz System</h1>
    </div>
</body>
</html>

