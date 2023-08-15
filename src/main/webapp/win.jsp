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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/winStyle.css" >
    <title>Ты победил!</title>
</head>
<body>
<h1>Поздравляю, ты победил!</h1>
<h2>${resultText}</h2>

<form action="game" method="post">
    <button type="submit" name="reset" value="true"  class="btn btn-primary btn-lg">Начать заново!</button>
</form>
</body>
<%@ include file="/WEB-INF/stats.jspf" %>
</html>

