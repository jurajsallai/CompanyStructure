abstract class TechnicalEmployee extends Employee {

    private static final double baseSalary = 75000;
    private int checkIn;

    // constructor
    public TechnicalEmployee(String name) {
        super(name, baseSalary);
        this.checkIn = 0;
    }

    // getter for checkIn
    public int getCheckIn() {
        return this.checkIn;
    }

    // increase checkIn
    public void setCheckIn() {
        this.checkIn++;
    }

    @Override
    public String employeeStatus() {
        return (getEmployeeID() + " " + getName() + " has " + getCheckIn() + " successful check ins");
    }

}