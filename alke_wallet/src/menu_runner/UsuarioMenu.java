package menu_runner;
/**
 * Import de Package de servicio_cuenta y usuario 
 */
import servicio_cuenta.*;
import usuario.*;
/**
 * Clase UsuarioMenu que hereda de Menu y representa un menú específico para usuario.
 */
public class UsuarioMenu extends Menu{
	    private CuentaServicio accountService;
	    private UsuarioCuenta currentUser;
	    /**
	     * Constructor que inicializa un objeto UsuarioMenu con el servicio de cuentas proporcionado.
	     *
	     * @param accountService el servicio de cuentas utilizado para las operaciones del menú.
	     */
	    public UsuarioMenu(CuentaServicio accountService) {
	        this.accountService = accountService;
	        this.currentUser = null;
	    }

	    /**
	     * Establece el usuario actual que ha iniciado sesión.
	     *
	     * @param currentUser el usuario que ha iniciado sesión.
	     */
	    public void setCurrentUser(UsuarioCuenta currentUser) {
	        this.currentUser = currentUser;
	    }

	    /**
	     * Muestra el menú principal del UsuarioMenu en la consola.
	     */
	    @Override
	    public void displayMenu() {
	        int choice;
	        do {
	            clearScreen();
	            System.out.println("===========================================================================");
	            System.out.println("== Bienvenido a Alke Wallet ==");
	            System.out.println("1. Iniciar sesión");
	            System.out.println("2. Salir");
	            System.out.println("===========================================================================");
	            choice = getUserChoice();

	            switch (choice) {
	                case 1:
	                    handleLogin();
	                    break;
	                case 2:
	                    System.out.println("¡Hasta luego!");
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intente de nuevo.");
	            }

	        } while (choice != 2);
	    }

	    /**
	     * Maneja el proceso de inicio de sesión solicitando credenciales al usuario.
	     */
	    private void handleLogin() {
	        clearScreen();
	        System.out.println("== Iniciar Sesión ==");
	        System.out.print("Ingrese su Email: ");
	        String email = scanner.next();
	        System.out.print("Ingrese su Contraseña: ");
	        String password = scanner.next();

	        UsuarioCuenta user = accountService.login(email, password);

	        if (user != null) {
	            setCurrentUser(user);
	            showUserOptionsMenu();
	        } else {
	            System.out.println("Credenciales incorrectas. Intente de nuevo.");
	        }
	    }

	    /**
	     * Muestra el menú de opciones disponible para el usuario autenticado.
	     */
	    private void showUserOptionsMenu() {
	        int choice;
	        do {
	            clearScreen();
	            System.out.println("===========================================================================");
	            System.out.println("== Menú | Nombre de Usuario: " + currentUser.getFirstName() + " " + currentUser.getLastName() + " | Nro de cuenta: " + currentUser.getAccountNumber() + " ==");
	            System.out.println("1. Depositar en Pesos Chilenos");
	            System.out.println("2. Retirar en Pesos Chilenos");
	            System.out.println("3. Convertir Pesos Chilenos a Dólares");
	            System.out.println("4. Convertir Dólares a Pesos Chilenos");
	            System.out.println("5. Consultar Saldo");
	            System.out.println("6. Cerrar Sesión");
	            System.out.println("===========================================================================");

	            choice = getUserChoice();

	            switch (choice) {
	                case 1:
	                    handleDeposit();
	                    break;
	                case 2:
	                    handleWithdraw();
	                    break;
	                case 3:
	                    handleConvertToDollars();
	                    break;
	                case 4:
	                    handleConvertToChileanPesos();
	                    break;
	                case 5:
	                    displayBalance();
	                    break;
	                case 6:
	                    currentUser = null;
	                    System.out.println("Sesión cerrada.");
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intente de nuevo.");
	            }

	        } while (choice != 6);
	    }

	    /**
	     * Maneja el proceso de depósito en Pesos Chilenos.
	     */
	    public void handleDeposit() {
	        System.out.print("Monto a depositar en Pesos Chilenos: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            accountService.depositChileanPesos(currentUser, amount);
	        } else {
	            System.out.println("Monto inválido. Debe ser mayor que 0.");
	        }
	    }

	    /**
	     * Maneja el proceso de retiro en Pesos Chilenos.
	     */
	    public void handleWithdraw() {
	        System.out.print("Monto a retirar en Pesos Chilenos: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            accountService.withdrawChileanPesos(currentUser, amount);
	        } else {
	            System.out.println("Monto inválido. Debe ser mayor que 0.");
	        }
	    }

	    /**
	     * Maneja el proceso de conversión de Pesos Chilenos a Dólares.
	     */
	    public void handleConvertToDollars() {
	        System.out.print("Monto en Pesos Chilenos a convertir a Dólares: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            accountService.convertChileanPesosToDollars(currentUser, amount);
	        } else {
	            System.out.println("Monto inválido. Debe ser mayor que 0.");
	        }
	    }

	    /**
	     * Maneja el proceso de conversión de Dólares a Pesos Chilenos.
	     */
	    public void handleConvertToChileanPesos() {
	        System.out.print("Monto en Dólares a convertir a Pesos Chilenos: ");
	        double amount = scanner.nextDouble();
	        if (amount > 0) {
	            accountService.convertDollarsToChileanPesos(currentUser, amount);
	        } else {
	            System.out.println("Monto inválido. Debe ser mayor que 0.");
	        }
	    }

	    /**
	     * Muestra el saldo actual del usuario autenticado.
	     */
	    public void displayBalance() {
	        accountService.displayBalance(currentUser);
	    }
	}