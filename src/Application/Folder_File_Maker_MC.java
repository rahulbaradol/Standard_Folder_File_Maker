package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Folder_File_Maker_MC extends Application {

    @Override
    public void start(Stage ps) {
        try {
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/Folder_File_Maker.fxml")));
            ps.setTitle("Standard Folder/File Maker");
            ps.setScene(sc);
            ps.setResizable(false);
            ps.show();
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Folder/File Maker");
            error.setHeaderText("Error");
            error.setContentText("Could not find the file");

            IOException fnfe = new IOException("Could not find the file");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            fnfe.printStackTrace(pw);

            JFXTextArea ta = new JFXTextArea(sw.toString());
            ta.setFocusColor(Color.LIME);
            ta.setUnFocusColor(Color.WHITE);

            error.getDialogPane().setExpandableContent(ta);
            error.showAndWait();
        }
    }

}