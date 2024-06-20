package oop.draw.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class MyLine implements MyShape {
    private double x1, y1, x2, y2, x, y;
    private Line line = null;

    public MyLine(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        line = new Line(x1, y1, x2, y2);
        this.x = line.getLayoutX();
        this.y = line.getLayoutY();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(4);
        line.setVisible(false);
    }

    @Override
    public void draw() {
        line.setVisible(true);
    }

    @Override
    public void hide() {
        line.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return line;
    }

    @Override
    public MyShape copy() {
        return new MyLine(x1 + 100, y1 + 100, x2 + 100, y2 + 100);
    }
    @Override
    public void move(double newX, double newY) {
        line.setLayoutX(newX);
        line.setLayoutY(newY);
        this.x = line.getStartX() + line.getLayoutX();
        this.y = line.getStartY() + line.getLayoutY();
    }
}
