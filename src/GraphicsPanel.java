import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsPanel extends JPanel{
    
    public GraphicsPanel(){
      setPreferredSize(new Dimension(400, 400));

      addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
              System.out.println("Mouse Clicked on window :D!");
              System.out.println("\n");
          }

          @Override
          public void mousePressed(MouseEvent e) {

          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {

          }

          @Override
          public void mouseExited(MouseEvent e) {

          }
      });

    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(10,10,40,40);
    }

}
