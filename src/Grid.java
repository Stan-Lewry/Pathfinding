import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


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
                grid[x][y] = new Cell(CellType.CELL_FREE );
            }
        }
    }

    public void clearPreviousSearch(){
        for(int y = 0; y < maxCells; y++ ){
            for(int x = 0; x < maxCells; x++){
                //grid[x][y] = new Cell(CellType.CELL_FREE );

                if(grid[x][y].getType() == CellType.CELL_PATH || grid[x][y].getType() == CellType.CELL_RANGE){
                    grid[x][y].setCellType(CellType.CELL_FREE);
                }
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

    public void breadthFirstSearch(Point origin, int range){

        ArrayList<Point> frontier = new ArrayList<>();
        ArrayList<Point> newFrontier = new ArrayList<>();
        ArrayList<Point> visited = new ArrayList<>();

        // while we are still within our range
        // put frontier in visited
        // add all adjacent cells to frontier

        frontier.add(origin);
        for(int i = 0 ; i < range ; i++){
            visited.addAll(frontier);
            for(int j = 0; j < frontier.size(); j++){
                Point current = frontier.get(j);
                if(current.x + 1 < maxCells && grid[current.x + 1][current.y].getType() == CellType.CELL_FREE){
                    grid[current.x + 1][current.y].setCellType(CellType.CELL_RANGE);
                    newFrontier.add(new Point(current.x + 1, current.y));
                }
                if(current.x - 1 >= 0 && grid[current.x - 1][current.y].getType() == CellType.CELL_FREE){
                    grid[current.x - 1][current.y].setCellType(CellType.CELL_RANGE);
                    newFrontier.add(new Point(current.x - 1, current.y));
                }
                if(current.y + 1 < maxCells && grid[current.x][current.y + 1].getType() == CellType.CELL_FREE){
                    grid[current.x][current.y + 1].setCellType(CellType.CELL_RANGE);
                    newFrontier.add(new Point(current.x, current.y + 1));
                }
                if(current.y - 1 >= 0 && grid[current.x][current.y - 1].getType() == CellType.CELL_FREE){
                    grid[current.x][current.y - 1].setCellType(CellType.CELL_RANGE);
                    newFrontier.add(new Point(current.x, current.y - 1));
                }
            }
            frontier.clear();
            frontier.addAll(newFrontier);
            newFrontier.clear();
        }
    }
    /*
    public void getPath(Point origin){
        ArrayList<Point> frontier = new ArrayList<>();
        ArrayList<Point> newFrontier = new ArrayList<>();
        ArrayList<Point> visited = new ArrayList<>();

        frontier.add(origin);

        boolean goalFound = false;

        while (!goalFound){
            for(int i = 0; i < frontier.size() ; i++){
                if(grid[frontier.get(i).x][frontier.get(i).y].getType() == CellType.CELL_GOAL){
                    visited.add(frontier.get(i));
                }
            }
        }
    }
    */

}
