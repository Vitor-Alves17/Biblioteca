import java.util.List;

public class Professor extends Usuario{

    public Professor(int id,String nome, String email, int numeroLivros) {
        super(id, nome, email,  numeroLivros);
    }

    public Professor() {
    }


    @Override
    public int getLimiteEmprestimo() {
        return 5;
    }

}
