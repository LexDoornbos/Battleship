package battleship;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board player1Board = new Board();
    Board player2Board = new Board();
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");

    void gameSetup() {

        System.out.println("\nPlayer 1, place your ships on the game field");
        player1Board.printBoard();
        for (Ship ship : Ship.values()) {
            player1.placeShip(player1Board, ship);
        }
        System.out.println("\nPress Enter and pass the move to another player");
        scanner.nextLine();

        System.out.println("\nPlayer 2, place your ships on the game field");
        player2Board.printBoard();
        for (Ship ship : Ship.values()) {
            player2.placeShip(player2Board, ship);
        }
    }

    void gameStart() {
        do {
            System.out.println("\nPress Enter and pass the move to another player");
            scanner.nextLine();

            player2Board.printFogBoard();
            System.out.print("---------------------");
            player1Board.printBoard();
            player1.takeShot(player2Board, player1);

            System.out.println("\nPress Enter and pass the move to another player");
            scanner.nextLine();

            player1Board.printFogBoard();
            System.out.print("---------------------");
            player2Board.printBoard();
            player2.takeShot(player1Board, player2);
        } while (!player1Board.isAllShipsDestroyed() || !player2Board.isAllShipsDestroyed());
    }
}