package forms;

import java.awt.*;
import java.awt.geom.Point2D;

public class Circle extends Shape{

    protected double radius;

    public Circle(Turtle turtle, Point2D location, Color color, int borderWidth, double radius) {
        super(turtle, location, color, borderWidth);
        this.radius = radius;
    }

    @Override
    public void paint() {
        World world = this.turtle.getWorld();
        Turtle turtle = this.turtle;

        turtle.setPenWidth(this.borderWidth);
        turtle.setColor(this.color);

        double theta = 0;
        turtle.penUp();
        while (theta <= 2.1 * Math.PI ) {
            turtle.goTo(radius * Math.cos(theta), radius * Math.sin(theta));
            turtle.penDown();
            theta += 0.1;
        }

    }
}
