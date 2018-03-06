import java.util.ArrayList;

class BusinessLead extends BusinessEmployee {
  
  private int headCount;
  private ArrayList<Accountant> team;
  
  // constructor
  public BusinessLead(String name) {
    super(name);
    setBaseSalary(getBaseSalary()*2);
    setHeadCount(10);
    this.team = new ArrayList<Accountant>();
  }
  
  // setter for headCount
  public void setHeadCount(int headCount) {
    this.headCount = headCount;
  }
  
  // returns size of this team
  public int getTeamSize() {
    return this.team.size();
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
    else {
      return false;
    }       
  }
  
  // if the BusinessLead has head count left, new Accountant  will be added to the team.
  // bonus will be increased by 1.1 times that new employee's salary
  // sets which TechnicalLead will this Accountant supports
  public boolean addReport(Accountant e, TechnicalLead supportTeam) {
    if (hasHeadCount()) {
      this.team.add(e);
      setBonusBudget(getBonusBudget() + 1.1 * e.getBaseSalary());
      e.supportTeam(supportTeam);
      e.setManager(this);
      return true;
    } else {
      return false;
    }
  }
  
  // if requested bonus fits in current BusinessLead's budget, Accountant should get that bonus, 
  // the BusinessLeader's budget is deducted and true returned. False is returned otherwise.
  public boolean requestBonus(Accountant e, double bonus) {
    if (bonus <= getBonusBudget()) {
      e.setBonusBudget(bonus);
      this.setBonusBudget(getBonusBudget() - bonus);
      return true;
    } else {
      return false;
    }
  }
  
  // looks through the Accountants the BusinessLead manages, and if any of them are supporting the TechnicalLead 
  // that is the manager of the Employee passed in then the Accountant's budget should be consulted to see if the bonus
  // could be afforded. If the team can afford the bonus it should be rewarded and true returned, false otherwise
  public boolean approveBonus(Accountant e, double bonus) {
    for (Accountant a:team) {
      /* if accountant in team is supporting the TechnicalLead that is the manager of the Employee passed in argument */
      if (a.getTeamSupported().equals(e.getManager())) {
        /* if bonus can be afforded */
        if (a.getBonusBudget() >= bonus) {
          e.setBonusBudget(bonus);
          return true;
        } else 
          return false;              
      }  
    } return false;  
  }

  
  // returns team status
  public String getTeamStatus() {
    if (getTeamSize() == 0) {
      return this.employeeStatus() + " and no direct reports yet";
    } else {
      String returnString = employeeStatus() + "  and is managing:\n";
      for (Accountant a:team) {
        returnString = returnString.concat(a.employeeStatus() + "\n");
      }
      return returnString;
    }

  }

}
