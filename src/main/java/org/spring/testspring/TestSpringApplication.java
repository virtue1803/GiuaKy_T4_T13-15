package org.spring.testspring;

import org.spring.testspring.enums.Roles;
import org.spring.testspring.models.Candidate;
import org.spring.testspring.models.Experience;
import org.spring.testspring.services.impl.CandidateService;
import org.spring.testspring.services.impl.ExperienceSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TestSpringApplication {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ExperienceSerivce experienceSerivce;

    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Candidate candidate_1 = new Candidate("John Smith", "0123456789", "john@gmail.com");
                Candidate candidate_2 = new Candidate("Jane Doe", "0987654321", "jane@gmail.com");
                Candidate candidate_3 = new Candidate("Joe Hash", "0135792468", "joe@gmail.com");

                Experience experience_1 = new Experience("Toshiba", Roles.ADMINISTRATOR, "Website Development by Java FullStack",
                        LocalDate.of(2018, 1, 1), LocalDate.of(2023, 5, 10), candidate_1);

                Experience experience_2 = new Experience("Intel", Roles.EXECUTIVE, "IOT Programming",
                        LocalDate.of(2020, 6, 21), LocalDate.of(2022, 10, 3), candidate_2);

                Experience experience_3 = new Experience("Asus", Roles.STAFF, "Create Content",
                        LocalDate.of(2021, 1, 9), LocalDate.of(2022, 2, 20), candidate_3);

                candidateService.save(candidate_1);
                candidateService.save(candidate_2);
                candidateService.save(candidate_3);

                experienceSerivce.save(experience_1);
                experienceSerivce.save(experience_2);
                experienceSerivce.save(experience_3);
            }
        };
    }

}
