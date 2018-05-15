package pl.lukaszprasek.FirstApp.controllers.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class CalculatorForm {

    @NotNull
    @Range(min = 0, max = 10000000)
    @Digits(integer = 9, fraction = 2)
    private double loanAmount;

    @NotNull
    @Range(min = 0, max = 10000000)
    @Digits(integer = 6, fraction = 2)
    private double salary;

    @NotNull
    @Range(min = 0, max = 360)
    private int months;

    @NotNull
    @Range(min = 0, max = 10000000)
    @Digits(integer = 6, fraction = 2)
    private double expenses;

    public CalculatorForm() {}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}
