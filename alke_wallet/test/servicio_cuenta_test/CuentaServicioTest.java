package servicio_cuenta_test;
/**
 * Importaciones necesarias para las pruebas.
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicio_cuenta.CuentaServicio;
/**
 * Import de clase UsuarioCuenta
 */
import usuario.UsuarioCuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Clase de prueba para la clase CuentaServicio.
 */
class CuentaServicioTest {

    /**
     * Prueba para el método login() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para login()")
    void testLogin() {
        
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        String email = "test@example.com";
        String password = "password";
        UsuarioCuenta usuarioCuenta = new UsuarioCuenta(email, password, null, null, null);
        when(cuentaServicio.login(email, password)).thenReturn(usuarioCuenta);

       
        UsuarioCuenta result = cuentaServicio.login(email, password);

        verify(cuentaServicio, times(1)).login(email, password);
        assertEquals(usuarioCuenta, result);
    }

    /**
     * Prueba para el método depositChileanPesos() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para depositChileanPesos()")
    void testDepositChileanPesos() {
        
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        UsuarioCuenta usuario = new UsuarioCuenta("jp@mail.com", "Profe123", null, null, null);
        double amount = 100.0;
        doNothing().when(cuentaServicio).depositChileanPesos(usuario, amount);

       
        cuentaServicio.depositChileanPesos(usuario, amount);

       
        verify(cuentaServicio, times(1)).depositChileanPesos(usuario, amount);
    }

    /**
     * Prueba para el método withdrawChileanPesos() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para withdrawChileanPesos()")
    void testWithdrawChileanPesos() {
        // Arrange
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        UsuarioCuenta usuario = new UsuarioCuenta("jp@mail.com", "Profe123", null, null, null);
        double amount = 50.0;
        doNothing().when(cuentaServicio).withdrawChileanPesos(usuario, amount);

       
        cuentaServicio.withdrawChileanPesos(usuario, amount);

       
        verify(cuentaServicio, times(1)).withdrawChileanPesos(usuario, amount);
    }

    /**
     * Prueba para el método convertChileanPesosToDollars() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para convertChileanPesosToDollars()")
    void testConvertChileanPesosToDollars() {
        // Arrange
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        UsuarioCuenta usuario = new UsuarioCuenta("jp@mail.com", "Profe123", null, null, null);
        double amount = 5000.0;
        doNothing().when(cuentaServicio).convertChileanPesosToDollars(usuario, amount);

      
        cuentaServicio.convertChileanPesosToDollars(usuario, amount);

       
        verify(cuentaServicio, times(1)).convertChileanPesosToDollars(usuario, amount);
    }

    /**
     * Prueba para el método convertDollarsToChileanPesos() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para convertDollarsToChileanPesos()")
    void testConvertDollarsToChileanPesos() {
       
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        UsuarioCuenta usuario = new UsuarioCuenta("jp@mail.com", "Profe123", null, null, null);
        double amount = 100.0;
        doNothing().when(cuentaServicio).convertDollarsToChileanPesos(usuario, amount);

        
        cuentaServicio.convertDollarsToChileanPesos(usuario, amount);

       
        verify(cuentaServicio, times(1)).convertDollarsToChileanPesos(usuario, amount);
    }

    /**
     * Prueba para el método displayBalance() de CuentaServicio.
     */
    @Test
    @DisplayName("Prueba para displayBalance()")
    void testDisplayBalance() {
     
        CuentaServicio cuentaServicio = mock(CuentaServicio.class);
        UsuarioCuenta usuario = new UsuarioCuenta("jp@mail.com", "Profe123", null, null, null);
        doNothing().when(cuentaServicio).displayBalance(usuario);

       
        cuentaServicio.displayBalance(usuario);

        verify(cuentaServicio, times(1)).displayBalance(usuario);
    }
}