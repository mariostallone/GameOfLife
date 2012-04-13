
package gameoflife.cell.states;

import gameoflife.cell.Cell;

/**
 *
 * @author mario
 */
public interface State {
    public void changeNoOfAliveNeighbours(Cell currentCell);
    public void stepUp(Cell currentCell);
}
