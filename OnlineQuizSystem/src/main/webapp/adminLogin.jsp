<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-page">
        <div class="login-container">
            <h2 class="login-title">Admin Login</h2>
            
            <form action="adminLogin" method="post" class="login-form">
                <div class="login-form-group">
                    <label for="login-username" class="login-label">Username:</label>
                    <input type="text" id="login-username" name="username" class="login-input" required>
                </div>

                <div class="login-form-group">
                    <label for="login-password" class="login-label">Password:</label>
                    <input type="password" id="login-password" name="password" class="login-input" required>
                </div>

                <input type="submit" value="Login" class="login-submit-btn">
            </form>

            <p class="login-error-msg">
                ${error}
            </p>
        </div>
    </div>    
</body>
</html>
