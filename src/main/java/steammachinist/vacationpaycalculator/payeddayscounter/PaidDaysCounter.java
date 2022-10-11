package steammachinist.vacationpaycalculator.payeddayscounter;

import java.time.LocalDate;

public interface PaidDaysCounter {
    int count(LocalDate start, LocalDate finish);
}
