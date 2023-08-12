<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Adventure Game</title>
</head>
<body>
<h1>Text Adventure Game</h1>
<form action="${pageContext.request.contextPath}/game" method="post">
    <p>${question}</p>
    <label>
        <input type="radio" name="answer" value="YES"> YES
    </label>
    <label>
        <input type="radio" name="answer" value="NO"> NO
    </label>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
