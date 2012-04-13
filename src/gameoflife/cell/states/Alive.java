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
public class Alive implements State
{
    @Override
    public void changeNoOfAliveNeighbours(Cell currentCell) 
    {
        int temp = currentCell.getNewNoOfAliveNeighbours()+1;
        currentCell.setNewNoOfAliveNeighbours(temp);
    }

    @Override
    public void stepUp(Cell currentCell) 
    {
        // Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
        // Any live cell with more than three live neighbours dies, as if by overcrowding.
        if(currentCell.getOldNoOfAliveNeighbours()<2||currentCell.getOldNoOfAliveNeighbours()>3)
        {
            currentCell.setState(new Dead());
        }
        // Any live cell with two or three live neighbours lives, unchanged, to the next generation.
    }
}
