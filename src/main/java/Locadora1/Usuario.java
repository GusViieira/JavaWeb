package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private int idUsuario;

//-------------------------------------------------------------------------------------------------------------------

    //CONTRUTORES DE FUNCIONARIOS
    public Usuario(String nome, String email, String senha, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    public Usuario() {

    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO GET nome
    public String getNome() {
        return nome;
    }

    //METODO SET nome
    public void setNome(String nome) {
        nome = nome.trim();
        this.nome = nome;
    }

    //METODO GET email
    public String getEmail() {
        return email;
    }

    //METODO SET email
    public void setEmail(String email) {
        email = email.trim();
        this.email = email;
    }

    //METODO GET senha
    public String getSenha() {
        return senha;
    }

    //METODO SET senga
    public void setSenha(String senha) {
        senha = senha.trim();
        this.senha = senha;
    }

    //METODO GET IdUsuario
    public int getIdUsuario() {
        return idUsuario;
    }

    //METODO SET IdUsuario
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO PARA CADASTRAR AS INFORMACOES DE USUARIO
    public boolean cadastrarUsuario(Scanner scan) {
        Cliente cl = new Cliente();
        Main.telasLocadora("LOCADORA PAO DURO", "CADASTRAR USUARIO", Main.textosProntos(6));
        cl.setNome(Main.lerDados(scan, "Informe o nome (ou '-1' para sair): "));
        if (!cl.getNome().equals("-1")) {
            cl.setEmail(Main.lerDados(scan, "Informe o email (ou '-1' para sair):  "));
            if (!cl.getEmail().equals("-1")) {
                cl.setSenha(Main.lerDados(scan, "Informe a senha (ou '-1' para sair): "));
                if (!cl.getSenha().equals("-1")) {  //COLOCAR OS DADOS DENTRO DOS ELEMENTOS DO OBJETO USUARIO (CLIENTE/FUNCIONARIO)
                    this.setNome(cl.getNome());
                    this.setEmail(cl.getEmail());
                    this.setSenha(cl.getSenha());
                    return true;    //CADASTRO OCORREU CORRETAMENTE
                }
            }
        }
        return false;   //CADASTRO NAO OCORREU
    }

    //METODO PARA TELA DE LOGIN
    public static int login(Scanner scan, ArrayList<Cliente> clientes, Funcionario f1, Funcionario f2) {
        String login, senha;    //LOGIN: 0 - INICIALIZADO LOGAR; -1 - VALOR INCORRETO; OUTRO VALOR POSITIVO - POSICAO (INDEX) DO CLIENTE
        Main.telasLocadora("LOCADORA PAO DURO", "LOGIN", Main.textosProntos(3));
        int logar = 0;
        do {
            login = Main.lerDados(scan, "Informe o Email (ou '-1' para sair): ");
            if (!login.equals("-1")) {
                senha = Main.lerDados(scan, "Informe a senha (ou '-1' para sair): ");
                if (!senha.equals("-1"))
                    logar = Usuario.verLogin(login, senha, clientes, f1, f2); //VERIFICACAO DOS DADOS DE LOGIN
            }
            if(logar == -1)     //VALOR INCORRETO
                System.out.println("Valor incorreto\tTente novamente...");
        } while (logar == -1);  //VALIDACAO DE VALOR INCORRETO
        return logar;
    }

    //VALIDACAO DE LOGIN
    public static int verLogin(String email, String senha, ArrayList<Cliente> clientes, Funcionario f1, Funcionario f2) {
        int valid = 0; // 0 - ACESSO NEGADO SENAO RETORNA ID DE USUARIO OU FUNCIONARIO
        if (email.equals(f1.getEmail()) && senha.equals(f1.getSenha()))     // VERIFICA LOGIN DE FUNCIONARIO F1
            valid = f1.getIdUsuario();
        if (email.equals(f2.getEmail()) && senha.equals(f1.getSenha()))     // VERIFICA LOGIN DE FUNCIONARIO F2
            valid = f2.getIdUsuario();
        for (Cliente aux : clientes)    // VERIFICA LOGIN DE CLIENTE
            if (email.equals(aux.getEmail()) && senha.equals(aux.getSenha())) {
                valid = aux.getIdUsuario();
                break;
            }
        return valid;
    }

    //METODO PARA EDITAR CLIENTE
    public void editarPerfil(Scanner scan) {
        int aux;
        do {
            do { // VALIDACAO DIGITADA PELO CLIENTE
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", Main.textosProntos(2));
                aux = Integer.parseInt(Main.lerDados(scan, "Digite um valor: "));
            } while (Main.verOpcao(aux, 0, 3));
            if (aux != 0)
                switch (aux) {// USA O METODO PARA EDITAR AS METO DO USUARIO
                    case 1 -> this.editarAtributoUsuario(scan, "nome");
                    case 2 -> this.editarAtributoUsuario(scan, "email");
                    case 3 -> this.editarAtributoUsuario(scan, "senha");
                }
            else
                System.out.println();
        } while (aux != 0);
    }

    //METODO PARA EDITAR AS CARACTERISTICAS(ATRIBUTOS) DE USUARIO
    public void editarAtributoUsuario(Scanner scan, String str) {   //str -> QUAL TIPO IRA EDITAR
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) { //MUDA A STRING ANT PARA APRESENTAR VALOR ANTIGO DA STRING QUE IRA EDITAR
            case "nome" -> ant = ant.concat(this.getNome());
            case "email" -> ant = ant.concat(this.getEmail());
            case "senha" -> ant = ant.concat(this.getSenha());
        }
        Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", ant);
        frase = Main.lerDados(scan, "Digite o " + str + " (ou '-1' para sair): ");//VERIFICA E VALIDA A DIGITACAO DA NOVA STRING
        if (!frase.equals("-1"))
            switch (str) {  //ATUALIZA A NOVA STRING
                case "nome" -> this.setNome(frase);
                case "email" -> this.setEmail(frase);
                case "senha" -> this.setSenha(frase);
            }
    }

}
