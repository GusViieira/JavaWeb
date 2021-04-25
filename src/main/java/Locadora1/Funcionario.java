package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Usuario {

    private Carro editarCarro;

    public Funcionario(String nome, String email, String senha, int idUsuario) {
        super(nome, email, senha, idUsuario); // ID tem que ser NEGATIVO para funcionario
    }

    public Carro getEditarCarro() {
        return editarCarro;
    }

    public void setEditarCarro(Carro editarCarro) {
        this.editarCarro = editarCarro;
    }

    // metodo para todas as funcionalidades de funcionario
    public static void metodosFuncionario(Scanner scan, int logar, Funcionario f1, Funcionario f2, ArrayList<Carro> carros) {
        String opc;
        do {
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO", Main.textosProntos(7));//|0 - Sair |1 - Editar Perfil |2 - Cadastrar Carro|3 - Listar Carros |4 - Editar Carro
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":
                    break;
                case "1":// Editar Perfil do Funcionario
                    if (f1.getIdUsuario() == logar)
                        f1.editarPerfil(scan);
                    else
                        f2.editarPerfil(scan);
                    break;
                case "2":// Cadastrar Carro
                    Carro.cadastrarCarro(scan, carros);
                    break;
                case "3":// Listar Carros
                    Main.telasLocadora("LOCADORA PAO DURO", "LISTAR CARRO", Carro.listarCarros(carros));
                    break;
                case "4": // Editar Carro
                    Main.telasLocadora("LOCADORA PAO DURO", "EDITAR CARRO", Carro.listarCarros(carros));
                    int pesq = Integer.parseInt(Main.lerDados(scan, "Escolha um carro (ou -1 para sair): "));
                    if (pesq != -1) {
                        int index = Main.indexOfIdCarro(carros, pesq);
                        carros.get(index).editarCarro(scan);
                    }
                    break;
            }
        } while (!opc.equals("0"));
    }
}