package gameoflife;

import gameoflife.axis.Axis;
import gameoflife.cell.Cell;
import gameoflife.cell.states.Alive;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Grid {
    private List<Axis> rows;
    public void instantiateEmptyGrid(String[] input)
    {
        rows =  new ArrayList<Axis>();
        for(int x=0;x<input.length;x++)
        {
            Axis axis = new Axis();
            List<Cell> row = new ArrayList<Cell>();
            axis.setCells(row);
            for(int y=0;y<input[0].length();y++)
            {
                row.add(new Cell());
            }
            rows.add(axis);
        }
        addObservers();
        createGrid(input);
        setCellInfo();
    }
    public void addObservers()
    {
        for(int x=0;x<rows.size();x++)
        {
            for(int y=0;y<rows.get(x).getCells().size();y++)
            {
                Cell cell = rows.get(x).getCells().get(y);
                int xLimit = rows.size()-1;
                int yLimit = rows.get(x).getCells().size()-1;
                if(x>0&&y>0) cell.addObserver(rows.get(x-1).getCells().get(y-1));
                if(x>0) cell.addObserver(rows.get(x-1).getCells().get(y));
                if(x>0&&y<yLimit) cell.addObserver(rows.get(x-1).getCells().get(y+1));
                if(y>0) cell.addObserver(rows.get(x).getCells().get(y-1));
                if(y<yLimit) cell.addObserver(rows.get(x).getCells().get(y+1));
                if(x<xLimit&&y>0) cell.addObserver(rows.get(x+1).getCells().get(y-1));
                if(x<xLimit) cell.addObserver(rows.get(x+1).getCells().get(y));
                if(x<xLimit&&y<yLimit) cell.addObserver(rows.get(x+1).getCells().get(y+1));
            }
        }
    }
    public void createGrid(String[] input)
    {
        int x=0,y=0;
        for(String line : input)
        {
            Axis axis = rows.get(x);
            y=0;
            for(char character : line.toCharArray())
            {
                List<Cell> cells = axis.getCells();
                if(character=='X')
                {
                    cells.get(y).setState(new Alive());
                }
                y++;
            }
            x++;
        }
    }
    public void setCellInfo()
    {
        for(Axis axis : rows)
        {
            for(Cell cell: axis.getCells())
            {
                cell.setOldNoOfAliveNeighbours(cell.getNewNoOfAliveNeighbours());
            }
        }
    }
    public void stepUp()
    { 
        Axis topRow = instantiateNewRow(0);
        Axis bottomRow = instantiateNewRow(rows.size()-1);
        List<Cell> leftColumn = instantiateNewColumn(0);
        List<Cell> rightColumn = instantiateNewColumn(rows.get(0).getCells().size()-1);
        int index=0;
        for(Axis axis : rows)
        {
            axis.stepUp();
        }
        if(topRow!=null) rows.add(0,topRow);
        if(bottomRow!=null) rows.add(bottomRow);
        if(leftColumn!=null) insertNewColumn(leftColumn, index);
        index = rows.get(0).getCells().size();
        if(rightColumn!=null) insertNewColumn(rightColumn, index);
        String []stringArray = gridToStringArray();
        instantiateEmptyGrid(stringArray);
    }
    public Axis instantiateNewRow(int i)
    {
        int flag=0;int index=-1;
        Axis newRow = null;
        Axis tempRow = rows.get(i);
        {
            for(Cell cell : tempRow.getCells())
            {
                index++;
                if(cell.getState().getClass()==Alive.class)
                {  
                    flag++;
                    if(flag==3) break;
                    continue;
                }
                flag=0;
            }
        }
        index--;
        if(flag==3)
        {
            newRow = new Axis();
            List<Cell> cells = new ArrayList<Cell>();
            newRow.setCells(cells);
            for(int x=0;x<tempRow.getCells().size();x++)
            {
                Cell cell = new Cell();
                cells.add(cell);
                if(x==index)
                {
                    cell.setState(new Alive());
                }
            }
        }
        return newRow;
    }
    public List<Cell> instantiateNewColumn(int i)
    {
        List<Cell> tempColumn = new ArrayList<Cell>();
        List<Cell> newColumn = null;
        for(Axis axis : rows)
        {
            tempColumn.add(axis.getCells().get(i));
        }
        int flag=0;int index=-1;
        for(Cell cell : tempColumn)
        {
            index++;
            if(cell.getState().getClass()==Alive.class)
            {  
                flag++;
                if(flag==3) break;
                continue;
            }
            flag=0;
        }
        index--;
        if(flag==3)
        {
            newColumn = new ArrayList<Cell>();
            for(int x=0;x<tempColumn.size();x++)
            {
                Cell cell = new Cell();
                newColumn.add(cell);
                if(x==index)
                {
                    cell.setState(new Alive());
                }
            }
        }
        return newColumn;
    }
    public void insertNewColumn(List<Cell> column, int index)
    {
        int x=0;
        for(Axis axis : rows)
        {
            axis.getCells().add(index, column.get(x));
            x++;
        }
    }
    public String[] gridToStringArray()
    {
        List<String> stringArray = new ArrayList<String>();
        for(Axis axis : rows)
        { 
            stringArray.add(rowToString(axis));  
        }
        return stringArray.toArray(new String[0]);
    }
    private String rowToString(Axis axis)
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
        return element.toString();
    }
    public void printGrid()
    {
        String[]strArray = gridToStringArray();
        for(String row : strArray)
        {
            System.out.println(row);
        }
    }  
    // Getters and Setters
    public List<Axis> getRows() {
        return rows;
    }

    public void setRows(List<Axis> rows) {
        this.rows = rows;
    }
}
