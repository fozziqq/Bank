package bank;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения в депозит должно быть больше чем 0");
        }
        this.balance += amount;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятие должно быть больше чем 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств! Баланс: " + balance + ", запрошено: " +  amount);
        }
        balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
}
