# Vacationpaycalculator

Calculates a pay for vacation given:
- [x] vacation days and month salary
- [x] specified dates of vacation (including both start and end, excluding weekends and holidays) and month salary


### Usage (with curl):
```
curl -X GET "http://localhost:<port>/calculate?vacationDays=<int>&monthSalary=<double>"

curl -X GET "http://localhost:<port>/calculate?start=<dd/MM/yyyy>&finish=<dd/MM/yyyy>&monthSalary=<double>"
```
for example:
* simple:
```
curl -X GET "http://localhost:8080/calculate?vacationDays=10&monthSalary=1200"
```
should return:  
> 400.0

* with specific dates:
```
curl -X GET "http://localhost:8080/calculate?start=03/10/2022&finish=09/10/2022>&monthSalary=2100"
```
should return (5 paid days and 2 weekends):
> 450.0
