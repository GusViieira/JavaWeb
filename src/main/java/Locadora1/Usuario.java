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

    public void Cadastrar (){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        this.nome = leitor.next();
        System.out.println("Informe o email: ");
        this.email = leitor.next();
        System.out.println("Informe a senha: ");
        this.senha = leitor.next();
        leitor.close();
    }
    public boolean Login (String email, String senha){
        boolean valid = false;
        if(email.equals(this.email)){
            valid = true;
        }
        return valid;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nEmail: " + this.email + "\nSenha: " + this.senha; 
    }
}
