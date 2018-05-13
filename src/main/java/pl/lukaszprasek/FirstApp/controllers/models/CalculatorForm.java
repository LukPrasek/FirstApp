package pl.lukaszprasek.FirstApp.controllers.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CalculatorForm {

    @NotEmpty
    @Size(max = 6)
    //@Pattern(regexp = "[0-9]*")
    private String loanAmount;

    @NotEmpty
    @Size(max = 6)
 //   @Pattern(regexp = "[0-9]*")
    private String salary;

    @NotEmpty
    @Size(max = 2)
   // @Pattern(regexp = "[0-9][0-9]")
    private String months;

    @NotEmpty
    @Size(max = 6)
    //@Pattern(regexp = "[0-9]*")
    private String expensys;

    public CalculatorForm() {
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getExpensys() {
        return expensys;
    }

    public void setExpensys(String expensys) {
        this.expensys = expensys;
    }
}
