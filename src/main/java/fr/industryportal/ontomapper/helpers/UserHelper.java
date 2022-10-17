package fr.industryportal.ontomapper.helpers;

import fr.industryportal.ontomapper.OntomapperApplication;
import fr.industryportal.ontomapper.model.requests.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Abdelwadoud Rasmi
 * This is the main entrypoint of the app
 */
@FeignClient(name = "userClient", url = OntomapperApplication.API_URL)

public interface UserHelper {

    /**
     * Queries the portal api to check of this user exist
     */
    @GetMapping("")
    User getUser(@RequestParam String username,
                 @RequestParam String apikey);
}
