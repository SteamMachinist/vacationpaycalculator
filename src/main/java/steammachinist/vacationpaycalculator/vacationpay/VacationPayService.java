package steammachinist.vacationpaycalculator.vacationpay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import steammachinist.vacationpaycalculator.payeddayscounter.PayedDaysCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class VacationPayService {
    private final PayedDaysCounter payedDaysCounter;
    private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VacationPay createVacationPay(int payedDays, double monthSalary) {
        return new VacationPay(payedDays, monthSalary);
    }

    public VacationPay createVacationPay(String start, String finish, double averageSalary) {
        return new VacationPay(payedDaysCounter.count(
                LocalDate.parse(start, f), LocalDate.parse(finish, f)), averageSalary);
    }
}
