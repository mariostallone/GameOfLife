/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mario
 */
public class GridTest {
    Grid instance;// = new Grid();
    public GridTest() {
    }
    @Before
    public void setUp() {
        instance = new Grid();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testBlockPattern()
    {
        System.out.println("testBlockPattern");
        String[] input = {"XX","XX"};
        instance.instantiateEmptyGrid(input);
        instance.printGrid();
        System.out.println("Next Generation");
        instance.stepUp();
        instance.printGrid();
        assertArrayEquals(input, instance.gridToStringArray());
    }
    @Test
    public void testBoatPattern()
    {
        System.out.println("testBoatPattern");
        String[] input = {"XX-","X-X","-X-"};
        instance.instantiateEmptyGrid(input);
        instance.printGrid();
        System.out.println("Next Generation");
        instance.stepUp();
        instance.printGrid();
        assertArrayEquals(input, instance.gridToStringArray());
    }
    @Test
    public void testBlinkerPattern()
    {
        System.out.println("testBlinkerPattern");
        String[] input = {"-X-","-X-","-X-"};
        String[] expected = {"---","XXX","---"};
        instance.instantiateEmptyGrid(input);
        instance.printGrid();
        System.out.println("Next Generation");
        instance.stepUp();
        instance.printGrid();
        assertArrayEquals(expected, instance.gridToStringArray());
    }
    @Test
    public void testToadPattern()
    {
        System.out.println("testToadPattern");
        String[] input = {"-XXX","XXX-"};
        String[] expected = {"--X-","X--X","X--X","-X--"};
        instance.instantiateEmptyGrid(input);
        instance.printGrid();
        System.out.println("Next Generation");
        instance.stepUp();
        instance.printGrid();
        assertArrayEquals(expected, instance.gridToStringArray());
    }
    @Test
    public void testVerticalToadPattern()
    {
        System.out.println("testVerticalToadPattern");
        String[] input = {"X-","XX","XX","-X"};
        String[] expected = {"-XX-","X---","---X","-XX-"};
        instance.instantiateEmptyGrid(input);
        instance.printGrid();
        System.out.println("Next Generation");
        instance.stepUp();
        instance.printGrid();
        assertArrayEquals(expected, instance.gridToStringArray());
    }
}
