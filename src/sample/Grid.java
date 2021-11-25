package sample;

public interface Grid {
    public void setCoordinates(int x, int y);
    public void unsetCoordinates(int x, int y);
    public char[][] getCompleteGrid();
    public void setCompleteGrid(char [][] grid);
}

