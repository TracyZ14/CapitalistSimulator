import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class BusinessInfo extends JPanel implements ActionListener
{
    private Player player;
    private Business business;
    private ArrayList<Business> sameBusinessType;

    public BusinessInfo(Player player, Business business)
    {
        this.player = player;
        this.business = business;
        this.setLayout(new BorderLayout(0, 50));
        JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.CENTER);
        businessType.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessType, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JButton addBusiness = new JButton("BUY NEW " + business.getBusinessType());
        addBusiness.addActionListener(this);
        center.add(addBusiness);
        JButton sellBusiness = new JButton("SELL " + business.getBusinessType());
        sellBusiness.addActionListener(this);
        center.add(sellBusiness);
        ArrayList<Business> businesses = player.getBusinesses();
        this.sameBusinessType = new ArrayList<Business>();
        ArrayList<Business> sameBusinessType = new ArrayList<Business>();
        for(Business b : businesses)
        {
            if(b.getBusinessType().equals(business.getBusinessType()))
            {
                sameBusinessType.add(b);
            }
        }
        JPanel sameBusinessInfo = new JPanel();
        sameBusinessInfo.setLayout(new GridLayout((sameBusinessType.size() + 1), 9));
        sameBusinessInfo.add(new JLabel("NAME", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY EXPENSES", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY REVENUE", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY NET INCOME", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("NUMBER OF EMPLOYEES", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("EMPLOYEE WAGE", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("IS HIRING", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("OWN BUILDING", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY RENT", SwingConstants.LEFT));
        for(Business b : sameBusinessType)
        {
            sameBusinessInfo.add(new JLabel(("" + b.getName()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("$" + b.calculateDailyExpenses()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("$" + b.calculateDailyRevenue()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("$" + b.calculateDailyNetIncome()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("" + b.getEmployees()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("$" + b.getEmployeeWage()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("" + b.getIsHiring()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("" + b.ownBuilding()), SwingConstants.LEFT));
            sameBusinessInfo.add(new JLabel(("$" + b.getBuildingRent()), SwingConstants.LEFT));
        }
        JScrollPane sameBusinessesInfo = new JScrollPane(sameBusinessInfo);
        center.add(sameBusinessesInfo);
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("BUY NEW " + business.getBusinessType()))
        {

        }
        if(command.equals("SELL " + business.getBusinessType()))
        {
            String businessSold = JOptionPane.showInputDialog("Business to sell:");
        }
    }
}