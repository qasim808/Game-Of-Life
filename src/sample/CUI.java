package sample;

import java.util.Scanner;

public class CUI extends UILayer{
    public CUI(int windowWidth, int windowHeight, int size){
        super(windowWidth, windowHeight, size);
    }

    private void drawGrid(){
        char [][] grid = super.getCharGrid();
        for (int i = 0; i < getWindowHeight() / getSize(); i++){
            for (int j = 0; j < getWindowWidth() / getSize(); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void display(){
        int xInput, yInput;
        boolean gameActive = true;
        Scanner inScanner = new Scanner(System.in);

        System.out.println("== CLI Instructions ==");
        System.out.println("1. Enter all values inside of the max bounds.");
        System.out.println("2. Enter -99 to Quit.");

        while (gameActive){
            drawGrid();

            System.out.print("x: ");
            xInput = inScanner.nextInt();
            System.out.print("Y: ");
            yInput = inScanner.nextInt();


            if (yInput == -99 || xInput == -99){
                gameActive = false;
            }

            while (xInput < 0 || xInput >= getWindowWidth() / getSize() || yInput < 0 || yInput >= getWindowHeight() / getSize()){
                System.out.println("* (Error) Please enter again.");
                System.out.print("x: ");
                xInput = inScanner.nextInt();
                System.out.print("Y: ");
                yInput = inScanner.nextInt();
            }
        }
    }
}
