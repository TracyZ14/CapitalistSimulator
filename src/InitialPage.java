import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Font;
public class InitialPage extends JPanel
{
    public InitialPage()
    {

    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Courier New", Font.BOLD, 150));
        g.drawString("CapitalistSimulator", 100, 400);
    }
}