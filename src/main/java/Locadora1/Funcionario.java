package Locadora1;

import java.util.Scanner;

public class Funcionario extends Usuario {
    private int idFuncionario;
    
    private Carro editarCarro;

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Carro getEditarCarro() {
        return editarCarro;
    }

    public void setEditarCarro(Carro editarCarro) {
        this.editarCarro = editarCarro;
    }

}