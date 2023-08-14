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
    <p>${question.questionText}</p>
    <label>
        <input type="radio" name="answer" value="yes"> ${yesAnswer.answerText}
    </label>
    <label>
        <input type="radio" name="answer" value="no"> ${noAnswer.answerText}
    </label>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
