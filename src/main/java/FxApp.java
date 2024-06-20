import canvas.MyCanvas;
import command.Command;
import factory.CommandFactory;
import factory.ShapeFactory;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import shape.MyShape;

import java.util.ArrayList;


public class FxApp extends Application {
    private static final double WIDTH = 1600, HEIGHT = 900;
    private AnchorPane root = new AnchorPane();
    private Scene scene = new Scene(root, WIDTH, HEIGHT);

    private final MyCanvas myCanvas = MyCanvas.getInstance();
    private ArrayList<Command> commands = new ArrayList<>();
    private final String[] butText = {"Rectangle", "Circle", "Ellipse", "Triangle", "Line", "Text", "Copy", "Delete", "Revoke"};

    private MyShape chosenShape = null;
    Point2D dragDistance, pressedPoint, releasedPoint;

    private void addShapeEvent(MyShape myShape) {
        Shape shape = myShape.getShape();

        shape.addEventFilter(MouseDragEvent.MOUSE_PRESSED, event_press -> {
            chosenShape = myShape;
            dragDistance = new Point2D(event_press.getSceneX(), event_press.getSceneY());
            pressedPoint = new Point2D(shape.getLayoutX(), shape.getLayoutY());
            dragDistance = dragDistance.subtract(root.localToScene(new Point2D(shape.getLayoutX(), shape.getLayoutY())));
        });

        shape.addEventFilter(MouseDragEvent.MOUSE_DRAGGED, event_drag -> {
            if (event_drag.isPrimaryButtonDown()) {
                Point2D px = new Point2D(event_drag.getSceneX(), event_drag.getSceneY());
                px = root.sceneToLocal(px.subtract(dragDistance));
                myShape.move(px.getX(), px.getY());
            }
        });

        shape.addEventFilter(MouseDragEvent.MOUSE_RELEASED, event_release -> {
            chosenShape = myShape;
            releasedPoint = new Point2D(shape.getLayoutX(), shape.getLayoutY());
            Command command = CommandFactory.getCommand("Drag", myShape, pressedPoint, releasedPoint);
            command.execute();
            commands.add(command);
        });
        root.getChildren().add(myShape.getShape());
    }


    @Override
    public void start(Stage primaryStage) {
        ArrayList<Button> butList = new ArrayList<>();
        TextField textField = new TextField();
        textField.setLayoutX(920);
        textField.setLayoutY(20);
        root.getChildren().add(textField);
        for (int i = 0; i < 9; i++) {
            Button but = new Button(butText[i]);
            but.setLayoutX(20 + 100 * i);
            but.setLayoutY(20);
            but.setMinWidth(80);
            if (i < 6) {
                but.setOnAction(event -> {
                    MyShape myShape = ShapeFactory.getShape(but.getText() , textField.getText());
                    addShapeEvent(myShape);
                    Command command = CommandFactory.getCommand("Draw", myShape, null, null);
                    command.execute();
                    commands.add(command);
                });
            } else if (i == 6) {
                but.setOnAction(event -> {
                    if (chosenShape != null) {
                        MyShape copy = chosenShape.copy();
                        addShapeEvent(copy);
                        Command command = CommandFactory.getCommand("Copy", copy, null, null);
                        command.execute();
                        commands.add(command);
                    }
                });
            } else if (i == 7) {
                but.setOnAction(event -> {
                    if (chosenShape != null) {
                        Command command = CommandFactory.getCommand("Delete", chosenShape, null, null);
                        command.execute();
                        commands.add(command);
                    }
                });
            } else if (i == 8) {
                but.setOnAction(event -> {
                    if (!commands.isEmpty()) {
                        Command command = commands.getLast();
                        command.undo();
                        commands.removeLast();
                    }
                });
            }
            butList.add(but);
        }
        root.getChildren().addAll(butList);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}