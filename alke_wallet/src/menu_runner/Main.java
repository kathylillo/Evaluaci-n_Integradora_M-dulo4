package menu_runner;
/**
 * Import de Package servicio_cuenta
 */
import servicio_cuenta.*;

/**
 * Clase principal que contiene el método main para iniciar la aplicación.
 */
public class Main {
	public static void main(String[] args) {
	//Instancia de AccountServiceImpl y UsuarioMenu
	CuentaServicio accountService = new CuentaServicioImpl();
    UsuarioMenu menu = new UsuarioMenu(accountService);

    menu.displayMenu();   // Mostrar el menú principal
    menu.closeScanner();  // Cerrar el scanner al finalizar la ejecución
} 

} 
