import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Emprestimo {
    static List<Emprestimo> emprestimos = new ArrayList<>();
    private Usuario usuario;
    private Livro livro;
    private String dataEmprestimo;
    private String dataDevolucao;



    public Emprestimo(Usuario usuario, Livro livro, String dataEmprestimo, String dataDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public static void emprestimo(Usuario usuario, Livro livro, String dataEmprestimo, String dataDevolucao ) {
        emprestimos.add(new Emprestimo(usuario, livro, dataEmprestimo, dataDevolucao));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
