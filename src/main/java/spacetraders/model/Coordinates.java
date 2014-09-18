package spacetraders.model;

public class Coordinate {
    
    private int x, y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    private int getX() {
        return x;
    }
    
    private int getY() {
        return y;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof Coordinate)) {
            return false;
        } else {
            Coordinate otherCoordinate = (Coordinate) other;
            return otherCoordinate.x == x && otherCoordinate.y == y;
        }
    }
}
