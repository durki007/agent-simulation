package utils;

// Contains information about position on 2D plane
// Should not be mutated

public class Position {
    public Integer x;
    public Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Boolean equals(Position pos) {
        return x == pos.x && y == pos.y;
    }

    public int distance(Position pos) {
        int dX = Math.abs(x - pos.x);
        int dY = Math.abs(y - pos.y);
        return dX + dY;
    }

    public String serialize() {
        return String.format("(%d, %d)", x, y);
    }

}
