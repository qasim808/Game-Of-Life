package sample;

public class CParser implements IController{
    public CParser(){

    }
    @Override
    public char[][] BtnClick_handleStart(char[][] grid) {
        IController ic = new Controller();
        return ic.BtnClick_handleStart(grid);
    }

    @Override
    public char[][] BtnClick_handleNext(char[][] grid) {
        IController ic = new Controller();
        return ic.BtnClick_handleNext(grid);
    }

    @Override
    public int getNumberOfSavedStatesInTxtDB() {
        IController ic = new Controller();
        return ic.getNumberOfSavedStatesInTxtDB();
    }

    @Override
    public char[][] get2dArr(int savedStateNo, int rows, int cols) {
        IController ic = new Controller();
        return ic.get2dArr(savedStateNo, rows, cols);
    }

    @Override
    public char[][] get2dArr(int rows, int cols) {
        IController ic = new Controller();
        return ic.get2dArr(rows, cols);
    }

    @Override
    public void saveToTxt(char[][] grid) {
        IController ic = new Controller();
        ic.saveToTxt(grid);
    }

    @Override
    public void saveToSql(char[][] grid) {

    }

    @Override
    public char[][] get2dArrFromSql(int rows, int cols) {
        return new char[0][];
    }
}
