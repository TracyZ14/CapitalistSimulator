import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game extends JFrame implements Runnable, ActionListener
{
    private Screen screen;
    private InitialPage page;
    private Menu menu;

    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        page = new InitialPage();
        this.add(page);
        menu = new Menu();
        JMenuBar menuBar = menu.getMenuBar();
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