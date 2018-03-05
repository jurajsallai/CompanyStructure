abstract class BusinessEmployee extends Employee {

    private static final double baseSalary = 50000;
    private double bonusBudget;

    // constructor
    public BusinessEmployee(String name) {
        super(name, baseSalary);
        this.bonusBudget = 0.0;
    }

    // getter for bonusBudget
    public double getBonusBudget() {
        return bonusBudget;
    }

    // setter for bonusBudget for use in Accountant
    public void setBonusBudget(double bonus) {
        this.bonusBudget = bonus;
    }

    @Override
    public String employeeStatus() {
        return (getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget());
    }



}
