import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game extends JFrame implements Runnable, ActionListener
{
    private Screen screen;
    private Menu menu;

    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.screen = new Screen();
        this.add(screen);
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