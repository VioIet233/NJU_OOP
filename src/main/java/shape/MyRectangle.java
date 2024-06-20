package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MyRectangle implements MyShape {
    private double x, y, width, height;
    private Rectangle rectangle = null;

    public MyRectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        rectangle.setStrokeWidth(4);
        rectangle.setVisible(false);
    }


    @Override
    public void draw() {
        rectangle.setVisible(true);
    }

    @Override
    public void hide() {
        rectangle.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }

    @Override
    public MyShape copy() {
        return new MyRectangle(x + 100, y + 100, width, height);
    }

    @Override
    public void move(double newX, double newY) {
        rectangle.setLayoutX(newX);
        rectangle.setLayoutY(newY);
        this.x = rectangle.getX() + rectangle.getLayoutX();
        this.y = rectangle.getY() + rectangle.getLayoutY();
    }
}
