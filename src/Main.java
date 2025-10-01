import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario prof = new Professor();
        Usuario aluno = new Aluno();

        int ver = 0;
        int opcao = 0;
        int user = 0;
        int livro = 0;
        int certo = 0;
        int certo2 = 0;
        String nometitulo = "";
        String autor = "";
        String email = "";
        //dados mocados:
        Biblioteca.adicionarLivro(new Livro(1,"Cinquenta tons de cinza", "Jaqueline", true));
        Biblioteca.adicionarLivro(new Livro(2,"Crepusculo", "Jeniffer", true));
        Biblioteca.adicionarLivro(new Livro(3,"Harry Potter", "JK Rolling", true));
        Biblioteca.adicionarLivro(new Livro(4,"Veradades dificeis de ouvir", "Josephine", true));
        Biblioteca.adicionarLivro(new Livro(5,"Café com Deus Pai", "João", true));
        Biblioteca.adicionarUsuarioAlu(new Aluno(1, "Lucas", "lucasn@gmail.com"));
        Biblioteca.adicionarUsuarioAlu(new Aluno(2, "Lyan", "lyaozinhocabritinho@gmail.com"));
        Biblioteca.adicionarUsuarioAlu(new Aluno(3, "Nathalia", "estolionathalia@gmail.com"));
        Biblioteca.adicionarUsuarioAlu(new Professor(4, "Fiama", "fiama@gmail.com"));
        Biblioteca.adicionarUsuarioAlu(new Professor(5, "Lucas", "lucaslima@gmail.com"));
        Biblioteca.adicionarUsuarioAlu(new Professor(6, "Gal", "galdiback@gmail.com"));

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
                        System.out.println("Qual livro deseja emprestar?: ");
                        livro = sc.nextInt();
                        System.out.println("Id do usuario para qual deseja emprestar: ");
                        user = sc.nextInt();
                        for (Livro livros: Biblioteca.livros){
                            certo++;
                            if (livros.getCodigo() == livro){
                                break;
                            }
                        }
                        Biblioteca.emprestarLivro(certo);
                        for (Usuario usuarios : Biblioteca.users){
                            certo2++;
                            if (usuarios.getId() == user){
                                break;
                            }
                        }
                        Emprestimo.emprestimo(Biblioteca.users.get(certo2-1), Biblioteca.livros.get(certo-1), "01/10/2025", "01/11/2015");
                        certo = 0;
                        certo2 = 0;
                        break;
                        case 4:
            }

        }while (ver != 0);
    }
}