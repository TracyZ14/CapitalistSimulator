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
    private JPanel center;
    private BusinessInfoChart sameBusinessInfo;

    public BusinessInfo(Player player, Business business)
    {
        this.player = player;
        this.business = business;
        this.setLayout(new BorderLayout(0, 50));
        JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.CENTER);
        businessType.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessType, BorderLayout.NORTH);
        this.center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JButton addBusiness = new JButton("BUY NEW " + business.getBusinessType());
        addBusiness.addActionListener(this);
        center.add(addBusiness);
        JButton sellBusiness = new JButton("SELL " + business.getBusinessType());
        sellBusiness.addActionListener(this);
        center.add(sellBusiness);
        ArrayList<Business> businesses = player.getBusinesses();
        this.sameBusinessType = new ArrayList<Business>();
        for(Business b : businesses)
        {
            if(b.getBusinessType().equals(business.getBusinessType()))
            {
                sameBusinessType.add(b);
            }
        }
        this.sameBusinessInfo = new BusinessInfoChart(sameBusinessType);
        JScrollPane sameBusinessesInfo = new JScrollPane(sameBusinessInfo);
        center.add(sameBusinessesInfo);
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("BUY NEW " + business.getBusinessType()))
        {
            JTextField newBusinessName = new JTextField(20);
            JTextField newBusinessWage = new JTextField(20);
            Object[] newBusinessInfo = {("Name of new " + business.getBusinessType().toLowerCase() + ":"), newBusinessName, "Initial employee wage:", newBusinessWage};
            int buyNewBusiness = JOptionPane.showConfirmDialog(null, newBusinessInfo, ("BUY NEW " + business.getBusinessType()), JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(buyNewBusiness == JOptionPane.OK_OPTION)
            {
                int buyBuilding = JOptionPane.showConfirmDialog(null, "Do you want to buy the building for your new business?", ("BUY NEW " + business.getBusinessType()), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(buyBuilding != JOptionPane.CANCEL_OPTION)
                {
                    int hireEmployees = JOptionPane.showConfirmDialog(null, "Do you want to start hiring employees right now?", ("BUY NEW " + business.getBusinessType()), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(hireEmployees != JOptionPane.CANCEL_OPTION)
                    {
                        String newName = newBusinessName.getText();
                        int newWage = Integer.parseInt(newBusinessWage.getText());
                        boolean boughtBuilding = false;
                        if(buyBuilding == JOptionPane.YES_OPTION)
                        {
                            boughtBuilding = true;
                        }
                        boolean hiringEmployees = false;
                        if(hireEmployees == JOptionPane.YES_OPTION)
                        {
                            hiringEmployees = true;
                        }
                        Business newBusiness = new Business();
                        if(business.getBusinessType().equals("BAKERY"))
                        {
                            newBusiness = new Bakery(newName, newWage, boughtBuilding, hiringEmployees);
                        }
                    }
                }
            }
        }
        if(command.equals("SELL " + business.getBusinessType()))
        {
            String[] businesses = new String[sameBusinessType.size()];
            for(int i = 0; i < sameBusinessType.size(); i++)
            {
                businesses[i] = sameBusinessType.get(i).getName();
            }
            String businessSold = (String) JOptionPane.showInputDialog(null, "Business to sell:", ("SELL " + business.getBusinessType()), JOptionPane.QUESTION_MESSAGE, null, businesses, "BUSINESS");
            if(businessSold != null)
            {
                for(int i = 0; i < businesses.length; i++)
                {
                    if(businessSold.equals(businesses[i]))
                    {
                        int sellBusiness = JOptionPane.showConfirmDialog(null, ("Are you sure you want to sell " + businessSold + "?"), ("SELL " + business.getBusinessType()), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(sellBusiness == JOptionPane.YES_OPTION)
                        {
                            for(int j = 0; j < 9; j++)
                            {
                                sameBusinessInfo.remove((i + 1) * 9);
                            }
                            player.changeMoney(sameBusinessType.get(i).calculateWorth());
                            JOptionPane.showMessageDialog(null, ("You have successfully sold " + businessSold + " for $" + sameBusinessType.get(i).calculateWorth() + "!"), ("SELL " + business.getBusinessType()), JOptionPane.INFORMATION_MESSAGE);
                            player.removeBusiness(sameBusinessType.remove(i));
                        }
                        if(sellBusiness == JOptionPane.NO_OPTION)
                        {
                            JOptionPane.showMessageDialog(null, ("You have failed to sell " + businessSold + "."), ("SELL " + business.getBusinessType()), JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
        sameBusinessInfo = new BusinessInfoChart(sameBusinessType);
        sameBusinessInfo.revalidate();
        sameBusinessInfo.repaint();
        this.revalidate();
        this.repaint();
    }
}