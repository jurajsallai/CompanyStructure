abstract class Employee {

    private String name;
    private double baseSalary;
    private static int count = 0;
    private int id;
    private Employee manager;

    // constructor
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.id = ++count;
    }

    // getter for baseSalary
    public double getBaseSalary() {
        return this.baseSalary;
    }

    // setter for baseSalary
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    // getter for id
    public int getEmployeeID() {
        return this.id;
    }

    // setter for manager
    public void setManager(Employee manager) {
        this.manager = manager;
    }


    // returns a reference to the Employee object that represents this employee's manager
    public Employee getManager() {
        return manager;
    }

    // returns true if two employee IDs are the same
    public boolean equals(Employee other) {
        if (this.id == other.id) {
            return true;
        }
        return false;
    }

    // returns a String representation of the employee in combination "id name"
    public String toString() {
        return this.id + this.name;
    }

    // returns a String representation of Employee's current status
    public abstract String employeeStatus();

}
