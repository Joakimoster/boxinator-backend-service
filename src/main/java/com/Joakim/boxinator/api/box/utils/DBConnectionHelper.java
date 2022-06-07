package com.Joakim.boxinator.api.box.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionHelper {

    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/boxinator";

    public void closeDatabaseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String getCONNECTION_URL() {
        return CONNECTION_URL;
    }
}
