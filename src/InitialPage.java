import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InitialPage extends JPanel implements ActionListener
{
    private TextField username;
    private TextField initialMoney;
    private JButton beginGame;

    public InitialPage()
    {
        this.setLayout(new BorderLayout(100, 50));
        this.setBorder(BorderFactory.createEmptyBorder(200, 0, 200, 0));
        JLabel gameName = new JLabel("CapitalistSimulator", SwingConstants.CENTER);
        gameName.setFont(new Font("Courier New", Font.BOLD, 100));
        this.add(gameName, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, 500));
        JLabel usernameLabel = new JLabel("USERNAME", SwingConstants.LEFT);
        usernameLabel.setFont(new Font("Courier New", Font.BOLD, 25));
        center.add(usernameLabel);
        this.username = new TextField(20);
        center.add(username);
        center.add(Box.createVerticalStrut(50));
        JLabel initialMoneyLabel = new JLabel("INITIAL MONEY", SwingConstants.LEFT);
        initialMoneyLabel.setFont(new Font("Courier New", Font.BOLD, 25));
        center.add(initialMoneyLabel);
        this.initialMoney = new TextField(20);
        center.add(initialMoney);
        center.add(Box.createVerticalStrut(50));
        this.beginGame = new JButton("START");
        beginGame.setFont(new Font("Courier New", Font.BOLD, 20));
        beginGame.addActionListener(this);
        center.add(beginGame);
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("START"))
        {
            boolean startedGame = true;
            String failureReason = "";
            if(!username.getText().equals(""))
            {
                if(!initialMoney.getText().equals(""))
                {
                    String possibleInitialMoney = initialMoney.getText();
                    for(int i = 0; (i < possibleInitialMoney.length()) && (startedGame); i++)
                    {
                        char character = possibleInitialMoney.charAt(i);
                        if(!Character.isDigit(character))
                        {
                            startedGame = false;
                            failureReason = "The initial amount of money that you set must be a integer number!";
                        }
                    }
                    if(startedGame)
                    {
                        String playerUsername = username.getText();
                        int playerInitialMoney = Integer.parseInt(initialMoney.getText());
                        Player player = new Player(playerUsername, playerInitialMoney);
                        new Game("CapitalistSimulator", player);
                    }
                }
                else
                {
                    int startWithoutMoney = JOptionPane.showConfirmDialog(null, "Are you sure you want to begin without setting the initial amount of money you have?", "BEGIN GAME", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(startWithoutMoney == JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "You will begin the game with a random initial amount of money!");
                        Player player = new Player(username.getText());
                        new Game("CapitalistSimulator", player);
                    }
                    if(startWithoutMoney == JOptionPane.NO_OPTION)
                    {
                        failureReason = "You need to set the initial amount of money you have!";
                    }
                }
            }
            else
            {
                startedGame = false;
                failureReason = "Please input a username!";
            }
            if(!startedGame)
            {
                JOptionPane.showMessageDialog(null, failureReason, "CANNOT BEGIN GAME", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}