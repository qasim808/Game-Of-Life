package sample.BL;
//bl
public interface IController {
    public char [][] BtnClick_handleStart(char [][] grid);
    public char[][] BtnClick_handleNext(char[][]grid);
    public int getNumberOfSavedStatesInTxtDB();
    public char[][] get2dArr(int savedStateNo, int rows, int cols);
    public char[][] get2dArr(int rows, int cols);
    public void saveToTxt(char[][] grid);
    public void saveToSql(char[][] grid);
    public char[][] get2dArrFromSql(int rows, int cols);
}
