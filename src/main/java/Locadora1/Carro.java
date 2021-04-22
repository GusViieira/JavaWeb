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
    
    public static void cadastrarCarro(Scanner scan, ArrayList carros){
        Carro car = new Carro();
        if (car.obterCarro(scan)){
            car.setIdCarro(carros.size()+1);
            car.setDispCarro(true);
            carros.add(car);
        }
    }
}
