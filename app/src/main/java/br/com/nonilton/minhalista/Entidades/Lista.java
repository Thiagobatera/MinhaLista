package br.com.nonilton.minhalista.Entidades;

/**
 * Created by Nonilton Alves on 01/10/2015.
 */
public class Lista {
    private long id;
    private String nome;

    public Lista(String nome){
        this.nome = nome;
    }

    public Lista(long id, String nome){
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
