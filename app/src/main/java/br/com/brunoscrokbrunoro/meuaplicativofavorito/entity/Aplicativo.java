package br.com.brunoscrokbrunoro.meuaplicativofavorito.entity;

/**
 * @author Bruno Scrok Brunoro
 * @create 26/7/16 18:23
 * @project MeuAplicativoFavorito
 */
public class Aplicativo {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
