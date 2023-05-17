package battleship;

import java.util.Scanner;

public class Player {

    void placeShip(Board board, Ship ship) {

        boolean loop;

        do {
            Scanner scanner = new Scanner(System.in);
            // Ask user for placement start- and end-Coordinates
            System.out.printf("\nEnter the coordinates of the %s (%d cells):\n\n", ship.name, ship.size);

            String startCoord = scanner.next().trim();
            String endCoord = scanner.next().trim();

            // declare starting and ending indexes of ship in board array
            int x1, y1 = 0, x2, y2 = 0;

            // make sure x1 always the lower index
            if(startCoord.charAt(0) <= endCoord.charAt(0)) {
                x1 = (int) startCoord.charAt(0) - 'A';
                x2 = (int) endCoord.charAt(0) - 'A';
            } else {
                x2 = (int) startCoord.charAt(0) - 'A';
                x1 = (int) endCoord.charAt(0) - 'A';
            }
            // make sure y1 always the lower index
            try {
                // code that may throw NumberFormatException
                if (Integer.parseInt(startCoord.substring(1)) <= Integer.parseInt(endCoord.substring(1))) {
                    y1 = Integer.parseInt(startCoord.substring(1)) - 1;
                    y2 = Integer.parseInt(endCoord.substring(1)) - 1;
                } else {
                    y2 = Integer.parseInt(startCoord.substring(1)) - 1;
                    y1 = Integer.parseInt(endCoord.substring(1)) - 1;
                }
            } catch (NumberFormatException ignored) {
            }

            // mark the ship on the board IF input is valid and correspond to the ship size
            if (isValidInput(startCoord) && isValidInput(endCoord) && isRightShipSize(ship, x1, y1, x2, y2)
                    && !(board.isTooClose(x1, y1, x2, y2))) {

                board.markShip(x1, y1, x2, y2);
                board.printBoard();
                loop = false;

            } else {
                loop = true;
            }
        } while (loop);
    }

    private boolean isValidInput(String Coord) {
        boolean valid = Coord.matches("[A-J]([1-9]|10)");
        System.out.print(valid ? "" : "\nError: invalid input!");
        return valid;
    }

    private boolean isRightShipSize(Ship ship, int x1, int y1, int x2, int y2) {
        int inputSize = 0;
        // get input size if horizontally aligned
        if (x1 == x2) {
            if(y1 > y2) {
                inputSize = Math.abs(y1 - y2) + 1;
//                System.out.println("Math.abs(y1 - y2) + 1 = " + inputSize);
            }
            else {
                inputSize = Math.abs(y2 - y1) + 1;
//                System.out.println("Math.abs(y1 - y2) + 1 = " + inputSize);
            }

            // get input size if vertically aligned
        } else if(y1 == y2) {
            if(x1 > x2) {inputSize = Math.abs(x1 - x2) + 1;}
            else {inputSize = Math.abs(x2 - x1) + 1;}
        } else {
            // Error messagage if input is not horizontal of vertical
            System.out.println("\nError! Place your ship horizontally or vertically.");
        }

        // check if inputsize matches ship size
        if (inputSize == ship.size) {
            return true;
        } else {
            System.out.println("\nError! Wrong size of ship.");
            return false;
        }
    }

    public void takeShot(Board fullBoard) {
        Scanner scanner = new Scanner(System.in);
//        boolean loop = false;
        int targetX, targetY;

        do {
            System.out.println("\nTake a shot!\n");

            String targetCoord = scanner.next().trim();
            if (isValidInput(targetCoord)){
                targetX = (int) targetCoord.charAt(0) - 'A';
                targetY = Integer.parseInt(targetCoord.substring(1)) - 1;
                fullBoard.markShot(targetX, targetY);

            } else {
//                loop = true;
                System.out.println("\nError! invalid input");
            }
        }   while (!fullBoard.isAllShipsDestroyed());
    }
}
