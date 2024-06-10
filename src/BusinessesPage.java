import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BusinessesPage extends JPanel implements ActionListener
{
    private Player player;

    public BusinessesPage(Player player)
    {
        this.player = player;

        this.setLayout(new BorderLayout(0, 50));
        this.setBorder(BorderFactory.createEmptyBorder(75, 200, 75, 200));

        JLabel businessesLabel = new JLabel("BUSINESSES", SwingConstants.CENTER);
        businessesLabel.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessesLabel, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JButton nextDay = new JButton("NEXT DAY");
        nextDay.setFont(new Font("Courier New", Font.PLAIN, 20));
        nextDay.addActionListener(this);
        center.add(nextDay);

        center.add(Box.createVerticalStrut(25));

        ArrayList<Business> businesses = player.getBusinesses();

        JPanel businessInfo = new JPanel();
        businessInfo.setLayout(new GridLayout(0, 4, 10, 20));

        Font columnLabelFont = new Font("Courier New", Font.BOLD, 20);

        JLabel businessTypeColumn = new JLabel("BUSINESS TYPE", SwingConstants.LEFT);
        businessTypeColumn.setFont(columnLabelFont);
        businessInfo.add(businessTypeColumn);

        JLabel businessNameColumn = new JLabel("BUSINESS NAME", SwingConstants.LEFT);
        businessNameColumn.setFont(columnLabelFont);
        businessInfo.add(businessNameColumn);

        JLabel dailyNetIncomeColumn = new JLabel("DAILY NET INCOME", SwingConstants.LEFT);
        dailyNetIncomeColumn.setFont(columnLabelFont);
        businessInfo.add(dailyNetIncomeColumn);

        JLabel currentStatusColumn = new JLabel("CURRENT STATUS", SwingConstants.LEFT);
        currentStatusColumn.setFont(columnLabelFont);
        businessInfo.add(currentStatusColumn);

        Font businessInfoFont = new Font("Courier New", Font.PLAIN, 20);

        for(Business business : businesses)
        {
            JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.LEFT);
            businessType.setFont(businessInfoFont);
            businessInfo.add(businessType);

            JLabel businessName = new JLabel(business.getName(), SwingConstants.LEFT);
            businessName.setFont(businessInfoFont);
            businessInfo.add(businessName);

            JLabel dailyNetIncome = new JLabel("$" + business.calculateDailyNetIncome(), SwingConstants.LEFT);
            if(business.calculateDailyNetIncome() < 0)
            {
                dailyNetIncome = new JLabel("-$" + Math.abs(business.calculateDailyNetIncome()), SwingConstants.LEFT);
            }
            dailyNetIncome.setFont(businessInfoFont);
            businessInfo.add(dailyNetIncome);

            JLabel currentStatus = new JLabel("Earning money", SwingConstants.LEFT);
            if(business.calculateDailyNetIncome() == 0)
            {
                currentStatus = new JLabel("Breaking even", SwingConstants.LEFT);
            }
            if(business.calculateDailyNetIncome() < 0)
            {
                currentStatus = new JLabel("Losing money", SwingConstants.LEFT);
            }
            currentStatus.setFont(businessInfoFont);
            businessInfo.add(currentStatus);
        }

        center.add(new JScrollPane(businessInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("NEXT DAY"))
        {
            player.increaseDaysPassed();
        }
        this.revalidate();
        this.repaint();
    }
}