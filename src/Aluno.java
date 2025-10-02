import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario{
    public Aluno(int id, String nome, String email, int numeroLivros) {

        super(id, nome, email, numeroLivros);
    }


    public Aluno() {
    }

    @Override
    public int getLimiteEmprestimo() {
        return 2;
    }


}
