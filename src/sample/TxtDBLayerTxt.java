package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtDBLayerTxt implements IDBLayerTxt {
    private String filePath;
    TxtDBLayerTxt(){

    }
    TxtDBLayerTxt(String path){
        this.filePath = path;
    }
    @Override
    public char[][] readFromTxtDB(int rows, int cols) {
        String data = "";
        try {
            File myObj = new File("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return parseStringBackTo2d(data, rows, cols);
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

    @Override
    public void saveToTxtDB(char[][] grid) {
        File myFile = new File("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
        String parsed = parse2dArrayToString(grid);
        if (myFile.canExecute()){
            if (myFile.canWrite()){
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
                    writer.write(parsed);
                    writer.close();
                } catch (IOException e) {
                    System.out.println("UNABLE TO WRITE TO FILE.");
                    e.printStackTrace();
                }
            }
        }
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
