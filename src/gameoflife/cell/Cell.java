package gameoflife.cell;

import gameoflife.cell.states.Dead;
import gameoflife.cell.states.State;
import java.util.Observable;
import java.util.Observer;

/**
 * A Cell is a single unit of the entire Universe of the GameOfLife
 * @author Mario Stallone
 */
public class Cell  extends Observable implements Observer
{
    private State state; //Specified the state of the Cell - Dead or Alive
    private Integer noOfAliveNeighbours; //Holds the count of alive neighbours
    
    public Cell() 
    {
        this.state = new Dead();
        this.noOfAliveNeighbours = 0;
    }
    
    /**
     * Method to update noOfAliveNeighbours' count based on the notification of a neighbouring cell
     * @param o  - the observable object.
     * @param arg - an argument passed to the notifyObservers method.
     */
    @Override
    public void update(Observable o, Object arg) {
        Cell neighbour = (Cell)o;
        this.changeNoOfAliveNeighbours(neighbour);
    }
    private void changeNoOfAliveNeighbours(Cell neighbour)
    {
        neighbour.getState().changeNoOfAliveNeighbours(this);
    }
    // Getters and Setters
    public Integer getNoOfAliveNeighbours() {
        return noOfAliveNeighbours;
    }
    public void setNoOfAliveNeighbours(Integer noOfAliveNeighbours) {
        this.noOfAliveNeighbours = noOfAliveNeighbours;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        if(this.state.getClass()!=state.getClass())
        {
            this.state = state;
            this.setChanged();
            this.notifyObservers();
        }
    }
}
