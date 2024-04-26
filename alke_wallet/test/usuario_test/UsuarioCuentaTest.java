package usuario_test;
/**
 * Importaciones necesarias para las pruebas
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Import de package Usuario 
 */
import usuario.*;

/**
 * Clase de prueba para la clase UsuarioCuenta.
 */
class UsuarioCuentaTest {

	private UsuarioCuenta usuario;

	/**
     * Configura un nuevo usuario antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        usuario = new UsuarioCuenta("Juan", "Pérez", "juan@mail.com", "123456789", "Profe12345");
    }

    /**
     * Limpia los datos del usuario después de cada prueba.
     */
    @AfterEach
    public void tearDown() {
        usuario = null;
    }

    /**
     * Prueba el constructor y los getters de UsuarioCuenta.
     */
    @Test
    @DisplayName("Prueba constructor y getters")
    public void testConstructorAndGetters() {
        assertEquals("Juan", usuario.getFirstName());
        assertEquals("Pérez", usuario.getLastName());
        assertEquals("juan@mail.com", usuario.getEmail());
        assertEquals("123456789", usuario.getAccountNumber());
        assertEquals("Profe12345", usuario.getPassword());
    }

    /**
     * Prueba los setters de UsuarioCuenta.
     */
    @Test
    @DisplayName("Prueba setters")
    public void testSetters() {
        usuario.setFirstName("Pedro");
        usuario.setLastName("Martínez");
        usuario.setEmail("pedro@mail.com");
        usuario.setAccountNumber("987654321");
        usuario.setPassword("12345Profe");

        assertEquals("Pedro", usuario.getFirstName());
        assertEquals("Martínez", usuario.getLastName());
        assertEquals("pedro@mail.com", usuario.getEmail());
        assertEquals("987654321", usuario.getAccountNumber());
        assertEquals("12345Profe", usuario.getPassword());
    }

    /**
     * Prueba que la cuenta en pesos chilenos no sea nula.
     */
    @Test
    @DisplayName("Prueba cuenta en pesos chilenos no nula")
    public void testGetChileanPesosAccountNotNull() {
        assertNotNull(usuario.getChileanPesos());
    }

    /**
     * Prueba que la cuenta en dólares no sea nula.
     */
    @Test
    @DisplayName("Prueba cuenta en dólares no nula")
    public void testGetDollarsAccountNotNull() {
        assertNotNull(usuario.getDollars());
    }
}