package steammachinist.vacationpaycalculator.payeddayscounter;

import java.time.LocalDate;

public interface PayedDaysCounter {
    int count(LocalDate start, LocalDate finish);
}
