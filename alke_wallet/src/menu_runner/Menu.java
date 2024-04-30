package menu_runner;
/**
 * Import de clase Scanner
 */
import java.util.Scanner;
/**
 * Clase abstracta Menu que define métodos para mostrar un menú en la consola
 */
public abstract class Menu {
	protected Scanner scanner;


    /**
     * Constructor que inicializa un objeto Scanner para entrada de usuario.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método abstracto para mostrar el contenido del menú en la consola.
     */
    public abstract void displayMenu();

    /**
     * Obtiene la opción seleccionada por el usuario desde la consola.
     *
     * @return la opción seleccionada por el usuario como un entero.
     */
    public int getUserChoice() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    /**
     * Limpia la pantalla de la consola.
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * Cierra el objeto Scanner utilizado para la entrada de usuario.
     */
    public void closeScanner() {
        scanner.close();
    }
}


