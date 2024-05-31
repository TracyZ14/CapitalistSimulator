import javax.swing.JFrame;
public class Game extends JFrame
{
    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(new InitialPage());
        this.setVisible(true);
    }
}