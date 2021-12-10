package sample;

public interface IDBLayerTxt {
    char [][] readFromTxtDB(int rows, int cols);
    void saveToTxtDB(char[][] grid);
    int getNumberOfSavedStates();
    char[][] loadSpecificGridFromTxtDb(int savedStateNo, int rows, int cols);
}
