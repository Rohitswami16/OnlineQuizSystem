<%
    if (session == null || session.getAttribute("admin") == null) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="style.css">
	<script src="index.js" defer></script>
</head>
<body>
	<header id="navbar" class="header">
	        <div class="logo">Quiz System</div>
			<h1 class="title">Add Question</h1>
	        <nav class="nav-links">
	            <a href="leaderboard" class="nav-link">Leaderboard</a>
	            <a href="takeQuiz" class="nav-link">Take Quiz</a>
				<a href="index.jsp?logout=true" class="nav-link">Logout</a>

	        </nav>
	    </header>
    <div class="admin-page">
        <div id="admin-container">

            <form action="adminPanel" method="post" id="admin-form">
				<div class="admin-form-group">
				    <label for="admin-question-text">Question:</label>
				    <input type="text" id="admin-question-text" name="questionText" maxlength="100" required><br>
				</div>

                <div class="admin-form-group">
                    <label for="admin-num-options">Number of Options (2-6):</label>
                    <input type="number" id="admin-num-options" name="numOptions" value="2" min="2" max="6" onchange="updateOptions()" required><br>
                </div>
				
				<div class="admin-option-group">
				    <div id="admin-option-div-1" class="admin-option-item">
				        <label for="admin-option-1">Option 1:</label>
				        <input type="text" id="admin-option-1" name="option1" required>
				    </div>
				    <div id="admin-option-div-2" class="admin-option-item">
				        <label for="admin-option-2">Option 2:</label>
				        <input type="text" id="admin-option-2" name="option2" required>
				    </div>
				    <div id="admin-option-div-3" class="admin-option-item" style="display: none;">
				        <label for="admin-option-3">Option 3:</label>
				        <input type="text" id="admin-option-3" name="option3">
				    </div>
				    <div id="admin-option-div-4" class="admin-option-item" style="display: none;">
				        <label for="admin-option-4">Option 4:</label>
				        <input type="text" id="admin-option-4" name="option4">
				    </div>
				    <div id="admin-option-div-5" class="admin-option-item" style="display: none;">
				        <label for="admin-option-5">Option 5:</label>
				        <input type="text" id="admin-option-5" name="option5">
				    </div>
				    <div id="admin-option-div-6" class="admin-option-item" style="display: none;">
				        <label for="admin-option-6">Option 6:</label>
				        <input type="text" id="admin-option-6" name="option6">
				    </div>
				</div>

                <div class="admin-form-group">
                    <label for="admin-correct-answer">Correct Answer (Option Number):</label>
                    <input type="number" id="admin-correct-answer" name="correctAnswer" min="1" max="2" required><br>
                </div>

                <input type="submit" name="action" value="Add Question" class="admin-submit-btn">
            </form>
        </div>
    </div>
	
    <script>updateOptions();</script>
</body>
</html>
