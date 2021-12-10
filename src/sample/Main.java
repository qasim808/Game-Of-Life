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

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
class ParentWindow {
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
class loadOptionsScene{
    private Stage primaryStage;
    private Scene nextScene;
    public loadOptionsScene(){
    }
    public loadOptionsScene(Stage primaryStage, Scene transition){
        this.primaryStage = primaryStage;
        this.nextScene = transition;
    }
    public Scene createButtons(final Stage primaryStage){
        VBox box = new VBox();
        CParser parser = new CParser();
        TilePane tPane = new TilePane();
        for (int i=0; i<parser.getNumberOfSavedStatesInTxtDB(); i++){
            Button btn = new Button("Load State " + i+1);
            btn.setPrefSize(200, 100);
            tPane.setAlignment(Pos.BASELINE_CENTER);
            btn.setStyle("-fx-background-color: #1b2670;");
            btn.setTextFill(Paint.valueOf("white"));
            final Button finalBtn = btn;
            final Button finalBtn1 = btn;
            btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    try {
                        String infOStoStore = "";
                        infOStoStore += finalBtn1.getText().replaceFirst("Load State ", "");
                        infOStoStore += '\n';
                        FileWriter writer = new FileWriter("C:\\Users\\qasim\\IdeaProjects\\HelloJFX\\src\\sample\\config.txt");
                        writer.write(infOStoStore);
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("UNABLE TO WRITE TO FILE.");
                        e.printStackTrace();
                    }
                    primaryStage.setScene(new gameWindow().createAndGetGameScene());
                }
            }));
            btn = finalBtn;
            tPane.getChildren().add(btn);
        }
        box.getChildren().add(tPane);
        return new Scene(box, 560, 700);
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
            //loadOptionsScene loadOptionsScene = new loadOptionsScene(primaryStage, gw.createAndGetGameScene());
            ParentWindow newWindow = new ParentWindow(primaryStage, gw.createAndGetGameScene());
            VBox parentScene = new VBox();
            parentScene.getChildren().add(newWindow.getParentButtons());
            primaryStage.setScene(new Scene(parentScene, 560, 700)); //700 to include the buttons
            primaryStage.show();
       /*     CUI CUI = new CUI(560, 560, 15);
            CUI.display();*/
    }
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        System.out.println("=== Welcome to John Conway's Game ===");
        System.out.println("Enter 1 to start Console Game.");
        System.out.println("Enter 2 to start Java FX Game.");
        System.out.println("Enter -99 to Quit.");

        System.out.print("* Choice: ");
        int choice;
        choice = inScanner.nextInt();

        if (choice == -99)
            return;

        while (choice < 1 || choice > 2){
            System.out.println("Wrong Choice Entered. Please Enter Again: ");
            choice = inScanner.nextInt();
        }

        if (choice == 1){
            System.out.println("Hello");
        }
        else {
            launch(args);
        }
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

