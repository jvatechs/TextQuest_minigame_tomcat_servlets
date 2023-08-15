package com.jvatechs.mygame.servlets.view;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private JsonObject jsonObject; // Store the JSON object

    @Override
    public void init() throws ServletException {
        jsonObject = loadJsonObjectFromJsonFile();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String storyIntro = loadStoryIntroFromJsonFile();
        String storyAcquaintanceText = loadStoryAcquaintanceTextFromJson();

        request.setAttribute("storyIntro", storyIntro);
        request.setAttribute("storyAcquaintanceText", storyAcquaintanceText);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerName = request.getParameter("playerName");
        HttpSession session = request.getSession();
        session.setAttribute("playerName", playerName);
        session.setAttribute("gamesPlayed", 0);

        String ipAddress = request.getRemoteAddr();
        session.setAttribute("ipAddress", ipAddress);

        response.sendRedirect(request.getContextPath() + "/game");

    }

    //    private String loadStoryIntroFromJsonFile() {
//        InputStream inputStream = getServletContext().getResourceAsStream("story.json");
//        InputStreamReader reader = new InputStreamReader(inputStream);
//
//        JsonReader jsonReader = Json.createReader(reader);
//        JsonObject jsonObject = jsonReader.readObject();
//        jsonReader.close();
//
//        return jsonObject.getJsonObject("intro").getString("text");
//    }
    private JsonObject loadJsonObjectFromJsonFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("story.json");
        JsonReader jsonReader = Json.createReader(inputStream);

        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        return jsonObject;
    }

    private String loadStoryIntroFromJsonFile() {
        return jsonObject.getJsonObject("intro").getString("text");
    }

    private String loadStoryAcquaintanceTextFromJson() {
        return jsonObject.getJsonObject("intro").getString("acquaintance");
    }

}