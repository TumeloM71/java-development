package forms;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {

    protected Turtle turtle;
    protected Point2D location;
    protected Color color;
    protected int borderWidth;

    public Shape(Turtle turtle, Point2D location, Color color, int borderWidth) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.borderWidth = borderWidth;
    }

    public abstract void paint();

    public Turtle getTurtle() {
        return turtle;
    }

    public Point2D getLocation() {
        return location;
    }

    public Color getColor() {
        return color;
    }

    public int getBorderWidth() {
        return borderWidth;
    }
}
