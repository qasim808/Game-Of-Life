package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class GUI extends UILayer {
    private boolean isFirstClick;
    private GridPane gPane;
    private Timeline timeline;
    public GUI(int windowWidth, int windowHeight, int size){
        super(windowWidth, windowHeight,size);
        this.isFirstClick = false;
        gPane = new GridPane();
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ev) {
                setCharGrid(Controller.BtnClick_handleNext(getCharGrid()));
                getGridPane();
            }
        }));
    }
    @Override
    public GridPane getGridPane(){
        //TilePane pane  = new TilePane();
        //pane.setPrefColumns((this.windowWidth/size));
        //pane.setPrefRows(this.windowHeight/size);
        //pane.setTileAlignment(Pos.CENTER)
        gPane.getChildren().removeAll(gPane.getChildren());
        gPane.setPrefSize(this.getWindowWidth()/this.getSize(), this.getWindowHeight()/this.getSize());
        gPane.setVgap(1);
        gPane.setHgap(1);
        for (int i=0; i<(this.getWindowWidth()/this.getSize()); i++) {
            for (int f=0; f<(this.getWindowHeight()/this.getSize()); f++) {
                final Rectangle rect;
                if (this.getCellAt(i, f) == 'S') {
                    rect = new Rectangle(this.getSize(), this.getSize(), Paint.valueOf("yellow"));
                }
                else{
                    rect = new Rectangle(this.getSize(), this.getSize(), Paint.valueOf("grey"));
                }
                EventHandler<MouseEvent> eventHand = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (rect.getFill() == Paint.valueOf("grey")) {
                            rect.setFill(Paint.valueOf("yellow"));
                            setCoordinates(Math.floor(rect.getLayoutX()/16), Math.floor(rect.getLayoutY()/16));
                        }
                        else{
                            rect.setFill(Paint.valueOf("grey"));
                            unsetCoordinates(Math.floor(rect.getLayoutX()/16), Math.floor(rect.getLayoutY()/16));
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
@Override
    public TilePane getMenu(){
        TilePane pane = new TilePane();
        //pane.getChildren().addAll(new Separator(Orientation.VERTICAL), new Separator());
        Button btn = new Button("Start");
        btn.setPrefSize(70, 50);
        pane.setAlignment(Pos.BASELINE_CENTER);
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        final Button finalBtn = btn;
        btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                if (finalBtn.getText().equals("Start")) {
                    isFirstClick = true;
                    setInitialGrid();
                    finalBtn.setText("Stop");
                    /*TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            setCharGrid(Controller.BtnClick_handleStart(getCharGrid()));
                            getGridPane();
                        }
                    };*/

                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();

                }
                else if (finalBtn.getText().equals("Stop")){
                    timeline.stop();
                    finalBtn.setText("Start");
                }
            }
        }));
        btn = finalBtn;
        pane.getChildren().add(btn);
        btn = new Button("Next");
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("NEXT CLICKED");
                isFirstClick = true;
                setInitialGrid();
                setCharGrid(Controller.BtnClick_handleNext(getCharGrid()));
                getGridPane(); //this function automatically detects and edits changes!!!!!!
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
                isFirstClick = false;
                initiliazeCharGrid();
                getGridPane();
            }
        });
        pane.getChildren().add(btn);
        btn = new Button("Reset");
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //reset to default empty
                setCharGrid(getInitialGrid());
                getGridPane();
            }
        });


        pane.getChildren().add(btn);
        return pane;
    }
    public void setInitialGrid(){
        if (!this.isFirstClick){
            this.setInitialGrid(getCharGrid());
        }
    }
}
