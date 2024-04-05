import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Font;
public class ScreenPanel extends JPanel implements MouseListener
{
    private Rectangle button;

    public ScreenPanel()
    {
        button = new Rectangle(100, 100, 100, 100);
        this.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e)
    {
        Point clicked = e.getPoint();

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {

    }
}