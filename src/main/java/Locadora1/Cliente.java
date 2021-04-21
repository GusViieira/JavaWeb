package Locadora1;

import java.util.Scanner;

public class Cliente extends Usuario {

    private int idCliente;
    private Carro carAlug;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Carro getCarAlug() {
        return carAlug;
    }

    public void setCarAlug(Carro carAlug) {
        this.carAlug = carAlug;
    }

    // ver a lista e selecionar um carro
    public void alugarCarro() { // passar a lista de carros

    }

    // ele mostra um print dos dados de carro de um cliente
    public void verCarroAlug() {
        System.out.printf(" -----------------------\n" +
                          "|   LOCADORA PAO DURO   |\n" +
                          "-----------------------\n" +
                          "|     Carro alugado     |\n" +
                          "-----------------------\n" +
                          "|Modelo: %s\n" +
                          "|Cor: %s\n" +
                          "|Ano do ve\u00edculo: %s\n" +
                          "|Descri\u00e7\u00e3o: %s\n" +
                          "|Valor do carro: R$ %.2f\n" +
                          "-----------------------\n",
                this.getCarAlug().getModelo(),
                this.getCarAlug().getCor(),
                this.getCarAlug().getAno(),
                this.getCarAlug().getDescricao(),
                this.getCarAlug().getValor());
    }

}
