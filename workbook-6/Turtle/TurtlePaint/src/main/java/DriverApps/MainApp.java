package DriverApps;


import forms.*;
import forms.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class MainApp {
    static World world;
    static Color borderColor;
    static Point2D location;
    static Shape shape;
    static int worldSize;

    public static void main(String[] args) {

        worldSize = Utilities.getIntValue(JOptionPane.showInputDialog(null, "What is the world size"));
        world = new World(worldSize, worldSize);

        while (true){
            int option = Utilities.getIntValue(JOptionPane.showInputDialog(null, "1. Add Shape 2. Save Image 0.Exit"));
            switch (option){
                case 1 -> addShape();
                case 2 -> saveImage();
                case 0 -> System.exit(0);
            }
        }
    }

    public static void addShape(){
        int shapeChoice = Utilities.getIntValue((JOptionPane.showInputDialog(null,"Choose a shape\n" +
                "1.Square 2.Circle 3.Triangle 0.Exit"))) ;
        switch (shapeChoice){
            case 1 -> drawSquare();
            case 2 -> drawCircle();
            case 3 -> drawTriangle();
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid shape choice");
        }
    }

    public static void saveImage(){
        world.saveAs("src/main/resources/image.png");
    }

    public static void drawSquare() {

        int width = Utilities.getIntValue(JOptionPane.showInputDialog(null, "What is is the border width"));
        int sideLength = Utilities.getIntValue(JOptionPane.showInputDialog(null, "What is is the length of a side?"));
        double x = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the x-coordinate of the drawing"));
        double y = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the y-coordinate"));
        location = new Point2D.Double(x,y);
        Turtle turtle = new Turtle(world,x,y);
        int colorChoice = Utilities.getIntValue(JOptionPane.showInputDialog(null,"Choose a color\n 1.Red 2.Blue"));
        switch (colorChoice){
            case 1 -> borderColor = Color.RED;
            case 2 -> borderColor = Color.BLUE;
            default -> System.out.println("Invalid choice");
        }
        shape = new Square(turtle, location, borderColor, width, sideLength);
        drawShape();
    }

    public static void drawCircle(){
        double radius = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"What is the radius?"));
        int width = Utilities.getIntValue(JOptionPane.showInputDialog(null, "What is is the border width?"));
        double x = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the x-coordinate of the drawing"));
        double y = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the y-coordinate"));
        location = new Point2D.Double(x,y);
        Turtle turtle = new Turtle(world,x,y);
        int colorChoice = Utilities.getIntValue(JOptionPane.showInputDialog(null,"Choose a color\n 1.Red 2.Blue"));
        switch (colorChoice){
            case 1 -> borderColor = Color.RED;
            case 2 -> borderColor = Color.BLUE;
            default -> System.out.println("Invalid choice");
        }
        shape = new Circle(turtle, location, borderColor, width, radius);
        drawShape();

    }

    public static void drawTriangle(){
        double base = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"What is the base?"));
        double height = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"What is the height?"));
        int width = Utilities.getIntValue(JOptionPane.showInputDialog(null, "What is is the border width?"));
        double x = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the x-coordinate of the drawing"));
        double y = Utilities.getDoubleValue(JOptionPane.showInputDialog(null,"Choose the y-coordinate"));
        location = new Point2D.Double(x,y);
        Turtle turtle = new Turtle(world,x,y);
        int colorChoice = Utilities.getIntValue(JOptionPane.showInputDialog(null,"Choose a color\n 1.Red 2.Blue"));
        switch (colorChoice){
            case 1 -> borderColor = Color.RED;
            case 2 -> borderColor = Color.BLUE;
            default -> System.out.println("Invalid choice");
        }
        shape = new Triangle(turtle, location, borderColor, width, base, height);
        drawShape();
    }

    public static void drawShape(){
        shape.paint();
    }

    public static void chooseBlue() {
        borderColor = Color.BLUE;
    }

    public static void chooseRed() {
        borderColor = Color.RED;
    }

    public static void drawSlicedPie() {
        World world = new World(500, 500);
        Turtle turtle = new Turtle(world, 0, 0);
        turtle.setColor(Color.RED);
        int radius = 100;
        double theta = 0;
        while (theta <= 1.5 * Math.PI) {
            turtle.goTo(radius * Math.cos(theta), radius * Math.sin(theta));
            theta += 0.1;
        }
        turtle.goTo(0, 0);
        turtle.penUp();
        turtle.goTo(10, -10);
        turtle.setColor(Color.BLUE);
        turtle.penDown();

        theta = 0;
        while (theta >= -.5 * Math.PI) {
            turtle.goTo(radius * Math.cos(theta) + 10, radius * Math.sin(theta) - 10);
            theta -= 0.05;
        }
        turtle.goTo(10, -10);
    }
}





