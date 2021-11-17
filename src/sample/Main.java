package sample;

import com.sun.javafx.geom.RectangularShape;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Collection;
import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Conway Game");
       // StackPane menuPane = new StackPane();
       // SubScene lowerMenu = new SubScene(menuPane, 560, 200);
        VBox root = new VBox();
        root.getChildren().addAll(getTilePane(560, 560), getMenu());
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 560, 700));
        primaryStage.show();

    }
    public TilePane getTilePane(double xCord, double yCord){
        TilePane pane  = new TilePane();
        int size = 15;
        pane.setPrefColumns(((int) xCord/size));
        pane.setPrefRows((int)yCord/size);
        pane.setTileAlignment(Pos.CENTER);
        pane.setHgap(1);
        pane.setVgap(1);
        for (int i=0; i<((int) xCord/size); i++) {
            for (int f=0; f<((int) yCord/size - 2); f++) {
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


    public static void main(String[] args) {

        launch(args);
    }
}
