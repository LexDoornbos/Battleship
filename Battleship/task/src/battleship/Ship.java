package battleship;

public enum Ship {

    AIRCRAFTCARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    final String name;

    final int size;

    Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }
}