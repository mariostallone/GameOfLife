/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.axis;

import gameoflife.cell.Cell;
import java.util.List;

/**
 *
 * @author mario
 */
public abstract class Axis {
    private List<Cell> cells;
    private Integer noOfAliveCells;
    public Integer getNoOfAliveCells() {
        return noOfAliveCells;
    }

    public void setNoOfAliveCells(Integer noOfAliveCells) {
        this.noOfAliveCells = noOfAliveCells;
    }
    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
