/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mario
 */
public class GridTest {
    Grid instance = new Grid();
    public GridTest() {
    }
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testEmptyGridCreation()
    {
        System.out.println("testEmptyGridCreation");
        String[] input = {"XX-","X-X","-X-"};
        instance.instantiateEmptyGrid(input);
    }
    @Test
    public void testAddingObservers()
    {
        System.out.println("testAddingObservers");
        String[] input = {"XX-","X-X","-X-"};
        instance.instantiateEmptyGrid(input);
        System.out.println("Grid Size : "+instance.getGrid().size());
        instance.addObservers();
        instance.createGrid(input);
        instance.gridPrinter();
    }
}
