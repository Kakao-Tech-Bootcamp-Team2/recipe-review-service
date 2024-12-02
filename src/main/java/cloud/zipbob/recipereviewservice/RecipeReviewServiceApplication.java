package cloud.zipbob.recipereviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableMongoAuditing
public class RecipeReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeReviewServiceApplication.class, args);
    }

}
