/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static connection.ModuloConexao.conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

/**
 *
 * @author Ingryd Duarte
 */
public class UsuarioDAO {

    /*
    * @brief Retorna todos os usuários
     */
    public List<Usuario> obterTodas() {
        List<Usuario> resultado = new ArrayList<>();

        try {
            Connection conn = conector();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, nome, endereco, login, senha, administrador, email FROM usuario"
            );

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEndereco(resultSet.getString("endereco"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAdministrador(resultSet.getBoolean("administrador"));
                usuario.setEmail(resultSet.getString("email"));

                resultado.add(usuario);
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Connection failure: " + ex.getMessage());
            return null;
        }

        return resultado;
    }

    public Usuario obter(String login) {
        Usuario usuario = null;
        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, nome, endereco, email, login, senha, administrador FROM usuario WHERE login = ?");
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEndereco(resultSet.getString("endereco"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAdministrador(resultSet.getBoolean("administrador"));
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Connection failure: " + ex.getMessage());
            return null;
        }
        return usuario;
    }
}
