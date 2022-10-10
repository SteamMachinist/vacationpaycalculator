package steammachinist.vacationpaycalculator.payeddayscounter;

import lombok.Value;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Stream;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

@Value
public class SimplePayedDaysCounter implements PayedDaysCounter {
    public static final int FIRST_LEAP_YEAR = 4;
    Set<LocalDate> holidays;

    @Override
    public int count(LocalDate start, LocalDate finish) {
        return (int) Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, finish) + 1)
                .filter(d -> d.getDayOfWeek() != SATURDAY && d.getDayOfWeek() != SUNDAY)
                .filter(d -> !holidays.contains(d.withYear(FIRST_LEAP_YEAR)))
                .count();
    }
}
