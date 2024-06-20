package command;
import shape.MyShape;
import canvas.MyCanvas;
public class DrawShapeCommand implements Command{

    private MyShape myShape;
    private MyCanvas myCanvas;

    public DrawShapeCommand(MyShape myShape) {
        this.myCanvas = MyCanvas.getInstance();
        this.myShape = myShape;
    }

    @Override
    public void execute() {
        myCanvas.addShape(myShape);
        myCanvas.redraw();
    }

    @Override
    public void undo() {
        myShape.hide();
        myCanvas.removeShape(myShape);
    }

}
