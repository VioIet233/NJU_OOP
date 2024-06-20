package oop.draw.command;

import javafx.geometry.Point2D;
import oop.draw.shape.MyShape;

public class DragShapeCommand implements Command {

    private MyShape myShape;
    private Point2D from, to;

    public DragShapeCommand(MyShape myShape, Point2D from, Point2D to) {
        this.myShape = myShape;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        myShape.move(to.getX(), to.getY());
    }

    @Override
    public void undo() {
        myShape.move(from.getX(), from.getY());
    }

}