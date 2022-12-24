import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Parent rootTwo = FXMLLoader.load(getClass().getResource("playScene.fxml"));


        Scene mainScene = new Scene(root);
        Scene playScene = new Scene(rootTwo);


        String css = this.getClass().getResource("styling.css").toExternalForm();
        mainScene.getStylesheets().add(css);
        playScene.getStylesheets().add(css);




        Image icon = new Image("tictactoeLogo.png");

        stage.setScene(mainScene);
        stage.getIcons().add(icon);
        stage.setTitle("TicTacToe");

        stage.show();

        
    }
}
