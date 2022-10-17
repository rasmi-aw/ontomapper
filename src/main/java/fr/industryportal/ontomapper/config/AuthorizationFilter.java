package fr.industryportal.ontomapper.config;

import fr.industryportal.ontomapper.helpers.UserHelper;
import fr.industryportal.ontomapper.model.requests.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Abdelwadoud Rasmi
 * Filter to check for authorized requests
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UserHelper userHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String apikey = request.getParameter("apikey");
        User user;
        try {
            // check if the user exists
            user = userHelper.getUser(username, apikey);
            request.setAttribute("user", user);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You must provide a valid username and a valid apikey, thank you.");
        }
        //
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String url = request.getRequestURI();
        return !(url.contains("/swagger-ui/index.html#") && url.contains("v2"));
    }
}
