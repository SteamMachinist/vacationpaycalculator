package steammachinist.vacationpaycalculator.vacationpay;

import lombok.Value;

@Value
public class VacationPay {
    private static final int MONTH_DAYS = 30;
    int payedDays;
    double monthSalary;

    public double calculatePay() {
        return payedDays * monthSalary / MONTH_DAYS;
    }
}
