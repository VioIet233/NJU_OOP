package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class MyEllipse implements MyShape {
    private double x, y, width, height;
    private Ellipse ellipse = null;

    public MyEllipse(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        ellipse = new Ellipse(x, y, width, height);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        ellipse.setStrokeWidth(4);
        ellipse.setVisible(false);
    }

    @Override
    public void draw() {
        ellipse.setVisible(true);
    }

    @Override
    public void hide() {
        ellipse.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return ellipse;
    }

    @Override
    public MyShape copy() {
        return new MyEllipse(x + 100, y + 100, width, height);
    }

    @Override
    public void move(double newX, double newY) {
        ellipse.setLayoutX(newX);
        ellipse.setLayoutY(newY);
        this.x = ellipse.getCenterX() + ellipse.getLayoutX();
        this.y = ellipse.getCenterY() + ellipse.getLayoutY();

    }

}
