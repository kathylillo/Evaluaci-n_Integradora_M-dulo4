package usuario;
/**
 * Clase abstracta que representa los atributos comunes de un usuario, como nombre, apellido, correo electrónico, número de cuenta y contraseña.
 */
public abstract class UsuarioCuentaDB {
	private String firstName;
    private String lastName;
    private String email;
    private String accountNumber;
    private String password;

    /**
     * Constructor para inicializar el objeto UsuarioCuentaDB con los datos proporcionados.
     * @param firstName     Nombre del usuario.
     * @param lastName      Apellido del usuario.
     * @param email         Correo electrónico del usuario.
     * @param accountNumber Número de cuenta del usuario.
     * @param password      Contraseña del usuario.
     */
    public UsuarioCuentaDB(String firstName, String lastName, String email, String accountNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return Correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el nombre del usuario.
     * @param firstName Nuevo nombre del usuario.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene el apellido del usuario.
     * @return Apellido del usuario.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido del usuario.
     * @param lastName Nuevo apellido del usuario.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene el número de cuenta del usuario.
     * @return Número de cuenta del usuario.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Establece el número de cuenta del usuario.
     * @param accountNumber Nuevo número de cuenta del usuario.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email Nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password Nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}