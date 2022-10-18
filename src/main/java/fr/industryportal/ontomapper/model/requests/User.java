package fr.industryportal.ontomapper.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Request model
 */
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @JsonProperty(value = "role")
    private List<String> roles;

    @Getter
    @Setter
    @JsonProperty(value = "@id")
    private String id;

    @Getter
    @Setter
    private String apikey;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", id='" + id + '\'' +
                '}';
    }
}
