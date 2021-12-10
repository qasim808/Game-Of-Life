package sample;

public class TxtDBFactory implements IDBLayerTxt{
    private TxtDBLayerTxt txtDbj;
    public TxtDBFactory(){
        txtDbj = new TxtDBLayerTxt();
    }

    @Override
    public char[][] readFromTxtDB(int rows, int cols) {
        return txtDbj.readFromTxtDB(rows, cols);
    }

    @Override
    public void saveToTxtDB(char[][] grid) {
        txtDbj.saveToTxtDB(grid);
    }

    @Override
    public int getNumberOfSavedStates() {
        return txtDbj.getNumberOfSavedStates();
    }

    @Override
    public char[][] loadSpecificGridFromTxtDb(int savedStateNo, int rows, int cols) {
        return txtDbj.loadSpecificGridFromTxtDb(savedStateNo, rows, cols);
    }
}
