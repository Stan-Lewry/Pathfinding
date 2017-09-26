import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsPanel extends JPanel{

    private Grid grid;
    private final int panelWidth = 400;
    private final int panelHeight = 400;

    public GraphicsPanel(){

        grid = new Grid(20);

      setPreferredSize(new Dimension(panelWidth, panelHeight));

      addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
              /*
              System.out.println("Mouse Clicked on window :D!");
              System.out.println("\n");
              */
              getClickedCell(e);
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
        for(int y = 0; y < grid.getCurrentGridSize(); y ++){
            for(int x = 0; x < grid.getCurrentGridSize(); x++){
                int cellWidth = panelWidth / grid.getCurrentGridSize();
                int cellHeight = panelHeight / grid.getCurrentGridSize();
                int cellX = x * cellWidth;
                int cellY = y * cellHeight;
                g.setColor(grid.getGrid()[x][y].getColor());
                g.fillRect(cellX, cellY, cellWidth, cellHeight);
            }
        }
        /*
        g.setColor(Color.CYAN);
        g.fillRect(10,10,40,40);
        */
    }

    public void getClickedCell(MouseEvent e){

        System.out.println("Clicked");

        for(int y = 0; y < grid.getCurrentGridSize(); y++){
            for(int x = 0; x < grid.getCurrentGridSize(); x++){
                if(e.getX() > x * (panelWidth / grid.getCurrentGridSize()) &&
                        e.getX() < (x* (panelWidth / grid.getCurrentGridSize())) + panelWidth / grid.getCurrentGridSize() &&
                        e.getY() > y * (panelWidth / grid.getCurrentGridSize()) &&
                        e.getY() < (y * (panelWidth / grid.getCurrentGridSize())) + panelWidth / grid.getCurrentGridSize()){

                    grid.getGrid()[x][y].setColor(Color.RED);
                    System.out.println(x + "," + y);
                    paint(getGraphics());
                }
            }
        }
    }

}
