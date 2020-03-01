package CS4200;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        QueenBoard board = new QueenBoard();
        board.gameLoop(board.getBoard(), 0, 0);
        int[][] boardArray = board.getBoard();
        GridPane boardPane = new GridPane();
        int size = 8 ;
        Image queenImage = new Image(getClass().getResourceAsStream("queen.png"));

        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                ImageView queenImageView = new ImageView(queenImage);
                queenImageView.setFitWidth(50);
                queenImageView.setFitHeight(50);

                Pane square = new Pane();
                String color;
                if ((row + col) % 2 == 0)
                {
                    color = "white";
                }
                else
                {
                    color = "black";
                }

                square.setStyle("-fx-background-color: "+color+";");

                if (boardArray[row][col] == 1)
                {
                    boardPane.add(queenImageView, col, row);
                }
                else {
                    boardPane.add(square, col, row);
                }
            }
        }

        for (int i = 0; i < size; i++)
        {
            boardPane.getColumnConstraints().add(new ColumnConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            boardPane.getRowConstraints().add(new RowConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        primaryStage.setScene(new Scene(boardPane, 600, 600));
       primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}