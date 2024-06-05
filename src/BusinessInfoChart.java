import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
public class BusinessInfoChart extends JPanel
{
    private ArrayList<Business> listOfBusinesses;

    public BusinessInfoChart(ArrayList<Business> listOfBusinesses)
    {
        this.listOfBusinesses = listOfBusinesses;
        this.setLayout(new GridLayout(0, 9, 15, 20));
        this.add(new JLabel("NAME", SwingConstants.LEFT));
        this.add(new JLabel("DAILY EXPENSES", SwingConstants.LEFT));
        this.add(new JLabel("DAILY REVENUE", SwingConstants.LEFT));
        this.add(new JLabel("DAILY NET INCOME", SwingConstants.LEFT));
        this.add(new JLabel("NUMBER OF EMPLOYEES", SwingConstants.LEFT));
        this.add(new JLabel("EMPLOYEE WAGE", SwingConstants.LEFT));
        this.add(new JLabel("IS HIRING", SwingConstants.LEFT));
        this.add(new JLabel("OWN BUILDING", SwingConstants.LEFT));
        this.add(new JLabel("DAILY RENT", SwingConstants.LEFT));
        for(Business b : listOfBusinesses)
        {
            this.add(new JLabel((b.getName()), SwingConstants.LEFT));
            this.add(new JLabel(("$" + b.calculateDailyExpenses()), SwingConstants.LEFT));
            this.add(new JLabel(("$" + b.calculateDailyRevenue()), SwingConstants.LEFT));
            this.add(new JLabel(("$" + b.calculateDailyNetIncome()), SwingConstants.LEFT));
            this.add(new JLabel(("" + b.getEmployees()), SwingConstants.LEFT));
            this.add(new JLabel(("$" + b.getEmployeeWage()), SwingConstants.LEFT));
            this.add(new JLabel(("" + b.getIsHiring()), SwingConstants.LEFT));
            this.add(new JLabel(("" + b.ownBuilding()), SwingConstants.LEFT));
            this.add(new JLabel(("$" + b.getBuildingRent()), SwingConstants.LEFT));
        }
    }
}