package edu.icet.ecom.controller;


import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import edu.icet.ecom.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import  edu.icet.ecom.db.DBConnection;
import java.util.List;
public class UserFormController {

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colMembershipDate;

    @FXML
    private TableColumn colName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMembershipDate;

    @FXML
    private TextField txtName;
    @FXML
    private TableView tblUsers;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        boolean isUserAdd = new UserController().addUser(
                new User(
                        Integer.parseInt(txtId.getText()),
                        txtName.getText(),
                        txtEmail.getText(),
                        txtMembershipDate.getText()
                )
        );

        if (isUserAdd){
            new Alert(Alert.AlertType.INFORMATION,"User Added!!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"User Not Added!!").show();

        }
    }


    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }
    private void loadTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMembershipDate.setCellValueFactory(new PropertyValueFactory<>("membershipDate"));

        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        List<User> all = new UserController().getAll();
        all.forEach(user -> {
            userObservableList.add(user);
        });

        tblUsers.setItems(userObservableList);
    }


}
