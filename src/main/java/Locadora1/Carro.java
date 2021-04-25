package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Carro extends CaractCarro {

    private int idCarro;
    private boolean dispCarro;

    public Carro(String modelo, String cor, String ano, String descricao, float valor) {
        super(modelo, cor, ano, descricao, valor);
    }

    public Carro() {
        super();
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public boolean isDispCarro() {
        return dispCarro;
    }

    public void setDispCarro(boolean dispCarro) {
        this.dispCarro = dispCarro;
    }

    //metodo para cadastrar um novo carro
    public static void cadastrarCarro(Scanner scan, ArrayList<Carro> carros) {
        Carro car = new Carro();
        if (car.obterCarro(scan)) {
            car.setIdCarro(carros.size() + 1);
            car.setDispCarro(true);
            carros.add(car);
        }
    }

    //metodo para listar carro
    public static String listarCarros(ArrayList<Carro> carros) {
        String texto = "CODIGO   -    MODELO      -   ANO    -    VALOR\n";
        for (Carro aux : carros) {
            if (aux.isDispCarro())
                texto += aux.toString();
        }
        return texto;
    }

    //  idCarro - modelo - ano - valor
    public String toString() {
        return "IDCarro = " + this.getIdCarro() + "|" +
               "Modelo = " + super.getModelo() + "|" +
               "Ano = " + super.getAno() + "|" +
               "Valor = R$" + super.getValor() + "\n";
    }

}
