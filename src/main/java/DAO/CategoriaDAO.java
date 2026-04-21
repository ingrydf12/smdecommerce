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
import java.util.ArrayList;
import java.util.List;
import models.Categoria;

/**
 * 
 * @author INGRYD
 */
public class CategoriaDAO {

    /**
     * Retorna todas as categorias
     * @return []
     */
    public List<Categoria> obterTodas() {
        List<Categoria> resultado = new ArrayList<>();

        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, nome FROM categoria");
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));

                resultado.add(categoria);
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Connection failure: " + ex.getMessage());
            return new ArrayList<>();
        }

        return resultado;
    }

    /**
     * Retorna uma categoria pelo ID
     * @param id
     * @return categoria
     */
    public Categoria obter(int id) {
        Categoria categoria = null;

        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT id, nome FROM categoria WHERE id = ?"
            );

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Falha de conexáo com o banco: " + ex.getMessage());
            return null;
        }

        return categoria;
    }

    /**
     * Insere uma nova categoria
     * @param nome
     */
    public boolean inserir(String nome) {
        boolean sucesso = false;

        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO categoria (nome) VALUES (?)"
            );

            preparedStatement.setString(1, nome);

            sucesso = (preparedStatement.executeUpdate() == 1);

            preparedStatement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Falha de conexáo com o banco: " + ex.getMessage());
            throw new RuntimeException("Erro ao inserir categoria", ex);
        }

        return sucesso;
    }

    /**
     * Atualiza uma categoria pelo ID
     * @param id, @para nome
     * @return 
     */
    public boolean atualizar(int id, String nome) {
        boolean sucesso = false;

        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE categoria SET nome = ? WHERE id = ?"
            );

            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, id);

            sucesso = (preparedStatement.executeUpdate() == 1);

            preparedStatement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Falha de conexáo com o banco: " + ex.getMessage());
            throw new RuntimeException("Erro ao atualizar categoria", ex);
        }

        return sucesso;
    }

    /**
     * Remove uma categoria pelo ID
     * @param id
     * @return 
     */
    public boolean remover(int id) {
        boolean sucesso = false;

        try {
            Connection conn = conector();
            PreparedStatement preparedStatement = conn.prepareStatement(
                "DELETE FROM categoria WHERE id = ?"
            );

            preparedStatement.setInt(1, id);

            sucesso = (preparedStatement.executeUpdate() == 1);

            preparedStatement.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Falha de conexáo com o banco: " + ex.getMessage());
            throw new RuntimeException("Erro ao remover categoria", ex);
        }

        return sucesso;
    }
}