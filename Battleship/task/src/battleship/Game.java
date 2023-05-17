package battleship;

public class Game {

    Board shipsBoard = new Board();
    Player player1 = new Player();

    void gameSetup() {
        shipsBoard.printBoard();
        for (Ship ship : Ship.values()) {
            player1.placeShip(shipsBoard, ship);
        }
    }

    void gameStart() {
        System.out.println("\nThe game starts!\n");
        shipsBoard.printFogBoard();
        player1.takeShot(shipsBoard);
    }
}
