package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private int idUsuario;

    public Usuario(String nome, String email, String senha, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    public Usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome.trim();
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        senha = senha.trim();
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean cadastrarUsuario(Scanner scan) {
        Cliente cl = new Cliente();
        Main.telasLocadora("LOCADORA PAO DURO", "CADASTRAR USUARIO", Main.textosProntos(6));
        cl.setNome(Main.lerDados(scan, "Informe o nome (ou '-1' para sair): "));
        if (!cl.getNome().equals("-1")) {
            cl.setEmail(Main.lerDados(scan, "Informe o email (ou '-1' para sair):  "));
            if (!cl.getEmail().equals("-1")) {
                cl.setSenha(Main.lerDados(scan, "Informe a senha (ou '-1' para sair): "));
                if (!cl.getSenha().equals("-1")) { // colocar os dados dentro de um dos elementos do objeto
                    this.setNome(cl.getNome());
                    this.setEmail(cl.getEmail());
                    this.setSenha(cl.getSenha());
                    return true; // cadastro ocorreu de forma correta
                }
            }
        }
        return false;// cadastro não ocorreu
    }

    // metodo para tela de login, sendo o retorno para funcionario
    public static int login(Scanner scan, ArrayList<Cliente> clientes, Funcionario f1, Funcionario f2) {
        String login, senha;
        Main.telasLocadora("LOCADORA PAO DURO", "LOGIN", Main.textosProntos(9));
        int logar = 0; // inicializando o logar
        do {
            login = Main.lerDados(scan, "Informe o Email (ou '-1' para sair): ");
            if (!login.equals("-1")) {
                senha = Main.lerDados(scan, "Informe a senha (ou '-1' para sair): ");
                if (!senha.equals("-1"))
                    logar = Usuario.verLogin(login, senha, clientes, f1, f2);
            }
            if(logar == -1) // valor incorreto
                System.out.println("Valor incorreto\tTente novamente...");
        } while (logar == -1);
        return logar;
    }

    // validacao de login
    public static int verLogin(String email, String senha, ArrayList<Cliente> clientes, Funcionario f1, Funcionario f2) {
        int valid = 0; // 0 - acesso negado, ID de acesso de cliente ou funcionario
        if (email.equals(f1.getEmail()) && senha.equals(f1.getSenha())) // verifica login de funcionario1
            valid = f1.getIdUsuario();

        if (email.equals(f2.getEmail()) && senha.equals(f1.getSenha())) // verifica login de funcionario2
            valid = f2.getIdUsuario();

        for (Cliente aux : clientes) // verifica login de cliente
            if (email.equals(aux.getEmail()) && senha.equals(aux.getSenha())) {
                valid = aux.getIdUsuario();
                break;
            }
        return valid;
    }

    // metodo para editar as informações do usuario
    public void editarPerfil(Scanner scan) {
        int aux;
        do {
            do { // verifica e valida a digitação da opcao para editar
                System.out.println("\n");
                System.out.println(this.toString()); // para testes
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", Main.textosProntos(2));
                aux = Integer.parseInt(Main.lerDados(scan, "Digite um valor: "));
            } while (Main.verOpcao(aux, 0, 3));
            if (aux != 0)
                switch (aux) {//vai para o metodo de editar o atributo do usuario
                    case 1 -> this.editarAtributoUsuario(scan, "nome");
                    case 2 -> this.editarAtributoUsuario(scan, "email");
                    case 3 -> this.editarAtributoUsuario(scan, "senha");
                }
            else
                System.out.println();
        } while (aux != 0);
    }

    public void editarAtributoUsuario(Scanner scan, String str) { // str -> Qual tipo ira editar
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) { // personalizar a string ant para apresentar na tela o valor antigo da string que esta editando
            case "nome" -> ant = ant.concat(this.getNome());
            case "email" -> ant = ant.concat(this.getEmail());
            case "senha" -> ant = ant.concat(this.getSenha());
        }
        Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", ant);
        frase = Main.lerDados(scan, "Digite o " + str + " (ou '-1' para sair): ");//verifica e valida a digitação da nova string
        if (!frase.equals("-1"))
            switch (str) { // atualiza a nova string
                case "nome" -> this.setNome(frase);
                case "email" -> this.setEmail(frase);
                case "senha" -> this.setSenha(frase);
            }
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               ", senha='" + senha + '\'' +
               '}';
    }
}
