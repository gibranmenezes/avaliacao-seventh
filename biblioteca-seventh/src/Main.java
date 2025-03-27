import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
       Biblioteca biblioteca = new Biblioteca();
       BibliotecaService service = new BibliotecaService(biblioteca);
       service.iniciarMenu();
    }

}