import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class BibliotecaService {
    private final Biblioteca biblioteca;
    private final Scanner scanner;

    public BibliotecaService(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Buscar por título");
            System.out.println("4. Carregar livros exemplo");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> listarLivros();
                case 3 -> buscarLivro();
                case 4 -> carregarExemplos();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }


    private void cadastrarLivro() {
        System.out.print("Título: ");
        String titulo = validarEntrada("Título não pode ser vazio");

        System.out.print("Autor: ");
        String autor = validarEntrada("Autor não pode ser vazio");

        System.out.print("Ano: ");
        String ano = validarEntrada("Ano não pode ser vazio");

        biblioteca.cadastrarLivro(new Livro(titulo, autor, ano));
    }

    private void listarLivros() {
        Optional<List<Livro>> livros = biblioteca.listarLivros();
        livros.ifPresentOrElse(
                lista -> lista.forEach(System.out::println),
                () -> System.out.println("Nenhum livro cadastrado!")
        );
    }

    private void buscarLivro() {
        System.out.print("Título para buscar: ");
        String titulo = scanner.nextLine();
        biblioteca.buscarLivroPorTitulo(titulo)
                .ifPresentOrElse(
                        livro -> System.out.println("Encontrado: " + livro),
                        () -> System.out.println("Livro não encontrado!")
                );
    }

    private void carregarExemplos() {
        List<Livro> exemplos = Arrays.asList(
                new Livro("Dom Casmurro", "Machado de Assis", "1899"),
                new Livro("1984", "George Orwell", "1949"),
                new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "1943")
        );

        exemplos.forEach(biblioteca::cadastrarLivro);
        System.out.println(exemplos.size() + " livros exemplo carregados!");
    }

    private String validarEntrada(String mensagemErro) {
        String entrada;
        while (true) {
            entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println(mensagemErro);
            System.out.print("Por favor, digite novamente: ");
        }
    }
}