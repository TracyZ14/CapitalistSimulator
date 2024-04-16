import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game extends JFrame implements Runnable, ActionListener
{
    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        JMenuItem playerInfoPage = new JMenuItem("PLAYER INFO");
        menu.add(playerInfoPage);
        JMenuItem defaultPage = new JMenuItem("LOG OUT");
        menu.add(defaultPage);
        menuBar.add(menu);
        JMenu business = new JMenu("BUSINESS");
        JMenuItem bakery = new JMenuItem("BAKERY");
        business.add(bakery);
        menuBar.add(business);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    public void run()
    {

    }

    public void actionPerformed(ActionEvent e)
    {

    }
}