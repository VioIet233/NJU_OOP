package shape;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Shape;

public class MyText implements MyShape{
    private double x, y;
    private  String context;
    private Text text = null;

    public MyText(double x, double y,String context) {
        this.x = x;
        this.y = y;
        this.context = context;
        text = new Text(x, y, context);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(1);
        text.setVisible(false);
    }

    @Override
    public void draw() {
        text.setVisible(true);
    }

    @Override
    public void hide() {
        text.setVisible(false);
    }

    @Override
    public Shape getShape() {
        return text;
    }

    @Override
    public MyShape copy() {
        return new MyText(x + 100, y + 100, context);
    }

    @Override
    public void move(double newX, double newY) {
        text.setLayoutX(newX);
        text.setLayoutY(newY);
        this.x = text.getX() + text.getLayoutX();
        this.y = text.getY() + text.getLayoutY();
    }
}
