package com.jvatechs.mygame.servlets.view;

import com.jvatechs.mygame.servlets.controller.InitClass;
import com.jvatechs.mygame.servlets.model.Answer;
import com.jvatechs.mygame.servlets.model.Question;
import com.jvatechs.mygame.servlets.model.Result;
import com.jvatechs.mygame.servlets.view.GameServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;

    private List<Question> questions;
    private GameServlet gameServlet;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        // Initialize questions
        questions = new ArrayList<>();
        questions.add(new Question("Question 1"));
        questions.add(new Question("Question 2"));

        // Initialize gameServlet
        gameServlet = new GameServlet() {

            protected List<Question> getQuestions() {
                return questions;
            }
        };
    }

    @Test
    void testDoGet() throws ServletException, IOException {
        // Mock session
        when(request.getSession()).thenReturn(session);

        // Mock dispatcher
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(requestDispatcher);

        // Execute the doGet method
        gameServlet.doGet(request, response);

        // Verify that the attributes were set and the dispatcher was called
        verify(request).setAttribute("question", questions.get(0));
        verify(request).setAttribute("yesAnswer", questions.get(0).getYesAnswer());
        verify(request).setAttribute("noAnswer", questions.get(0).getNoAnswer());
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoPost_YesAnswer() throws ServletException, IOException {
        // Mock session
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gamesPlayed")).thenReturn(0);

        // Mock user choice and dispatcher
        when(request.getParameter("answer")).thenReturn("yes");
        when(request.getRequestDispatcher("/win.jsp?restart=true")).thenReturn(requestDispatcher);

        // Mock current question and answer
        Answer yesAnswer = new Answer("Yes Answer", 1);
        Answer noAnswer = new Answer("No Answer", 2);
        Question question = new Question("Question", yesAnswer, noAnswer, 1);
        questions.add(question);

        // Execute the doPost method
        gameServlet.doPost(request, response);

        // Verify that the attributes were set and the dispatcher was called
        Result result = (Result) yesAnswer.getQuestionOrResult();
        verify(request).setAttribute("resultText", result.getResultText());
        verify(requestDispatcher).forward(request, response);
        verify(session).setAttribute("gamesPlayed", 1);
    }

    @Test
    void testDoPost_NoAnswer() throws ServletException, IOException {
        // Mock session
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gamesPlayed")).thenReturn(0);

        // Mock user choice and dispatcher
        when(request.getParameter("answer")).thenReturn("no");
        when(request.getRequestDispatcher("/gameover.jsp?restart=true")).thenReturn(requestDispatcher);

        // Mock current question and answer
        Answer yesAnswer = new Answer("Yes Answer", 1);
        Answer noAnswer = new Answer("No Answer", 2);
        Question question = new Question("Question", yesAnswer, noAnswer, 1);
        questions.add(question);

        // Execute the doPost method
        gameServlet.doPost(request, response);

        // Verify that the attributes were set and the dispatcher was called
        Result result = (Result) noAnswer.getQuestionOrResult();
        verify(request).setAttribute("resultText", result.getResultText());
        verify(requestDispatcher).forward(request, response);
        verify(session).setAttribute("gamesPlayed", 1);
    }
}
