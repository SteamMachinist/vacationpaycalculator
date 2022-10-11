package steammachinist.vacationpaycalculator.vacationpay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import steammachinist.vacationpaycalculator.payeddayscounter.PaidDaysCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class VacationPayFactory {
    private final PaidDaysCounter paidDaysCounter;
    private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VacationPay createVacationPay(int paidDays, double monthSalary) {
        return new VacationPay(paidDays, monthSalary);
    }

    public VacationPay createVacationPay(String start, String finish, double monthSalary) {
        return new VacationPay(paidDaysCounter.count(
                LocalDate.parse(start, f), LocalDate.parse(finish, f)), monthSalary);
    }
}
