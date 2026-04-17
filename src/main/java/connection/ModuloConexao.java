/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package connection;

import static config.Config.BD_DRIVER;
import static config.Config.BD_SENHA;
import static config.Config.BD_URL;
import static config.Config.BD_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Ingryd Duarte
 */
public class ModuloConexao {
    public static Connection conector() { // Criando método com nome de: conector

        java.sql.Connection conexao = null; //variável com nome de: conexao

        try {
            Class.forName(BD_DRIVER);
            conexao = DriverManager.getConnection(BD_URL, BD_USUARIO, BD_SENHA);
            return conexao;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado", e);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }
}