import java.util.*;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        if (livros.contains(livro)) {
            System.out.println("OPERAÇÃO NÃO CONCLUÍDA: Livro já cadastrado!");
        } else {
            livros.add(livro);
            System.out.println("Livro cadastrado com sucesso!");
        }
    }

    public Optional<List<Livro>> listarLivros() {
        return livros.isEmpty() ?
                Optional.empty() :
                Optional.of(livros);
    }

    public Optional<Livro> buscarLivroPorTitulo(String titulo) {
        return livros.stream()
        .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
        .findFirst();
    }
}
