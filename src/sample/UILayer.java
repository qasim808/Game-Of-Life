package sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class UILayer {
    private int windowWidth;
    private int windowHeight;
    private int size;
    public UILayer(){

    }

    public UILayer(int windowWidth, int windowHeight, int size) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.size = size;
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

    public TilePane getTilePane(){
        TilePane pane  = new TilePane();
        pane.setPrefColumns((this.windowWidth/size));
        pane.setPrefRows(this.windowHeight/size);
        pane.setTileAlignment(Pos.CENTER);
        pane.setHgap(1);
        pane.setVgap(1);
        for (int i=0; i<(this.windowWidth/size); i++) {
            for (int f=0; f<(this.windowHeight/size - 2); f++) {
                final Rectangle rect = new Rectangle(size, size, Paint.valueOf("grey"));
                EventHandler<MouseEvent> eventHand = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        rect.setFill(Paint.valueOf("yellow"));
                    }
                };
                rect.setOnMouseClicked(eventHand);
                pane.getChildren().add(rect);
            }
        }
        return pane;
    }
    public TilePane getMenu(){
        TilePane pane = new TilePane();
        //pane.getChildren().addAll(new Separator(Orientation.VERTICAL), new Separator());
        Button btn = new Button("Start");
        btn.setPrefSize(70, 50);
        pane.setAlignment(Pos.BASELINE_CENTER);
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
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
}
