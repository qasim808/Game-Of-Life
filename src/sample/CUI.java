package sample;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

public class CUI extends UILayer implements KeyListener {
    public CUI(int windowWidth, int windowHeight, int size){
        super(windowWidth, windowHeight, size);
    }

    private void drawGrid(){
        char [][] grid = super.getCharGrid();
        for (int i = 0; i < getWindowHeight() / getSize(); i++){
            for (int j = 0; j < getWindowWidth() / getSize(); j++){
                System.out.print(super.getCharGrid()[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void display() throws IOException {
        int xInput, yInput;
        boolean gameActive = true;
        Scanner inScanner = new Scanner(System.in);

        System.out.println("== CLI Instructions ==");
        System.out.println("1. Enter all values inside of the max bounds.");
        System.out.println("2. Enter -99 to Quit.");

        while (gameActive){
            drawGrid();

            System.out.print("X: ");
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

            if (super.getCharGrid()[xInput][yInput] == ' '){
                setCoordinates(xInput, yInput);
            }
            else
            {
                unsetCoordinates(xInput, yInput);
            }

            System.out.println("Press Any Key To Continue To Next Iteration....");
            int hitKey = System.in.read();
            System.out.println(hitKey);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
