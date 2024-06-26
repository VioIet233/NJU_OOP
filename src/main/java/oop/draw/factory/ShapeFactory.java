package oop.draw.factory;

import oop.draw.shape.*;

public class ShapeFactory {
    public static MyShape getShape(String shapeType , String context){
        if(shapeType == null){
            return null;
        }
        return switch (shapeType) {
            case "Circle" -> new MyCircle(800, 500, 100);
            case "Rectangle" -> new MyRectangle(800, 100, 150, 100);
            case "Line" -> new MyLine(900, 500, 600, 500);
            case "Ellipse" -> new MyEllipse(800, 500, 150, 100);
            case "Triangle" -> new MyTriangle(700, 400, 650, 500, 750, 500);
            case "Text" -> new MyText(800, 500, context);
            default -> null;
        };

    }
}