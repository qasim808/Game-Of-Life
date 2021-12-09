package sample;

import com.sun.javafx.geom.RectangularShape;
import javafx.animation.Animation;
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

    public TilePane getParentButtons(final Stage primaryStage, final VBox box){
        TilePane tPane = new TilePane();
        Button btn = new Button("Start New Game");
        btn.setPrefSize(200, 100);
        tPane.setAlignment(Pos.BASELINE_CENTER);
        btn.setStyle("-fx-background-color: #1b2670;");
        btn.setTextFill(Paint.valueOf("white"));
        final Button finalBtn = btn;
        btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setScene(new Scene(box, 560, 700));
            }
        }));
        btn = finalBtn;
        tPane.getChildren().add(btn);
        return tPane;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
          primaryStage.setTitle("Conway Game");
       // StackPane menuPane = new StackPane();
       // SubScene lowerMenu = new SubScene(menuPane, 560, 200);
            UILayer UIWindow = new GUI(560, 560, 15); //coordinates for the block window
            VBox root = new VBox();
            primaryStage.setResizable(false);
            root.getChildren().addAll(UIWindow.getGridPane(), UIWindow.getMenu());
            //above code defines the UI scene...
            VBox parentScene = new VBox();
            parentScene.getChildren().add(getParentButtons(primaryStage, root));
            primaryStage.setScene(new Scene(parentScene, 560, 700)); //700 to include the buttons
            primaryStage.show();
       /*     CUI CUI = new CUI(560, 560, 15);
            CUI.display();*/
    }
    public static void main(String[] args) {
        launch(args);
    }
}

