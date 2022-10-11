package steammachinist.vacationpaycalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VacationpaycalculatorApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private AppController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void simpleVacationPayCalculation() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/calculate?vacationDays=15&monthSalary=2400",
                String.class)).contains("1200");
    }

    @Test
    void simpleDatesVacationPayCalculation() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/calculate?start=10/10/2022&finish=14/10/2022&monthSalary=2700",
                String.class)).contains("450");
    }

    @Test
    void weekendsDatesVacationPayCalculation() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/calculate?start=26/09/2022&finish=09/10/2022&monthSalary=2700",
                String.class)).contains("900");
    }

    @Test
    void holidaysDatesVacationPayCalculation() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/calculate?start=07/03/2022&finish=11/03/2022&monthSalary=2100",
                String.class)).contains("280");
    }

    @Test
    void largeDatesVacationPayCalculation() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port
                        + "/calculate?start=29/12/2021&finish=25/02/2022&monthSalary=3000",
                String.class)).contains("3700");
    }

}
