/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;


import DAO.CategoriaDAO;
import models.Categoria;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author INGRYD
 * Os testes tao com baseados no banco real (por enquanto)
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteCategoriaDAO {

    static CategoriaDAO dao;
    static int idCategoriaCriada;

    @BeforeAll
    public static void setup() {
        dao = new CategoriaDAO();
    }

    @Test
    @Order(1)
    public void testInserir() {
        boolean resultado = dao.inserir("Categoria Teste");

        assertTrue(resultado, "A inserção deveria retornar true");

        List<Categoria> lista = dao.obterTodas();
        assertFalse(lista.isEmpty());

        idCategoriaCriada = lista.get(lista.size() - 1).getId();

        System.out.println("ID criado: " + idCategoriaCriada);
    }

    @Test
    @Order(2)
    public void testObterTodas() {
        List<Categoria> lista = dao.obterTodas();

        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test
    @Order(3)
    public void testObterPorId() {
        Categoria cat = dao.obter(idCategoriaCriada);

        assertNotNull(cat);
        assertEquals(idCategoriaCriada, cat.getId());
    }

    @Test
    @Order(4)
    public void testAtualizar() {
        boolean atualizado = dao.atualizar(idCategoriaCriada, "Categoria Alterada");

        assertTrue(atualizado);

        Categoria cat = dao.obter(idCategoriaCriada);
        assertEquals("Categoria Alterada", cat.getNome());
    }

    @Test
    @Order(5)
    public void testRemover() {
        boolean removido = dao.remover(idCategoriaCriada);

        assertTrue(removido);

        Categoria cat = dao.obter(idCategoriaCriada);
        assertNull(cat);
    }
}