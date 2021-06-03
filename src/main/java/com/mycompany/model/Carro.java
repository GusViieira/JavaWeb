package com.mycompany.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Carro extends CaractCarro {    //HERANÇA DE CARACTCARRO

    private int idCarro;
    private boolean dispCarro;

//-------------------------------------------------------------------------------------------------------------------

    //CONSTRUTORES DE CARRO
    public Carro(String modelo, String cor, String ano, String descricao, float valor) {
        super(modelo, cor, ano, descricao, valor);
    }

    public Carro() {
        super();
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO GET iDCarro
    public int getIdCarro() {
        return idCarro;
    }

    //METODO SET iDCarro
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    //METODO GET dispCarro
    public boolean isDispCarro() {
        return dispCarro;
    }

    //METODO SET dispCarro
    public void setDispCarro(boolean dispCarro) {
        this.dispCarro = dispCarro;
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO PARA CADASTRAR CARRO
    public static void cadastrarCarro(Scanner scan, ArrayList<Carro> carros) {
        Carro car = new Carro();
        if (car.obterCarro(scan)) {
            car.setIdCarro(carros.size() + 1); // idCarro vai de 1 para cima
            car.setDispCarro(true);
            carros.add(car);
        }
    }

    //  METODO PARA EXIBIR INFORMACOES DO CARRO: idCarro - modelo - ano - valor
    public String toString() {
        return "IDCarro = " + this.getIdCarro() + "|" +
               "Modelo = " + super.getModelo() + "|" +
               "Ano = " + super.getAno() + "|" +
               "Valor = R$" + super.getValor();
    }

}
