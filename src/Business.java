public class Business
{
    private String name;
    private int employees;
    private double employeeWage;
    private boolean ownBuilding;
    private double buildingRent;
    private boolean isHiring;

    public Business(String name, int employees, double employeeWage, boolean ownBuilding, double buildingRent, boolean isHiring)
    {
        this.name = name;
        this.employees = employees;
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

    public double getEmployeeWage()
    {
        return employeeWage;
    }

    public void setEmployeeWage(double newEmployeeWage)
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

    public double getBuildingRent()
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