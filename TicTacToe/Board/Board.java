package Board;

import PlayingPiece.PlayingPiece;


import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int r, int c, PlayingPiece playingPiece)
    {
            if(board[r][c]!=null){
                return false;
            }
            board[r][c] = playingPiece;
            return true;
    }
    public void printBoard(){
        for(int i=0;i<size;i++)
        {
            for(int j =0 ;j<size;j++)
            {
                if(board[i][j]==null){
                    System.out.print("    |");
                }
                else System.out.print(board[i][j].pieceType + "   |");
            }
            System.out.print("\n");

        }
    }

    public List<List<Integer>> getFreeCells(){
        List<List<Integer>> freeCells = new ArrayList<>();

        for(int i=0;i<size;i++)
        {
            for(int j = 0;j<size;j++)
            {
                if(board[i][j]==null)
                {
                    List<Integer> rowColumn = new ArrayList<>();
                    rowColumn.add(i);
                    rowColumn.add(j);
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;
    }

}
