package br.edu.ifsp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PrimaryController implements Initializable {

    private boolean clicou = false;

    @FXML
    private VBox vboxPrincipal;

    @FXML
    private Button b11;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        BackgroundFill bf = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(bf);
        vboxPrincipal.setBackground(bg);
       // bf = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
        //b11.setBackground(bg);
    }

    @FXML
    public void revelar(){
        BackgroundFill bf = null;
        if (!clicou){
            bf = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
            clicou = true;
        } else {
            bf = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
            clicou = false;
        }
        Background bg = new Background(bf);
        b11.setBackground(bg);
    }
}
