package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoxRepositoryTest {

    private ResultSet mockResultset = mock(ResultSet.class);
    private Connection mockConnection = mock(Connection.class);
    private PreparedStatement mockStatement = mock(PreparedStatement.class);

    private final String connectionString = "jdbc:mysql://localhost:3306/boxinator";
    private final String databaseUsername = "root";
    private final String databasePassword = "server";

    @Test
    void getAllBoxes() throws SQLException {
        List<BoxResponseDto> boxList = new ArrayList<>();
        mockConnection = DriverManager.getConnection(connectionString, databaseUsername, databasePassword);
        mockStatement = mockConnection.prepareStatement("SELECT Name, Weight, Color, ShippingCost from Box");
        mockResultset = mockStatement.executeQuery();

        while (mockResultset.next()) {
            BoxResponseDto box = new BoxResponseDto(
                    mockResultset.getString(1),
                    mockResultset.getDouble(2),
                    mockResultset.getString(3),
                    mockResultset.getDouble(4));
            boxList.add(box);
        }
        assertThat(boxList.size()).isNotNull();
    }

    @Test
    void addBox() throws SQLException {
        Box box = getBox();
        mockConnection = DriverManager.getConnection(connectionString, databaseUsername, databasePassword);
        mockStatement = mockConnection.prepareStatement("INSERT INTO Box(Name, Weight, Color, ShippingCost, Country) VALUES(?,?,?,?,?)");

        mockStatement.setString(1, box.getName());
        mockStatement.setDouble(2, box.getWeight());
        mockStatement.setString(3, box.getColor());
        mockStatement.setDouble(4, box.getShippingCost());
        mockStatement.setString(5, box.getCountry());

        assertThat(mockStatement.executeUpdate()).isNotNull();
    }

    private List<BoxResponseDto> getBoxList() {
        List<BoxResponseDto> boxList = new ArrayList<>();
        boxList.add(getBoxResponseDto());
        return boxList;
    }

    private Box getBox() {
        Box box = new Box();
        box.setName("Joakims box");
        box.setWeight(99.5);
        box.setColor("#9c5454");
        box.setShippingCost(350);
        box.setCountry("China");
        return box;
    }

    private BoxResponseDto getBoxResponseDto() {
        BoxResponseDto box = new BoxResponseDto();
        box.setName("New box name");
        box.setWeight(50.5);
        box.setColor("#9c5454");
        box.setShippingCost(50);
        return box;
    }
}