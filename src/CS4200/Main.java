package CS4200;

public class Main
{
    public static void main(String[] args)
    {
        QueenBoard board = new QueenBoard();
        System.out.println(board.gameLoop(board.getBoard(), 0, 0));

    }

}
