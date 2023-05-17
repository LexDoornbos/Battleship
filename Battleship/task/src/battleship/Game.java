package battleship;

public class Game {

    Board fullBoard = new Board();
    Player player1 = new Player();

    void gameSetup() {
        fullBoard.printBoard();
        for (Ship ship : Ship.values()) {
            player1.placeShip(fullBoard, ship);
        }
    }

    void gameStart() {
        System.out.println("\nThe game starts!");
        fullBoard.printFogBoard();
        player1.takeShot(fullBoard);
    }
}