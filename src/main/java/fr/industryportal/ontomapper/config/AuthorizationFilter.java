package fr.industryportal.ontomapper.config;

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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apikey = request.getParameter("apikey");
        //

    }


    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return super.shouldNotFilterErrorDispatch();
    }
}
