package forms;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class Triangle extends Shape{

    protected double base;
    protected double height;

    public Triangle(Turtle turtle, Point2D location, Color color, int borderWidth, double base, double height) {
        super(turtle, location, color, borderWidth);
        this.base = base;
        this.height = height;
    }

    @Override
    public void paint() {
        World world = this.turtle.getWorld();
        Turtle turtle = this.turtle;

        turtle.setPenWidth(this.borderWidth);
        turtle.setColor(this.color);
        Point2D first = new Point2D.Double(this.location.getX() - base / 2, this.location.getY());
        Point2D second = new Point2D.Double(this.location.getX()+base/2, this.location.getY());
        Point2D third = new Point2D.Double(this.location.getX(), this.location.getY()+height);
        turtle.penUp();
        turtle.goTo(first);
        turtle.penDown();
        turtle.goTo(second);
        turtle.goTo(third);
        turtle.goTo(first);
    }
}
