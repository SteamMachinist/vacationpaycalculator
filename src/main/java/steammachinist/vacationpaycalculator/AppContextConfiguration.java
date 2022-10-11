package steammachinist.vacationpaycalculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import steammachinist.vacationpaycalculator.payeddayscounter.SimplePaidDaysCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@ComponentScan
public class AppContextConfiguration {
    @Value("classpath:static/holidays.txt")
    Resource holidaysFile;

    @Bean
    public SimplePaidDaysCounter simplePayedDaysCounter() {
        return new SimplePaidDaysCounter(readHolidaysFromFile());
    }

    @Bean
    public Set<LocalDate> readHolidaysFromFile() {
        try {
            try (Stream<String> lines = new BufferedReader(
                    new InputStreamReader(holidaysFile.getInputStream(), StandardCharsets.UTF_8)).lines()) {
                return lines.map(s -> {
                    String[] date = s.split("/");
                    return LocalDate.of(
                            SimplePaidDaysCounter.FIRST_LEAP_YEAR,
                            Integer.parseInt(date[1]),
                            Integer.parseInt(date[0]));
                }).collect(Collectors.toSet());
            }
        } catch (IOException ignored) {}

        return new HashSet<>();
    }
}
