package com.jvatechs.mygame.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", "Ты потерял память.\n" +
                "Принять вызов НЛО?\n");
        request.getRequestDispatcher("/game.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAnswer = request.getParameter("answer");

        if ("YES".equals(userAnswer)) {
            request.setAttribute("question", "Ты принял вызов.\n" +
                    "Поднимаешься на мостик к капитану? \n");
        } else if ("NO".equals(userAnswer)) {
            request.setAttribute("question", "Ты отклонил вызов.\n" +
                    "Поражение\n");
        }

        request.getRequestDispatcher("/game.jsp").forward(request, response);


    }
}