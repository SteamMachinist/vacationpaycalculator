package steammachinist.vacationpaycalculator.vacationpay;

import lombok.Value;

@Value
public class VacationPay {
    private static final int MONTH_DAYS = 30;
    int paidDays;
    double monthSalary;

    public double calculatePay() {
        return paidDays * monthSalary / MONTH_DAYS;
    }
}
