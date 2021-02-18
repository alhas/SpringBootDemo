package alhas.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;



@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bahtiyar = new Student(
                    "Bahtiyar",
                    "bahtiyaralialhas@gmail.com",
                    LocalDate.of(1993, Month.FEBRUARY, 28)
            );
            Student hakan = new Student(
                    "Hakan",
                    "zaralioglan@gmail.com",
                    LocalDate.of(1999, Month.DECEMBER, 12)
            );
            repository.saveAll(
                    List.of(bahtiyar, hakan)
            );

        };

    }

}
