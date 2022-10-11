package steammachinist.vacationpaycalculator;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import steammachinist.vacationpaycalculator.vacationpay.VacationPay;
import steammachinist.vacationpaycalculator.vacationpay.VacationPayFactory;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Validated
public class AppController {
    private final VacationPayFactory vacationPayFactory;

    @RequestMapping(method = RequestMethod.GET, value = "/calculate", params = {"vacationDays", "monthSalary"})
    public double calculatePay(@RequestParam @Min(0) int vacationDays, @RequestParam @Min(0) double monthSalary) {
        VacationPay vacationPay = vacationPayFactory.createVacationPay(vacationDays, monthSalary);
        return vacationPay.calculatePay();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculate", params = {"start", "finish", "monthSalary"})
    public double calculatePay(@RequestParam @NotNull String start, @RequestParam @NotNull String finish,
                               @RequestParam @Min(0) double monthSalary) {
        VacationPay vacationPay = vacationPayFactory.createVacationPay(start, finish, monthSalary);
        return vacationPay.calculatePay();
    }
}

