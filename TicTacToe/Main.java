public class Main {
    public static void main(String[] args){

        System.out.println("It is a Tic Tac Toe");
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("The winner is :" + game.startGame() );
    }
}
