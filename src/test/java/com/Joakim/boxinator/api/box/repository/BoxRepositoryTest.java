package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BoxRepositoryTest {

    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;

    private BoxRepository repository = new BoxRepository();

    @Test
    void getAllBoxes() throws SQLException {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getString(1)).thenReturn("table_r3").thenReturn("table_r1").thenReturn("table_r2");

        Statement statement = Mockito.mock(Statement.class);
        Mockito.when(statement.executeQuery("SELECT name FROM tables")).thenReturn(resultSet);

        Connection jdbcConnection = Mockito.mock(Connection.class);
        Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);
    }

    @Test
    void addBox() throws SQLException {
        when(mockStatement.executeUpdate(Mockito.any())).thenReturn(1);
        when(mockConnection.createStatement()).thenReturn(mockStatement);

        Box box = new Box(
                "New box",
                15.5,
                "255, 255, 255",
                "Sweden",
                50
        );
        repository.addBox(box);
        assertNotNull(box.getName());
    }
}