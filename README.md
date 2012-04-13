Conway's Game of Life
---------------------
Conway's Game of Life, also known as the Game of Life or simply Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970. It is the best-known example of a cellular automaton.
The "game" is actually a zero-player game, meaning that its evolution is determined by its initial state, needing no input from human players. One interacts with the Game of Life by creating an initial configuration and observing how it evolves

Rules
-----
The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

* 1. Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
* 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
* 3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.
* 4. Any dead cell with exactly three live neighbours cells will come to life.

The initial pattern constitutes the 'seed' of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick. (In other words, each generation is a pure function of the one before.) The rules continue to be applied repeatedly to create further generations.

Design
------
The Structure of the Solution is Divided like this.

Cell (Alive or Dead)
Axis -> groups of Cells (Rows or Columns)
Grid -> combination of 2 Axis

A Cell implements a State, either Dead or Alive. Based on its state various calculations are performed. 
A Cell is responsible for its own life. It keeps a tab of all its neighbours via Observers and accordingly modifies its noOfAliveNeighbours property which is then used to decide the fate of the cell through the next generation.

An Axis merely holds a collection of Cells.

The Grid holds as many Axes as necessary, in our case primarily 2.
The Grid instantiates an empty playing field based on the input recieved. Cells are made to observe their neighbours so that they can keep track of their own life and death based on their neighbours. A stepUp operation advances the game to the Next Stage.

Unit Tests
----------
Unit Tests have been written for the two main functional units - Cell and Grid.
These can be run from the command line via ant.

ant test -> will run the junit tests.

ant run -> will run the Project