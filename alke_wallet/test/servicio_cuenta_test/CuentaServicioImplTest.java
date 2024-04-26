package servicio_cuenta_test;

/**
 *Import de la interfaz HashMap, es una implementación de la interfaz Map 
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Importaciones necesarias para las pruebas.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Import de clases necesarias.
 */
import servicio_cuenta.CuentaServicioImpl;
import usuario.UsuarioCuenta;

/**
 * Clase de pruebas unitarias para la clase CuentaServicioImpl.
 */
public class CuentaServicioImplTest {

    private CuentaServicioImpl cuentaServicio;
    private Map<String, UsuarioCuenta> usuarios;

    
    /**
     * Configura un nuevo usuario antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        usuarios = new HashMap<>();
        UsuarioCuenta usuario1 = new UsuarioCuenta("Juan", "Durán", "jp@mail.com","123456789", "Profe12345");
        usuarios.put(usuario1.getEmail(), usuario1);
        cuentaServicio = new CuentaServicioImpl(usuarios);
    }

    /**
     * Prueba de inicio de sesión exitoso.
     */
    @Test
    @DisplayName("Prueba de inicio de sesión exitoso")
    public void testLoginUsuarioExistenteContrasenaCorrecta() {
        UsuarioCuenta usuarioLogueado = cuentaServicio.login("jp@mail.com", "Profe12345");
        assertNotNull(usuarioLogueado, "Se esperaba un usuario logueado");
        assertEquals("Juan", usuarioLogueado.getFirstName(), "El nombre del usuario no coincide");
    }

    /**
     * Prueba de inicio de sesión fallido por contraseña incorrecta.
     */
    @Test
    @DisplayName("Prueba de inicio de sesión fallido: contraseña incorrecta")
    public void testLoginUsuarioExistenteContrasenaIncorrecta() {
        UsuarioCuenta usuarioLogueado = cuentaServicio.login("jp@mail.com", "claveIncorrecta");
        assertNull(usuarioLogueado, "No se esperaba un usuario logueado con contraseña incorrecta");
    }

    /**
     * Prueba de inicio de sesión fallido por usuario inexistente.
     */
    @Test
    @DisplayName("Prueba de inicio de sesión fallido: usuario inexistente")
    public void testLoginUsuarioInexistente() {
        UsuarioCuenta usuarioLogueado = cuentaServicio.login("usuario@invalido.com", "Profe12345");
        assertNull(usuarioLogueado, "No se esperaba un usuario logueado con un usuario inexistente");
    }

    /**
     * Prueba de depósito exitoso en pesos chilenos.
     */
    @Test
    @DisplayName("Prueba de depósito exitoso en pesos chilenos")
    public void testDepositChileanPesosValidAmount() {
        UsuarioCuenta usuario = usuarios.get("jp@mail.com");
        double initialBalance = usuario.getChileanPesosAccount().getBalance();
        cuentaServicio.depositChileanPesos(usuario, 100.0);
        assertEquals(initialBalance + 100.0, usuario.getChileanPesosAccount().getBalance(), 0.001,
                "El saldo en pesos chilenos después del depósito no coincide");
    }

    /**
     * Prueba de retiro exitoso en pesos chilenos.
     */
    @Test
    @DisplayName("Prueba de retiro exitoso en pesos chilenos")
    public void testWithdrawChileanPesosValidAmount() {
        UsuarioCuenta usuario = usuarios.get("jp@mail.com");
        cuentaServicio.depositChileanPesos(usuario, 200.0);
        double initialBalance = usuario.getChileanPesosAccount().getBalance();
        cuentaServicio.withdrawChileanPesos(usuario, 50.0);
        assertEquals(initialBalance - 50.0, usuario.getChileanPesosAccount().getBalance(), 0.001,
                "El saldo en pesos chilenos después del retiro no coincide");
    }

    /**
     * Prueba de conversión de pesos chilenos a dólares exitosa.
     */
    @Test
    @DisplayName("Prueba de conversión de pesos chilenos a dólares exitosa")
    public void testConvertChileanPesosToDollarsValidAmount() {
        UsuarioCuenta usuario = usuarios.get("jp@mail.com");
        cuentaServicio.depositChileanPesos(usuario, 1000.0);
        double initialChileanPesosBalance = usuario.getChileanPesosAccount().getBalance();
        double initialDollarsBalance = usuario.getDollarsAccount().getBalance();
        cuentaServicio.convertChileanPesosToDollars(usuario, 500.0);
        assertEquals(initialChileanPesosBalance - 500.0, usuario.getChileanPesosAccount().getBalance(), 0.001,
                "El saldo en pesos chilenos después de la conversión no coincide");
        assertEquals(initialDollarsBalance + (500.0 / 1100.0), usuario.getDollarsAccount().getBalance(), 0.001,
                "El saldo en dólares después de la conversión no coincide");
    }

    /**
     * Prueba de conversión de dólares a pesos chilenos exitosa.
     */
    @Test
    @DisplayName("Prueba de conversión de dólares a pesos chilenos exitosa")
    public void testConvertDollarsToChileanPesosValidAmount() {
        UsuarioCuenta usuario = usuarios.get("jp@mail.com");
        cuentaServicio.depositChileanPesos(usuario, 200000.0); // 200,000 CLP
        cuentaServicio.convertDollarsToChileanPesos(usuario, 100.0); // 100 USD
        assertEquals(200000.0 - (100.0 * 1100.0), usuario.getChileanPesosAccount().getBalance(), 0.001,
                "El saldo en pesos chilenos después de la conversión no coincide");
        assertEquals(100.0, usuario.getDollarsAccount().getBalance(), 0.001,
                "El saldo en dólares después de la conversión no coincide");
    }
}
