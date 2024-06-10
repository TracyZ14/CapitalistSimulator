import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
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
        this.setBorder(BorderFactory.createEmptyBorder(75, 200, 75, 200));

        JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.CENTER);
        businessType.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessType, BorderLayout.NORTH);

        this.center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        Font buttonsFont = new Font("Courier New", Font.PLAIN, 20);

        JButton nextDay = new JButton("NEXT DAY");
        nextDay.setFont(buttonsFont);
        nextDay.addActionListener(this);
        center.add(nextDay);

        center.add(Box.createVerticalStrut(25));

        JButton buyBusiness = new JButton("BUY NEW " + business.getBusinessType());
        buyBusiness.setFont(buttonsFont);
        buyBusiness.addActionListener(this);
        center.add(buyBusiness);

        center.add(Box.createVerticalStrut(25));

        JButton sellBusiness = new JButton("SELL " + business.getBusinessType());
        sellBusiness.setFont(buttonsFont);
        sellBusiness.addActionListener(this);
        center.add(sellBusiness);

        center.add(Box.createVerticalStrut(25));

        JButton modifyBusinessInfo = new JButton("CHANGE " + business.getBusinessType() + " SETTINGS");
        modifyBusinessInfo.setFont(buttonsFont);
        modifyBusinessInfo.addActionListener(this);
        center.add(modifyBusinessInfo);

        center.add(Box.createVerticalStrut(25));

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
        center.add(new JScrollPane(sameBusinessInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("NEXT DAY"))
        {
            player.increaseDaysPassed();
        }
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
                        String newName = business.getBusinessType();
                        if(!newBusinessName.getText().equals(""))
                        {
                            newName = newBusinessName.getText();
                        }
                        int newWage = 0;
                        if(!newBusinessWage.getText().equals(""))
                        {
                            String possibleWage = newBusinessWage.getText();
                            boolean isNumber = true;
                            for(int i = 0; (i < possibleWage.length()) && (isNumber); i++)
                            {
                                char character = possibleWage.charAt(i);
                                if(!Character.isDigit(character))
                                {
                                    isNumber = false;
                                }
                            }
                            if(isNumber)
                            {
                                newWage = Integer.parseInt(newBusinessWage.getText());
                            }
                        }
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
                        if(business.getBusinessType().equals("BOOKSTORE"))
                        {
                            newBusiness = new Bookstore(newName, newWage, boughtBuilding, hiringEmployees);
                        }
                        int cost = newBusiness.getStartUpCost();
                        if(boughtBuilding)
                        {
                            cost += newBusiness.getBuildingCost();
                        }
                        int buyBusiness = JOptionPane.showConfirmDialog(null, ("Are you sure you want to buy a new " + business.getBusinessType().toLowerCase() + " for $" + cost + "?"), ("BUY NEW " + business.getBusinessType()), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(buyBusiness == JOptionPane.YES_OPTION)
                        {
                            player.changeMoney(-cost);
                            sameBusinessType.add(newBusiness);
                            player.addBusiness(newBusiness);
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
        if(command.equals("CHANGE " + business.getBusinessType() + " SETTINGS"))
        {
            String[] businesses = new String[sameBusinessType.size()];
            for(int i = 0; i < businesses.length; i++)
            {
                businesses[i] = sameBusinessType.get(i).getName();
            }
            String businessModified = (String) JOptionPane.showInputDialog(null, "Business to modify:", ("MODIFY" + business.getBusinessType()), JOptionPane.QUESTION_MESSAGE, null, businesses, "BUSINESS");
            if(businessModified != null)
            {
                for(int i = 0; i < businesses.length; i++)
                {
                    if(businessModified.equals(businesses[i]))
                    {
                        String newName = (String) JOptionPane.showInputDialog(null, ("Current name: " + businesses[i] + "\nNew name:"), ("MODIFY" + business.getBusinessType()), JOptionPane.QUESTION_MESSAGE, null, null, businesses[i]);
                        String newEmployeeWage = (String) JOptionPane.showInputDialog(null, ("Current employee wage: $" + sameBusinessType.get(i).getEmployeeWage() + "\nNew employee wage:"), ("MODIFY " + business.getBusinessType()), JOptionPane.QUESTION_MESSAGE, null, null, "" + sameBusinessType.get(i).getEmployeeWage());
                        int changeHiringStatus = JOptionPane.showConfirmDialog(null, ("Currently hiring: " + sameBusinessType.get(i).getIsHiring() + "\nAre you sure you want to change the current hiring status?"), ("MODIFY " + business.getBusinessType()), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        int changeOwnBuilding = JOptionPane.showConfirmDialog(null, ("Currently own building: " + sameBusinessType.get(i).ownBuilding() + "\nAre you sure you want to buy / sell the building?"), ("MODIFY " + business.getBusinessType()), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        int saveChanges = JOptionPane.showConfirmDialog(null, "Are you sure you want to save all the changes made?", ("MODIFY " + business.getBusinessType()), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(saveChanges == JOptionPane.YES_OPTION)
                        {
                            sameBusinessType.get(i).setName(newName);
                            boolean isNumber = true;
                            for(int j = 0; (j < newEmployeeWage.length()) && (isNumber); j++)
                            {
                                char character = newEmployeeWage.charAt(j);
                                if(!Character.isDigit(character))
                                {
                                    isNumber = false;
                                }
                            }
                            if(isNumber)
                            {
                                sameBusinessType.get(i).setEmployeeWage(Integer.parseInt(newEmployeeWage));
                            }
                            if(changeHiringStatus == JOptionPane.YES_OPTION)
                            {
                                if(sameBusinessType.get(i).getIsHiring())
                                {
                                    sameBusinessType.get(i).setHiring(false);
                                }
                                if(!sameBusinessType.get(i).getIsHiring())
                                {
                                    sameBusinessType.get(i).setHiring(true);
                                }
                            }
                            if(changeOwnBuilding == JOptionPane.YES_OPTION)
                            {
                                if(sameBusinessType.get(i).ownBuilding())
                                {
                                    player.changeMoney(sameBusinessType.get(i).getBuildingCost());
                                    sameBusinessType.get(i).setOwnBuilding(false);
                                }
                                if(!sameBusinessType.get(i).ownBuilding())
                                {
                                    player.changeMoney(-sameBusinessType.get(i).getBuildingCost());
                                    sameBusinessType.get(i).setOwnBuilding(true);
                                }
                            }
                        }
                    }
                }
            }
        }
        sameBusinessInfo = new BusinessInfoChart(sameBusinessType);
        center.remove(8);
        center.add(new JScrollPane(sameBusinessInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        this.revalidate();
        this.repaint();
    }
}