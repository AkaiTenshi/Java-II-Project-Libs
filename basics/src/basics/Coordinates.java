/*
 Basic Coordinate class doesn't do much
 */
package basics;

public class Coordinates {

    private String type;
    private double x;
    private double y;

    // Consrtuctor
    public Coordinates() {
        this.x = 0;
        this.y = 0;
        this.type = "";
    }

    // Getters & Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
