package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

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
        System.out.println("Hello World");
        Scanner in = new Scanner(System.in);

        int choice;
        System.out.print("* How would you like to launch the game? (1. Console 2. JavaFX): ");
        choice = in.nextInt();

        if (choice == 1)
        {
            System.out.print("Console!");
        }
        else{
            launch(args);
        }
    }
}
