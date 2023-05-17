package battleship;

public class Main {

    public static void main(String[] args) {
        // create new game object
        Game game = new Game();
        // At game start -> print a board and ask user to place ships
        game.gameSetup();
        // After placing the ships, the shooting phase begins.
        game.gameStart();
    }
}
