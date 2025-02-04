package edu.icet.ecom.controller;
import edu.icet.ecom.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.icet.ecom.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserController implements  UserService{

    @Override
    public boolean addUser(User user) {
        String SQL = "INSERT INTO users VALUES(?,?,?,?)";
        try {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement psTm = connection.prepareStatement(SQL);
        psTm.setObject(1,user.getId());
        psTm.setObject(2,user.getName());
        psTm.setObject(3,user.getEmail());
        psTm.setObject(4,user.getMembershipDate());
        return psTm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User searchUser(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE id=" +"'"+ id+"'");
            resultSet.next();
            return new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> customerArrayList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                customerArrayList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerArrayList;
    }
    public ObservableList<Integer> getUserIds(){
        List<User> userList = getAll();
        ObservableList<Integer> userIdList = FXCollections.observableArrayList();

        userList.forEach(user -> {
            userIdList.add(user.getId());
        });

        return userIdList;

    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }
}
