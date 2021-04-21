package Locadora1;

public class Carro extends CaractCarro {

    private int idCarro;
    private boolean dispCarro;

    public Carro(String modelo, String cor, String ano, String descricao, float valor) {
        super(modelo, cor, ano, descricao, valor);
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

}
