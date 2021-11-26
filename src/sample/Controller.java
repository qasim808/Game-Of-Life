package sample;


public class Controller {
    public Controller(){

    }
    public static void BtnClick_handleStart(char [][] grid){
            //handle once the start button is clicked it should
    }
    public static char[][] BtnClick_handleNext(char[][]grid){
        Controller con = new Controller();
        return con.nextMove(grid);
    }
    public int getNeighbours(char[][]grid, int x, int y){
        int count = 0;
        if (y+1 < grid.length && x+1 < grid[y+1].length && grid[y+1][x+1] == 'S')
            count++;
        if (y+1 < grid.length && grid[y+1][x] == 'S')
            count++;
        if (x+1 < grid[y].length && grid[y][x+1] == 'S')
            count++;
        if (y!=0 && grid[y-1][x] == 'S')
            count++;
        if (y!=0 && x!=0 && grid[y-1][x-1] == 'S')
            count++;
        if (x!=0 && grid[y][x-1] == 'S')
            count++;
        if (y!=0 && x + 1 < grid[y-1].length && grid[y-1][x+1] == 'S')
            count++;
        if (x!=0 && y + 1 < grid.length && grid[y+1][x-1] == 'S')
            count++;
        return count;
    }
    public char[][] nextMove(char [][]grid){
        char[][] newGrid = new char[grid.length][grid[0].length];
        char[][] gridWithDeadCells = new char[grid.length][grid[0].length];
        //initializeGrid(newGrid);
        copyGrids(grid, newGrid);
        for (int i=0; i<grid.length; i++) {
            for (int f = 0; f < grid[i].length; f++) {
                if (getNeighbours(grid, f, i) == 3 && grid[i][f] == ' ') {
                    newGrid[i][f] = 'S';
                }
            }
        }
        killCells(grid, newGrid);

        return newGrid;
    }
    public void initializeGrid(char[][] grid){
        for (int i=0; i < grid.length; i++){
            for (int f=0; f < grid[i].length; f++){
                grid[i][f] = ' ';
            }
        }
    }
    public char[][] killCells(char[][]grid, char[][] newGrid){
        for (int i=0; i<grid.length; i++) {
            for (int f = 0; f < grid[i].length; f++) {
                if (getNeighbours(grid, f, i) < 2 && grid[i][f] == 'S' || getNeighbours(grid, f, i) > 3) {
                    newGrid[i][f] = ' ';
                }
                /*else{
                    if (getNeighbours(grid, f, i) > 2 && grid[i][f] == ' ' || getNeighbours(grid, f, i) >= 2 && grid[i][f] == 'S') {
                        newGrid[i][f] = 'S';
                    }
                }*/
            }
        }
        return newGrid;
    }
    public void copyGrids(char [][] grid1, char[][]grid2){
        for (int i=0; i<grid1.length; i++){
            for (int f=0; f<grid2.length; f++){
                grid2[i][f] = grid1[i][f];
            }
        }
    }
}
