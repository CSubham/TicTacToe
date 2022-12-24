import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;

public class mainSceneController implements Initializable{
    @FXML
    private AnchorPane anchorPane;

    
    

    private Stage stage;
    private Scene scene;
    private Parent root;
    



    public void play(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("playScene.fxml"));
        stage = (Stage)( (Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void quit(ActionEvent event){
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        BackgroundFill bgFill = new BackgroundFill(Color.rgb(86, 89, 90), null, null);
        Background mainBackground = new Background(bgFill);
        anchorPane.setBackground(mainBackground);
        
    }
    
}
