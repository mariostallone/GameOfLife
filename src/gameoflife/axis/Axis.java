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
public class Axis implements Observer
{
    private List<Cell> cells;
    private Integer newNoOfAliveCells;
    private Integer oldNoOfAliveCells;
    @SuppressWarnings("LeakingThisInConstructor")
    public Axis() 
    {
        cells = new Stack<Cell>();
        newNoOfAliveCells = 0;
        oldNoOfAliveCells = 0;
    }
    public void setObserver()
    {
        for(Cell cell : cells)
        {
            cell.addObserver(this);
        } 
    }
    @Override
    public void update(Observable o, Object arg) 
    {
        System.out.print("Observed Object : "+o);
        Cell cell = (Cell)o;
        if(cell.getState().getClass()==Alive.class)
        {
            newNoOfAliveCells++;
        }
        else if(cell.getState().getClass()==Dead.class)
        {
            newNoOfAliveCells--;
        }
    }
    public void stepUp()
    {
        //System.out.println("Axis : "+newNoOfAliveCells);
        this.oldNoOfAliveCells = newNoOfAliveCells;
        for(Cell cell : cells)
        {
            //cell.setOldNoOfAliveNeighbours(cell.getNewNoOfAliveNeighbours());
            cell.stepUp();
        }
    }
    // Getters and Setters
    public Integer getNewNoOfAliveCells() {
        return newNoOfAliveCells;
    }

    public void setNewNoOfAliveCells(Integer noOfAliveCells) {
        this.newNoOfAliveCells = noOfAliveCells;
    }
    
    public Integer getOldNoOfAliveCells() {
        return oldNoOfAliveCells;
    }

    public void setOldNoOfAliveCells(Integer oldNoOfAliveCells) {
        this.oldNoOfAliveCells = oldNoOfAliveCells;
    }
    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
