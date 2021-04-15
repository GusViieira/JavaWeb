package Locadora1;
import java.util.Random;
public class Carro {
    private int id;
    private CaractCarros ctCarro;
    private boolean status;
    
    Random idRandom = new Random();
    
    public Carro(CaractCarros ctCarro, boolean status) {
        this.id = idRandom.nextInt(100) * 10;
        this.ctCarro = ctCarro;
        this.status = status;
    }
    
    public void Cadastrar (CaractCarros ctCarro, boolean status){
        this.id = idRandom.nextInt(1000);
        this.ctCarro = ctCarro;
        this.status = status;
    }
    
    public void Alterar (){
        this.ctCarro = ctCarro;
        this.status = status;
    }
    
    public void Excluir (){
            this.id = 0;
            this.ctCarro = null;
            this.status = false;
    }
    
    public CaractCarros getCtCarro() {
        return ctCarro;
    }
    
    public void setCtCarro(CaractCarros ctCarro) {
        this.ctCarro = ctCarro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + "\n\n\n" +this.ctCarro +"\n\n\nStatus: " + this.status;
    }
}