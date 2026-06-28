import Board.Board;
import Player.Player;
import PlayingPiece.PlayingPiece;
import PlayingPiece.PlayingPieceO;
import PlayingPiece.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame(){
        initializeGame();
    }
    public void initializeGame()
    {
        players = new LinkedList<>();
        Player player1 = new Player("Player1",new PlayingPieceX());
        Player player2 = new Player("Player2",new PlayingPieceO());

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);

    }

    public String startGame()
    {
        boolean noWinner = true;
        while(noWinner)
        {
            Player player = players.removeFirst();
            PlayingPiece playingPiece = player.getPlayingPiece();

            List<List<Integer>> freeCells = gameBoard.getFreeCells();

            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }

            gameBoard.printBoard();
            System.out.println("Player : "+player.getName()+ " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] value = s.split(",");

            int row = Integer.valueOf(value[0]);
            int column = Integer.valueOf(value[1]);

            boolean pieceAdded = gameBoard.addPiece(row,column,player.getPlayingPiece());

            if(!pieceAdded){
                System.out.println("Incorrect position chosen,try again");
                players.addFirst(player);
                continue;
            }

            players.addLast(player);

            boolean winner = isThereWinner( row,column,player.getPlayingPiece());

            if(winner){
                return player.getName();
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row,int column,PlayingPiece playingPiece)
    {
        boolean checkRow=true;
        boolean checkColumn=true;
        boolean checkDiag=true;
        boolean checkNegDiag=true;
        for(int j = 0;j<gameBoard.size;j++)
        {
            if(gameBoard.board[row][j]==null || gameBoard.board[row][j]!= playingPiece )
                checkRow = false;
        }
        for(int i = 0;i<gameBoard.size;i++)
        {
            if(gameBoard.board[i][column]==null || gameBoard.board[i][column]!= playingPiece )
                checkColumn = false;
        }

        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j]!= playingPiece )
                checkDiag = false;
        }
        for(int i=0,j=gameBoard.size -1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j]!= playingPiece )
                checkNegDiag = false;
        }

        return checkDiag||checkNegDiag||checkColumn||checkRow;

    }
}
