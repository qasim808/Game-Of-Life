package sample;


public class Controller implements IController {
    public Controller(){

    }
    @Override
    public int getNumberOfSavedStatesInTxtDB(){
        TxtDBFactory txt = new TxtDBFactory();
        return txt.getNumberOfSavedStates();
    }

    @Override
    public char[][] get2dArr(int savedState, int rows, int cols) {
        TxtDBFactory txt = new TxtDBFactory();
        return parseStringBackTo2d(txt.loadSpecificGridFromTxtDb(savedState), rows, cols);
    }

    @Override
    public char[][] get2dArr(int rows, int cols) {
        TxtDBFactory txt = new TxtDBFactory();
        return parseStringBackTo2d(txt.readFromTxtDB(), rows, cols);
    }

    @Override
    public void saveToTxt(char[][] grid) {
        TxtDBFactory txt = new TxtDBFactory();
        txt.saveToTxtDB(parse2dArrayToString(grid));
    }

    @Override
    public void saveToSql(char[][] grid) {
        SQLDBFactory dbFac= new SQLDBFactory();
    }

    @Override
    public char[][] get2dArrFromSql(int rows, int cols) {
        return new char[0][];
    }

    @Override
    public char [][] BtnClick_handleStart(char [][] grid){
            //handle once the start button is clicked it should
        Controller con = new Controller();
        return con.nextMove(grid);
    }
    @Override
    public char[][] BtnClick_handleNext(char[][]grid){
        Controller con = new Controller();
        return con.nextMove(grid);
    }
    private int getNeighbours(char[][]grid, int x, int y){
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
    private char[][] nextMove(char [][]grid){
        char[][] newGrid = new char[grid.length][grid[0].length];
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
    private void killCells(char[][]grid, char[][] newGrid){
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
    }
    private void copyGrids(char [][] grid1, char[][]grid2){
        for (int i=0; i<grid1.length; i++){
            for (int f=0; f<grid2.length; f++){
                grid2[i][f] = grid1[i][f];
            }
        }
    }
    private char[][] parseStringBackTo2d(String str, int rows, int cols){
        int row = 0, col = 0;
        char [][] arr = new char[rows][cols];
        for (int i=0; i< str.length(); i++){
            if (str.charAt(i) == '|') {
                row++;
                col = 0;
            }
            else {
                arr[row][col++] = str.charAt(i);
            }
        }
        return arr;
    }
    private String parse2dArrayToString(char[][]grid){
        StringBuilder parsed = new StringBuilder();
        for (int i=0; i<grid.length; i++){
            for (int f=0; f<grid.length; f++){
                parsed.append(grid[i][f]);
            }
            parsed.append('|');
        }
        parsed.append('\n');
        return parsed.toString();
    }
}
