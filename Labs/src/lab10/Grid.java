package lab10;

/**
 * A grid object represents the cell grid of a life simulation.
 * The grid is a 2D array of cells.  The grid object keeps track
 * of the state of each cell (alive, dead), and allows the user
 * to make one step in the life simulation.
 *
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 *
 * @author Peter Jensen and (your name here)
 * @version (date here)
 */
public class Grid
{
    // Instance variables here.
    private int[][] grid;
    private final int dead = 0;
    private final int alive = 1;
    /**
     * Constructor - creates an empty grid of the
     * specified dimensions.
     *
     * @param width The width of the new grid
     * @param height The height of the new grid
     */
    public Grid (int width, int height)
    {
        this.grid = new int[width][height];
    }

    /**
     * Returns true if the specified cell in the grid
     * is alive, false otherwise.  If the coordinates
     * are illegal (outside the grid), false is returned.
     *
     * @param row  a row number
     * @param column a column number
     * @return true iff that cell is alive
     */
    public boolean isAlive (int row, int column)
    {
        try {
            if(grid[row][column] == alive) {
                return true;
            }
            else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    /**
     * Returns the width of the grid.
     *
     * @return the width of this grid
     */
    public int getWidth ()
    {
        return grid.length;
    }

    /**
     * Returns the height of the grid.
     *
     * @return the height of this grid
     */
    public int getHeight ()
    {
        return grid[0].length;
    }

    /**
     * Sets the state of the specified cell in the
     * grid.
     *
     * @param row a row number
     * @param column a column number
     * @param isAlive true if the grid cell should be alive
     */
    public void setCellState(int row, int column, boolean isAlive)
    {
        if(isAlive){
            grid[row][column] = alive;
        } else{
            grid[row][column] = dead;
        }
    }


    /**
     * Clears the grid, all cells marked as dead.
     */
    public void clear ()
    {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = dead;
            }
        }
    }

    /**
     * Performs one 'life' step using the standard rules
     * of life:
     *
     * Any live cell with fewer than two neighbors dies, as if by loneliness.
     * Any live cell with more than three neighbors dies, as if by overcrowding.
     * Any live cell with two or three neighbors lives, unchanged, to the next generation.
     * Any dead cell with exactly three neighbors comes to life.
     *
     * Care must be taken to make sure the next generation is kept separate from the
     * current generation.
     */
    public void stepOneGeneration ()
    {
        // Create a spare grid
        int[][] duplicateGrid = new int[grid.length][grid[0].length];
        // Loop through each grid location
        for (int index = 0; index < grid.length; index++) {
            for (int loopIndex = 0; loopIndex < grid[0].length; loopIndex++) {
                // Count the neighbors of the current location (using the helper function 8 times)
                int neighbor = 0;
                if(isAlive(index-1,loopIndex-1)){
                    neighbor++;
                }
                if(isAlive(index-1,loopIndex)){
                    neighbor++;
                }
                if(isAlive(index-1,loopIndex+1)){
                    neighbor++;
                }
                if(isAlive(index,loopIndex-1)){
                    neighbor++;
                }
                if(isAlive(index,loopIndex+1)){
                    neighbor++;
                }
                if(isAlive(index+1,loopIndex-1)){
                    neighbor++;
                }
                if(isAlive(index+1,loopIndex)){
                    neighbor++;
                }
                if(isAlive(index+1,loopIndex+1)){
                    neighbor++;
                }
                // Set the alive/dead state in the spare grid according to the rules
                if (grid[index][loopIndex] == alive && (neighbor == 2 || neighbor == 3)) {
                    duplicateGrid[index][loopIndex] = alive;
                }
                else if (grid[index][loopIndex] == dead && neighbor == 3){
                    duplicateGrid[index][loopIndex] = alive;
                }
                else {
                    duplicateGrid[index][loopIndex] = dead;
                }
            }
        }
        // Store the spare grid in the grid field (replacing the old grid with the new one)
        grid = duplicateGrid;
    }
}