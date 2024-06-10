import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
public class BusinessInfoChart extends JPanel
{
    public BusinessInfoChart(ArrayList<Business> listOfBusinesses)
    {
        this.setLayout(new GridLayout(0, 12, 10, 20));

        Font columnLabelFont = new Font("Courier New", Font.BOLD, 20);

        JLabel nameColumn = new JLabel("NAME", SwingConstants.LEFT);
        nameColumn.setFont(columnLabelFont);
        this.add(nameColumn);

        JLabel dailyExpensesColumn = new JLabel("DAILY EXPENSES", SwingConstants.LEFT);
        dailyExpensesColumn.setFont(columnLabelFont);
        this.add(dailyExpensesColumn);

        JLabel dailyRevenueColumn = new JLabel("DAILY REVENUE", SwingConstants.LEFT);
        dailyRevenueColumn.setFont(columnLabelFont);
        this.add(dailyRevenueColumn);

        JLabel dailyNetIncomeColumn = new JLabel("DAILY NET INCOME", SwingConstants.LEFT);
        dailyNetIncomeColumn.setFont(columnLabelFont);
        this.add(dailyNetIncomeColumn);

        JLabel customersColumn = new JLabel("NUMBER OF CUSTOMERS", SwingConstants.LEFT);
        customersColumn.setFont(columnLabelFont);
        this.add(customersColumn);

        JLabel productCostColumn = new JLabel("PRODUCT COST", SwingConstants.LEFT);
        productCostColumn.setFont(columnLabelFont);
        this.add(productCostColumn);

        JLabel productProceedColumn = new JLabel("PRODUCT PROCEED", SwingConstants.LEFT);
        productProceedColumn.setFont(columnLabelFont);
        this.add(productProceedColumn);

        JLabel numberOfEmployeesColumn = new JLabel("NUMBER OF EMPLOYEES", SwingConstants.LEFT);
        numberOfEmployeesColumn.setFont(columnLabelFont);
        this.add(numberOfEmployeesColumn);

        JLabel employeeWageColumn = new JLabel("EMPLOYEE WAGE", SwingConstants.LEFT);
        employeeWageColumn.setFont(columnLabelFont);
        this.add(employeeWageColumn);

        JLabel hiringStatusColumn = new JLabel("IS HIRING", SwingConstants.LEFT);
        hiringStatusColumn.setFont(columnLabelFont);
        this.add(hiringStatusColumn);

        JLabel ownBuildingColumn = new JLabel("OWN BUILDING", SwingConstants.LEFT);
        ownBuildingColumn.setFont(columnLabelFont);
        this.add(ownBuildingColumn);

        JLabel dailyRentColumn = new JLabel("DAILY RENT", SwingConstants.LEFT);
        dailyRentColumn.setFont(columnLabelFont);
        this.add(dailyRentColumn);

        Font businessInfoFont = new Font("Courier New", Font.PLAIN, 20);

        for(Business b : listOfBusinesses)
        {
            JLabel name = new JLabel(b.getName(), SwingConstants.LEFT);
            name.setFont(businessInfoFont);
            this.add(name);

            JLabel dailyExpenses = new JLabel("$" + b.calculateDailyExpenses(), SwingConstants.LEFT);
            dailyExpenses.setFont(businessInfoFont);
            this.add(dailyExpenses);

            JLabel dailyRevenue = new JLabel("$" + b.calculateDailyRevenue(), SwingConstants.LEFT);
            dailyRevenue.setFont(businessInfoFont);
            this.add(dailyRevenue);

            JLabel dailyNetIncome = new JLabel("$" + b.calculateDailyNetIncome(), SwingConstants.LEFT);
            if(b.calculateDailyNetIncome() < 0)
            {
                dailyNetIncome = new JLabel("-$" + Math.abs(b.calculateDailyNetIncome()), SwingConstants.LEFT);
            }
            dailyNetIncome.setFont(businessInfoFont);
            this.add(dailyNetIncome);

            JLabel customers = new JLabel("" + b.getCustomers(), SwingConstants.LEFT);
            customers.setFont(businessInfoFont);
            this.add(customers);

            JLabel productCost = new JLabel("$" + b.getProductCost(), SwingConstants.LEFT);
            productCost.setFont(businessInfoFont);
            this.add(productCost);

            JLabel productProceed = new JLabel("" + b.getProductProceed(), SwingConstants.LEFT);
            productProceed.setFont(businessInfoFont);
            this.add(productProceed);

            JLabel employees = new JLabel("" + b.getEmployees(), SwingConstants.LEFT);
            employees.setFont(businessInfoFont);
            this.add(employees);

            JLabel employeeWage = new JLabel("$" + b.getEmployeeWage(), SwingConstants.LEFT);
            employeeWage.setFont(businessInfoFont);
            this.add(employeeWage);

            JLabel hiringStatus = new JLabel("" + b.getIsHiring(), SwingConstants.LEFT);
            hiringStatus.setFont(businessInfoFont);
            this.add(hiringStatus);

            JLabel ownBuilding = new JLabel("" + b.ownBuilding(), SwingConstants.LEFT);
            ownBuilding.setFont(businessInfoFont);
            this.add(ownBuilding);

            JLabel buildingRent = new JLabel("$" + b.getBuildingRent(), SwingConstants.LEFT);
            buildingRent.setFont(businessInfoFont);
            this.add(buildingRent);
        }
    }
}