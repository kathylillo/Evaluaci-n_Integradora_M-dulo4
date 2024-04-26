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
 * Esta clase contiene pruebas unitarias para la clase MonedaPesoChileno.
 */
public class MonedaPesoChilenoTest {

    private MonedaPesoChileno monedaPesoChileno;

    /**
     * Configuración previa a cada prueba.
     */
    @BeforeEach
    void setUp() {
        monedaPesoChileno = new MonedaPesoChileno();
    }

    /**
     * Prueba para verificar el depósito en Peso Chileno.
     */
    @Test
    @DisplayName("Prueba depositar en Peso Chileno")
    void testDeposit() {
        monedaPesoChileno.deposit(1000.0);
        assertEquals(1000.0, monedaPesoChileno.getBalance());
    }

    /**
     * Prueba para verificar el retiro en Peso Chileno.
     */
    @Test
    @DisplayName("Prueba retirar en Peso Chileno")
    void testWithdraw() {
        monedaPesoChileno.deposit(1000.0);
        monedaPesoChileno.withdraw(500.0);
        assertEquals(500.0, monedaPesoChileno.getBalance());
    }

    /**
     * Prueba para verificar la conversión de Peso Chileno a Dólar, u otra moneda.
     */
    @Test
    @DisplayName("Prueba convertir a otra moneda")
    void testConvertTo() {
        MonedaDolar dollars = new MonedaDolar();
        double convertedAmount = monedaPesoChileno.convertTo(dollars, 1000.0);
        assertEquals(1000.0 * 0.0010, convertedAmount);
    }
}