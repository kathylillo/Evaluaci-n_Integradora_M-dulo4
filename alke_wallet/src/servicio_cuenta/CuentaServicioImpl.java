package servicio_cuenta;

/**
 * Import de la interfaz HashMap, es una implementación de la interfaz Map
 */
import java.util.HashMap;
import java.util.Map;
/**
 * Import del Package usuario
 */
import usuario.*;

/**
 * Clase AccountServiceImpl implementa interface AccountService que proporciona
 * la lógica para realizar las operaciones utilizando las clases y métodos.
 */
public class CuentaServicioImpl implements CuentaServicio {
	private Map<String, UsuarioCuenta> usuarios;
	
	
	public CuentaServicioImpl(Map<String, UsuarioCuenta> usuarios) {
		this.usuarios = usuarios;
	}

	/**
     * Constructor que inicializa el mapa de usuarios.
     */
	public CuentaServicioImpl() {
		this.usuarios = new HashMap<>();
		// Inicializar usuario
		UsuarioCuenta usuario1 = new UsuarioCuenta("Juan", "Durán", "jp@mail.com", "123456789", "Profe12345");
		usuarios.put(usuario1.getEmail(), usuario1); 
	}

	@Override
	public UsuarioCuenta login(String email, String password) {
		if (usuarios.containsKey(email)) {
			UsuarioCuenta user = usuarios.get(email);
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void depositChileanPesos(UsuarioCuenta usuario, double amount) {
		if (amount > 0) {
			usuario.getChileanPesosAccount().deposit(amount);
			System.out.println("Depósito exitoso. Saldo actual en pesos chilenos: "
					+ usuario.getChileanPesosAccount().getBalance());
		} else {
			System.out.println("Monto inválido para depósito. Debe ser mayor que 0.");
		}
	}

	@Override
	public void withdrawChileanPesos(UsuarioCuenta usuario, double amount) {
		if (amount > 0 && amount <= usuario.getChileanPesosAccount().getBalance()) {
			usuario.getChileanPesosAccount().withdraw(amount);
			System.out.println(
					"Retiro exitoso. Saldo actual en pesos chilenos: " + usuario.getChileanPesosAccount().getBalance());
		} else {
			System.out.println("Monto inválido para retiro o saldo insuficiente.");
		}
	}

	@Override
	public void convertChileanPesosToDollars(UsuarioCuenta usuario, double amount) {
		if (amount > 0 && amount <= usuario.getChileanPesosAccount().getBalance()) {
			double convertedAmount = usuario.getChileanPesosAccount().convertTo(usuario.getDollarsAccount(), amount);
			usuario.getChileanPesosAccount().withdraw(amount);
			usuario.getDollarsAccount().deposit(convertedAmount);
			System.out
					.println("Conversión exitosa. Nuevo saldo en dólares: " + usuario.getDollarsAccount().getBalance());
		} else {
			System.out.println("Monto inválido para conversión o saldo insuficiente.");
		}
	}

	@Override
	public void convertDollarsToChileanPesos(UsuarioCuenta usuario, double amount) {
		if (amount > 0 && amount <= usuario.getDollarsAccount().getBalance()) {
			double convertedAmount = usuario.getDollarsAccount().convertTo(usuario.getChileanPesosAccount(), amount);
			usuario.getDollarsAccount().withdraw(amount);
			usuario.getChileanPesosAccount().deposit(convertedAmount);
			System.out.println("Conversión exitosa. Nuevo saldo en pesos chilenos: "
					+ usuario.getChileanPesosAccount().getBalance());
		} else {
			System.out.println("Monto inválido para conversión o saldo insuficiente.");
		}
	}

	@Override
	public void displayBalance(UsuarioCuenta usuario) {
		System.out.println("Saldo en pesos chilenos: " + usuario.getChileanPesosAccount().getBalance());
		System.out.println("Saldo en dólares: " + usuario.getDollarsAccount().getBalance());
	}
}