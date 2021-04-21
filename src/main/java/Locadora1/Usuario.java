package Locadora1;

import java.util.Scanner;

public class Usuario {

    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void Cadastrar(Scanner leitor) {
        System.out.println("Informe o nome: ");
        this.nome = leitor.next();
        System.out.println("Informe o email: ");
        this.email = leitor.next();
        System.out.println("Informe a senha: ");
        this.senha = leitor.next();
    }

    /*public boolean Login (String email, String senha){
        boolean valid = false;
        if(email.equals(this.email)){
            valid = true;
        }
        return valid;
    }*/
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

    // metodo para editar as informações do usuario
    public void editarPerfil(Scanner scan) {
        int aux;
        do {
            do { // verifica e valida a digitação da opcao para editar
                System.out.println("\n");
                System.out.println(this.toString()); // para testes
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", Main.textosProntos(2));
                aux = Integer.parseInt(Main.lerDados(scan, "Digite um valor: "));
            } while (!Main.verOpcao(aux, 0, 3));
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
