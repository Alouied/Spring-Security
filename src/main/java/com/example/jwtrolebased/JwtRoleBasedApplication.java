package com.example.jwtrolebased;

import com.example.jwtrolebased.auth.AuthenticationService;
import com.example.jwtrolebased.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.jwtrolebased.user.Role.ADMIN;
import static com.example.jwtrolebased.user.Role.MANAGER;

@SpringBootApplication
public class JwtRoleBasedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtRoleBasedApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authenticationService
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("admin")
                    .lastname("admin")
                    .email("admin@admin.com")
                    .password("admin")
                    .role(ADMIN)
                    .build();
            System.out.println("admin: " + authenticationService.register(admin));

            var manager = RegisterRequest.builder()
                    .firstname("manager")
                    .lastname("manager")
                    .email("manager@manager.com")
                    .password("manager")
                    .role(MANAGER)
                    .build();
            System.out.println("manager: " + authenticationService.register(manager));
        };
    }
}
