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
            UILayer UIWindow = new UILayer(560, 560, 15);
            VBox root = new VBox();
            primaryStage.setResizable(false);
            root.getChildren().addAll(UIWindow.getGridPane(), UIWindow.getMenu());
            primaryStage.setScene(new Scene(root, 560, 700));
            primaryStage.show();
    }
    public static void main(String[] args) {
        int i=0;
        launch(args);
    }
}
