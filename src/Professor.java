import java.util.List;

public class Professor extends Usuario{

    public Professor(int id,String nome, String email) {
        super(id, nome, email);
    }

    public Professor() {
    }


    @Override
    public int getLimiteEmprestimo() {
        return 5;
    }

}
