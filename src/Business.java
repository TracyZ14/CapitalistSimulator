public class Business {
    private String businessType;
    private String name;
    private int employees;
    private int employeeWage;
    private int startUpCost;
    private boolean ownBuilding;
    private int buildingCost;
    private int buildingRent;
    private boolean isHiring;
    private int customers;
    private int productCost;
    private int productProceed;

    public Business()
    {
        this.businessType = "BUSINESS";
    }

    public Business(String name, int employeeWage, boolean ownBuilding, boolean isHiring) {
        this.businessType = "BUSINESS";
        this.name = name;
        this.employees = 0;
        this.employeeWage = employeeWage;
        this.startUpCost = 0;
        this.ownBuilding = ownBuilding;
        this.buildingCost = 0;
        this.buildingRent = 0;
        this.isHiring = isHiring;
        this.customers = 0;
        this.productCost = 0;
        this.productProceed = 0;
    }

    public String getBusinessType()
    {
        return businessType;
    }

    public void setBusinessType(String newBusinessType)
    {
        businessType = newBusinessType;
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

    public int getCustomers()
    {
        return customers;
    }

    public void randomizeNumberOfCustomers()
    {
        customers = (int) (100 + Math.random() * 200);
        if(employees == 0)
        {
            customers = 0;
        }
    }

    public int getProductCost()
    {
        return productCost;
    }

    public void setProductCost(int newProductCost)
    {
        productCost = newProductCost;
    }

    public int getProductProceed()
    {
        return productProceed;
    }

    public void setProductProceed(int newProductProceed)
    {
        productProceed = newProductProceed;
    }

    public int calculateDailyExpenses()
    {
        int expenses = 4;
        expenses += (employees * employeeWage);
        if(!ownBuilding)
        {
            expenses += buildingRent;
        }
        expenses += customers * productCost;
        return expenses;
    }

    public int calculateDailyRevenue()
    {
        int revenue = 0;
        revenue += customers * productProceed;
        revenue += employees * (revenue / 100);
        return revenue;
    }

    public int calculateDailyNetIncome()
    {
        return(calculateDailyRevenue() - calculateDailyExpenses());
    }

    public int calculateWorth()
    {
        int worth = 0;
        worth += (startUpCost / 2);
        if(ownBuilding)
        {
            worth += 4 * (buildingCost / 5);
        }
        worth += 3 * ((calculateDailyNetIncome() * 365) / 10);
        return worth;
    }
}