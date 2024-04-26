package cuenta_moneda;
/**
 *  Clase MonedaDolar que implementa la interfaz Moneda y representa una cuenta en dólares con un saldo específico.
 */
public class MonedaDolar implements Moneda{
	
	private double balance;
	/**
     * Constructor que inicializa una cuenta en dólares con un saldo inicial de 0.0.
     */
    public MonedaDolar() {
        this.balance = 0.0;
    }

    /**
     * Deposita una cantidad específica en la cuenta en dólares.
     * @param amount la cantidad a depositar (debe ser mayor que 0)
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    /**
     * Retira una cantidad específica de la cuenta en dólares, si hay suficiente saldo disponible.
     * @param amount la cantidad a retirar (debe ser mayor que 0 y menor o igual que el saldo disponible)
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    /**
     * Convierte una cantidad de dólares a otra moneda especificada.
     * En este caso, solo se implementa la conversión a pesos chilenos (MonedaPesoChileno).
     * @param currency la moneda a la cual se desea convertir (debe ser MonedaPesoChileno)
     * @param amount   la cantidad de dólares a convertir
     * @return la cantidad convertida en la moneda especificada (pesos chilenos)
     */
    @Override
    public double convertTo(Moneda currency, double amount) {
        if (currency instanceof MonedaPesoChileno) {
            double conversionRate = 979.55; // Tasa de conversión de dólares a pesos chilenos
            return amount * conversionRate;
        }
        return 0.0; // Si se intenta convertir a otra moneda no compatible, se devuelve 0.0
    }

    /**
     * Obtiene el saldo actual de la cuenta en dólares.
     * @return el saldo actual de la cuenta en dólares
     */
    @Override
    public double getBalance() {
        return this.balance;
    }
}