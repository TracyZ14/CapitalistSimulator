import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Simulator extends JFrame implements ActionListener
{
    private CardLayout pages;
    private int currentPage;

    public Simulator()
    {
        this.currentPage = 1;

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        pages = new CardLayout();

        JPanel screen = new JPanel();
        screen.setLayout(pages);

        JMenuBar menuBar = new JMenuBar();
        JMenu home = new JMenu("HOME");
        menuBar.add(home);
        JMenu playerStatus = new JMenu("PLAYER STATUS");
        menuBar.add(playerStatus);
        JMenu businesses = new JMenu("BUSINESSES");
        JMenuItem bakeries = new JMenuItem("BAKERIES");
        businesses.add(bakeries);
        menuBar.add(businesses);

        JPanel homePage = new JPanel();
        screen.add(homePage, "1");

        JPanel playerStatusPage = new JPanel();
        screen.add(playerStatusPage, "2");

        JPanel bakeriesPage = new JPanel();
        screen.add(bakeriesPage, "3");
    }

    public void actionPerformed(ActionEvent e)
    {

    }
}