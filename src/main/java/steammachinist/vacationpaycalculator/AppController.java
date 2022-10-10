package steammachinist.vacationpaycalculator;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import steammachinist.vacationpaycalculator.vacationpay.VacationPay;
import steammachinist.vacationpaycalculator.vacationpay.VacationPayService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Validated
public class AppController {
    private final VacationPayService vacationPayService;

    @RequestMapping(method = RequestMethod.GET, value = "/calculate", params = {"vacationDays", "averageSalary"})
    public double calculatePay(@RequestParam @Min(0) int vacationDays, @RequestParam @Min(0) double averageSalary) {
        VacationPay vacationPay = vacationPayService.createVacationPay(vacationDays, averageSalary);
        return vacationPay.calculatePay();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculate", params = {"start", "finish", "averageSalary"})
    public double calculatePay(@RequestParam @NotNull String start, @RequestParam @NotNull String finish,
                               @RequestParam @Min(0) double averageSalary) {
        VacationPay vacationPay = vacationPayService.createVacationPay(start, finish, averageSalary);
        return vacationPay.calculatePay();
    }
}

