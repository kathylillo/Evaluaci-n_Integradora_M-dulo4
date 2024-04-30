package usuario_test;

/**
 * Importaciones necesarias para las pruebas.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Import de package Usuario 
 */
import usuario.*;


/**
 * Clase de prueba para la clase UsuarioCuenta.
 */
public class UsuarioCuentaDBTest {

	 private UsuarioCuenta usuario;

	    /**
	     * Configura un nuevo usuario antes de cada prueba.
	     */
	    @BeforeEach
	    public void setUp() {
	        usuario = new UsuarioCuenta("Juan", "Pérez", "juan@mail.com", "123456789", "Profe12345");
	    }

	    /**
	     * Prueba el método getFirstName() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba obtener nombre")
	    public void testGetFirstName() {
	        assertEquals("Juan", usuario.getFirstName());
	    }

	    /**
	     * Prueba el método getLastName() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba obtener apellido")
	    public void testGetLastName() {
	        assertEquals("Pérez", usuario.getLastName());
	    }

	    /**
	     * Prueba el método getEmail() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba obtener email")
	    public void testGetEmail() {
	        assertEquals("juan@mail.com", usuario.getEmail());
	    }

	    /**
	     * Prueba el método getAccountNumber() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba obtener número de cuenta")
	    public void testGetAccountNumber() {
	        assertEquals("123456789", usuario.getAccountNumber());
	    }

	    /**
	     * Prueba el método getPassword() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba obtener contraseña")
	    public void testGetPassword() {
	        assertEquals("Profe12345", usuario.getPassword());
	    }

	    /**
	     * Prueba el método setFirstName() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba establecer nombre")
	    public void testSetFirstName() {
	        usuario.setFirstName("Pedro");
	        assertEquals("Pedro", usuario.getFirstName());
	    }

	    /**
	     * Prueba el método setLastName() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba establecer apellido")
	    public void testSetLastName() {
	        usuario.setLastName("Martínez");
	        assertEquals("Martínez", usuario.getLastName());
	    }

	    /**
	     * Prueba el método setEmail() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba establecer email")
	    public void testSetEmail() {
	        usuario.setEmail("pedro@mail.com");
	        assertEquals("pedro@mail.com", usuario.getEmail());
	    }

	    /**
	     * Prueba el método setAccountNumber() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba establecer número de cuenta")
	    public void testSetAccountNumber() {
	        usuario.setAccountNumber("987654321");
	        assertEquals("987654321", usuario.getAccountNumber());
	    }

	    /**
	     * Prueba el método setPassword() de UsuarioCuenta.
	     */
	    @Test
	    @DisplayName("Prueba establecer contraseña")
	    public void testSetPassword() {
	        usuario.setPassword("12345Profe");
	        assertEquals("12345Profe", usuario.getPassword());
	    }
	}