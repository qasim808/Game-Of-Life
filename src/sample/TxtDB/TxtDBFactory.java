package sample.TxtDB;

public class TxtDBFactory implements IDBLayerTxt {
    private TxtDBLayerTxt txtDbj;
    public TxtDBFactory(){
        txtDbj = new TxtDBLayerTxt();
    }

    @Override
    public String readFromTxtDB() {
        return txtDbj.readFromTxtDB();
    }

    @Override
    public void saveToTxtDB(String grid) {
        txtDbj.saveToTxtDB(grid);
    }

    @Override
    public int getNumberOfSavedStates() {
        return txtDbj.getNumberOfSavedStates();
    }

    @Override
    public String loadSpecificGridFromTxtDb(int savedStateNo) {
        return txtDbj.loadSpecificGridFromTxtDb(savedStateNo);
    }
}
