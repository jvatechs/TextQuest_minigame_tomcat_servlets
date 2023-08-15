<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h1>Welcome to the Game!</h1>
<%--<div id="story-text">${storyIntro}</div>--%>
<form action="${pageContext.request.contextPath}/index" method="post">
    <h3> Пролог: </h3>
    <p>${storyIntro}</p>
    <br>
    <h3> Знакомство с экипажем: </h3>
    <p>${storyAcquaintanceText}</p>

<%--    <form action="${pageContext.request.contextPath}/game" method="get">--%>

        <label for="name">[Введите свое имя ниже и нажмите кнопку "Начать игру"]</label>
        <br>
        <br>
        <input type="text" id="name" name="playerName" placeholder="Введите свое имя:" required>
        <br>
        <br>
        <button type="submit">Start Game</button>
</form>



<%--<a href="game" target="_blank">Start Game</a>--%>
</body>
</html>
