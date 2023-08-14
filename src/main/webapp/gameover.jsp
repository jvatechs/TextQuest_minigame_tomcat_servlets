<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 14.08.2023
  Time: 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Over - You Lost</title>
</head>
<body>
<h1>Game Over</h1>
<p>Unfortunately, you lost the game. Reason: ${resultText}</p>

<form action="game" method="post">
    <button type="submit" name="reset" value="true">Start Over</button>
</form>
<!-- Add any additional content or styling as needed -->
</body>
</html>


