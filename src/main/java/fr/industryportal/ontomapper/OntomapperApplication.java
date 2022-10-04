package fr.industryportal.ontomapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OntomapperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OntomapperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
