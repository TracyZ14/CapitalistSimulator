import javax.swing.JFrame;
public class Game extends JFrame
{
    private Screen screen;

    public Game(String display)
    {
        super(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.screen = new Screen(this);
        this.add(screen);
        this.setVisible(true);
    }
}