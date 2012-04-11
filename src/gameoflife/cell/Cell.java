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
    private Integer newNoOfAliveNeighbours; //Holds the count of alive neighbours
    private Integer oldNoOfAliveNeighbours;
    public Cell() 
    {
        this.state = new Dead();
        this.newNoOfAliveNeighbours = 0;
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
    
    public void stepUp()
    {
        this.setOldNoOfAliveNeighbours(newNoOfAliveNeighbours);
        this.getState().stepUp(this);
    }
    // Getters and Setters
    public Integer getNewNoOfAliveNeighbours() {
        return newNoOfAliveNeighbours;
    }
    public void setNewNoOfAliveNeighbours(Integer noOfAliveNeighbours) {
        this.newNoOfAliveNeighbours = noOfAliveNeighbours;
    }
        public Integer getOldNoOfAliveNeighbours() {
        return oldNoOfAliveNeighbours;
    }

    public void setOldNoOfAliveNeighbours(Integer oldNoOfAliveNeighbours) {
        this.oldNoOfAliveNeighbours = oldNoOfAliveNeighbours;
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
