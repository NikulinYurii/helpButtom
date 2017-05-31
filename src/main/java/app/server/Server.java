package app.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by yurii on 22.04.17.
 */

@EnableWebMvc
@ComponentScan(value = "app")
@EntityScan(basePackages = "app.model")
@SpringBootApplication
public class Server {

    public static void main(String[] args) {

        SpringApplication.run(Server.class, args);
    }
}
