/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.cell.states;

import gameoflife.cell.Cell;

/**
 *
 * @author mario
 */
public interface State {
    public void changeNoOfAliveNeighbours(Cell currentCell);
}
