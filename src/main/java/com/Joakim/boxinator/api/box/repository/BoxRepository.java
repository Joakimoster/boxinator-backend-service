package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoxRepository implements IBoxRepository {

    private Connection conn;

    @Override
    public List<BoxResponseDto> getAllBoxes() {
        List<BoxResponseDto> boxList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "server");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name, Weight, Color, ShippingCost from Box");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BoxResponseDto box = new BoxResponseDto(
                        resultSet.getString(1),
                        resultSet.getDouble(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4));
                boxList.add(box);
            }
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return boxList;
    }

    @Override
    public Box addBox(Box box) {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "server");
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Box(Name, Weight, Color, ShippingCost) VALUES(?,?,?,?)");

            preparedStatement.setString(1, box.getName());
            preparedStatement.setDouble(2, box.getWeight());
            preparedStatement.setString(3, box.getColor());
            preparedStatement.setDouble(4, box.getShippingCost());

            preparedStatement.executeUpdate();
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return box;
    }
}
