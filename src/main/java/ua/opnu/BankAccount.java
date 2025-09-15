
package ua.opnu;

/**
 * Клас BankAccount описує банківський рахунок клієнта.
 */
public class BankAccount {

    /**
     * Ім'я власника рахунку.
     */
    private String name;

    /**
     * Поточний баланс рахунку.
     */
     double balance;

    /**
     * Комісія за транзакцію.
     */
     double transactionFee = 0.0;

    /**
     * Метод для поповнення балансу.
     *
     * @param amount Сума для поповнення. Повинна бути більшою за нуль.
     */
    public void deposit(final double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
        }
    }

    /**
     * Повертає поточний баланс рахунку.
     *
     * @return Поточний баланс.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Метод для зняття грошей з рахунку.
     *
     * @param amount Сума для зняття. Повинна бути більшою за нуль.
     * @return true, якщо операція успішна, інакше false.
     */
    public boolean withdraw(final double amount) {
        if (amount <= 0) {
            return false;
        }

        double totalAmount = amount + this.transactionFee;

        if (this.balance >= totalAmount) {
            this.balance = this.balance - totalAmount;
            return true;
        }

        return false;
    }

    /**
     * Метод для переказу грошей на інший рахунок.
     *
     * @param receiver Рахунок-одержувач.
     * @param amount   Сума для переказу. Повинна бути більшою за нуль.
     * @return true, якщо операція успішна, інакше false.
     */
    public boolean transfer(final BankAccount receiver, final double amount) {
        if (amount <= 0) {
            return false;
        }

        double totalAmountToWithdraw = amount + this.transactionFee;

        if (this.balance >= totalAmountToWithdraw) {
            // Використовуємо існуючий метод withdraw,
            // щоб уникнути дублювання коду
            if (this.withdraw(amount)) {
                receiver.deposit(amount);
                return true;
            }
        }
        return false;
    }

    // --- Додані методи доступу (геттери та сеттери) ---

    /**
     * Повертає ім'я власника рахунку.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }
}
