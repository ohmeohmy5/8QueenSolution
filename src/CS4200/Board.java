package CS4200;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
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

        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                StackPane square = new StackPane();
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

                if(boardArray[row][col] == 1)
                {
                    square.setStyle("-fx-background-image: url('/queen.png')");
                    square.setStyle("-fx-background-size: 100, 200;");
                }

                boardPane.add(square, col, row);
            }
        }

        for (int i = 0; i < size; i++)
        {
            boardPane.getColumnConstraints().add(new ColumnConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            boardPane.getRowConstraints().add(new RowConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        primaryStage.setScene(new Scene(boardPane, 800, 800));
       primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}