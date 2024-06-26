package oop.draw.command;

import oop.draw.canvas.MyCanvas;
import oop.draw.shape.MyShape;

public class DeleteShapeCommand implements Command {

    private MyShape myShape;
    private MyCanvas myCanvas;

    public DeleteShapeCommand(MyShape myShape) {
        this.myCanvas = MyCanvas.getInstance();
        this.myShape = myShape;
    }

    @Override
    public void execute() {
        myShape.hide();
        myCanvas.removeShape(myShape);
    }

    @Override
    public void undo() {
        myCanvas.addShape(myShape);
        myCanvas.redraw();
    }

}
