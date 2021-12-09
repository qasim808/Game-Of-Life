package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

class gameWindow{
    public gameWindow(){

    }
    public Scene createAndGetGameScene(){
        UILayer UIWindow = new GUI(560, 560, 15); //coordinates for the block window
        VBox root = new VBox();
        root.getChildren().addAll(UIWindow.getGridPane(), UIWindow.getMenu());
        return new Scene(root, 560, 700);
    }
}
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
          primaryStage.setTitle("Conway Game");
       // StackPane menuPane = new StackPane();
       // SubScene lowerMenu = new SubScene(menuPane, 560, 200);
            /*UILayer UIWindow = new GUI(560, 560, 15); //coordinates for the block window
            VBox root = new VBox();
            primaryStage.setResizable(false);
            root.getChildren().addAll(UIWindow.getGridPane(), UIWindow.getMenu());*/
            //above code defines the UI scene...

            gameWindow gw = new gameWindow();
            primaryStage.setResizable(false);
            ParentWindow newWindow = new ParentWindow(primaryStage, gw.createAndGetGameScene());
            VBox parentScene = new VBox();
            parentScene.getChildren().add(newWindow.getParentButtons());
            primaryStage.setScene(new Scene(parentScene, 560, 700)); //700 to include the buttons
            primaryStage.show();
       /*     CUI CUI = new CUI(560, 560, 15);
            CUI.display();*/
    }
    public static void main(String[] args) {
        launch(args);
    }
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
}

