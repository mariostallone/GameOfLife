package gameoflife;

import gameoflife.axis.Axis;
import gameoflife.cell.Cell;
import gameoflife.cell.states.Alive;
import gameoflife.cell.states.Dead;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mario
 */
public class Grid {
    private List<Axis> rows;
    private List<Axis> columns;
    public void instantiateEmptyGrid(String[] input)
    {
        rows =  new Stack<Axis>();
        for(int x=0;x<input.length;x++)
        {
            Axis axis = new Axis();
            List<Cell> row = new Stack<Cell>();
            axis.setCells(row);
            for(int y=0;y<input[0].length();y++)
            {
                row.add(new Cell());
            }
            axis.setObserver();
            rows.add(axis);
        }
        System.out.println("Rows : "+rows.size()+"Columns : "+rows.get(0).getCells().size());
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
                //iterateObservers(cell, x, y);
            }
        }
    }
    private void iterateObservers(Cell cell,int x, int y)
    {
        int startX = x-1; if(startX<0) startX=0;
        int endX = x+1; if(endX>=rows.get(x).getCells().size()) endX = rows.get(x).getCells().size()-1;
        int startY = y-1; if(startY<0) startY = 0;
        int endY = y+1; if(endY>=rows.size()) endY = rows.size()-1;
        /*int startX = ((x-1)<0) ? 0 : x-1;
        int endX = ((x+1)>=rows.get(x).getCells().size()) ? 
                rows.get(x).getCells().size()-1:x+1;
        int startY = ((y-1)<0) ? 0 : y-1;
        int endY = ((y+1)>=rows.size()) ? rows.size()-1:y+1;*/
        int count = 0;
        //System.out.println("Iteration  : "+x+","+y);
        //System.out.println("From : "+startX+","+startY+"To : "+endX+","+endY);
        for(int i=startY;i<=endY;i++)
        {
            for(int j=startX;j<=endX;j++)
            {
                System.out.println("("+i+","+j+")"+"Row : "+rows.get(i).getCells().size());
                Cell neighbour = rows.get(i).getCells().get(j);
                if(!cell.equals(neighbour))
                neighbour.addObserver(cell);count++;
            }
        }
        //System.out.print("Cell : "+cell+"Observers : "+count+"State : ");
        //if(cell.getState().getClass()==Alive.class) System.out.print("Alive");
        //else System.out.print("Dead");
        //System.out.println();
    }
    public void createGrid(String[] input)
    {
        System.out.println("createGrid");
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
                System.out.print(character);
                y++;
            }
            System.out.println();
            x++;
        }
        System.out.println("END");
    }
    public void setCellInfo()
    {
        for(Axis axis : rows)
        {
            for(Cell cell: axis.getCells())
            {
                System.out.println("Cell : "+cell+" Alive : "+cell.getNewNoOfAliveNeighbours());
                cell.setOldNoOfAliveNeighbours(cell.getNewNoOfAliveNeighbours());
            }
        }
    }
    public void stepUp()
    {
        int flag=0;
        for(Axis axis : rows)
        {
            if(axis.getNewNoOfAliveCells()>3)
            {
                for(Cell cell : axis.getCells())
                {
                    if(cell.getState().getClass()==Alive.class) {
                        flag++;
                        continue;
                    }
                    flag=0;
                }
            }
            axis.stepUp();
        }
    }
    public String[] printGrid()
    {
        List<String> stringArray = new ArrayList<String>();
        for(Axis axis : rows)
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
    public List<Axis> getRows() {
        return rows;
    }

    public void setRows(List<Axis> rows) {
        this.rows = rows;
    }
    
    public List<Axis> getColumns() {
        return columns;
    }

    public void setColumns(List<Axis> columns) {
        this.columns = columns;
    }
}
