import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario prof = new Professor();
        Usuario aluno = new Aluno();

        int ver = 0;
        int opcao = 0;



        do{
            System.out.println("""
                    Qual operaçãodeseja realizar?:
                    1 -> Adiconar Livro
                    2 -> Adicionar Usuario
                    3 -> Emprestar Livro
                    4 -> Devolver Livro
                    5 -> Sair
                    """);
            ver = sc.nextInt();
            switch (ver){
                case 1:
                    Biblioteca.adicionarLivro(new Livro(sc.next(), sc.next(), true));
                break;
                case 2:
                    System.out.println("""
                            Qual tipo de user deseja adicionar?:
                            1 -> Adicionar Professor
                            2 -> Adicionar Aluno
                            """);
                    opcao = sc.nextInt();
                    while (opcao != 1 && opcao != 2 && opcao != 0) {
                        System.out.println("Digito invalido, tente novamente");
                    }
                    int id = 0;
                    do{
                    switch (opcao){
                        case 1:Biblioteca.adicionarUsuarioProf(new Aluno(id++, sc.next(), sc.next()));
                        break;
                        case 2: Biblioteca.adicionarUsuarioAlu(new Professor(id++, sc.next(), sc.next()));
                    }
                        System.out.println("""
                                Deseja adiconar outro Usuario?:
                                1 -> Adicionar Aluno
                                2 -> Adicionar Professor
                                0 -> Sair
                                """);
                    opcao = sc.nextInt();
                    while (opcao != 0 && opcao != 2 && opcao != 1) {
                        System.out.println("Digito invalido, tente novamente");
                    }
                    }while(opcao != 0);
                    break;
                    case 3:
            }

        }while (ver != 0);
    }
}