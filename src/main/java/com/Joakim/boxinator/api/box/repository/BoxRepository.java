package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import com.Joakim.boxinator.api.box.utils.DBConnectionHelper;
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

    private DBConnectionHelper dbConnectionHelper;
    private Connection conn;

    @Override
    public List<BoxResponseDto> getAllBoxes() {
        List<BoxResponseDto> boxList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(dbConnectionHelper.getCONNECTION_URL(), "root", "server");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name, Weight, Color, Country, ShippingCost from Box");
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
        }
        catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            dbConnectionHelper.closeDatabaseConnection(conn);
        }
        return boxList;
    }

    @Override
    public Box addBox(Box box) {

        try {
            conn = DriverManager.getConnection(dbConnectionHelper.getCONNECTION_URL(), "root", "server");
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Box(Name, Weight, Color, Country, ShippingCost) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, box.getName());
            preparedStatement.setDouble(2, box.getWeight());
            preparedStatement.setString(3, box.getColor());
            preparedStatement.setString(4, box.getCountry());
            preparedStatement.setDouble(5, box.getShippingCost());
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            dbConnectionHelper.closeDatabaseConnection(conn);
        }
        return box;
    }
}
