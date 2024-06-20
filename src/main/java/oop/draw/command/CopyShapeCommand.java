package oop.draw.command;

import oop.draw.canvas.MyCanvas;
import oop.draw.shape.MyShape;

public class CopyShapeCommand implements Command{

    private MyShape copyShape;
    private MyCanvas myCanvas;

    public CopyShapeCommand(MyShape copyShape) {
        this.myCanvas = MyCanvas.getInstance();
        this.copyShape = copyShape;
    }

    @Override
    public void execute() {
        myCanvas.addShape(copyShape);
        myCanvas.redraw();
    }

    @Override
    public void undo() {
        copyShape.hide();
        myCanvas.removeShape(copyShape);
    }

}
