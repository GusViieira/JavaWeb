package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Usuario {  //HERANÇA DE USUARIO

    //CONSTRUTOR DE FUNCIONARIO 
    public Funcionario(String nome, String email, String senha, int idUsuario) {
        super(nome, email, senha, idUsuario); // ID É NEGATIVO PARA FUNCIONARIO
    }
//-------------------------------------------------------------------------------------------------------------------

    // METODO PARA TODAS AS FUNCIONALIDADES DE FUNCIONARIO
    public static void metodosFuncionario(Scanner scan, int logar, Funcionario f1, Funcionario f2, ArrayList<Carro> carros) {
        String opc;
        do {
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO", Main.textosProntos(7));
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":   //SAIR
                    break;
                case "1":   //EDITAR PERFIL DO FUNCIONARIO
                    if (f1.getIdUsuario() == logar) //REALIZAR POR ARRAY QUANDO IMPLEMENTAR BANCO DE DADOS.
                        f1.editarPerfil(scan);
                    else
                        f2.editarPerfil(scan);      //REALIZAR POR ARRAY QUANDO IMPLEMENTAR BANCO DE DADOS.
                    break;
                case "2":   //CADASTRAR CARRO
                    Carro.cadastrarCarro(scan, carros);
                    break;
                case "3":   //LISTAR CARRO
                    Main.telasLocadora("LOCADORA PAO DURO", "LISTAR CARRO", Carro.listarCarros(carros));
                    break;
                case "4":   //EDITAR CARRO
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