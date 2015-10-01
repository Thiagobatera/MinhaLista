package br.com.nonilton.minhalista.Entidades;

/**
 * Created by Nonilton Alves on 01/10/2015.
 */
public class Produto {
    private long id;
    private String nome;

    public Produto(String nome){
        this.nome = nome;
    }

    public Produto (long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
