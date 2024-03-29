package com.jvatechs.mygame.servlets.view;

import com.jvatechs.mygame.servlets.controller.InitClass;
import com.jvatechs.mygame.servlets.model.Gradable;
import com.jvatechs.mygame.servlets.model.Question;
import com.jvatechs.mygame.servlets.model.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private List<Question> questions;  // List of questions
    private int currentQuestionIndex;  // Index of the current question

    @Override
    public void init() throws ServletException {
        // Initialize your list of questions here
        InitClass initClass = new InitClass();

        questions = initClass.getQuestionList();
        currentQuestionIndex = 0;  // Start with the first question
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            request.setAttribute("question", currentQuestion);
            request.setAttribute("yesAnswer", currentQuestion.getYesAnswer());
            request.setAttribute("noAnswer", currentQuestion.getNoAnswer());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/game.jsp");
            dispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userChoice = request.getParameter("answer"); // Get user's choice
        String resetChoice = request.getParameter("reset");

        if ("true".equals(resetChoice)) {
            currentQuestionIndex = 0;
            doGet(request, response);
        }


        if ("yes".equals(userChoice)) {
            // User chose yesAnswer, process accordingly
            Gradable gradable = questions.get(currentQuestionIndex).getYesAnswer().getQuestionOrResult();

            if (gradable instanceof Question) {
                currentQuestionIndex++;
                doGet(request, response);  // Show the next question
            } else if (gradable instanceof Result) {
                // Game over logic, show appropriate JSP page
                // request.getRequestDispatcher("/win.jsp").forward(request, response);
                Result result = (Result) gradable;
                request.setAttribute("resultText", result.getResultText());
                incrementGamesPlayed(request);
                request.getRequestDispatcher("/win.jsp?restart=true").forward(request, response);
            }
        } else if ("no".equals(userChoice)) {
            // User chose noAnswer, process accordingly
            Gradable gradable = questions.get(currentQuestionIndex).getNoAnswer().getQuestionOrResult();

            //everyTime will be GameOver

            Result result = (Result) gradable;
            request.setAttribute("resultText", result.getResultText());
            incrementGamesPlayed(request);
            request.getRequestDispatcher("/gameover.jsp?restart=true").forward(request, response);
        }


    }

    private void incrementGamesPlayed(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");
        if (gamesPlayed == null || gamesPlayed == 0) {
            gamesPlayed = 1;
        } else {
            gamesPlayed++;
        }
        session.setAttribute("gamesPlayed", gamesPlayed);
    }
}