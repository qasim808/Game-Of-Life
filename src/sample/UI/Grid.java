package sample.UI;

public interface Grid {
    public void setCoordinates(double x, double y);
    public void unsetCoordinates(double x, double y);
    public char[][] getCompleteGrid();
    public void setCompleteGrid(char [][] grid);
}

