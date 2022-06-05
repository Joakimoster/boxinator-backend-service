package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.repository.entity.Box;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoxRepository implements IBoxRepository {

    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/boxinator";

    @Override
    public List<Box> getAllBoxes() {
        ArrayList<Box> boxList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, "root", "server");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, Name, Weight, Color, Country, ShippingCost from Box");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Box box = new Box(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6));
                boxList.add(box);
            }
            System.out.println(boxList.get(0).getCountry());
        }
        catch (Exception ex) {      //Should be custom exception here instead
            System.out.println("Something went wrong..");
        }
        return boxList;
    }

    @Override
    public Box addBox(Box box) {

        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, "root", "server");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Box(Id, Name, Weight, Color, Country, ShippingCost) VALUES(?,?,?,?,?,?)");

            preparedStatement.setInt(1, Math.toIntExact(box.getId()));
            preparedStatement.setString(2, box.getName());
            preparedStatement.setDouble(3, box.getWeight());
            preparedStatement.setString(4, box.getColor());
            preparedStatement.setString(5, box.getCountry());
            preparedStatement.setDouble(6, box.getShippingCost());
            preparedStatement.executeUpdate();
        }
        catch (Exception ex) {      //Should be custom exception here instead
            System.out.println("Something went wrong..");
        }
        return box;
    }
}
