package sample;

public interface IDBLayerTxt {
    char [][] readFromTxtDB(int rows, int cols);
    void saveToTxtDB(char[][] grid);
}
