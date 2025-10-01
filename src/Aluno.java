import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario{
    public Aluno(int id, String nome, String email) {
         super(id, nome, email);
    }

    public Aluno() {
    }

    @Override
    public int getLimiteEmprestimo() {
        return 2;
    }


}
