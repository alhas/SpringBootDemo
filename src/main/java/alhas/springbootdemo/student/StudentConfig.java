package alhas.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bahtiyar = new Student(
                    "Bahtiyar",
                    "bahtiyaralialhas@gmail.com",
                    LocalDate.of(1993, FEBRUARY, 28)
            );
            Student hakan = new Student(
                    "Hakan",
                    "zaralioglan@gmail.com",
                    LocalDate.of(1999, DECEMBER, 12)
            );
            repository.saveAll(
                    List.of(bahtiyar, hakan)
            );

        };

    }

}
