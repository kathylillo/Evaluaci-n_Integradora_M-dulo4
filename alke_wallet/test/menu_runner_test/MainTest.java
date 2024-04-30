package menu_runner_test;

/**
 * Import del Package menu_runner
 */
import menu_runner.*;
/**
 *  Importaciones necesarias para las pruebas.
 */
import org.junit.jupiter.api.*;
import servicio_cuenta.CuentaServicio;
import servicio_cuenta.CuentaServicioImpl;

import static org.mockito.Mockito.*;

/**
 * Clase de prueba para la clase Main.
 */
class MainTest {

    /**
     * Prueba unitaria para el método main().
     */
    @Test
    @DisplayName("Prueba para método main()")
    void testMain() {
  
        CuentaServicio accountService = mock(CuentaServicioImpl.class); 
        UsuarioMenu menu = mock(UsuarioMenu.class); 

     
        Main.main(null); // 

       
        verify(menu, times(1)).displayMenu();
        verify(menu, times(1)).closeScanner();
    }
}