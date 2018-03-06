class SoftwareEngineer extends TechnicalEmployee {
    private boolean access;

    // constructor
    public SoftwareEngineer(String name) {
        super(name);
        setCodeAccess(false);
    }

    // getter for access
    public boolean getCodeAccess() {
        return this.access;
    }

    // setter for access
    public void setCodeAccess(boolean access) {
        this.access = access;
    }

    // if manager approves SoftwareEngineer's check in, the checkin count should be
    // increased and the method should return "true". Otherwise is access changed
    // to false and returns "false".
    public boolean checkInCode() {
        /* if manager approves their check in */
        if (((TechnicalLead) getManager()).approveCheckIn(this)) {
            setCheckIn();
            return true;
        }
        else {
            setCodeAccess(false);
            return false;
        }
    }
}
