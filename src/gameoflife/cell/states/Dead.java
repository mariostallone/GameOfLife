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
public class Dead implements State
{

    @Override
    public void changeNoOfAliveNeighbours(Cell currentCell) 
    {
        int temp = currentCell.getNoOfAliveNeighbours();
        currentCell.setNoOfAliveNeighbours(--temp);
    }
    
}
