package fr.industryportal.ontomapper.controller;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Abdelwadoud Rasmi
 * Controller to manage contributions
 */
@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping("")
    public JSONObject getRoot() {
        JSONObject json = new JSONObject();
        json.put("developer", "Abdelouadoud Rasmi");
        json.put("email", "abdelouadoudrasmi@gmail.com");
        json.put("github", "https://github.com/rasmi-aw");
        json.put("project_repo", "https://github.com/rasmi-aw/ontomapper");
        json.put("note", "You have to provide the api-key and username while submitting your requests");
        return json;
    }


    @GetMapping("/api")
    public void showApiUi(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/swagger-ui/index.html#");
    }

    @GetMapping("/api/json")
    public void showApiJson(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/v2/api-docs");
    }
}
