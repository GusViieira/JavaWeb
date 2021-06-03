package com.mycompany.model;

import com.mycompany.view.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Usuario implements Interface {  //HERANÇA DE USUARIO

    //CONSTRUTORES DE FUNCIONARIO
    public Funcionario(String nome, String email, String senha, int idUsuario) {
        super(nome, email, senha, idUsuario); // idUsuario TEM QUE SER NEGATIVO PARA FUNCIONARIO
    }

    public Funcionario() {
        super();
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO PARA TODAS AS FUNCIONALIDADES DE FUNCIONARIO
    public void metodosFuncionario(Scanner scan, ArrayList<Carro> carros) {
        String opc;
        do {
            System.out.println("\n\n");//PARA PULAR LINHAS
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO", Main.textosProntos(7));
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":   //SAIR
                    break;
                case "1":   // EDITAR PERFIL DO FUNCIONARIO
                    this.editarPerfil(scan);//REALIZAR POR ARRAY QUANDO IMPLEMENTAR BANCO DE DADOS.
                    break;
                case "2":   //CADASTRAR CARRO
                    Carro.cadastrarCarro(scan, carros);
                    break;
                case "3":   //LISTAR CARRO
                    System.out.println("\n\n");//PARA PULAR LINHAS
                    Main.telasLocadora("LOCADORA PAO DURO", "LISTAR CARRO", this.listarCarros(carros));
                    System.out.println("Digite qualquer coisa para voltar...");
                    scan.nextLine();
                    break;
                case "4":   //EDITAR CARRO
                    System.out.println("\n\n");     //PARA PULAR LINHAS
                    Main.telasLocadora("LOCADORA PAO DURO", "EDITAR CARRO", this.listarCarros(carros));
                    if (carros.size() != 0) {
                        int pesq;   //INICIALIZANDO pesq
                        do {
                            pesq = Integer.parseInt(Main.lerDados(scan, "Escolha um carro (ou -1 para sair): "));
                            if (pesq != -1) {
                                int index = Main.indexOfIdCarro(carros, pesq);
                                if ((index + 1) > 0) {    //SE O NUMERO DIGITADO EXISTE
                                    carros.get(index).editarCarro(scan);
                                    break;
                                } else {//SE NUMERO DIGITADO NAO EXISTIR
                                    System.out.println("NUMERO INVALIDO\tTente novamente...");
                                }
                            }
                        } while (pesq != -1);
                    } else {
                        System.out.println("Digite qualquer coisa para voltar...");
                        scan.nextLine();
                    }
                    break;
            }
        } while (!opc.equals("0"));
    }

    //METODO PARAR LISTAR CARROS
    @Override
    public String listarCarros(ArrayList<Carro> carros) {
        String texto = " CODIGO - MODELO - ANO - VALOR - DISPONIBILIDADE\n\n";
        if (carros.size() != 0) {//VERIFICA SE EXITE ALGUM CARRO CADASTRADO
            for (Carro aux : carros) {
                texto += aux.toString();
                if (aux.isDispCarro())
                    texto += "|DISPONIVEL PARA ALUGAR\n";
                else
                    texto += "|JA ALUGADO\n";
            }
        } else
            texto += "    NAO EXITE CARROS CADASTRADOS";
        return texto + "\n";   //RETORNA STRING QUE CONTEM A LISTA DE CARROS
    }
}