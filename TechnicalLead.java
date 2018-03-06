import java.util.ArrayList;


class TechnicalLead extends TechnicalEmployee {
    //private double baseSalary;
    private int headCount;
    private ArrayList<SoftwareEngineer> team;

    // constructor
    public TechnicalLead(String name) {
        super(name);
        setBaseSalary(getBaseSalary()*1.3);
        setHeadCount(4);
        this.team = new ArrayList<SoftwareEngineer>();
    }

    // setter for headCount
    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }


    // returns size of this team
    public int getTeamSize() {
        return this.team.size();
    }

    // getter for team for use in Accountant
    public ArrayList<SoftwareEngineer> getTeam() {
        return this.team;
    }

    // returns size of this headCount
    public int getHeadCount() {
        return this.headCount;
    }

    // returns true if the number of direct reports this manager has is less than their headcount.
    public boolean hasHeadCount() {
        if (getTeamSize() < getHeadCount()) {
            return true;
        }
        return false;
    }

    //  if the TechnicalLead has head count left, new SoftwareEngineer will be added to the team.
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            this.team.add(e);
            e.setManager(this);
            return true;
        } else
            return false;
    }

    // returns true if employee passed in does report to this manager and if code access is "true"
    public boolean approveCheckIn(SoftwareEngineer e) {
        if (e.getManager().equals(this) &&  e.getCodeAccess())
            return true;
        else
            return false;
    }

    // checks if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
    // If it is, that employee should get that bonus and true should be returned. False should be returned otherwise 
    public boolean requestBonus(Accountant e, double bonus) {
        if ( ((BusinessLead) getManager()).approveBonus(e, bonus) ) {
          e.setBonusBudget(bonus);
          return true;
        } else {
          return false;
        }
    
    }
  

    // returns team status
    public String getTeamStatus() {
        if (getTeamSize() == 0) {
            return this.employeeStatus() + " and no direct reports yet";
        } else {
            String returnString = employeeStatus() + "  and is managing:\n";
            for (SoftwareEngineer e:team) {
                returnString = returnString.concat(e.employeeStatus() + "\n");
            }
            return returnString;
        }

    }

}
