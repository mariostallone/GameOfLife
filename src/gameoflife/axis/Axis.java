package gameoflife.axis;

import gameoflife.cell.Cell;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Axis
{
    private List<Cell> cells;
    public Axis() 
    {
        cells = new ArrayList<Cell>();
    }
    public void stepUp()
    {
        for(Cell cell : cells)
        {
            cell.stepUp();
        }
    }
    // Getters and Setters
    public List<Cell> getCells() {
        return cells;
    }
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
