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
    private GridPane gPane;
    public UILayer(){

    }

    public UILayer(int windowWidth, int windowHeight, int size) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.size = size;
        this.charGrid = new char[windowHeight/size][windowWidth/size];
        gPane = new GridPane();
        initiliazeCharGrid();
    }

    public void initiliazeCharGrid(){
        for (int i=0; i<windowHeight/size; i++){
            for (int f=0; f<windowWidth/size; f++){
                charGrid[i][f] = ' ';
            }
        }
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

    public GridPane getGridPane(){
        //TilePane pane  = new TilePane();
        //pane.setPrefColumns((this.windowWidth/size));
        //pane.setPrefRows(this.windowHeight/size);
        //pane.setTileAlignment(Pos.CENTER)
        gPane.getChildren().removeAll(gPane.getChildren());
        gPane.setPrefSize(this.windowWidth/size, this.windowHeight/size);
        gPane.setVgap(1);
        gPane.setHgap(1);
        for (int i=0; i<(this.windowWidth/size); i++) {
            for (int f=0; f<(this.windowHeight/size); f++) {
                final Rectangle rect;
                if (charGrid[i][f] == 'S') {
                    rect = new Rectangle(size, size, Paint.valueOf("yellow"));
                }
                else{
                    rect = new Rectangle(size, size, Paint.valueOf("grey"));
                }
                EventHandler<MouseEvent> eventHand = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (rect.getFill() == Paint.valueOf("grey")) {
                            rect.setFill(Paint.valueOf("yellow"));
                            setCoordinates(Math.floor(rect.getLayoutX() / 15.2), Math.floor(rect.getLayoutY()/15.2));
                        }
                        else{
                            rect.setFill(Paint.valueOf("grey"));
                            unsetCoordinates(Math.floor(rect.getLayoutX() / 15.2), Math.floor(rect.getLayoutY()/15.2));
                        }
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
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("NEXT CLICKED");
                charGrid = Controller.BtnClick_handleNext(charGrid);
                getGridPane();
            }
        });
        pane.getChildren().add(btn);
        btn = new Button("Clear");
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //reset to default empty
                initiliazeCharGrid();
                getGridPane();
            }
        });
        pane.getChildren().add(btn);
        return pane;
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
}
