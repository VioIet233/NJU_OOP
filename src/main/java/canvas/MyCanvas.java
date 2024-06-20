package canvas;

import shape.MyShape;

import java.util.ArrayList;
import java.util.List;

public class MyCanvas {
    private static MyCanvas instance;
    private MyCanvas() {
        myShapes = new ArrayList<>();
    }
    public static synchronized MyCanvas getInstance() {
        if (instance == null) {
            instance = new MyCanvas();
        }
        return instance;
    }

    private List<MyShape> myShapes = new ArrayList<>();

    public void addShape(MyShape myShape) {
        myShapes.add(myShape);
    }

    public void removeShape(MyShape myShape) {
        myShapes.remove(myShape);
    }

    public void clear() {
        myShapes.clear();
    }

    public void redraw() {
        for (MyShape myShape : myShapes) {
            myShape.draw();
        }
    }
}