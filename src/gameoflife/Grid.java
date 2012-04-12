/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import gameoflife.axis.Axis;
import gameoflife.cell.Cell;
import gameoflife.cell.states.Alive;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mario
 */
public class Grid {
    private List<Axis> grid;
    public void instantiateEmptyGrid(String[] input)
    {
        grid =  new Stack<Axis>();
        for(int x=0;x<=input.length+1;x++)
        {
            Axis axis = new Axis();
            List<Cell> cellList = new Stack<Cell>();
            axis.setCells(cellList);
            for(int y=0;y<=input[0].length()+1;y++)
            {
                cellList.add(new Cell());
            }
            grid.add(axis);
        }
    }
    public void addObservers()
    {
        for(int x=0;x<grid.size();x++)
        {
            for(int y=0;y<grid.get(x).getCells().size();y++)
            {
                Cell cell = grid.get(x).getCells().get(y);
                iterateObservers(cell, x, y);
            }
        }
    }
    private void iterateObservers(Cell cell,int x, int y)
    {
        int startX = ((x-1)<0) ? 0 : x-1;
        int endX = ((x+1)>=grid.get(x).getCells().size()) ? grid.get(x).getCells().size()-1:x+1;
        int startY = ((y-1)<0) ? 0 : y-1;
        int endY = ((y+1)>=grid.size()) ? grid.size()-1:y+1;
        int count = 0;
       // System.out.println("Iteration  : "+x+","+y);
       // System.out.println("From : "+startX+","+startY+"To : "+endX+","+endY);
        for(int i=startX;i<=endX;i++)
        {
            for(int j=startY;j<=endY;j++)
            {
                cell.addObserver(grid.get(i).getCells().get(j));count++;
            }
        }
       // System.out.println("Cell : "+cell+"Observers : "+count);
    }
    public void createGrid(String[] input)
    {
        System.out.println("createGrid");
        int x=1,y=1;
        for(String line : input)
        {
            Axis axis = grid.get(x);
            y=1;
            for(char character : line.toCharArray())
            {
                List<Cell> cells = axis.getCells();
                if(character=='X')
                {
                    cells.get(y).setState(new Alive());
                }
                System.out.print(character);
                y++;
            }
            System.out.println();
            grid.add(axis);
            x++;
        }
        System.out.println("END");
    }
    public void formGrid(String[] input)
    {   
        grid =  new Stack<Axis>();
        for(String line : input)
        {
            Axis axis = new Axis();
            List<Cell> cellList = new Stack<Cell>();
            axis.setCells(cellList);
            for(char character : line.toCharArray())
            {
                Cell cell = new Cell();
                if(character=='X')
                {
                    cell.setState(new Alive());
                }
                cellList.add(cell);
            }
            grid.add(axis);
        }
    }
    public String[] gridPrinter()
    {
        List<String> stringArray = new ArrayList<String>();
        for(Axis axis : grid)
        {
            StringBuilder element = new StringBuilder();
            for(Cell cell : axis.getCells())
            {
                if(cell.getState().getClass()==Alive.class)
                {
                    element.append('X');
                    continue;
                }
                element.append('-');
            }
            stringArray.add(element.toString());
            System.out.println(element);
        }
        return stringArray.toArray(new String[0]);
    }
    public List<Axis> getGrid() {
        return grid;
    }

    public void setGrid(List<Axis> grid) {
        this.grid = grid;
    }
}
