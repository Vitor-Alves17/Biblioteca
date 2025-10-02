import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
       static ArrayList<Livro> livros = new ArrayList<>();
       static ArrayList<Usuario> users = new ArrayList<>();



    public static void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    public static void adicionarUsuarioProf(int idProfessor, String nome, String email, int numeroLivros){
        users.add(new Professor(idProfessor, nome, email, numeroLivros));
    }
    public static void adicionarUsuarioAlu(int idAluno, String nome, String email, int numeroLivros){
        users.add(new Aluno(idAluno, nome, email, numeroLivros));
    }
    public static void emprestarLivro(int codigo){
        for (Livro livro : livros){
            if (livro.getCodigo() == codigo){
                if(livro.isStatus() == true){
                    livro.setStatus(false);
                } else {
                    System.out.println("Livro Indisponivel");
                }
            }
        }
    }
    public static void devolverLivro(Usuario user, int codigo){
        for (Livro livro : livros){
            if (livro.getCodigo() == codigo){
                if(livro.isStatus() == false){
                    livro.setStatus(true);
                } else  {
                    System.out.println("Livro já Disponivel");
                }
            }
        }
    }
}
