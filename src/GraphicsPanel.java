import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsPanel extends JPanel{

    private CellType currentBrush;
    private Grid grid;
    private final int panelWidth = 400;
    private final int panelHeight = 400;

    private Point guyPos;
    private Point goalPos;

    public GraphicsPanel(){

        guyPos = new Point(0, 0);
        goalPos = new Point(0, 0);

        currentBrush = CellType.CELL_FREE;

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
                //g.setColor(grid.getGrid()[x][y].getColor());

                switch(grid.getGrid()[x][y].getType()){
                    case CELL_BLOCKED:
                        g.setColor(Color.BLACK);
                        break;
                    case CELL_FREE:
                        g.setColor(Color.WHITE);
                        break;
                    case CELL_PATH:
                        g.setColor(Color.RED);
                        break;
                    case CELL_RANGE:
                        g.setColor(Color.cyan);
                        break;
                    case CELL_GOAL:
                        g.setColor(Color.GREEN);
                        break;
                    case CELL_GUY:
                        g.setColor(Color.ORANGE);
                        break;
                    default:
                        break;

                }
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

                    if(currentBrush == CellType.CELL_GUY){
                        grid.getGrid()[guyPos.x][guyPos.y].setCellType(CellType.CELL_FREE);
                        guyPos = new Point(x, y);
                    }
                    else if(currentBrush == CellType.CELL_GOAL){
                        grid.getGrid()[goalPos.x][goalPos.y].setCellType(CellType.CELL_FREE);
                        goalPos = new Point(x, y);
                    }

                    grid.getGrid()[x][y].setCellType(currentBrush);
                    System.out.println(x + "," + y);
                    paint(getGraphics());
                }
            }
        }
    }

    public void clearGrid(){
        grid.initGrid();
        paint(getGraphics());
    }

    public void setGridSize(int newSize){
        grid.setCurrentGridSize(newSize);
        paint(getGraphics());
    }

    public Grid getGrid(){
        return grid;
    }

    public int getPanelWidth(){
        return panelWidth;
    }

    public int getPanelHeight(){
        return panelHeight;
    }

    public void setBrush(CellType newBrush){
        currentBrush = newBrush;
    }
}
