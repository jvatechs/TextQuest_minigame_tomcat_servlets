<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/indexStyle.css" >
    <title>Welcome to the Game!</title>
</head>
<body>
<div id="wrapper">
    <h1>Welcome to the Game!</h1>
    <form action="${pageContext.request.contextPath}/index" method="post" target="_blank">
    <h3> Пролог: </h3>
    <p>${storyIntro}</p>
    <br>
    <h3> Знакомство с экипажем: </h3>
    <p>${storyAcquaintanceText}</p>

<%--    <form action="${pageContext.request.contextPath}/game" method="get">--%>

        <label for="name" id="enterName">[Введите свое имя ниже и нажмите кнопку "Начать игру"]</label>
        <br>
        <br>
        <input type="text" id="name" name="playerName" placeholder="Введите свое имя:" required>
        <br>
        <br>
        <button type="submit" class="btn btn-success">Начать игру!</button>
</form>

</div>
</body>
</html>
