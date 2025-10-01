import java.util.ArrayList;

abstract class Usuario {
    private int id;
    private String nome;
    private String email;

    public Usuario(int id, String nome, String email) {
    }
    public Usuario(){
    }


    abstract public int getLimiteEmprestimo();
}
