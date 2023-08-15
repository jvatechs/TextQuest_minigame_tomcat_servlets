<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 14.08.2023
  Time: 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Over - You Win!</title>
</head>
<body>
<h1>Congratulations! You Win!</h1>
<h2>${resultText}</h2>

<form action="game" method="post">
    <button type="submit" name="reset" value="true">Start Over</button>
</form>
<!-- Add any additional content or styling as needed -->
</body>
<%@ include file="/WEB-INF/stats.jspf" %>
</html>

