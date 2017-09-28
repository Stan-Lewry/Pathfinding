import java.awt.*;

enum CellType{
    CELL_FREE,
    CELL_BLOCKED,
    CELL_GUY,
    CELL_GOAL,
    CELL_RANGE,
    CELL_PATH
}

public class Cell {
    private CellType cellType;

    public Cell (CellType cellType){
        this.cellType = cellType;
    }

    public CellType getType(){
        return cellType;
    }

    public void setCellType(CellType cellType){
        this.cellType = cellType;
    }
}
