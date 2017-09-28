import java.awt.*;

public class Grid {

    private final int maxCells;
    private int currentGridSize;

    private Cell[][] grid;

    public Grid(int currentGridSize){
        maxCells = 100;
        grid = new Cell[maxCells][maxCells];
        this.currentGridSize = currentGridSize;
        initGrid();
    }

    public void initGrid(){
        for(int y = 0; y < maxCells; y++ ){
            for(int x = 0; x < maxCells; x++){
                grid[x][y] = new Cell(Color.CYAN);
            }
        }
    }

    public Cell[][] getGrid(){
        return grid;
    }

    public int getCurrentGridSize(){
        return currentGridSize;
    }

    public void setCurrentGridSize(int currentGridSize){
        this.currentGridSize = currentGridSize;
    }

    public int getMaxCells(){
        return maxCells;
    }
}
