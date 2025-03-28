import java.util.*;
import java.util.function.Predicate;

public class Main {
   public static void main(String[] args) {
       Biblioteca biblioteca = new Biblioteca();
       BibliotecaService service = new BibliotecaService(biblioteca);
       service.iniciarMenu();
    }
}