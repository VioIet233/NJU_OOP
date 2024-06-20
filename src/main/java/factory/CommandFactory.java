package factory;

import command.*;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
import shape.*;

public class CommandFactory {

    public static Command getCommand(String commandType, MyShape myShape, Point2D from, Point2D to) {
        if (commandType == null) {
            return null;
        }
        return switch (commandType) {
            case "Draw" -> new DrawShapeCommand(myShape);
            case "Drag" -> new DragShapeCommand(myShape, from, to);
            case "Copy" -> new CopyShapeCommand(myShape);
            case "Delete" -> new DeleteShapeCommand(myShape);
            default -> null;
        };

    }

}
