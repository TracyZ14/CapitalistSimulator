import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Frame extends JFrame implements Runnable
{
    private ScreenPanel s;

    public Frame(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JMenu menu = new JMenu("Menu");
        JMenuBar menuBar = new JMenuBar();
        JMenuItem playerInfo = new JMenuItem("PLAYER INFO");
        menu.add(playerInfo);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    public void run()
    {
        while(true)
        {
            s.repaint();
        }
    }
}