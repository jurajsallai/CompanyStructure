import java.util.ArrayList;
class Accountant extends BusinessEmployee {

    //team they are officially supporting
    TechnicalLead teamSupported;

    // constructor
    public Accountant(String name) {
        super(name);
        //no team they are officially supporting
    }

    // getter for teamSupported
    public TechnicalLead getTeamSupported() {
        return this.teamSupported;
    }

    // sets TechnicalLead which will be supported
    // sets budget
    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        ArrayList<SoftwareEngineer> e = lead.getTeam();
        double salary = e.get(0).getBaseSalary();
        setBonusBudget(salary * e.size() + salary * e.size() * 0.1);
    }

    //  If the suggested bonus is greater than the remaining budget,
    // false should be returned, otherwise true. If the accountant is not
    // supporting any team false should be returned.
    public boolean approveBonus(double bonus) {
        if (bonus < getBonusBudget() && !teamSupported.equals(null)) {
            return true;
        } else {
            return false;
        }
    }

    @ Override
    public String employeeStatus() {
        return super.employeeStatus().concat(" is supporting " + this.getTeamSupported().getName());
    }
}

