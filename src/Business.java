public class Business
{
    private String name;
    private int employees;
    private int employeeWage;
    private boolean ownBuilding;
    private int buildingRent;
    private boolean isHiring;

    public Business(String name, int employeeWage, boolean ownBuilding, int buildingRent, boolean isHiring)
    {
        this.name = name;
        this.employees = 0;
        this.employeeWage = employeeWage;
        this.ownBuilding = ownBuilding;
        this.buildingRent = buildingRent;
        this.isHiring = isHiring;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public int getEmployees()
    {
        return employees;
    }

    public void setEmployees(int newEmployees)
    {
        employees = newEmployees;
    }

    public int getEmployeeWage()
    {
        return employeeWage;
    }

    public void setEmployeeWage(int newEmployeeWage)
    {
        employeeWage = newEmployeeWage;
    }

    public boolean ownBuilding()
    {
        return ownBuilding;
    }

    public void setOwnBuilding(boolean newOwnBuilding)
    {
        ownBuilding = newOwnBuilding;
    }

    public int getBuildingRent()
    {
        return buildingRent;
    }

    public boolean getIsHiring()
    {
        return isHiring;
    }

    public void setHiring(boolean newIsHiring)
    {
        isHiring = newIsHiring;
    }
}