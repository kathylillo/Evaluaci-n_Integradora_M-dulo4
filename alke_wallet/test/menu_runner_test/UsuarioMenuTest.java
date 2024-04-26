package menu_runner_test;

/**
 * Importaciones necesarias para las pruebas
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Importaciones  de package del proyecto
 */
import servicio_cuenta.*;
import usuario.*;
import menu_runner.*;

/**
 * Esta clase contiene pruebas unitarias para la clase UsuarioMenu.
 */
public class UsuarioMenuTest {
	
	/**
	 * El orden es afectado durante la ejecucion pero deberia ser asi el orede de saldos a ingresar por consola.
	 * Monto en Pesos Chilenos a convertir a Dólares:100
	 * Monto a retirar en Pesos Chilenos: 50 
	 * Monto a depositar en PesosChilenos: 100 
	 * Monto en Dólares a convertir a Pesos Chilenos: 50
	 * 
	 */

	private UsuarioMenu usuarioMenu;
	private CuentaServicio cuentaServicio;
	private UsuarioCuenta usuario;

	/**
	 * Configuración previa a cada prueba.
	 */
	@BeforeEach
	void setUp() {
		cuentaServicio = mock(CuentaServicio.class);
		usuarioMenu = new UsuarioMenu(cuentaServicio);

		usuario = new UsuarioCuenta("Juan", "Durán", "jp@mail.com", "123456789", "Profe12345");
		usuarioMenu.setCurrentUser(usuario);
	}
	/**
     * Prueba para verificar el método de depósito en pesos chilenos.
     */
    @Test
    @DisplayName("Prueba handleDeposit")
    void testHandleDeposit() {
        usuarioMenu.handleDeposit();
        verify(cuentaServicio).depositChileanPesos(usuario, 100.0);
    }

    /**
     * Prueba para verificar el método de retiro en pesos chilenos.
     */
    @Test
    @DisplayName("Prueba handleWithdraw")
    void testHandleWithdraw() {
        usuarioMenu.handleWithdraw();
        verify(cuentaServicio).withdrawChileanPesos(usuario, 50.0);
    }

    /**
     * Prueba para verificar el método de conversión de pesos chilenos a dólares.
     */
    @Test
    @DisplayName("Prueba handleConvertToDollars")
    void testHandleConvertToDollars() {
        usuarioMenu.handleConvertToDollars();
        verify(cuentaServicio).convertChileanPesosToDollars(usuario, 100.0);
    }

    /**
     * Prueba para verificar el método de conversión de dólares a pesos chilenos.
     */
    @Test
    @DisplayName("Prueba handleConvertToChileanPesos")
    void testHandleConvertToChileanPesos() {
        usuarioMenu.handleConvertToChileanPesos();
        verify(cuentaServicio).convertDollarsToChileanPesos(usuario, 50.0);
    }

    /**
     * Prueba para verificar el método de visualización de saldo.
     */
    @Test
    @DisplayName("Prueba displayBalance")
    void testDisplayBalance() {
        usuarioMenu.displayBalance();
        verify(cuentaServicio).displayBalance(usuario);
    }
}