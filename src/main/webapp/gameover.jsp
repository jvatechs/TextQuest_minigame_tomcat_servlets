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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/gameover.css" >
    <title>Game Over - You Lost</title>
</head>
<body>
<h1>Game Over</h1>
<p id="gameover"> Ты проиграл! Причина: ${resultText}</p>

<form action="game" method="post">
    <button type="submit" name="reset" value="true"  class="btn btn-primary btn-lg">Начать заново </button>
</form>
<!-- Add any additional content or styling as needed -->
</body>
<%@ include file="/WEB-INF/stats.jspf" %>
</html>

