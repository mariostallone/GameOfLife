package gameoflife;

/**
 *
 * @author mario
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] input = {"XX-","X-X","-X-"};
        Grid grid = new Grid();
        grid.instantiateEmptyGrid(input);
        grid.printGrid();
        System.out.println("Next Generation");
        grid.stepUp();
        grid.printGrid();
    }
}
