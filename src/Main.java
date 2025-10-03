import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        int ver = 0;
        int opcao = 0;
        int user = 0;
        int livro = 0;
        int certo = 0;
        int certo2 = 0;
        int idEmprestimo = 0;
        String nometitulo = "";
        String autor = "";
        String email = "";
        //dados mocados:
        Biblioteca.adicionarLivro(new Livro(1,"Cinquenta tons de cinza", "Jaqueline", true));
        Biblioteca.adicionarLivro(new Livro(2,"Crepusculo", "Jeniffer", true));
        Biblioteca.adicionarLivro(new Livro(3,"Harry Potter", "JK Rolling", true));
        Biblioteca.adicionarLivro(new Livro(4,"Veradades dificeis de ouvir", "Josephine", true));
        Biblioteca.adicionarLivro(new Livro(5,"Café com Deus Pai", "João", true));
        Biblioteca.adicionarUsuarioAlu(new Aluno(1, "Lucas", "lucas@gmail.com", 0));
        Biblioteca.adicionarUsuarioAlu(new Aluno(2, "Lyan", "lyaozinhocabritinho@gmail.com", 0));
        Biblioteca.adicionarUsuarioAlu(new Aluno(3, "Nathalia", "estolionathalia@gmail.com", 0));
        Biblioteca.adicionarUsuarioProf(new Professor(4, "Lucas", "lucas@gmail.com", 0));
        Biblioteca.adicionarUsuarioProf(new Professor(5, "Fiama", "fiama@gmail.com", 0));
        Biblioteca.adicionarUsuarioProf(new Professor(6, "Gal", "Gal@gmail.com", 0));



        Biblioteca.lista();
        //Biblioteca.adicionarUsuarioProf(5, "Lucas", "lucaslima@gmail.com", 0);
        //Biblioteca.adicionarUsuarioProf(6, "Gal", "galdiback@gmail.com", 0);

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
                    int id = 6;
                    do{
                    switch (opcao){
                        case 1:Biblioteca.adicionarUsuarioProf(new Professor(id++, sc.next(), sc.next(), 0));
                        break;
                        case 2: Biblioteca.adicionarUsuarioAlu(new Aluno(id++, sc.next(), sc.next(), 0));
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
                        for (Livro livros: Biblioteca.livros){
                            certo++;
                            if (livros.getCodigo() == livro){
                                break;
                            }
                        }
                        if (Biblioteca.livros.get(certo-1).isStatus() == false){
                            System.out.println("Livro indisponivel");
                        }else {
                        System.out.println("Id do usuario para qual deseja emprestar: ");
                        user = sc.nextInt();
                        Biblioteca.emprestarLivro(certo);
                        for (Usuario usuarios : Biblioteca.users){
                            certo2++;
                            if (usuarios.getId() == user){
                                break;
                            }
                        }
                        if (Biblioteca.users.get(certo2-1).getNumeroLivros()+1 > Biblioteca.users.get(certo2-1).getLimiteEmprestimo()){
                            System.out.println("Limite de emprestimos atingido para esse usuario. ");
                        }else {
                        Biblioteca.users.get(certo2-1).addEmprest();
                        Emprestimo.emprestimo(idEmprestimo++,Biblioteca.users.get(certo2-1), Biblioteca.livros.get(certo-1), "01/10/2025", "01/11/2015");
                            Emprestimo.emprestimos.forEach(System.out::println);
                            System.out.printf(""" 
                                Emprestimo feito com sucesso!
                                Livro: %s
                                Codigo do livro: %d
                                Usuario: %s
                                Id do usuario: %d
                                Data do emprestimo: %s
                                Data de devolução: %s
                                """, Biblioteca.livros.get(certo-1).getTitulo(),Biblioteca.livros.get(certo-1).getCodigo(), Biblioteca.users.get(certo2-1).getNome(),Biblioteca.users.get(certo2-1).getId(), "01/10/2025", "01/11/2015");
                        }
                        }
                        certo = 0;
                        certo2 = 0;
                        break;
                        case 4:
                            System.out.println("Qual livro deseja devolver?: ");
                            livro = sc.nextInt();
                            System.out.println("Id do usuario para qual deseja devolver: ");
                            user = sc.nextInt();
                            for (Livro livros: Biblioteca.livros){
                                certo++;
                                if (livros.getCodigo() == livro){
                                    break;
                                }
                            }
                            for (Usuario usuarios : Biblioteca.users){
                                certo2++;
                                if (usuarios.getId() == user){
                                    break;
                                }
                            }
                            Biblioteca.devolverLivro(Biblioteca.users.get(certo2-1), certo-1);
                            for (int i = 0; i < Emprestimo.emprestimos.size(); i++){
                                if (Emprestimo.emprestimos.get(i).getLivro().getCodigo() == Biblioteca.livros.get(certo-1).getCodigo()){
                                    idEmprestimo = i;
                                    break;
                                }
                                Emprestimo.emprestimos.remove(idEmprestimo);
                                System.out.printf(""" 
                                Devolução feita com sucesso!
                                Livro: %s
                                Codigo do livro: %d
                                Usuario: %s
                                Id do usuario: %d
                                Data do emprestimo: %s
                                Data de devolução: %s
                                """, Biblioteca.livros.get(certo-1).getTitulo(),Biblioteca.livros.get(certo-1).getCodigo(), Biblioteca.users.get(certo2-1).getNome(),Biblioteca.users.get(certo2-1).getId(), "01/10/2025", "01/11/2015");
                            }
                            certo = 0;
                            certo2 = 0;
                            break;
                            case 5:
                                ver = 0;

            }

        }while (ver != 0);
    }
}