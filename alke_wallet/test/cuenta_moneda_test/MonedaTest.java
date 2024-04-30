package cuenta_moneda_test;
/**
 * Import de Interface Moneda 
 */
import cuenta_moneda.Moneda;

/**
 * Importaciones necesarias para las pruebas.
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Clase de prueba para la interfaz Moneda.
 */
class MonedaTest {

    /**
     * Prueba para el método deposit() de Moneda.
     */
    @Test
    @DisplayName("Prueba para deposit()")
    void testDeposit() {
       
        Moneda moneda = mock(Moneda.class);
        doNothing().when(moneda).deposit(100);

        moneda.deposit(100);

       
        verify(moneda, times(1)).deposit(100);
    }

    /**
     * Prueba para el método withdraw() de Moneda.
     */
    @Test
    @DisplayName("Prueba para withdraw()")
    void testWithdraw() {
        
        Moneda moneda = mock(Moneda.class);
        doNothing().when(moneda).withdraw(50);

       
        moneda.withdraw(50);

       
        verify(moneda, times(1)).withdraw(50);
    }

    /**
     * Prueba para el método convertTo() de Moneda.
     */
    @Test
    @DisplayName("Prueba para convertTo()")
    void testConvertTo() {
        // Arrange
        Moneda moneda = mock(Moneda.class);
        Moneda otraMoneda = mock(Moneda.class);
        double amount = 50;
        when(moneda.convertTo(otraMoneda, amount)).thenReturn(50.0);

     
        double result = moneda.convertTo(otraMoneda, amount);

       
        verify(moneda, times(1)).convertTo(otraMoneda, amount);
        assertEquals(50.0, result);
    }

    /**
     * Prueba para el método getBalance() de Moneda.
     */
    @Test
    @DisplayName("Prueba para getBalance()")
    void testGetBalance() {
       
        Moneda moneda = mock(Moneda.class);
        when(moneda.getBalance()).thenReturn(200.0);

      
        double balance = moneda.getBalance();

        verify(moneda, times(1)).getBalance();
        assertEquals(200.0, balance);
    }
}