package cuenta_moneda;
/**
 * Interfaz Moneda  que define métodos para operaciones relacionadas con transacciones monetarias,
 *  como depositar, retirar, convertir y obtener saldo.
 */
public interface Moneda {
	
	
	/**
     * Deposita una cantidad especificada en esta moneda.
     * @param amount la cantidad a depositar
     */
    void deposit(double amount);

    /**
     * Retira una cantidad especificada de esta moneda, si es posible.
     * @param amount la cantidad a retirar
     */
    void withdraw(double amount);

    /**
     * Convierte una cantidad especificada de esta moneda a otra moneda dada.
     * @param currency la moneda a la cual se desea convertir
     * @param amount   la cantidad a convertir
     * @return la cantidad convertida en la moneda especificada
     */
    double convertTo(Moneda currency, double amount);

    /**
     * Obtiene el saldo actual de esta moneda.
     * @return el saldo actual de la moneda
     */
    double getBalance();

}
