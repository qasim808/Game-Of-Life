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
    public String readFromTxtDB() {
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
        return data;
    }


    @Override
    public void saveToTxtDB(String grid) {
        File myFile = new File("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
        if (myFile.canExecute()){
            if (myFile.canWrite()){
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
                    writer.write(grid);
                    writer.close();
                } catch (IOException e) {
                    System.out.println("UNABLE TO WRITE TO FILE.");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getNumberOfSavedStates() {
        int count = 0;
        try {
            File myObj = new File("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                myReader.nextLine();
                count += 1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public String loadSpecificGridFromTxtDb(int savedStateNo) {
        int count = getNumberOfSavedStates();
        String data = "";
        if (savedStateNo <= count){
            try {
                File myObj = new File("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\db.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()){
                    count += 1;
                    if (count - savedStateNo == 0){
                        data = myReader.nextLine();
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return data;
        }
        return "";
    }




}
