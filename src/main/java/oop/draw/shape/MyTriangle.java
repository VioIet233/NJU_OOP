package oop.draw.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class MyTriangle implements MyShape {
    private double x1, y1, x2, y2, x3, y3, x, y;
    private Polygon triangle = null;

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        triangle = new Polygon();
        triangle.getPoints().addAll(x1, y1, x2, y2, x3, y3);
        this.x = triangle.getLayoutX();
        this.y = triangle.getLayoutY();
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.WHITE);
        triangle.setStrokeWidth(4);
        triangle.setVisible(false);
    }

    @Override
    public void draw() {
        triangle.setVisible(true);
    }

    @Override
    public void hide() {
        triangle.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return triangle;
    }

    @Override
    public MyShape copy() {
        return new MyTriangle(x1 + x + 100, y1 +y+ 100, x2 + x+ 100, y2 +y+ 100, x3 + x+ 100, y3 +y+ 100);
    }


    @Override
    public void move(double newX, double newY) {
        triangle.setLayoutX(newX);
        triangle.setLayoutY(newY);
        this.x = triangle.getLayoutX();
        this.y = triangle.getLayoutY();
    }

}
