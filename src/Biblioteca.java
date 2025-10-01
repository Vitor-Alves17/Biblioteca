import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
       static ArrayList<Livro> livros = new ArrayList<>();
       static ArrayList<Usuario> users = new ArrayList<>();



    public static void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    public static void adicionarUsuarioProf(Usuario usuario){
        users.add(usuario);
    }
    public static void adicionarUsuarioAlu(Usuario usuario){
        users.add(usuario);
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
