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
        int temp = currentCell.getNewNoOfAliveNeighbours();
        if(temp>0) currentCell.setNewNoOfAliveNeighbours(--temp);
    }

    @Override
    public void stepUp(Cell currentCell) {
        // Any dead cell with exactly three live neighbours cells will come to life.
        if(currentCell.getOldNoOfAliveNeighbours()==3)
        {
            currentCell.setState(new Alive());
        }
    }
    
}
