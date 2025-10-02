import java.util.ArrayList;

abstract class Usuario {
    private int id;
    private String nome;
    private String email;
    private int numeroLivros;

    public Usuario(int id, String nome, String email,  int numeroLivros) {
    }
    public Usuario(){
    }


    abstract public int getLimiteEmprestimo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumeroLivros() {
        return numeroLivros;
    }

    public void addNumeroLivros(int numeroLivros) {
        this.numeroLivros = numeroLivros;
    }
    public void addEmprest() {
        this.numeroLivros++;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", numeroLivros=" + numeroLivros +
                '}';
    }
}
