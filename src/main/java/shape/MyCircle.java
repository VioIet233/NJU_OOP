package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;

public class MyCircle implements MyShape {
    private double x, y, radius;
    private Circle circle = null;

    public MyCircle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        circle = new Circle(x, y, radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(4);
        circle.setVisible(false);
        circle.setAccessibleText("芝士圆形");
    }

    @Override
    public void draw() {
        circle.setVisible(true);
    }

    @Override
    public void hide() {
        circle.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return circle;
    }

    @Override
    public MyShape copy() {
        return new MyCircle(x + 100, y + 100, radius);
    }

    @Override
    public void move(double newX, double newY) {
        circle.setLayoutX(newX);
        circle.setLayoutY(newY);
        this.x = circle.getCenterX() + circle.getLayoutX();
        this.y = circle.getCenterY() + circle.getLayoutY();
    }
}
