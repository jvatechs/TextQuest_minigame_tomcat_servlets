<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/gameStyle.css" >

    <title> Мини-игра "Cosmos Quiz" </title>

</head>
<body>
<div>
<h1> Мини-игра "Cosmos Quiz" </h1>
<form action="${pageContext.request.contextPath}/game" method="post" >
    <p id="question">${question.questionText}</p>
    <br>
    <label class="answer">
        <input class="form-check-input" type="radio" name="answer" value="yes" required> ${yesAnswer.answerText}
    </label>
    <br>
    <br>
    <label class="answer">
        <input class="form-check-input" type="radio" name="answer" value="no" required> ${noAnswer.answerText}
    </label>
    <br>
    <br>
    <input type="submit" value="Submit" class="btn btn-success">
</form>
</div>
</body>
<%@ include file="/WEB-INF/stats.jspf" %>
</html>
