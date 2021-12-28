package sample.TxtDB;

public interface IDBLayerTxt {
    String readFromTxtDB();
    void saveToTxtDB(String grid);
    int getNumberOfSavedStates();
    String loadSpecificGridFromTxtDb(int savedStateNo);
}
