import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
       static List<Livro> livros = new ArrayList<>();
       static List<Usuario> users = new ArrayList<>();


    public static void lista(){
        for (Usuario u : users) {

            System.out.println(u.getId() + u.toString());
        }
    }

    public static void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    public static void adicionarUsuarioProf(Usuario u){
        users.add(u);
    }
    public static void adicionarUsuarioAlu(Usuario u){
        users.add(u);
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
                Biblioteca.users.get(user.getId()).removeEmprest();
            }
        }
    }
}
