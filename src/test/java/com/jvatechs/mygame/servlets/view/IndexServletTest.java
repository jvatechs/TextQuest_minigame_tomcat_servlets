package com.jvatechs.mygame.servlets.view;

import com.jvatechs.mygame.servlets.view.IndexServlet;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.StringReader;

import static org.mockito.Mockito.*;

public class IndexServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Test
    void testDoGet() throws ServletException, IOException {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Create a JSON object as a string to simulate loading from the JSON file
        String jsonContent = "{\"intro\": {\"text\": \"Intro Text\", \"acquaintance\": \"Acquaintance Text\"}}";

        // Mock the behavior of the request and session
        when(request.getSession()).thenReturn(session);

        // Mock the behavior of loading the JSON object
        JsonObject jsonObject = Json.createReader(new StringReader(jsonContent)).readObject();
        IndexServlet servlet = new IndexServlet();
        servlet.init();
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);
        when(request.getAttribute("storyIntro")).thenReturn(jsonObject.getJsonObject("intro").getString("text"));
        when(request.getAttribute("storyAcquaintanceText")).thenReturn(jsonObject.getJsonObject("intro").getString("acquaintance"));

        // Execute the doGet method
        servlet.doGet(request, response);

        // Verify that the attributes were set and the dispatcher was called
        verify(request).setAttribute("storyIntro", "Intro Text");
        verify(request).setAttribute("storyAcquaintanceText", "Acquaintance Text");
        verify(requestDispatcher).forward(request, response);
    }
}
