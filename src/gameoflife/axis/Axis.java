package gameoflife.axis;

import gameoflife.cell.Cell;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mario
 */
public class Axis
{
    private List<Cell> cells;
    @SuppressWarnings("LeakingThisInConstructor")
    public Axis() 
    {
        cells = new Stack<Cell>();
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
