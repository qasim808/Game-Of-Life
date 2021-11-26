package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.lang.Math;

public class UILayer implements Grid {
    private int windowWidth;
    private int windowHeight;
    private int size;
    private char [][] charGrid;
    public UILayer(){

    }

    public UILayer(int windowWidth, int windowHeight, int size) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.size = size;
        this.charGrid = new char[windowHeight][windowWidth];
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

    public GridPane getTilePane(){
        TilePane pane  = new TilePane();
        GridPane gPane = new GridPane();
        //pane.setPrefColumns((this.windowWidth/size));
        //pane.setPrefRows(this.windowHeight/size);
        //pane.setTileAlignment(Pos.CENTER);
        gPane.setPrefSize(this.windowWidth/size, this.windowHeight/size);

        for (int i=0; i<(this.windowWidth/size); i++) {
            for (int f=0; f<(this.windowHeight/size - 2); f++) {
                final Rectangle rect = new Rectangle(size, size, Paint.valueOf("grey"));
                EventHandler<MouseEvent> eventHand = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        rect.setFill(Paint.valueOf("yellow"));
                        System.out.println("X: " +  Math.floor(rect.getLayoutX()/15.2) + "Y: " + Math.floor(rect.getLayoutY()/15.2));

                    }

                };

                rect.setOnMouseClicked(eventHand);
                gPane.add(rect, f, i);
                //pane.getChildren().add(rect);
            }
        }
        return gPane;
    }
    public TilePane getMenu(){
        TilePane pane = new TilePane();
        //pane.getChildren().addAll(new Separator(Orientation.VERTICAL), new Separator());
        Button btn = new Button("Start");
        btn.setPrefSize(70, 50);
        pane.setAlignment(Pos.BASELINE_CENTER);
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                Controller.BtnClick_handleStart(charGrid);
            }
        }));
        pane.getChildren().add(btn);
        btn = new Button("Next");
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        pane.getChildren().add(btn);
        btn = new Button("Reset");
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        pane.getChildren().add(btn);
        return pane;
    }
    @Override
    public void setCoordinates(int x, int y) {
        this.charGrid[x][y] = 'S';
    }
    @Override
    public void unsetCoordinates(int x, int y){
        this.charGrid[x][y] = ' ';
    }
    @Override
    public char[][] getCompleteGrid(){
        return this.charGrid;
    }
    @Override
    public void setCompleteGrid(char[][] grid){
        this.charGrid = grid;
    }
}
