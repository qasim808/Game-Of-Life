package sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ParentWindow {
    private Stage primaryStage;
    private Scene nextScene;

    public ParentWindow(Stage primaryStage, Scene transition){
        this.primaryStage = primaryStage;
        this.nextScene = transition;
    }
    public TilePane getParentButtons(){
        TilePane tPane = new TilePane();
        Button btn = new Button("Start New Game");
        btn.setPrefSize(200, 100);
        tPane.setAlignment(Pos.BASELINE_CENTER);
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        final Button finalBtn = btn;
        btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setScene(nextScene);
            }
        }));
        btn = finalBtn;
        tPane.getChildren().add(btn);
        return tPane;
    }
}
