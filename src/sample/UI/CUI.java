package sample.UI;

import sample.BL.CParser;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import sample.UI.UILayer;

import java.util.Scanner;

public class CUI extends UILayer {
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
    public void display(){
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

            if (super.getCharGrid()[xInput][yInput] == ' ')
                setCoordinates(xInput, yInput);
            else
                unsetCoordinates(xInput, yInput);
            drawGrid();
            System.out.println("ENTER 'S' TO START LOOP\n 'N' FOR NEXT MOVE\n 'D' TO SAVE IN TXT DB'\n F TO LOAD FROM TXTDB");
            System.out.println("ENTER G to SAVE IN SQL\nENTER H to GET FROM SQL");
            System.out.println("ENTER C to continue marking");
            String input = "";
            input = inScanner.next();
            if (input.equals("S")){
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ev) {
                        CParser cp = new CParser();
                        setCharGrid(cp.BtnClick_handleNext(getCharGrid()));
                        drawGrid();
                    }
                }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
            else if (input.equals("N")){
                CParser cp = new CParser();
                setCharGrid(cp.BtnClick_handleNext(getCharGrid()));
                drawGrid();
            }
            else if (input.equals("D")){
                CParser cp = new CParser();
                cp.saveToTxt(getCharGrid());
            }
            else if (input.equals("F")){
                CParser cp = new CParser();
                setCharGrid(cp.get2dArr(this.getWindowWidth()/getSize(), this.getWindowHeight()/getSize()));
            }
            else if (input.equals("G")){
                CParser cp = new CParser();
                cp.saveToSql(getCharGrid());
            }
            else if (input.equals("H")){
                CParser cp = new CParser();
                setCharGrid(cp.get2dArrFromSql(this.getWindowWidth()/getSize(), this.getWindowHeight()/getSize()));
            }

        }
    }
}
