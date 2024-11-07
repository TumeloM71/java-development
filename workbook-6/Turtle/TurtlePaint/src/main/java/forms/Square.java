package forms;

import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape{

    protected int sideLength;

    public Square(Turtle turtle, Point2D location, Color color, int borderWidth, int sideLength) {
        super(turtle, location, color, borderWidth);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        World world = this.turtle.getWorld();
        Turtle turtle = this.turtle;

        turtle.setPenWidth(this.borderWidth);
        turtle.setColor(this.color);

        turtle.forward(sideLength);
        turtle.turnLeft(90);
        turtle.forward(sideLength);
        turtle.turnLeft(90);
        turtle.forward(sideLength);
        turtle.turnLeft(90);
        turtle.forward(sideLength);
    }
}
