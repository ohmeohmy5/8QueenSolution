package CS4200;

public class QueenBoard
{
    static int[][] QUEEN_BOARD = new int[8][8];

    public static int gameLoop(int[][] givenBoard, int currentRow, int nextQueenIndex)
    {
        int[][] previousBoard = copyBoard(givenBoard);
        placeQueen(currentRow, nextQueenIndex, givenBoard);
        boolean[] rowCosts = heuresticFunction(currentRow, givenBoard);

        if (checkGameState(givenBoard) == 0)
        {
            previousBoard = copyBoard(givenBoard);
            for (int i = 0; i < rowCosts.length; i++)
            {
                if (rowCosts[i] == true)
                {
                    givenBoard = copyBoard(previousBoard);
                    int returnInt = gameLoop(givenBoard, currentRow+1,i);

                    if(returnInt == 1)
                    {
                        return 1;
                    }
                }
            }
        }
        else if (checkGameState(givenBoard) == 1)
        {
            QUEEN_BOARD = copyBoard(givenBoard);
            return 1;
        }
        else if (checkGameState(givenBoard) == 2)
        {
            givenBoard = copyBoard(previousBoard);
            return 2;
        }
        return 0;
    }

    static int checkGameState(int[][] inputBoard)
    {
        int legalCount = 0;
        int queenCount = 0;

        for (int i = 0; i < inputBoard.length; i++)
        {
            for (int j = 0; j < inputBoard[0].length; j++)
            {
                if (inputBoard[i][j] == 0)
                {
                    legalCount++;
                }
                if (inputBoard[i][j] == 1)
                {
                    queenCount++;
                }
                }
            }
        if (queenCount == 8)
        {
            return 1;
        }
        else if (legalCount > 0)
        {
            return 0;
        }
        else
        {
            return 2;
        }
    }

    // 0 represents legal or open space, 1 represents queen, 2 represents illegal space
    static void placeQueen(int rowIndex, int columnIndex, int[][] inputBoard)
    {
        for (int i = 0; i < inputBoard.length; i++)
        {
            inputBoard[rowIndex][i] = 2;
            inputBoard[i][columnIndex] = 2;
        }

        int posBoundary = 8;
        int negBoundary = -1;

        for(int i = 0; i < 4; i++)
        {
            int currentRowIndex = rowIndex;
            int currentColIndex = columnIndex;
            int deltaRow = 0;
            int deltaCol = 0;

            if(i == 0)
            {
                deltaRow = 1;
                deltaCol = 1;
            }
            else if(i == 1)
            {
                deltaRow = 1;
                deltaCol = -1;
            }
            else if(i == 2)
            {
                deltaRow = -1;
                deltaCol = 1;
            }
            else if(i == 3)
            {
                deltaRow = -1;
                deltaCol = -1;
            }

            while(((currentRowIndex + deltaRow) > negBoundary && (currentRowIndex + deltaRow) < posBoundary) && ((currentColIndex + deltaCol) > negBoundary && (currentColIndex + deltaCol) < posBoundary))
            {
                currentRowIndex += deltaRow;
                currentColIndex += deltaCol;
                inputBoard[currentRowIndex][currentColIndex] = 2;
            }
        }

        inputBoard[rowIndex][columnIndex] = 1;
    }

    static boolean[] heuresticFunction(int rowIndex, int[][] inputBoard)
    {
        boolean[] returnArray = new boolean[8];
        int[] rowCosts = new int[8];
        int[][] previousBoard = copyBoard(inputBoard);

        for(int i = 0; i < inputBoard.length; i++)
        {
            if(inputBoard[rowIndex][i] == 0)
            {
                placeQueen(rowIndex, i, inputBoard);
                int sum = calculateSum(inputBoard);
                rowCosts[i] = sum;
            }
            inputBoard = copyBoard(previousBoard);
        }

        int max = calculateHighest(rowCosts);

        for(int i = 0; i < rowCosts.length; i++)
        {
            if (rowCosts[i] == max)
            {
                returnArray[i] = true;
            }
        }

        return returnArray;
    }

    static int calculateHighest(int[] rowCosts)
    {
        int highest = rowCosts[0];
        for(int x: rowCosts)
        {
            if (x > highest)
            {
                highest = x;
            }
        }
        return highest;
    }

    static int calculateSum(int[][] inputBoard)
    {
        int sum = 0;
        for (int i = 0; i < inputBoard.length; i++)
        {
            for (int j = 0; j < inputBoard[0].length; j++)
            {
                if (inputBoard[i][j] == 0)
                {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    static int[][] copyBoard(int[][] inputBoard)
    {
        int[][] outputBoard = new int[8][8];
        for (int i = 0; i < inputBoard.length; i++)
        {
            for (int j = 0; j < inputBoard[0].length; j++)
            {
                outputBoard[i][j] = inputBoard[i][j];
            }
        }

        return outputBoard;
    }

    static int[][] getBoard()
    {
        return QUEEN_BOARD;
    }

    static void printBoard()
    {
        for (int i = 0; i < QUEEN_BOARD.length; i++)
        {
            System.out.println("");
            for (int j = 0; j < QUEEN_BOARD[0].length; j++)
            {
                System.out.print(QUEEN_BOARD[i][j] + "  ");
            }
        }
    }
}
