package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BoxRepositoryTest {

    private ResultSet mockResultset = mock(ResultSet.class);
    private Connection mockConnection = mock(Connection.class);
    private PreparedStatement mockStatement = mock(PreparedStatement.class);

    private BoxRepository repository = mock(BoxRepository.class);

    @Test
    void getAllBoxes() throws SQLException {
        List<BoxResponseDto> boxList = new ArrayList<>();
        mockConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "server");
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
        assertThat(boxList.get(0).getName()).isEqualTo("Tezev");
        assertThat(boxList.size()).isNotNull();
    }

    @Test
    void addBox() throws SQLException {
        Box box = getBox();
        mockConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "server");
        mockStatement = mockConnection.prepareStatement("INSERT INTO Box(Name, Weight, Color, ShippingCost) VALUES(?,?,?,?)");

        mockStatement.setString(1, box.getName());
        mockStatement.setDouble(2, box.getWeight());
        mockStatement.setString(3, box.getColor());
        mockStatement.setDouble(4, box.getShippingCost());
        mockStatement.executeUpdate();

        assertThat(mockStatement.executeUpdate()).isNotNegative();
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
        box.setColor("150, 150, 150");
        box.setShippingCost(5);
        return box;
    }

    private BoxResponseDto getBoxResponseDto() {
        BoxResponseDto box = new BoxResponseDto();
        box.setName("New box name");
        box.setWeight(50.5);
        box.setColor("255, 255, 255");
        box.setShippingCost(50);
        return box;
    }
}