package sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.lang.Math;

public class UILayer implements Grid {
    private int windowWidth;
    private int windowHeight;
    private int size;
    private char [][] charGrid;
    private char [][] initialGrid;
    public UILayer(){

    }

    public UILayer(int windowWidth, int windowHeight, int size) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.size = size;
        this.charGrid = new char[windowHeight/size][windowWidth/size];
        this.initialGrid = new char [windowHeight/size][windowWidth/size];
        initiliazeCharGrid();
    }

    public void initiliazeCharGrid(){
        for (int i=0; i<windowHeight/size; i++){
            for (int f=0; f<windowWidth/size; f++){
                charGrid[i][f] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
    @Override
    public void setCoordinates(double x, double y) {
        this.charGrid[(int)y][(int)x] = 'S';
        System.out.println("X: " + (int)x + " Y: " +(int)y);
    }
    @Override
    public void unsetCoordinates(double x, double y){
        this.charGrid[(int)y][(int)x] = ' ';
        System.out.println("X: " + (int)x + " Y: " +(int)y);
    }
    @Override
    public char[][] getCompleteGrid(){
        return this.charGrid;
    }
    @Override
    public void setCompleteGrid(char[][] grid){
        this.charGrid = grid;
    }
    public void setInitialGridByLoop(){
        for (int i=0; i<windowWidth; i++){
            for (int f=0; f<windowHeight; i++){
                this.initialGrid[i][f] = this.charGrid[i][f];
            }
        }
    }
    public char getCellAt(int x, int y){
        return this.charGrid[x][y];
    }

    public char[][] getCharGrid() {
        return charGrid;
    }

    public char[][] getInitialGrid() {
        return initialGrid;
    }

    public void setCharGrid(char[][] charGrid) {
        this.charGrid = charGrid;
    }

    public void setInitialGrid(char[][] initialGrid) {
        this.initialGrid = initialGrid;
    }
    public GridPane getGridPane(){
        GridPane gPane = new GridPane();
        return gPane;
    }
    public TilePane getMenu(){
        return new TilePane();
    }
    public void display(){

    }
}
