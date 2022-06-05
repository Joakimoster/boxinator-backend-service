package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
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
    public List<BoxResponseDto> getAllBoxes() {
        List<BoxResponseDto> boxList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, "root", "server");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Name, Weight, Color, Country, ShippingCost from Box");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BoxResponseDto box = new BoxResponseDto(
                        resultSet.getString(1),
                        resultSet.getDouble(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5));
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
                    connection.prepareStatement("INSERT INTO Box(Name, Weight, Color, Country, ShippingCost) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, box.getName());
            preparedStatement.setDouble(2, box.getWeight());
            preparedStatement.setString(3, box.getColor());
            preparedStatement.setString(4, box.getCountry());
            preparedStatement.setDouble(5, box.getShippingCost());
            preparedStatement.executeUpdate();
        }
        catch (Exception ex) {      //Should be custom exception here instead
            System.out.println("Something went wrong..");
        }
        return box;
    }
}
