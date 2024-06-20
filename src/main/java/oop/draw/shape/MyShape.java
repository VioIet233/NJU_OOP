package oop.draw.shape;

import javafx.scene.shape.Shape;
public interface MyShape {
    void draw();

    void hide();

    Shape getShape();

    MyShape copy();

    void move(double newX, double newY);
}
