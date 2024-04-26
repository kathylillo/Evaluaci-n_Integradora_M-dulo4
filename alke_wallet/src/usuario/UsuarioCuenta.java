package usuario;
import cuenta_moneda.*;
/**
 * Clase que hereda de UsuarioBase y contiene instancias de las clases PesoChileno y Dollar.
 */
public class UsuarioCuenta extends UsuarioCuentaDB {

	private MonedaPesoChileno chileanPesos;
	private MonedaDolar dollars;
	/**
     * Constructor para inicializar el objeto UsuarioCuenta con los datos proporcionados.
     * @param firstName     Nombre del usuario.
     * @param lastName      Apellido del usuario.
     * @param email         Correo electrónico del usuario.
     * @param accountNumber Número de cuenta del usuario.
     * @param password      Contraseña del usuario.
     */
    public UsuarioCuenta(String firstName, String lastName, String email, String accountNumber, String password) {
        super(firstName, lastName, email, accountNumber, password);
        this.chileanPesos = new MonedaPesoChileno();
        this.dollars = new MonedaDolar();
    }

    /**
     * Obtiene la cuenta en Pesos Chilenos asociada a este usuario.
     * @return Objeto `MonedaPesoChileno` que representa la cuenta en Pesos Chilenos.
     */
    public MonedaPesoChileno getChileanPesosAccount() {
        return chileanPesos;
    }

    /**
     * Obtiene la cuenta en Dólares asociada a este usuario.
     * @return Objeto `MonedaDolar` que representa la cuenta en Dólares.
     */
    public MonedaDolar getDollarsAccount() {
        return dollars;
    }

    // Getters y Setters adicionales para las variables chileanPesos y dollars

    public MonedaPesoChileno getChileanPesos() {
        return chileanPesos;
    }

    public void setChileanPesos(MonedaPesoChileno chileanPesos) {
        this.chileanPesos = chileanPesos;
    }

    public MonedaDolar getDollars() {
        return dollars;
    }

    public void setDollars(MonedaDolar dollars) {
        this.dollars = dollars;
    }
}