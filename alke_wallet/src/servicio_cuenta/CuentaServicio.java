package servicio_cuenta;
/**
 * Import de Package usuario
 */
import usuario.*;
/**
 * Interfaz  CuentaServicio que define operaciones de servicio relacionadas con cuentas de usuario, 
 * como inicio de sesión, depósito, retiro, conversión de monedas y visualización de saldo.
 */
public interface CuentaServicio {

	 /**
     * Realiza el inicio de sesión de un usuario con las credenciales especificadas.
     * @param email    correo electrónico del usuario.
     * @param password contraseña del usuario.
     */
    UsuarioCuenta login(String email, String password);

    /**
     * Realiza un depósito en pesos chilenos en la cuenta del usuario especificado.
     * @param usuario objeto `UsuarioCuenta` en el que se realizará el depósito.
     * @param amount  cantidad de dinero a depositar en pesos chilenos.
     */
    void depositChileanPesos(UsuarioCuenta usuario, double amount);

    /**
     * Realiza un retiro en pesos chilenos de la cuenta del usuario especificado.
     * @param usuario objeto `UsuarioCuenta` del que se realizará el retiro.
     * @param amount  cantidad de dinero a retirar en pesos chilenos.
     */
    void withdrawChileanPesos(UsuarioCuenta usuario, double amount);

    /**
     * Convierte una cantidad de pesos chilenos a dólares en la cuenta del usuario especificado.
     * @param usuario objeto `UsuarioCuenta` en el que se realizará la conversión.
     * @param amount  cantidad de pesos chilenos a convertir a dólares.
     */
    void convertChileanPesosToDollars(UsuarioCuenta usuario, double amount);

    /**
     * Convierte una cantidad de dólares a pesos chilenos en la cuenta del usuario especificado.
     * @param usuario objeto `UsuarioCuenta` en el que se realizará la conversión.
     * @param amount  cantidad de dólares a convertir a pesos chilenos.
     */
    void convertDollarsToChileanPesos(UsuarioCuenta usuario, double amount);

    /**
     * Muestra el saldo actual en las cuentas del usuario especificado.
     * @param usuario objeto `UsuarioCuenta` del que se mostrará el saldo.
     */
    void displayBalance(UsuarioCuenta usuario);

}
