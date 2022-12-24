import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class playSceneController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label zeroZero;
    @FXML
    private Label zeroOne;
    @FXML
    private Label zeroTwo;
    @FXML
    private Label oneZero;
    @FXML
    private Label oneOne;
    @FXML
    private Label oneTwo;
    @FXML
    private Label twoZero;
    @FXML
    private Label twoOne;
    @FXML
    private Label twoTwo;

    @FXML
    private Rectangle xSquare;
    @FXML
    private Rectangle xCircle;
    @FXML
    private Label winDisplay;

    private boolean tracker = true;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int[][] board = new int[3][3];

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        BackgroundFill bgFill = new BackgroundFill(Color.rgb(86, 89, 90), null, null);
        Background mainBackground = new Background(bgFill);
        anchorPane.setBackground(mainBackground);
        initBoard(board);
        xSquare.setFill(Color.rgb(57, 77, 83));
        xSquare.setOpacity(0.5);

    }

    public void initBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void previous(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean gameOver = false;

    public void enter(MouseEvent event) {
        Label label = (Label) event.getSource();

        String position = label.getId();
        // System.out.println(position);
        char row = position.charAt(0);
        char column = position.charAt(1);
        // System.out.println(row);
        // System.out.println(column);
        int r = Integer.parseInt(row + "");
        int c = Integer.parseInt(column + "");
        // System.out.println(r);
        // System.out.println(c);

        if (gameOver == false) {
            if (label.getText() == "") {
                if (tracker == true) {
                    label.setText("X");// represented by 0
                    tracker = false;
                    board[r][c] = 1;
                    xSquare.setFill(Color.WHITE);
                    xSquare.setOpacity(0.0);
                    xCircle.setFill(Color.rgb(57, 77, 83));
                    xCircle.setOpacity(0.5);
                    

                } else {
                    label.setText("O");
                    tracker = true;
                    board[r][c] = 0;
                    xCircle.setFill(Color.WHITE);
                    xCircle.setOpacity(0.0);
                    xSquare.setFill(Color.rgb(57, 77, 83));
                    xSquare.setOpacity(0.5);
                }

            }
            
            switch (check(board)) {
                case 1: {
                    gameOver = true;
                    //System.out.println("X wins");
                    winDisplay.setText("X wins!");
                    //initBoard(board);
                    break;
                }
                case 0: {
                    gameOver = true;
                    //System.out.println("O wins");
                    winDisplay.setText("O wins!");

                    //initBoard(board);
                    break;
                }default:{
                    if (boardIsFull(board) == true) {
                        //System.out.println("board full");
                        winDisplay.setText("Game over!");
        
                        gameOver = true;
                       //initBoard(board);
                    } 

                }
            }
            
        }
    }

    public boolean boardIsFull(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void restart(ActionEvent event) {
        winDisplay.setText("");
        initBoard(board);
        zeroZero.setText("");
        zeroOne.setText("");
        zeroTwo.setText("");
        oneZero.setText("");
        oneOne.setText("");
        oneTwo.setText("");
        twoZero.setText("");
        twoOne.setText("");
        twoTwo.setText("");
        gameOver = false;

    }

    public int check(int[][] board) {

        // Check each row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        // Check each column
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        // Check the diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        // Otherwise nobody has not won yet
        return ' ';

    }

}
