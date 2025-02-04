package edu.icet.ecom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;


public class DashBoardFormController {
    @FXML
    public AnchorPane loadFormContent;
    @FXML
    void btnOpenUserFormOnAction(ActionEvent actionEvent) throws IOException {
            URL resource = this.getClass().getResource("/view/user_form.fxml");

            assert resource != null;

            Parent load = FXMLLoader.load(resource);

            loadFormContent.getChildren().clear();
            loadFormContent.getChildren().add(load);

        }
    }


