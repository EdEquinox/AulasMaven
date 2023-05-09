package pt.isec.pa.exerc29.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.exerc29.model.data.Figure;
import pt.isec.pa.exerc29.ui.gui.log.ModelStage;

public class MainJFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new ModelStage(stage);

        RootPane rootPane= new RootPane(new Figure());
        Scene scene = new Scene(rootPane,400,300);
        stage.setScene(scene);
        stage.setTitle("DEIS-ISEC");
        stage.show();
    }

}

