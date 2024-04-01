/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {
    private static final Logger logger = LoggerFactory.getLogger(Conexion.class);
    private static final String url = "jdbc:mysql://localhost:3306/CITASSENA";
    private static final String user = "root";
    private static final String pass = "Emma_Sofia0529";
    private static Connection con;

    public static Connection conector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Corrección del método forName
            con = DriverManager.getConnection(url, user, pass); // Corrección del método getConnection
            logger.info("Conexion establecida"); // Corrección del mensaje de información
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error de conexión: {}", e.getMessage()); // Corrección del mensaje de error
        }
        return con;
    }
}

    