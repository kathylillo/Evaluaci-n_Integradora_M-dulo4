package cuenta_moneda;


/**
 *  Clase MonedaPesoChileno que implementa la interfaz Moneda y representa una cuenta en Pesos Chilenos con un saldo específico.
 */
public class MonedaPesoChileno implements Moneda {

	private double balance;

	/**
     * Constructor que inicializa una cuenta en Pesos Chilenos con un saldo inicial de 0.0.
     */
    public MonedaPesoChileno() {
        this.balance = 0.0;
    }

    /**
     * Deposita una cantidad específica en la cuenta en Pesos Chilenos.
     * @param amount la cantidad a depositar (debe ser mayor que 0)
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    /**
     * Retira una cantidad específica de la cuenta en Pesos Chilenos, si hay suficiente saldo disponible.
     * @param amount la cantidad a retirar (debe ser mayor que 0 y menor o igual que el saldo disponible)
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    /**
     * Convierte una cantidad de Pesos Chilenos a otra moneda especificada.
     * En este caso, solo se implementa la conversión a Dólares (MonedaDolar).
     * @param currency la moneda a la cual se desea convertir (debe ser MonedaDolar)
     * @param amount   la cantidad de Pesos Chilenos a convertir
     * @return la cantidad convertida en la moneda especificada (dólares)
     */
    @Override
    public double convertTo(Moneda currency, double amount) {
        if (currency instanceof MonedaDolar) {
            double conversionRate = 0.0010; // Tasa de conversión de Pesos Chilenos a Dólares
            return amount * conversionRate;
        }
        return 0.0; // Si se intenta convertir a otra moneda no compatible, se devuelve 0.0
    }

    /**
     * Obtiene el saldo actual de la cuenta en Pesos Chilenos.
     * @return el saldo actual de la cuenta en Pesos Chilenos
     */
    @Override
    public double getBalance() {
        return this.balance;
    }
}