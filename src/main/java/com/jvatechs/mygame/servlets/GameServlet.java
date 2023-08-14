package com.jvatechs.mygame.servlets;

import com.jvatechs.mygame.servlets.model.InitClass;
import com.jvatechs.mygame.servlets.model.basic_entities.Gradable;
import com.jvatechs.mygame.servlets.model.basic_entities.Question;
import com.jvatechs.mygame.servlets.model.basic_entities.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/game")
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
        } else {
            // Game over logic, show appropriate JSP page
            // request.getRequestDispatcher("/gameover.jsp").forward(request, response);
        }

        String restart = request.getParameter("restart");

        if ("true".equals(restart)) {
            currentQuestionIndex = 0;  // Reset the game
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userChoice = request.getParameter("answer"); // Get user's choice


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
                request.getRequestDispatcher("/win.jsp?restart=true").forward(request, response);
            }
        } else if ("no".equals(userChoice)) {
            // User chose noAnswer, process accordingly
            Gradable gradable = questions.get(currentQuestionIndex).getNoAnswer().getQuestionOrResult();

            //everyTime will be GameOver

            Result result = (Result) gradable;
            request.setAttribute("resultText", result.getResultText());
            request.getRequestDispatcher("/gameover.jsp?restart=true").forward(request, response);


//            if (gradable instanceof Question) {
//                currentQuestionIndex++;
//                doGet(request, response);  // Show the next question
//            } else if (gradable instanceof Result) {
//                // Game over logic, show appropriate JSP page
//                // request.getRequestDispatcher("/win.jsp").forward(request, response);
//            }
        }
    }
}