package spacetraders.model;

public class Coordinates {
    
    private int x, y;
    
    public Coordinates(int x, int y) {
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
        } else if (!(other instanceof Coordinates)) {
            return false;
        } else {
            Coordinates otherCoordinate = (Coordinates) other;
            return otherCoordinate.x == x && otherCoordinate.y == y;
        }
    }
}
