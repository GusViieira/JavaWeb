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
    public void Cadastrar (Scanner leitor){
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

    @Override
    public String toString() {
        return "Usuario{" +
               "nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               ", senha='" + senha + '\'' +
               '}';
    }
}
