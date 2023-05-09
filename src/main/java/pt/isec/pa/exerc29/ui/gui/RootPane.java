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
        tbtLine.setOnAction(a -> update());
        tbtRect.setOnAction(a -> update());
        tbtEllipse.setOnAction(a -> update());
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
        if (tbtLine.isSelected())
            centralPane.getChildren().add(new Line(50,50,250,150));
        else if (tbtRect.isSelected())
            centralPane.getChildren().add(new Rectangle(50,50,250,150));
        else if (tbtEllipse.isSelected())
            centralPane.getChildren().add(new Ellipse(175,100,100,50));
    }
}
