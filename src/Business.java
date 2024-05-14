public class Business {
    private String name;
    private int employees;
    private int employeeWage;
    private int startUpCost;
    private boolean ownBuilding;
    private int buildingCost;
    private int buildingRent;
    private boolean isHiring;

    public Business(String name, int employeeWage, boolean ownBuilding, boolean isHiring) {
        this.name = name;
        this.employees = 0;
        this.employeeWage = employeeWage;
        this.startUpCost = 0;
        this.ownBuilding = ownBuilding;
        this.buildingCost = 0;
        this.buildingRent = 0;
        this.isHiring = isHiring;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int newEmployees) {
        employees = newEmployees;
    }

    public int getEmployeeWage() {
        return employeeWage;
    }

    public int getStartUpCost()
    {
        return startUpCost;
    }

    public void setStartUpCost(int newStartUpCost)
    {
        startUpCost = newStartUpCost;
    }

    public void setEmployeeWage(int newEmployeeWage) {
        employeeWage = newEmployeeWage;
    }

    public boolean ownBuilding() {
        return ownBuilding;
    }

    public void setOwnBuilding(boolean newOwnBuilding) {
        ownBuilding = newOwnBuilding;
    }

    public int getBuildingCost()
    {
        return buildingCost;
    }

    public void setBuildingCost(int newBuildingCost)
    {
        buildingCost = newBuildingCost;
    }

    public int getBuildingRent() {
        return buildingRent;
    }

    public void setBuildingRent(int newBuildingRent)
    {
        buildingRent = newBuildingRent;
    }

    public boolean getIsHiring() {
        return isHiring;
    }

    public void setHiring(boolean newIsHiring) {
        isHiring = newIsHiring;
    }

    public int calculateDailyExpenses()
    {
        int expenses = 0;
        if(!ownBuilding)
        {
            expenses += buildingRent;
        }
        expenses += (employees * employeeWage);
        return expenses;
    }

    public int calculateDailyRevenue()
    {
        int revenue = 0;
        return revenue;
    }

    public int calculateDailyNetIncome()
    {
        return(calculateDailyRevenue() - calculateDailyExpenses());
    }
}