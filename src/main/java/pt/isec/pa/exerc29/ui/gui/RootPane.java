package pt.isec.pa.exerc29.ui.gui;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import pt.isec.pa.exerc29.model.ModelLog;
import pt.isec.pa.exerc29.model.data.Figure;

public class RootPane extends BorderPane {
    private static final String LINE = "Line";
    private static final String RECT = "Rect";
    private static final String ELLIPSE = "Ellipse";

    Figure model;
    Pane centralPane;
    ToggleGroup tgr;
    ToggleButton tbtLine,tbtRect,tbtEllipse;

    public RootPane(Figure model) {
        this.model = model;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        HBox hbox = new HBox();
        tgr = new ToggleGroup();
        tbtLine = new ToggleButton(LINE);
        tbtLine.setToggleGroup(tgr);
        tbtLine.setPrefWidth(Integer.MAX_VALUE);
        tbtRect = new ToggleButton(RECT);
        tbtRect.setToggleGroup(tgr);
        tbtRect.setPrefWidth(Integer.MAX_VALUE);
        tbtEllipse = new ToggleButton(ELLIPSE);
        tbtEllipse.setToggleGroup(tgr);
        tbtEllipse.setPrefWidth(Integer.MAX_VALUE);
        tgr.selectToggle(tbtLine);
        hbox.getChildren().addAll(tbtLine,tbtRect,tbtEllipse);
        this.setTop(hbox);

        centralPane = new Pane();
        setCenter(centralPane);
    }

    private void registerHandlers() {
        centralPane.setOnMousePressed(e ->{
            model.setP1(e.getX(),e.getY());
            model.setP2(e.getX(),e.getY());
            model.defineColor();
            update();
        });
        centralPane.setOnMouseDragged(e -> {
            model.setP2(e.getX(),e.getY());
            update();
        });
        centralPane.setOnMouseReleased(e ->{
            model.setP2(e.getX(),e.getY());
            update();
        });
        centralPane.setOnMouseClicked(e -> {
            ModelLog.getInstance().add(
                    String.format("%.2f %.2f %b %b %b",
                            e.getX(),e.getY(),e.isShiftDown(), e.isControlDown(),e.isAltDown()
                    )
            );
        });
    }

    private void update() {
        centralPane.getChildren().clear();
        if (tbtLine.isSelected()){
            Line line = new Line(50,50,250,150);
            line.setStartY(model.getY1());
            line.setStartX(model.getX1());
            line.setEndX(model.getX2());
            line.setEndY(model.getY2());
            centralPane.getChildren().add(line);
        }
        else if (tbtRect.isSelected()){
            Rectangle rectangle = new Rectangle(50,50,250,150);
            rectangle.setY(model.getY1());
            rectangle.setX(model.getX1());
            rectangle.setWidth(model.getX2()-model.getX1());
            rectangle.setHeight(model.getY2()-model.getY1());
            centralPane.getChildren().add(rectangle);
        }
        else if (tbtEllipse.isSelected()){
            Ellipse ellipse = new Ellipse(50,50,250,150);
            ellipse.setCenterX(model.getCX());
            ellipse.setCenterY(model.getCY());
            ellipse.setRadiusX(model.getX2()-model.getX1());
            ellipse.setRadiusY(model.getY2()-model.getY1());
            centralPane.getChildren().add(ellipse);
        }
    }
}
