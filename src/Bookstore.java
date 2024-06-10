public class Bookstore extends Business
{
    public Bookstore()
    {
        super.setBusinessType("BOOKSTORE");
    }

    public Bookstore(String name, int employeeWage, boolean ownBuilding, boolean isHiring)
    {
        super(name, employeeWage, ownBuilding, isHiring);
        super.setBusinessType("BOOKSTORE");
        super.setStartUpCost((int) (120000 + Math.random() * 380000));
        super.setBuildingCost((int) (426000 + Math.random() * 530000));
        super.setBuildingRent((int) (300 + Math.random() * 133));
        super.setProductCost((int) (3 + Math.random() * 2));
        super.setProductProceed((int) (14 + Math.random() * 4));
    }
}