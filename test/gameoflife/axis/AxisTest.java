/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.axis;

import gameoflife.cell.states.Dead;
import gameoflife.cell.Cell;
import gameoflife.cell.states.Alive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mario
 */
public class AxisTest {
    Axis axis;
    public AxisTest() {
    }

    @Before
    public void setUp() 
    {
        axis = new Axis();
        for(int i=0;i<3;i++)
        {
            Cell cell = new Cell();
            axis.getCells().add(cell);        
        }
        axis.setObserver();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Axis.
     */
    @Test
    public void testInitialState() 
    {
        System.out.println("testInitialState"); 
        assertEquals(Integer.valueOf(0),axis.getNewNoOfAliveCells());  
    }
    @Test
    public void testAfterSettingOneCellAsAlive() 
    {
        System.out.println("testAfterSettingOneCellAsAlive");
        axis.getCells().get(0).setState(new Alive());
        assertEquals(Integer.valueOf(1),axis.getNewNoOfAliveCells()); 
    }
    @Test
    public void testAfterSettingAliveCellAsDead() 
    {
        System.out.println("testAfterSettingOneCellAsAlive");
        axis.getCells().get(0).setState(new Dead());
        assertEquals(Integer.valueOf(0),axis.getNewNoOfAliveCells()); 
    }
}
