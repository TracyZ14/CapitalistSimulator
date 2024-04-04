public class Bakery extends Business
{
    public Bakery(String name, int employeeWage, boolean ownBuilding, boolean isHiring)
    {
        super(name, employeeWage, ownBuilding, BusinessInfo.findBakeryRent(), isHiring);
    }
}