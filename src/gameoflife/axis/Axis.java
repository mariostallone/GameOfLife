/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.axis;

import gameoflife.cell.Cell;
import gameoflife.cell.states.Alive;
import gameoflife.cell.states.Dead;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
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
        //System.out.println("Axis : "+newNoOfAliveCells);
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
