package cuenta_moneda_test;
/**
 * Importaciones necesarias para las pruebas
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Importacion de package cuenta_moneda
 */
import cuenta_moneda.*;

/**
 * Esta clase contiene pruebas unitarias para la clase MonedaDolar.
 */
public class MonedaDolarTest {

    private MonedaDolar monedaDolar;

    /**
     * Configuración previa a cada prueba.
     */
    @BeforeEach
    void setUp() {
        monedaDolar = new MonedaDolar();
    }

    /**
     * Prueba para verificar el depósito en dólares.
     */
    @Test
    @DisplayName("Prueba depositar en dólares")
    void testDeposit() {
        monedaDolar.deposit(100.0);
        assertEquals(100.0, monedaDolar.getBalance());
    }

    /**
     * Prueba para verificar el retiro en dólares.
     */
    @Test
    @DisplayName("Prueba retirar en dólares")
    void testWithdraw() {
        monedaDolar.deposit(100.0);
        monedaDolar.withdraw(50.0);
        assertEquals(50.0, monedaDolar.getBalance());
    }

    /**
     * Prueba para verificar la conversión de dólares a PesoChileno u otra moneda.
     */
    @Test
    @DisplayName("Prueba convertir a otra moneda")
    void testConvertTo() {
        MonedaPesoChileno pesos = new MonedaPesoChileno();
        double convertedAmount = monedaDolar.convertTo(pesos, 100.0);
        assertEquals(100.0 * 979.55, convertedAmount);
    }
}