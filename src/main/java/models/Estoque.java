/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Ingryd Duarte
 */

//enum TipoProduto {
//    
//}

public class Estoque {
    private Long id;
    private String produto;
    //private String tipo;
    private Number quantidade;
    private Float precoMercado;
    private Float precoVarejo;
    
    // Construtores
    public Estoque() {}

    public Estoque(Long id, String produto, Number quantidade, Float precoMercado, Float precoVarejo) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;        
        this.precoMercado = precoMercado;
        this.precoVarejo = precoVarejo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    public Number getQuantidadeProduto() {
        return quantidade;
    }

    public void setQuantidade(Number quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setPrecoMercado(Float precoMercado) {
        this.precoMercado = precoMercado;
    }
    
    public void setPrecoVarejo(Float precoVarejo) {
        this.precoVarejo = precoVarejo;
    }
    
    public Float getPrecoMercado() {
        return precoMercado;
    }
    
    public Float getPrecoVarejo() {
        return precoVarejo;
    }
}
