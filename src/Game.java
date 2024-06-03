import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Game extends JFrame
{
    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(new JScrollPane(new InitialPage(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        this.setVisible(true);
    }

    public Game(String display, Player player)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(new JScrollPane(new Screen(player), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        this.setVisible(true);
    }
}