public class Bakery extends Business
{
    public Bakery(String name, int employeeWage, boolean ownBuilding, boolean isHiring)
    {
        super(name, employeeWage, ownBuilding, isHiring);
    }

    public int startUpCost()
    {
        return((int) (51500 + (Math.random() * 90000)));
    }

    public int buildingCost()
    {
        return((int) (267000 + (Math.random() * 483000)));
    }

    public int buildingRent()
    {
        return((int) (30 + (Math.random() * 170)));
    }
}