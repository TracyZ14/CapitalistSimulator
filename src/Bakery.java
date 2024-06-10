public class Bakery extends Business
{
    public Bakery()
    {
        super.setBusinessType("BAKERY");
    }

    public Bakery(String name, int employeeWage, boolean ownBuilding, boolean isHiring)
    {
        super(name, employeeWage, ownBuilding, isHiring);
        super.setBusinessType("BAKERY");
        super.setStartUpCost((int) (51500 + (Math.random() * 90000)));
        super.setBuildingCost((int) (267000 + (Math.random() * 483000)));
        super.setBuildingRent((int) (30 + (Math.random() * 170)));
        super.setProductCost((int) (1 + Math.random() * 1));
        super.setProductProceed((int) (4 + Math.random() * 2));
    }
}